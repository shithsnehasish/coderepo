package com.dell.glit.controllers;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dell.glit.model.Dashboard;
import com.dell.glit.model.DashboardConfig;
import com.dell.glit.model.Form;
import com.dell.glit.model.FormDataValue;
import com.dell.glit.model.FormFields;
import com.dell.glit.model.InteractionReport;
import com.dell.glit.model.InteractionReportData;
import com.dell.glit.model.Questionaire;
import com.dell.glit.model.QuestionaireConfig;
import com.dell.glit.service.DashboardService;
import com.dell.glit.service.GLITService;
import com.dell.glit.util.ChartDTO;
import com.dell.glit.util.DailyBasisDataDTO;
import com.dell.glit.util.DashboardConfigDTO;
import com.dell.glit.util.EditDashboardConfigDTO;
import com.dell.glit.util.GlitContants;
import com.dell.glit.util.RandomUtil;
import com.dell.glit.util.ShowDashboardConfigDTO;
import com.dell.glit.util.ShowEditDashboardConfigDTO;

/*
DASHBOARD CONTROLLER
*/
@Controller
public class DashboardController {

	@Autowired
	GLITService glitService;
	
	@Autowired
	DashboardService dashboardService;
	
	HttpSession session;
	
	@RequestMapping(value="/selectDashboard.spring")
	public String selectDashboard(ModelMap model,HttpServletRequest request,HttpServletResponse response){
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		String role = (String) session.getAttribute("role");
		session.removeAttribute("chartUtils");
		List<Dashboard> dashboards = getAllDashboardsForClient(clientId);
		model.addAttribute("role", role);
		model.addAttribute("dashboards",dashboards);
		return "dashboard";
	}

	private List<Dashboard> getAllDashboardsForClient(long clientId) {
		List<Dashboard> dashboards = null;
		List<Long> questionaireIds = new ArrayList<Long>();
		List<Questionaire> questionaires = glitService.getAllQuestionaireBasedOnClient(clientId);
		for (Questionaire questionaire : questionaires) {
			questionaireIds.add(questionaire.getQuestionaireId());
		}
		if(questionaireIds != null && !questionaireIds.isEmpty()){
			dashboards = dashboardService.getAllDashboardByClientId(questionaireIds);
		}
		return dashboards;
	}
	
	@RequestMapping(value="/dashboard.spring")
	public String showDashboard(ModelMap model,HttpServletRequest request,HttpServletResponse response){
		
		session = request.getSession();
		session.removeAttribute("chartUtils");
    	Date endDate = new Date();
		Date startDateDaily = DateUtils.addDays(endDate, -9);
		Date startDateMonthly = DateUtils.addMonths(endDate, -12);
		long clientId = (Long) session.getAttribute("clientId");
		List<Dashboard> dashboards = getAllDashboardsForClient(clientId);
		model.addAttribute("dashboards",dashboards);
		if(request.getParameter("dashboardId") != null){
			Long dashboardId = Long.parseLong(request.getParameter("dashboardId"));
			List<ChartDTO> chartUtils = new ArrayList<ChartDTO>();
			List<DashboardConfigDTO> dashboardConfigUtils = getDashboardConfig(dashboardId);
			if(dashboardConfigUtils != null && !dashboardConfigUtils.isEmpty()){
				for (DashboardConfigDTO dashboardConfigUtil : dashboardConfigUtils) {
					ChartDTO chartUtil = new ChartDTO();
					if(dashboardConfigUtil.getCriteria().equals(GlitContants.DAILY)) {
						chartUtil = getDailyBasisChartData(clientId,dashboardConfigUtil,startDateDaily,endDate);
					} else if(dashboardConfigUtil.getCriteria().equals(GlitContants.WEEKLY)) {
						chartUtil = getWeeklyBasisChartData(clientId,dashboardConfigUtil,startDateDaily,endDate);
					} else if(dashboardConfigUtil.getCriteria().equals(GlitContants.MONHTLY)) {
						chartUtil = getMonthlyBasisChartData(clientId, dashboardConfigUtil,startDateMonthly,endDate);
					}
					chartUtils.add(chartUtil);
				}
			}
			model.addAttribute("chartUtils",chartUtils);
			session.setAttribute("chartUtils", chartUtils);
			request.setAttribute("chartUtils", chartUtils);
			model.addAttribute("dashboardId",dashboardId);
		}
        return "dashboard";
	}
	
	private ChartDTO getDailyBasisChartData(long clientId, DashboardConfigDTO dashboardConfigUtil, Date startDate,Date endDate) {
		Map<Date,Map<String, Integer>> outerMap = new LinkedHashMap<Date, Map<String,Integer>>();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		ChartDTO chartUtil = new ChartDTO();
		Dashboard dashboard = dashboardService.getDashBoardById(dashboardConfigUtil.getDashboardId());
		List<InteractionReport> interactionReports = glitService.getInteractionReportbyquestionaireId(dashboard.getQuestionaire().getQuestionaireId());
        List<FormDataValue> formDataValues = glitService.getFormDataValuebyFieldId(dashboardConfigUtil.getFieldId());
        List<Date> dateList = getPreviousTenDaysDates(startDate,endDate);
        outerMap = setDefaultValueToOuterMap(outerMap, formDataValues, dateList);        
        List<Long> interactionIds = new ArrayList<Long>();
	    if(interactionReports != null && !interactionReports.isEmpty()) {    
        	for (InteractionReport interactionReport : interactionReports) {
	        	interactionIds.add(interactionReport.getInteractionId());
	        }
	    }
        if(!interactionIds.isEmpty()) {
	        Map<Date, List<String>> valuesForRef = setQuestionaireDataToMap(dashboardConfigUtil, interactionIds);
	        List<Date> mapKeys = new ArrayList<Date>(valuesForRef.keySet());
	        for (Date dateL : dateList) {
	        	List<String> listofDataforADay = new ArrayList<String>();
	        	for (Date date : mapKeys) {
	        		if(dateFormat.format(date).equals(dateFormat.format(dateL))) {
	        			List<String> list = valuesForRef.get(date);
	        			listofDataforADay.addAll(list);
	        		}
	        	}
	        	Map<String, Integer> innerMap = outerMap.get(dateL);
	        	for(String string : listofDataforADay) {
	    			if(innerMap.containsKey(string)) {
	                    int value = innerMap.get(string);
	                    value++;
	                    innerMap.put(string, value);
	    			} 
	        	}
	        	if(!innerMap.isEmpty())
	        	outerMap.put(dateL, innerMap);
			}
	        Map<String, List<Integer>> newFieldValueMap = convertMapToNewMapForObjectChartUtil(outerMap);
	        chartUtil = mapToChartUtil(dashboardConfigUtil, dateList, newFieldValueMap, endDate);
        }
		return chartUtil;
	}

	private ChartDTO mapToChartUtil(DashboardConfigDTO dashboardConfigUtil, List<Date> dateList,
			Map<String, List<Integer>> newFieldValueMap, Date endDate) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		ChartDTO chartUtil = new ChartDTO();
		chartUtil.setReportName(dashboardConfigUtil.getReportName());
		chartUtil.setReportType(dashboardConfigUtil.getTypeOfChart());
		chartUtil.setReportCriteria(dashboardConfigUtil.getCriteria());
		chartUtil.setFieldId(dashboardConfigUtil.getFieldId());
		chartUtil.setDashboardConfigId(dashboardConfigUtil.getDashboardConfigId());
		List<DailyBasisDataDTO> basisDatas = new ArrayList<DailyBasisDataDTO>();
		List<String> list = new ArrayList<String>(newFieldValueMap.keySet());
		for (String string : list) {
			DailyBasisDataDTO basisData = new DailyBasisDataDTO();
			basisData.setValue(string);
			basisData.setColor(RandomUtil.getRandomColor());
			List<String> newDateList = new LinkedList<String>();
			List<Long> counts = new LinkedList<Long>();
			for (int i = 0; i < dateList.size(); i++) {
			long count = newFieldValueMap.get(string).get(i);
			counts.add(count);
			if(dashboardConfigUtil.getCriteria().equals(GlitContants.DAILY)) {
				newDateList.add("'"+dateFormat.format(dateList.get(i))+"'");
			} else if(dashboardConfigUtil.getCriteria().equals(GlitContants.WEEKLY)) {
				if(i>0) {
					newDateList.add("'"+dateFormat.format(addADayToExistingDate(dateList.get(i))) + " - " + dateFormat.format(dateList.get(i-1))+ "'");
				} else {
					newDateList.add("'"+dateFormat.format(addADayToExistingDate(dateList.get(i))) + " - " + dateFormat.format(endDate)+ "'");
				}
			}
			else if(dashboardConfigUtil.getCriteria().equals(GlitContants.MONHTLY)) {
				Date monthDate = dateList.get(i);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(monthDate);
				int month = calendar.get(Calendar.MONTH);
				long year = calendar.get(Calendar.YEAR);
				if(i>0) {
					newDateList.add("'"+ getMonthForInt(month) + " - " + year + "'");
				} else {
					newDateList.add( "'"+ getMonthForInt(month) + " - " + year + "'");
				}
			}
			}
			basisData.setCounts(counts);
			basisData.setDateList(newDateList);
			basisDatas.add(basisData);
		}
		
		chartUtil.setDailyBasisDatas(basisDatas);
		chartUtil.setDailyBasisDatasSize(basisDatas.size());
		return chartUtil;
	}

	private String getMonthForInt(int num) {
		String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
	}

	private Map<String, List<Integer>> convertMapToNewMapForObjectChartUtil(
			Map<Date, Map<String, Integer>> outerMap) {
		Map<String, List<Integer>> newFieldValueMap = new HashMap<String, List<Integer>>();
		List<Date> newDateList = new ArrayList<Date>(outerMap.keySet());
		for (Date date : newDateList) {
			Map<String, Integer> innerMap = outerMap.get(date);
			List<String> list = new ArrayList<String>(innerMap.keySet());
			for (String string : list) {
				if(newFieldValueMap.containsKey(string)) {
					List<Integer> integers = newFieldValueMap.get(string);
					integers.add(innerMap.get(string));
					newFieldValueMap.put(string, integers);
				} else {
				List<Integer> integers = new ArrayList<Integer>();
				integers.add(innerMap.get(string));
				newFieldValueMap.put(string, integers);
				}
			}
		}
		return newFieldValueMap;
	}

	private Map<Date, List<String>> setQuestionaireDataToMap(
		DashboardConfigDTO dashboardConfigUtil, List<Long> interactionIds) {
		List<InteractionReportData> interactionDatas = dashboardService.getAllInteractionDataByInteractionIdAndFieldId(interactionIds, dashboardConfigUtil.getFieldId());
		Map<Date, List<String>> valuesForRef = new LinkedHashMap<Date, List<String>>();
		for (InteractionReportData interactionData : interactionDatas) {
			List<String> strings = Arrays.asList(interactionData.getValue().split(", "));
		    List<String> list = new LinkedList<String>();
			for (String string2 : strings) {
		    	FormDataValue dataValue = glitService.getFormDataValueById(Long.parseLong(string2));
		    	list.add(dataValue.getValue());
		    }
			valuesForRef.put(interactionData.getInteractionReport().getInteractionDate(), list);
		}
		return valuesForRef;
	}

	private Map<Date, Map<String, Integer>> setDefaultValueToOuterMap(Map<Date, Map<String, Integer>> outerMap,
			List<FormDataValue> formDataValues, List<Date> dateList) {
		for (Date date : dateList) {
        	Map<String, Integer> innerMap = new HashMap<String, Integer>();
        	if(formDataValues != null && !formDataValues.isEmpty()) {
        		for (FormDataValue formDataValue : formDataValues) {
        			innerMap.put(formDataValue.getValue(), 0);
        		}
        		outerMap.put(date, innerMap);
        	}
        }
		return outerMap;
	}
	
	public ChartDTO getWeeklyBasisChartData(long clientId, DashboardConfigDTO dashboardConfigUtil, Date startDate,Date endDate) {
		Map<Date,Map<String, Integer>> outerMap = new LinkedHashMap<Date, Map<String,Integer>>();
		ChartDTO chartUtil = new ChartDTO();
		Dashboard dashboard = dashboardService.getDashBoardById(dashboardConfigUtil.getDashboardId());
		List<InteractionReport> interactionReports = glitService.getInteractionReportbyquestionaireId(dashboard.getQuestionaire().getQuestionaireId());
        List<FormDataValue> formDataValues = glitService.getFormDataValuebyFieldId(dashboardConfigUtil.getFieldId());
        List<Date> dateList = getPreviousTenWeeksDates(endDate);
        outerMap = setDefaultValueToOuterMap(outerMap, formDataValues, dateList);        
        List<Long> interactionIds = new ArrayList<Long>();
	    if(interactionReports != null && !interactionReports.isEmpty()) {    
        	for (InteractionReport interactionReport : interactionReports) {
	        	interactionIds.add(interactionReport.getInteractionId());
	        }
	    }
        if(!interactionIds.isEmpty()) {
	        Map<Date, List<String>> valuesForRef = setQuestionaireDataToMap(dashboardConfigUtil, interactionIds);
	        List<Date> mapKeys = new ArrayList<Date>(valuesForRef.keySet());
	        for (int i = 0; i< dateList.size(); i++) {
	        	List<String> listofDataforADay = new ArrayList<String>();
	        	for (Date date : mapKeys) {
	        		if(i>0) {
		        		if(dateList.get(i).before(date) && dateList.get(i-1).after(date)) {
		        			List<String> list = valuesForRef.get(date);
		        			listofDataforADay.addAll(list);
		        		}
	        		} else {
	        			if(dateList.get(i).before(date)) {
		        			List<String> list = valuesForRef.get(date);
		        			listofDataforADay.addAll(list);
		        		}
	        		}
	        	}
	        	Map<String, Integer> innerMap = outerMap.get(dateList.get(i));
	        	for(String string : listofDataforADay) {
	    			if(innerMap.containsKey(string)) {
	                    int value = innerMap.get(string);
	                    value++;
	                    innerMap.put(string, value);
	    			} 
	        	}
	        	if(!innerMap.isEmpty())
	        	outerMap.put(addADayToExistingDate(dateList.get(i)), innerMap);
			}
	        Map<String, List<Integer>> newFieldValueMap = convertMapToNewMapForObjectChartUtil(outerMap);
	        chartUtil = mapToChartUtil(dashboardConfigUtil, dateList, newFieldValueMap, endDate);
        }
		return chartUtil;
	}
	
	public ChartDTO getMonthlyBasisChartData(long clientId, DashboardConfigDTO dashboardConfigUtil, Date startDate,Date endDate) {
		Map<Date,Map<String, Integer>> outerMap = new LinkedHashMap<Date, Map<String,Integer>>();
		ChartDTO chartUtil = new ChartDTO();
		Dashboard dashboard = dashboardService.getDashBoardById(dashboardConfigUtil.getDashboardId());
		List<InteractionReport> interactionReports = glitService.getInteractionReportbyquestionaireId(dashboard.getQuestionaire().getQuestionaireId());
        List<FormDataValue> formDataValues = glitService.getFormDataValuebyFieldId(dashboardConfigUtil.getFieldId());
        List<Date> dateList = getPreviousMonthsList(startDate,endDate);
        outerMap = setDefaultValueToOuterMap(outerMap, formDataValues, dateList);        
        List<Long> interactionIds = new ArrayList<Long>();
	    if(interactionReports != null && !interactionReports.isEmpty()) {    
        	for (InteractionReport interactionReport : interactionReports) {
	        	interactionIds.add(interactionReport.getInteractionId());
	        }
	    }
        if(!interactionIds.isEmpty()) {
	        Map<Date, List<String>> valuesForRef = setQuestionaireDataToMap(dashboardConfigUtil, interactionIds);
	        List<Date> mapKeys = new ArrayList<Date>(valuesForRef.keySet());
	        for (int i = 0; i< dateList.size(); i++) {
	        	List<String> listofDataforADay = new ArrayList<String>();
	        	for (Date date : mapKeys) {
	        		if(i>0) {
		        		if(dateList.get(i).before(date) && dateList.get(i-1).after(date)) {
		        			List<String> list = valuesForRef.get(date);
		        			listofDataforADay.addAll(list);
		        		}
	        		} else {
	        			if(dateList.get(i).before(date)) {
		        			List<String> list = valuesForRef.get(date);
		        			listofDataforADay.addAll(list);
		        		}
	        		}
	        	}
	        	Map<String, Integer> innerMap = outerMap.get(dateList.get(i));
	        	for(String string : listofDataforADay) {
	    			if(innerMap.containsKey(string)) {
	                    int value = innerMap.get(string);
	                    value++;
	                    innerMap.put(string, value);
	    			} 
	        	}
	        	if(!innerMap.isEmpty())
	        	outerMap.put(dateList.get(i), innerMap);
			}
	        Map<String, List<Integer>> newFieldValueMap = convertMapToNewMapForObjectChartUtil(outerMap);
	        chartUtil = mapToChartUtil(dashboardConfigUtil, dateList, newFieldValueMap, endDate);
        }
		return chartUtil;
	}
	
	private List<DashboardConfigDTO> getDashboardConfig(long dashboardId) {
		 return dashboardService.showAllDashboardConfig(dashboardId);
	}

	@RequestMapping(value="/dashboardConfig.spring")
	public String showDashboardConfiguration(ModelMap model,HttpServletRequest request,HttpServletResponse response){
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		List<ShowDashboardConfigDTO> configDTOs = new ArrayList<ShowDashboardConfigDTO>();
		List<Questionaire> questionaires = glitService.getAllQuestionaireBasedOnClient(clientId);
		List<Dashboard> dashboards = getAllDashboardsForClient(clientId);
		if(dashboards != null && !dashboards.isEmpty()) {
			for (Dashboard dashboard : dashboards) {
				ShowDashboardConfigDTO  configDTO = new ShowDashboardConfigDTO();
				List<DashboardConfigDTO> dashboardConfigs  = new ArrayList<DashboardConfigDTO>();
				dashboardConfigs.addAll(dashboardService.showAllDashboardConfig(dashboard.getDashboardId()));
				configDTO.setDashboardName(dashboard.getDashboardName());
				configDTO.setDashboardId(dashboard.getDashboardId());
				configDTO.setConfigUtils(dashboardConfigs);
				configDTOs.add(configDTO);
			}
		}
		model.addAttribute("allDashboardConfig",configDTOs);
		long availableConfigCount = 5L;
		model.addAttribute("availableConfigCount",availableConfigCount);
		model.addAttribute("questionaires",questionaires);
		return "dashboardConfig";
	}
	
	@RequestMapping(value="/getForms.spring",method = RequestMethod.GET)  
	 public @ResponseBody 
	 	List<Object[]> getForms(@RequestParam(value = "questionaireData") String questionaireId,HttpServletRequest request,HttpServletResponse response) {
		List<Form> forms = new ArrayList<Form>();
		if(questionaireId != null){
			List<QuestionaireConfig> configs = glitService.getQuestionaireConfigBasedOnQId(Long.parseLong(questionaireId));
			for (QuestionaireConfig questionaireConfig : configs) {
				forms.add(questionaireConfig.getForm());
			}
		}
		List<Object[]> formIdNamePairList = new ArrayList<Object[]>();
		for (Form form : forms) {
			Object[] formIdNamePair = new Object[2];
			formIdNamePair[0] = form.getFormId();
			formIdNamePair[1] = form.getFormName();
			formIdNamePairList.add(formIdNamePair);
		}
		return formIdNamePairList;
	 }
	
	@RequestMapping(value="/saveConfig.spring")
	public String saveConfig(HttpServletRequest request,HttpServletResponse response){
		String[] reportNameArray = request.getParameterValues("reportName");
		String[] fieldArray = request.getParameterValues("fieldBox");
		String[] chartArray = request.getParameterValues("chartBox");
		String[] criteriaArray = request.getParameterValues("criteriaBox");
		String dashboardName = request.getParameter("dashboardName");
		String dashboardId = request.getParameter("dashboardId");
		long questionaireId = Long.parseLong(request.getParameter("questionaireData"));
		Questionaire questionaire = glitService.getQuestionaireBasedOnId(questionaireId);
		Dashboard dashboard = new Dashboard();
		if(dashboardId != null && dashboardId != "") {
			List<DashboardConfig> dashboardConfigs = dashboardService.getAllDashboardConfigByDashboardId(Long.parseLong(dashboardId));
			for (DashboardConfig dashboardConfig : dashboardConfigs) {
				dashboardService.deleteDashboardConfigData(dashboardConfig.getDashboardConfigId());
			}
			dashboard.setDashboardId(Long.parseLong(dashboardId));
		}
		dashboard.setDashboardName(dashboardName);
		dashboard.setQuestionaire(questionaire);
		dashboard = dashboardService.addDashboard(dashboard);
		for(int i=0;i<reportNameArray.length;i++){
			long fieldId = Long.valueOf(fieldArray[i]);
			FormFields formField = new FormFields();
			formField.setFieldId(fieldId);
			DashboardConfig dashboardConfig = new DashboardConfig();
			dashboardConfig.setDashboard(dashboard);
			dashboardConfig.setFormFields(formField);
			dashboardConfig.setReportName(reportNameArray[i]);
			dashboardConfig.setCriteria(criteriaArray[i]);
			dashboardConfig.setTypeOfChart(chartArray[i]);
			dashboardService.addDashboardConfig(dashboardConfig);
		}
		return "redirect:/selectDashboard.spring";
	}
	
	@RequestMapping(value="/getField.spring",method = RequestMethod.GET)  
	 public @ResponseBody  
	 	List<Object[]> getFields(@RequestParam(value = "formBox") String formBox,HttpServletRequest request,HttpServletResponse response) {
	 	Long formId = Long.valueOf(formBox);	
	 	List<FormFields> formFields = glitService.getFormFieldsbyFormId(formId);
	 	List<Object[]> formIdNamePairList = new ArrayList<Object[]>();
	 	for (FormFields formField : formFields) {
	 		Object[] formIdNamePair = new Object[2];
	 		formIdNamePair[0] = formField.getFieldId();
	 		formIdNamePair[1] = formField.getFieldName();
	 		formIdNamePairList.add(formIdNamePair);
		}
		return formIdNamePairList;
	 }
	 	
	 
	 private List<Date> getPreviousTenDaysDates(Date startDate,Date endDate) {
		List<Date> dateList = new ArrayList<Date>();
     
		dateList.add(endDate);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String previousDate = null;
			Date lastDate = endDate;
			for(@SuppressWarnings("unused")
			int i = 1; lastDate.after(startDate); i++) {
				Calendar cal = Calendar.getInstance();
				cal.setTime ( lastDate );
				cal.set(Calendar.HOUR, 00);
				cal.set(Calendar.MINUTE, 00);
				cal.set(Calendar.SECOND, 00);
				int daysToDecrement = -1;
				cal.add(Calendar.DATE, daysToDecrement);
				lastDate = cal.getTime();
				previousDate = dateFormat.format(lastDate);
				try {
					dateList.add(dateFormat.parse(previousDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
        return dateList;
	 }
	 
	 private List<Date> getPreviousTenWeeksDates(Date newDate) {
			List<Date> dateList = new ArrayList<Date>();
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	        String previousDate = null;
	        for(int i = 1; i<=10; i++) {
		       Calendar cal = Calendar.getInstance();
		       cal.setTime ( newDate );
		       cal.set(Calendar.DAY_OF_WEEK, 0);
		       cal.set(Calendar.HOUR, 00);
		       cal.set(Calendar.MINUTE, 00);
		       cal.set(Calendar.SECOND, 00);
		       int daysToDecrement = -1;
		       cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, daysToDecrement);
		       newDate = cal.getTime();
		       previousDate = dateFormat.format(newDate);
		       try {
		    	   dateList.add(dateFormat.parse(previousDate));
		       } catch (ParseException e) {
		    	   e.printStackTrace();
		       }
	        }
	        return dateList;
		 }
	 
	 private List<Date> getPreviousMonthsList(Date startDate,Date endDate) {
		List<Date> dateList = new ArrayList<Date>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date lastDate = endDate;
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDate);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(lastDate);
        Calendar cal1 = Calendar.getInstance();
	    cal1.setTime ( endDate );
	    cal1.set(Calendar.DATE, 01);
	    endDate = cal1.getTime();
	    dateList.add(endDate);
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        String previousMonth = null;
        for(int i = 1; i<=diffMonth; i++) {
	       Calendar cal = Calendar.getInstance();
	       cal.setTime ( endDate );
	       int monthsToDecrement = -1;
	       cal.add(Calendar.MONTH, monthsToDecrement);
	       endDate = cal.getTime();
	       previousMonth = dateFormat.format(endDate);
	       try {
	    	   dateList.add(dateFormat.parse(previousMonth));
	       } catch (ParseException e) {
	    	   e.printStackTrace();
	       }
        }
        return dateList;
	 }
	 
 	private Date addADayToExistingDate(Date date) {
 		Calendar c = Calendar.getInstance();
 		c.setTime(date);
 		c.add(Calendar.DATE, 1);
 		date = c.getTime();
 		return date;
 	}
	 	
 	@RequestMapping(value = "/deleteDashboardConfigData.spring", method=RequestMethod.GET)
	public String deleteDashboardConfigData(@RequestParam("dashboardConfigId")long dashboardConfigId,ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		dashboardService.deleteDashboardConfigData(dashboardConfigId);
		return "redirect:/dashboardConfig.spring";
	}
 	 
 	@RequestMapping(value = "/deleteDashboard.spring", method=RequestMethod.GET)
	public String deleteDashboard(@RequestParam("dashboardId")long dashboardId,ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		dashboardService.deleteDashboard(dashboardId);
		return "redirect:/dashboardConfig.spring";
	}
 	
 	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getPeriodDailyData.spring")
	public String getPeriodDailyData(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		Long dashboardId = Long.parseLong(request.getParameter("dashboardId"));
		List<Dashboard> dashboards = getAllDashboardsForClient(clientId);
		model.addAttribute("dashboards",dashboards);
		Long dashboardConfigId = Long.valueOf(request.getParameter("dashboardConfigId"));
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = null;
		Date endDate = null;
		if(request.getParameter("reportCriteria").equals("Daily")){
			String startDateStr = request.getParameter("from");
			startDate = format.parse(startDateStr);
			String endDateStr = request.getParameter("to");
			endDate = format.parse(endDateStr);
		}else if(request.getParameter("reportCriteria").equals("Monthly")){
			String startDateStr = request.getParameter("fromMonthDate");
			startDate = format.parse(startDateStr);
			String endDateStr = request.getParameter("toMonthDate");
			endDate = format.parse(endDateStr);
		}
		List<ChartDTO> chartUtils = (List<ChartDTO>) session.getAttribute("chartUtils");
		ChartDTO util = null;
		for (ChartDTO chartUtil : chartUtils) {
			if(chartUtil.getDashboardConfigId() == dashboardConfigId){
				util = chartUtil;
			}
		}
		if(util != null){
			chartUtils.remove(util);
		}
		
		List<DashboardConfigDTO> dashboardConfigUtils = getDashboardConfig(dashboardId);
		if(dashboardConfigUtils != null && !dashboardConfigUtils.isEmpty()){
			for (DashboardConfigDTO dashboardConfigUtil : dashboardConfigUtils) {
				ChartDTO chartUtil = new ChartDTO();
				if(dashboardConfigUtil.getDashboardConfigId() == dashboardConfigId){
					if(dashboardConfigUtil.getCriteria().equals(GlitContants.DAILY)) {
						chartUtil = getDailyBasisChartData(clientId,dashboardConfigUtil,startDate,endDate);
					} else if(dashboardConfigUtil.getCriteria().equals(GlitContants.WEEKLY)) {
						chartUtil = getWeeklyBasisChartData(clientId,dashboardConfigUtil,startDate,endDate);
					} else if(dashboardConfigUtil.getCriteria().equals(GlitContants.MONHTLY)) {
						chartUtil = getMonthlyBasisChartData(clientId, dashboardConfigUtil,startDate,endDate);
					}
					chartUtils.add(chartUtil);
				}
			}
			model.addAttribute("chartUtils",chartUtils);
			session.setAttribute("chartUtils", chartUtils);
			request.setAttribute("chartUtils", chartUtils);
			model.addAttribute("dashboardId",dashboardId);
			
		}
        return "dashboard";
	}
 	
 	@RequestMapping(value = "/editDashboard.spring", method=RequestMethod.GET)
	public String editDashboard(@RequestParam("dashboardId")long dashboardId,ModelMap model,HttpServletRequest request,HttpServletResponse response) {
 		List<Form> forms = new ArrayList<Form>();
 		Dashboard dashboard = dashboardService.getDashBoardById(dashboardId);
 		List<QuestionaireConfig> questionaireConfigs = glitService.getQuestionaireConfigBasedOnQId(dashboard.getQuestionaire().getQuestionaireId());
		for (QuestionaireConfig questionaireConfig : questionaireConfigs) {
			forms.add(questionaireConfig.getForm());
		}
		ShowEditDashboardConfigDTO  configDTO = new ShowEditDashboardConfigDTO();
		List<EditDashboardConfigDTO> dashboardConfigs  = new ArrayList<EditDashboardConfigDTO>();
		dashboardConfigs.addAll(dashboardService.showAllEditDashboardConfig(dashboard.getDashboardId()));
		configDTO.setDashboardName(dashboard.getDashboardName());
		configDTO.setDashboardId(dashboard.getDashboardId());
		configDTO.setConfigUtils(dashboardConfigs);
		long availableConfigCount = 5L;
		model.addAttribute("availableConfigCount",availableConfigCount);
		model.addAttribute("dashboard", dashboard);
		model.addAttribute("configDTO", configDTO);
		model.addAttribute("forms", forms);
 		return "editDashboard";
	}
}
