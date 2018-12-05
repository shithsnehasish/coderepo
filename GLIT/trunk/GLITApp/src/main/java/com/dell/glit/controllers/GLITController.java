
/**
 * GLIT CONTROLLER
 */
package com.dell.glit.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dell.glit.model.Client;
import com.dell.glit.model.Dashboard;
import com.dell.glit.model.Form;
import com.dell.glit.model.FormData;
import com.dell.glit.model.FormDataValue;
import com.dell.glit.model.FormFields;
import com.dell.glit.model.InteractionReport;
import com.dell.glit.model.InteractionReportData;
import com.dell.glit.model.Questionaire;
import com.dell.glit.model.QuestionaireConfig;
import com.dell.glit.model.User;
import com.dell.glit.service.DashboardService;
import com.dell.glit.service.GLITService;
import com.dell.glit.util.ExcelDTO;
import com.dell.glit.util.FieldDTO;
import com.dell.glit.util.FormDTO;
import com.dell.glit.util.FormDataDTO;
import com.dell.glit.util.FormUtilDTO;
import com.dell.glit.util.GlitContants;
import com.dell.glit.util.QuestionaireDTO;
import com.dell.glit.util.QuestionaireFormDTO;
import com.dell.glit.util.UploadItem;
import com.dell.glit.util.ValidateCopyFormDTO;

/**
 * @author SNEHASISH_SHITH
 * 
 */
@Controller
public class GLITController {
	@Autowired
	GLITService glitService;

	@Autowired
	DashboardService dashboardService;
	HttpSession session;

	@RequestMapping(value = "/login.spring", method = RequestMethod.GET)
	public String showForm() {
		return "login";
	}

	@RequestMapping(value = "/client.spring")
	public String login(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		String role = auth.getAuthorities().toString();
		role = role.toString().replaceAll("[\\[\\]]", "");
		session = request.getSession();
		session.setAttribute("username", name);
		session.setAttribute("role", role);
		session.setAttribute("date", new Date());
		model.addAttribute("username", name);
		model.addAttribute("role", role);
		model.addAttribute("date", new Date());
		model.addAttribute("clientListSize", glitService.getAllClients().size());
		model.addAttribute("clientList", glitService.getAllClients());
		return "client";

	}

	@RequestMapping(value = "/addclientform.spring", method = RequestMethod.GET)
	public String addClientForm(HttpServletRequest request,
			HttpServletResponse response) {
		return "addclient";

	}

	@RequestMapping(value = "/uploadExcel.spring", method = RequestMethod.GET)
	public String uploadExcelForm(@RequestParam("value")String value,Model model, HttpServletRequest request,
			HttpServletResponse response) {
		UploadItem item = new UploadItem();
		if("true".equals(value)) {
			model.addAttribute("message", "Your file has been successfully uploaded !!");
		}
		model.addAttribute("fileUploadForm", item);
		return "uploadExcel";

	}

	@RequestMapping(value = "/submitExcel.spring", method = RequestMethod.POST)
	public String saveExcelForm(@ModelAttribute("fileUploadForm") UploadItem uploadForm,
			Model model, BindingResult result, HttpServletRequest request) {
		MultipartFile multipartFile = uploadForm.getFileData();
		if(!multipartFile.getContentType().contains("vnd")) {
			ObjectError error = new ObjectError("fileData","file with format .xls/.xlsx are only supported");
			result.addError(error);
		}
		if(result.hasErrors()) {
			return "uploadExcel";
		} else {
			session = request.getSession();
			long clientId = (Long) session.getAttribute("clientId");
			Client client = glitService.getClientById(clientId);
			List<String> errorForName = new ArrayList<String>();
			ExcelDTO excelDTO = glitService.uploadExcelData(multipartFile);
			if(!excelDTO.getErrorList().isEmpty()){
				model.addAttribute("errorList", excelDTO.getErrorList());
				return "uploadExcel";
			} else {
				List<FormDTO> formDTOs = excelDTO.getFormList();
				for (FormDTO formDTO : formDTOs) {
					String formNameExist = glitService.checkFormName(formDTO.getFormName(), clientId);
					if(formNameExist.equals(GlitContants.IN_USE)) {
						errorForName.add(formDTO.getFormName());
					}
				}
				if(errorForName.isEmpty()) {
					for (FormDTO formDTO : formDTOs) {
						saveFormfromExcel(formDTO,client);
					}
					return "redirect:/uploadExcel.spring?value=true";
				} else {
					model.addAttribute("formNameError", errorForName);
					return "uploadExcel";
				}
			}
		} 
	}

	private void saveFormfromExcel(FormDTO formDTO, Client client) {
		Form form = new Form();
		form.setClient(client);
		form.setFormName(formDTO.getFormName());
		form = glitService.addForm(form);
		Map<Long, String> map = new HashMap<Long, String>();
		if(formDTO.getFieldsName() != null) {
			for (String fieldName : formDTO.getFieldsName()) {
				FormFields fields = new FormFields();
				fields.setFieldDataType("Text");
				fields.setFieldLimit(40);
				fields.setFieldName(fieldName);
				fields.setFieldType("text");
				fields.setForm(form);
				fields.setMandatory(false);
				fields.setMultiSelect(false);
				fields = glitService.addFormFields(fields);
				map.put(fields.getFieldId(), fieldName);
			}
		}
		List<Map<Long, String>> dataValueList = new ArrayList<Map<Long,String>>();
		if(formDTO.getFieldsData() != null) {
			for (Map<String, String> valueMap : formDTO.getFieldsData()) {
				Map<Long, String> newMap = new HashMap<Long, String>();
				List<Long> keyset = new ArrayList<Long>(map.keySet());
				for (Long long1 : keyset) {
					newMap.put(long1, valueMap.get(map.get(long1)));
				}
				dataValueList.add(newMap);
			}
		}
		if(dataValueList != null && !dataValueList.isEmpty()) {
			for (Map<Long, String> dataMap : dataValueList) {
				FormData formData = new FormData();
				formData.setForm(form);
				formData = glitService.addFormData(formData);
				List<Long> keyset = new ArrayList<Long>(dataMap.keySet());
				for (Long key : keyset) {
					FormDataValue dataValue = new FormDataValue();
					dataValue.setFormData(formData);
					dataValue.setValue(dataMap.get(key));
					dataValue.setField(glitService.getFormFieldsById(key));
					dataValue = glitService.addFormDataValue(dataValue);
				}
			}
		}
	}

	@RequestMapping(value = "/addClient.spring", method = RequestMethod.POST)
	public String addClient(HttpServletRequest request,
			HttpServletResponse response) {
		String clientId = request.getParameter("clientId");
		String clientName = request.getParameter("clientName");
		String clientAddress = request.getParameter("clientAddress");
		String clientEmail = request.getParameter("clientEmail");
		String clientSPOC = request.getParameter("clientSPOC");
		Long contactNo = Long.parseLong(request.getParameter("contact"));
		Client client = new Client();
		if(clientId != null && clientId !="") {
			client.setClientId(Long.parseLong(clientId));
		}
		client.setClientName(clientName);
		client.setClientEmail(clientEmail);
		client.setClientSPOCName(clientSPOC);
		client.setClientAddress(clientAddress);
		client.setClientContactNo(contactNo);
		glitService.addClient(client);

		return "redirect:/client.spring";
	}

	@RequestMapping(value = "/form.spring", method = RequestMethod.GET)
	public String showClientForm(@RequestParam("clientId") long clientId,
			Model model, HttpServletRequest request) {
		session = request.getSession();
		session.setAttribute("clientId", clientId);
		boolean isClientHaveQuestionaire = glitService.isClientHaveQuestionaire(clientId);
		String username = (String) session.getAttribute("username");
		model.addAttribute("username", username);
		model.addAttribute("date", (Date) session.getAttribute("date"));
		String role = (String) session.getAttribute("role");
		List<FormUtilDTO> formUtils = new ArrayList<FormUtilDTO>();
		FormUtilDTO formUtil;
		List<Form> forms = glitService.getAllFormBasedOnClientId(clientId);
		for (Form form : forms) {
			formUtil = new FormUtilDTO();
			formUtil.setFormId(form.getFormId());
			formUtil.setFormName(form.getFormName());
			formUtil.setTotalFields(glitService.getTotalFieldsofForm(form
					.getFormId()));
			formUtil.setTotalEntries(glitService.getTotalEntriesofForm(form
					.getFormId()));
			formUtils.add(formUtil);
		}
		model.addAttribute("isClientHaveQuestionaire", isClientHaveQuestionaire);
		model.addAttribute("role", role);
		model.addAttribute("formListSize", formUtils.size());
		model.addAttribute("formList", formUtils);
		return "form";
	}

	@RequestMapping(value = "/addform.spring", method = RequestMethod.GET)
	public String showClientaddForm(@RequestParam("formId") String formId,Model model, HttpServletRequest request) {
		session = request.getSession();
		Long fId=Long.parseLong(formId);
		String url ="addform";
		if(fId > 0)
		{
			Form form=glitService.getFormbyFormId(fId);
			model.addAttribute("formName", form.getFormName());
			List<FormFields> formFields = glitService.getFormFieldsbyFormId(fId);
			model.addAttribute("formFields", formFields);
			model.addAttribute("flag",1);
			model.addAttribute("formId", fId);
		}
		else{
			model.addAttribute("flag", 0);
		}
		model.addAttribute("clientId", session.getAttribute("clientId"));
		return url;
	}

	@RequestMapping(value = "/disabledform.spring", method = RequestMethod.GET)
	public String showClientdisabledForm(@RequestParam("formId") String formId,Model model, HttpServletRequest request) {
		session = request.getSession();
		Long fId=Long.parseLong(formId);
		String url ="addform";
		Form form=glitService.getFormbyFormId(fId);
		model.addAttribute("formName", form.getFormName());
		List<FormFields> formFields = glitService.getFormFieldsbyFormId(fId);
		model.addAttribute("formFields", formFields);
		model.addAttribute("flag",2);
		model.addAttribute("formId", fId);
		model.addAttribute("clientId", session.getAttribute("clientId"));
		return url;
	}

	@RequestMapping(value = "/copyform.spring", method = RequestMethod.GET)
	public String showClientCopyForm(@RequestParam("formId") String formId,Model model, HttpServletRequest request) {
		session = request.getSession();
		Long fId=Long.parseLong(formId);
		String url ="copyform";
		Form form=glitService.getFormbyFormId(fId);
		model.addAttribute("formName", form.getFormName());
		List<FormFields> formFields = glitService.getFormFieldsbyFormId(fId);
		model.addAttribute("formFields", formFields);
		model.addAttribute("flag",0);
		model.addAttribute("formId", fId);
		model.addAttribute("clientId", session.getAttribute("clientId"));
		return url;
	}

	@RequestMapping(value="/checkFormNames.spring",method = RequestMethod.GET)  
	public @ResponseBody 
	String checkFormNames(@RequestParam(value = "formName") String formName,HttpServletRequest request,HttpServletResponse response) {
		String availabilityResponse = null;
		session = request.getSession();
		String availablity = glitService.checkFormName(formName,(Long)session.getAttribute("clientId"));
		if(availablity.equals(GlitContants.AVAILABLE))
		{
			availabilityResponse = "<font color=green><b>"+formName+"</b> is avaliable";
		}
		else{
			availabilityResponse = "<font color=red><b>"+formName+"</b> is already in use</font>";
		}
		return availabilityResponse ;
	}

	@RequestMapping(value="/checkClientNames.spring",method = RequestMethod.GET)  
	public @ResponseBody 
	String checkClientNames(@RequestParam(value = "clientName") String clientName,HttpServletRequest request,HttpServletResponse response) {
		String availabilityResponse = null;
		session = request.getSession();
		String availablity = glitService.checkClientName(clientName);
		if(availablity.equals(GlitContants.AVAILABLE))
		{
			availabilityResponse = "<font color=green><b>"+clientName+"</b> is avaliable";
		}
		else{
			availabilityResponse = "<font color=red><b>"+clientName+"</b> is already in use</font>";
		}
		return availabilityResponse ;
	}

	@RequestMapping(value = "/addNewForm.spring", method = RequestMethod.POST)
	public String addForm(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		String formName = request.getParameter("formName");
		String fieldName[] = request.getParameterValues("fieldName");
		String textLimit[] = request.getParameterValues("textLimit");
		String fieldDataType[] = request.getParameterValues("fieldDataType");
		String multiSelect[] = request.getParameterValues("multiSelect");
		String mandatory[] = request.getParameterValues("mandatory");
		Client client = glitService.getClientById(clientId);
		Integer flag = Integer.parseInt(request.getParameter("flag"));
		if(flag >0)
		{
			Long formId = Long.parseLong(request.getParameter("formId"));
			glitService.deleteFormFields(formId);
			Form returnForm = glitService.getFormbyFormId(formId);
			for (int i = 0; i < fieldName.length; i++) {
				FormFields fields = new FormFields();
				fields.setFieldName(fieldName[i]);
				fields.setFieldType("text");
				if (Integer.parseInt(multiSelect[i]) == 1)
					fields.setMultiSelect(true);
				else
					fields.setMultiSelect(false);
				if (Integer.parseInt(mandatory[i]) == 1)
					fields.setMandatory(true);
				else
					fields.setMandatory(false);
				fields.setFieldDataType(fieldDataType[i]);
				fields.setFieldLimit(Integer.parseInt(textLimit[i]));
				fields.setForm(returnForm);
				glitService.addFormFields(fields);
			}
		}
		else
		{
			Form form = new Form();
			form.setFormName(formName);
			form.setClient(client);
			Form returnForm = glitService.addForm(form);
			for (int i = 0; i < fieldName.length; i++) {
				FormFields fields = new FormFields();
				fields.setFieldName(fieldName[i]);
				fields.setFieldType("text");
				if (Integer.parseInt(multiSelect[i]) == 1)
					fields.setMultiSelect(true);
				else
					fields.setMultiSelect(false);
				if (Integer.parseInt(mandatory[i]) == 1)
					fields.setMandatory(true);
				else
					fields.setMandatory(false);
				fields.setFieldDataType(fieldDataType[i]);
				fields.setFieldLimit(Integer.parseInt(textLimit[i]));
				fields.setForm(returnForm);
				glitService.addFormFields(fields);
			}
		}

		String url = "redirect:/form.spring?clientId=" + clientId;
		return url;
	}

	@RequestMapping(value = "/displayform.spring", method = RequestMethod.GET)
	public String displayForm(@RequestParam("formId") String formId,
			@RequestParam("dataId") String dataId, Model model) {
		Form form = glitService.getFormbyFormId(Long.parseLong(formId));
		List<FormDataDTO> formDataUtils = new ArrayList<FormDataDTO>();
		List<FormFields> fields = glitService.getFormFieldsbyFormId(Long
				.parseLong(formId));
		if (Integer.parseInt(dataId) == 0) {
			model.addAttribute("fieldList", fields);
		} else {
			for (FormFields formFields : fields) {
				FormDataValue dataValue = glitService.getFormDataValueObject(
						Integer.parseInt(dataId), formFields.getFieldId());
				FormDataDTO dataUtil = new FormDataDTO();
				dataUtil.setFormFields(formFields);
				dataUtil.setValue(dataValue.getValue());
				formDataUtils.add(dataUtil);
			}
			model.addAttribute("fieldDataList", formDataUtils);
		}
		model.addAttribute("formName", form.getFormName());
		model.addAttribute("formId", form.getFormId());
		model.addAttribute("flag", Integer.parseInt(dataId));
		return "displayform";
	}

	@RequestMapping(value = "/saveForm.spring")
	public String saveForm(HttpServletRequest request) {
		session = request.getSession();
		Long formId = Long.parseLong(request.getParameter("formId"));
		Form form = glitService.getFormbyFormId(formId);
		FormData newFormData;
		long dataId = Long.parseLong(request.getParameter("dataId"));
		if (dataId == 0) {
			FormData formData = new FormData();
			formData.setForm(form);
			newFormData = glitService.addFormData(formData);
		} else {
			newFormData = glitService.getFormDatabyDataId(dataId);
		}
		List<FormFields> fields = glitService.getFormFieldsbyFormId(formId);
		FormDataValue dataValue;
		for (FormFields formFields : fields) {
			if (dataId == 0) {
				dataValue = new FormDataValue();
			} else {
				dataValue = glitService.getFormDataValueObject(dataId,
						formFields.getFieldId());
			}
			String fieldValue = request.getParameter(formFields.getFieldName());
			dataValue.setFormData(newFormData);
			dataValue.setField(formFields);
			dataValue.setValue(fieldValue);
			glitService.addFormDataValue(dataValue);
		}
		String url = "redirect:/formdata.spring?formId=" + formId;
		return url;
	}

	@RequestMapping(value = "/questionnaire.spring", method = RequestMethod.GET)
	public String showQuestionnaire(Model model, HttpServletRequest request) {
		boolean isQuestionaireHasInteraction = false;
		Map<QuestionaireDTO, List<String>> questionaireMap = new HashMap<QuestionaireDTO, List<String>>(); 
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		String role = (String) session.getAttribute("role");
		List<Questionaire> questionaires = glitService.getAllQuestionaireBasedOnClient(clientId);
		for (Questionaire questionaire : questionaires) {
			List<String> formNames = new ArrayList<String>();
			List<QuestionaireConfig> questionaireConfigs = glitService.getQuestionaireConfigBasedOnQId(questionaire.getQuestionaireId());
			for (QuestionaireConfig questionaireConfig : questionaireConfigs) {
				Form form = glitService.getFormbyFormId(questionaireConfig.getForm().getFormId());
				formNames.add(form.getFormName());
			}
			isQuestionaireHasInteraction = glitService.isQuestionaireHasInteraction(questionaire.getQuestionaireId());
			QuestionaireDTO questionaireDTO = new QuestionaireDTO();
			questionaireDTO.setQuestionaire(questionaire);
			questionaireDTO.setQuestionaireHasInteraction(isQuestionaireHasInteraction);
			questionaireMap.put(questionaireDTO, formNames);
		}
		model.addAttribute("role", role);
		model.addAttribute("questionaireListSize", questionaireMap.size());
		model.addAttribute("questionaireList", questionaireMap);
		model.addAttribute("clientId", clientId);
		return "questionnaire";
	}

	@RequestMapping(value = "/addQuestionnaireConfig.spring", method = RequestMethod.GET)
	public String addQuestionaire(@RequestParam("questionaireId")String questionaireId, Model model, HttpServletRequest request) {
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		Questionaire questionaire = glitService.getQuestionaireBasedOnId(Long.parseLong(questionaireId));
		List<Form> selectedForms = new ArrayList<Form>();
		List<Form> unSelectedForms = new ArrayList<Form>();
		List<Form> formList = glitService.getAllFormBasedOnClientId(clientId);
		formList = getFormListHavingData(formList);
		unSelectedForms.addAll(formList);
		if(Long.parseLong(questionaireId) != 0) {
			List<QuestionaireConfig> configs = glitService.getQuestionaireConfigBasedOnQId(Long.parseLong(questionaireId));
			for (QuestionaireConfig questionaireConfig : configs) {
				selectedForms.add(questionaireConfig.getForm());
				for (Form form : formList) {
					if(form.getFormId() == questionaireConfig.getForm().getFormId()) {
						unSelectedForms.remove(form);
					}
				}
			}
			model.addAttribute("questionaire", questionaire);
			model.addAttribute("flag", 0);
		}
		model.addAttribute("formList", unSelectedForms);
		model.addAttribute("selectedForms", selectedForms);
		return "questionnaireConfig";
	}

	@RequestMapping(value = "/disabledQuestionnaireConfig.spring", method = RequestMethod.GET)
	public String disabledQuestionaire(@RequestParam("questionaireId")String questionaireId, Model model, HttpServletRequest request) {
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		Questionaire questionaire = glitService.getQuestionaireBasedOnId(Long.parseLong(questionaireId));
		List<Form> selectedForms = new ArrayList<Form>();
		List<Form> unSelectedForms = new ArrayList<Form>();
		List<Form> formList = glitService.getAllFormBasedOnClientId(clientId);
		formList = getFormListHavingData(formList);
		unSelectedForms.addAll(formList);
		if(Long.parseLong(questionaireId) != 0) {
			List<QuestionaireConfig> configs = glitService.getQuestionaireConfigBasedOnQId(Long.parseLong(questionaireId));
			for (QuestionaireConfig questionaireConfig : configs) {
				selectedForms.add(questionaireConfig.getForm());
				for (Form form : formList) {
					if(form.getFormId() == questionaireConfig.getForm().getFormId()) {
						unSelectedForms.remove(form);
					}
				}
			}
			model.addAttribute("questionaire", questionaire);
			model.addAttribute("flag", 2);
		}
		model.addAttribute("formList", unSelectedForms);
		model.addAttribute("selectedForms", selectedForms);
		return "questionnaireConfig";
	}

	private List<Form> getFormListHavingData(List<Form> formList) {
		List<Form> forms = new ArrayList<Form>();
		for (Form form : formList) {
			List<FormData> formDatas = glitService.getAllFormDatabyFormId(form.getFormId()); 
			if (formDatas != null && !formDatas.isEmpty()) {
				forms.add(form);
			}
		}
		return forms;
	}

	@RequestMapping(value = "/submitQuestionaireConfig.spring", method = RequestMethod.POST)
	public String submitQuestionaire(Model model, HttpServletRequest request) {
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		List<Long> formIds = new ArrayList<Long>();
		String questionaireName = request.getParameter("questionaireName");
		String questionaireId = request.getParameter("questionaireId");
		String[] arrayOfFormIds= request.getParameterValues("selectedForm");
		for (String string : arrayOfFormIds) {
			formIds.add(Long.parseLong(string));
		}
		if (questionaireId != null && questionaireId != "") {
			Questionaire questionaire = glitService.getQuestionaireBasedOnId(Long.parseLong(questionaireId));
			glitService.deleteQuestionaire(questionaire);
		}
		String username = (String) session.getAttribute("username");
		User user = glitService.getUserbyUserName(username);
		Questionaire questionaire = new Questionaire();
		questionaire.setDate(new Date());
		questionaire.setName(questionaireName);
		questionaire.setClient(glitService.getClientById(clientId));
		questionaire.setUser(user);
		questionaire = glitService.addQuestionaire(questionaire);
		for (Long formId : formIds) {
			Form  form = glitService.getFormbyFormId(formId);
			QuestionaireConfig questionaireConfig = new QuestionaireConfig();
			questionaireConfig.setQuestionaire(questionaire);
			questionaireConfig.setForm(form);
			questionaireConfig = glitService.addQuestionaireConfig(questionaireConfig);
		}
		return "redirect:/questionnaire.spring";
	}
	@RequestMapping(value = "/interActionReport.spring", method = RequestMethod.GET)
	public String showInteractionReport(@RequestParam("qId")String questionaireId, Model model, HttpServletRequest request) {
		Map<String, Map<String,List<String>>> headerMap = new LinkedHashMap<String, Map<String,List<String>>>();
		Map<Date, Map<Long,List<String>>> valueMap = new LinkedHashMap<Date, Map<Long,List<String>>>();
		session = request.getSession();
		String role = (String) session.getAttribute("role");
		List<Form> forms = new ArrayList<Form>();
		List<QuestionaireConfig> configs = glitService.getQuestionaireConfigBasedOnQId(Long.parseLong(questionaireId));
		for (QuestionaireConfig questionaireConfig : configs) {
			forms.add(questionaireConfig.getForm());
		}
		List<InteractionReport> interactionReports = glitService.getInteractionReportbyquestionaireId(Long.parseLong(questionaireId));
		for (InteractionReport interactionReport : interactionReports) {
			Map<Long,List<String>> innerValueMap =new LinkedHashMap<Long, List<String>>();
			Map<String,List<String>> innerMap =new LinkedHashMap<String, List<String>>();
			for (Form form : forms) {
				List<String> fieldValues = new LinkedList<String>();
				List<String> fieldNames = new LinkedList<String>();
				List<FormFields> fields = glitService.getFormFieldsbyFormId(form.getFormId());
				for (FormFields formFields : fields) {
					String values = " ";
					InteractionReportData interactionReportData = glitService.getInteractionReportDatabyInteractionIdAndFieldId(interactionReport.getInteractionId(),formFields.getFieldId());
					if(interactionReportData.getValue() != null && !interactionReportData.getValue().isEmpty()) {
						values = "";
						List<String> strings2 = Arrays.asList(interactionReportData.getValue().split(", "));
						int i = 1;
						for (String string2 : strings2) {
							FormDataValue dataValue = glitService.getFormDataValueById(Long.parseLong(string2));
							if(i < strings2.size()) {
								values = values + dataValue.getValue() + ", ";
							} else {
								values = values +dataValue.getValue();
							}
							i++;
						}
					}
					fieldNames.add(formFields.getFieldName());
					fieldValues.add(values);
				}
				innerMap.put(form.getFormName(), fieldNames);
				innerValueMap.put(form.getFormId(), fieldValues);
			}
			headerMap.put("Date", innerMap);
			valueMap.put(interactionReport.getInteractionDate(), innerValueMap);
		}
		model.addAttribute("valueMap", valueMap);
		model.addAttribute("role", role);
		model.addAttribute("headerMap", headerMap);
		model.addAttribute("questionaireId", questionaireId);
		return "interactionReport";
	}

	@RequestMapping(value = "/addInteractionReport.spring", method = RequestMethod.GET)
	public String addInteractionReport(@RequestParam("questionaireId")Long questionaireId ,Model model, HttpServletRequest request) {
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		List<Form> forms = new ArrayList<Form>();
		List<QuestionaireConfig> questionaireConfigs = glitService.getQuestionaireConfigBasedOnQId(questionaireId);
		for (QuestionaireConfig questionaireConfig : questionaireConfigs) {
			forms.add(questionaireConfig.getForm());
		}
		List<QuestionaireFormDTO> questionaireFormUtils = new ArrayList<QuestionaireFormDTO>();
		boolean formValue = false;
		for (Form form : forms) {
			List<FormFields> fields = glitService.getFormFieldsbyFormId(form
					.getFormId());
			QuestionaireFormDTO questionaireFormUtil = new QuestionaireFormDTO();
			List<FieldDTO> fieldUtils = new ArrayList<FieldDTO>();
			for (FormFields formFields : fields) {
				List<FormDataValue> formDataValues = glitService
						.getFormDataValuebyFieldId(formFields.getFieldId());
				if (formDataValues.size() > 0) {					
					FieldDTO fieldUtil = new FieldDTO();
					fieldUtil.setFieldId(formFields.getFieldId());
					fieldUtil.setFieldName(formFields.getFieldName());
					fieldUtil.setMultiselect(formFields.isMultiSelect());
					fieldUtil.setFormDataValues(formDataValues);
					fieldUtils.add(fieldUtil);
					formValue = true;
				}
				else
					formValue = false;
			}
			if (formValue) {
				questionaireFormUtil.setFormId(form.getFormId());
				questionaireFormUtil.setName(form.getFormName());
				questionaireFormUtil.setFieldUtilList(fieldUtils);
				questionaireFormUtils.add(questionaireFormUtil);
			}
		}
		model.addAttribute("questionaireList", questionaireFormUtils);
		model.addAttribute("questionaireListSize", questionaireFormUtils.size());
		model.addAttribute("clientId", clientId);
		model.addAttribute("questionaireId", questionaireId);
		return "addInteractionReport";
	}

	@RequestMapping(value = "/submitInteractionReport.spring", method = RequestMethod.POST)
	public String submitInteractionReport(HttpServletRequest request) {
		String questionaireId = request.getParameter("questionaireId");
		List<Long> formIds = new ArrayList<Long>();
		List<Form> forms = new ArrayList<Form>();
		List<QuestionaireConfig> questionaireConfigs = glitService.getQuestionaireConfigBasedOnQId(Long.parseLong(questionaireId));
		for (QuestionaireConfig questionaireConfig : questionaireConfigs) {
			forms.add(questionaireConfig.getForm());
		}
		for (Form form : forms) {
			formIds.add(form.getFormId());
		}
		Questionaire questionaire = glitService.getQuestionaireBasedOnId(Long.parseLong(questionaireId));
		InteractionReport interactionReport = new InteractionReport();
		interactionReport.setInteractionDate(new Date());
		interactionReport.setQuestionaire(questionaire);
		interactionReport = glitService.addInteractionReport(interactionReport);
		List<FormFields> formFields = glitService
				.getFormFieldsbyFormIds(formIds);
		for (FormFields fields : formFields) {
			InteractionReportData interactionReportData = new InteractionReportData();
			interactionReportData.setInteractionReport(interactionReport);
			interactionReportData.setFormFields(fields);
			List<String> strings = new ArrayList<String>();
			String[] value = request.getParameterValues(Long.toString(fields
					.getFieldId()));
			String values = null;
			if(value != null) {
				for (String string : value) {
					strings.add(string);
				}
				values = strings.toString().replaceAll("[\\[\\]]", "");
				interactionReportData.setValue(values);
				glitService.addInretactionReportData(interactionReportData);
			}
		}
		return "redirect:/interActionReport.spring?qId="+questionaireId;
	}

	@RequestMapping(value = "/formdata.spring", method = RequestMethod.GET)
	public String showFormData(@RequestParam("formId") String formId,
			HttpServletRequest request, Model model) {
		session = request.getSession();
		long clientId = (Long) session.getAttribute("clientId");
		String role = (String) session.getAttribute("role");
		boolean isClientHaveQuestionaire = glitService.isClientHaveQuestionaire(clientId);
		List<FormFields> formFields = glitService.getFormFieldsbyFormId(Long
				.parseLong(formId));
		List<FormData> formDatas = glitService.getAllFormDatabyFormId(Long
				.parseLong(formId));
		String[][] formDataArrayStrings = new String[formDatas.size()][formFields
		                                                               .size() + 1];
		for (int i = 0; i < formDatas.size(); i++) {
			for (int j = 0; j <= formFields.size(); j++) {
				if (j == 0) {
					formDataArrayStrings[i][j] = Long.toString(formDatas.get(i)
							.getDataId());
				} else {
					FormDataValue dataValue = glitService
							.getFormDataValueObject(formDatas.get(i)
									.getDataId(), formFields.get(j - 1)
									.getFieldId());
					formDataArrayStrings[i][j] = dataValue.getValue();
				}
			}
		}
		Form form = glitService.getFormbyFormId(Long.parseLong(formId));
		model.addAttribute("isClientHaveQuestionaire", isClientHaveQuestionaire);
		model.addAttribute("role", role);
		model.addAttribute("clientId", clientId);
		model.addAttribute("formFieldSize", formFields.size());
		model.addAttribute("formFields", formFields);
		model.addAttribute("formDatas", formDatas);
		model.addAttribute("formDataArrayStringSize", formDataArrayStrings.length);
		model.addAttribute("formDataArrayStrings", formDataArrayStrings);
		model.addAttribute("formId", formId);
		model.addAttribute("form", form);
		return "formdata";
	}

	@RequestMapping(value = "/deleteForm.spring", method=RequestMethod.GET)
	public String deleteForm(@RequestParam("formId")long formId,Model model,HttpServletRequest request) {
		Form form = glitService.getFormbyFormId(formId);
		session = request.getSession();
		long clientId = (Long)session.getAttribute("clientId");
		glitService.deleteForm(form);
		String url = "redirect:/form.spring?clientId=" + clientId;
		return url;
	}

	@RequestMapping(value = "/deleteFormData.spring", method=RequestMethod.GET)
	public String deleteFormData(@RequestParam("formId") String formId,
			@RequestParam("dataId") String dataId, Model model) {
		long formDatatId = Long.parseLong(dataId); 
		glitService.deleteFormData(formDatatId);
		String url = "redirect:/formdata.spring?formId=" + formId  ;
		return url;
	}

	@RequestMapping(value = "/copyClientForm.spring", method=RequestMethod.GET)
	public String copyForm(Model model,HttpServletRequest request) {
		List<Client> clients = glitService.getAllClients();
		session = request.getSession();
		long clientId = (Long)session.getAttribute("clientId");
		Client client = glitService.getClientById(clientId);
		for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext();) {
			Client client1 = (Client) iterator.next();
			if(client1.getClientId() == client.getClientId()) {
				iterator.remove();
			}
		}
		List<Form> forms = new ArrayList<Form>();
		model.addAttribute("clientList", clients);
		model.addAttribute("selectedForms", forms);
		return "copyClientForm";
	}

	@RequestMapping(value="/getClientForms.spring",method = RequestMethod.GET)  
	public @ResponseBody 
	List<Object[]> getForms(@RequestParam(value = "clientId") String clientId,HttpServletRequest request,HttpServletResponse response) {
		List<Form> forms = glitService.getAllFormBasedOnClientId(Long.parseLong(clientId));
		List<Object[]> formIdNamePairList = new ArrayList<Object[]>();
		for (Form form : forms) {
			Object[] formIdNamePair = new Object[2];
			formIdNamePair[0] = form.getFormId();
			formIdNamePair[1] = form.getFormName();
			formIdNamePairList.add(formIdNamePair);
		}
		return formIdNamePairList;
	}

	@RequestMapping(value = "/selectedForm.spring", method = RequestMethod.POST)
	public String validateFormForCopy(Model model,HttpServletRequest request) {
		List<ValidateCopyFormDTO> validateCopyFormList = new ArrayList<ValidateCopyFormDTO>();
		session = request.getSession();
		long clientIdfromSession = (Long)session.getAttribute("clientId");
		String clientId = request.getParameter("clientId");
		String[] arrayOfFormIds= request.getParameterValues("selectedForm");
		Client client = glitService.getClientById(Long.parseLong(clientId));
		for (String string : arrayOfFormIds) {
			ValidateCopyFormDTO copyFormDTO = new ValidateCopyFormDTO();
			Boolean isNameExist = Boolean.FALSE;
			Form form = glitService.getFormbyFormId(Long.parseLong(string));
			String nameExist = glitService.checkFormName(form.getFormName(), clientIdfromSession); 
			if(nameExist.equals(GlitContants.IN_USE)) {
				isNameExist = Boolean.TRUE;
			}
			copyFormDTO.setNameExist(isNameExist);
			copyFormDTO.setForm(form);
			validateCopyFormList.add(copyFormDTO);
		}
		model.addAttribute("client", client);
		model.addAttribute("formUtil", validateCopyFormList);
		return "validateCopyForms";
	}
	@RequestMapping(value = "/submitCopyForm.spring", method = RequestMethod.POST)
	public String submitCopyForm(Model model,HttpServletRequest request) {
		session = request.getSession();
		long clientIdSession = (Long)session.getAttribute("clientId");
		Long clientId = Long.parseLong(request.getParameter("clientId"));
		List<Form> forms = glitService.getAllFormBasedOnClientId(clientId);
		Client client = glitService.getClientById(clientIdSession);
		for (Form form : forms) {
			String formName = request.getParameter(Long.toString(form.getFormId()));
			if(formName != null && !formName.isEmpty()) {
				Form newForm =  new Form();
				newForm.setClient(client);
				newForm.setFormName(formName);
				newForm = glitService.addForm(newForm);
				List<FormFields> formFields = glitService.getFormFieldsbyFormId(form.getFormId());
				for (FormFields formField : formFields) {
					FormFields newFormField = new FormFields();
					newFormField.setForm(newForm);
					newFormField.setFieldDataType(formField.getFieldDataType());
					newFormField.setFieldLimit(formField.getFieldLimit());
					newFormField.setFieldName(formField.getFieldName());
					newFormField.setFieldType(formField.getFieldType());
					newFormField.setMandatory(formField.getMandatory());
					newFormField.setMultiSelect(formField.isMultiSelect());
					glitService.addFormFields(newFormField);
				}
			}
		}
		String url = "redirect:/form.spring?clientId=" + clientIdSession;
		return url;
	}

	@RequestMapping(value = "/deleteQuestionaire.spring", method=RequestMethod.GET)
	public String deleteQuestionaire(@RequestParam("questionaireId")long questionaireId,Model model,HttpServletRequest request) {
		Questionaire questionaire = glitService.getQuestionaireBasedOnId(questionaireId);
		glitService.deleteQuestionaire(questionaire);
		String url = "redirect:/questionnaire.spring";
		return url;
	}

	@RequestMapping(value = "/deleteClient.spring", method=RequestMethod.GET)
	public String deleteClient(@RequestParam("clientId")long clientId,Model model,HttpServletRequest request) {
		Client client = glitService.getClientById(clientId);
		List<Questionaire> questionaires = glitService.getAllQuestionaireBasedOnClient(clientId);
		if(questionaires != null && !questionaires.isEmpty()) {
			for (Questionaire questionaire : questionaires) {
				List<InteractionReport> interactionReports = glitService.getInteractionReportbyquestionaireId(questionaire.getQuestionaireId());
				if(interactionReports != null && !interactionReports.isEmpty()) {
					for (InteractionReport interactionReport : interactionReports) {
						glitService.deleteInteractionReport(interactionReport);
					}
				}
				List<Dashboard> dashboards = dashboardService.getDashboardByQuestionaireId(questionaire.getQuestionaireId());
				if (dashboards != null && !dashboards.isEmpty()) {
					for (Dashboard dashboard : dashboards) {
						dashboardService.deleteDashboard(dashboard);
					}
				}
				glitService.deleteQuestionaire(questionaire);
			}
		}
		List<Form> forms = glitService.getAllFormBasedOnClientId(clientId);
		if (forms != null && !forms.isEmpty()) {
			for (Form form : forms) {
				List<FormData> formDatas = glitService.getAllFormDatabyFormId(form.getFormId());
				if (formDatas != null && !formDatas.isEmpty() ) {
					for (FormData formData : formDatas) {
						glitService.deleteFormData(formData.getDataId());
					}
				}
				glitService.deleteForm(form);
			}
		}
		glitService.deleteClient(client);
		String url = "redirect:/client.spring";
		return url;
	}

	@RequestMapping(value = "/editClient.spring", method=RequestMethod.GET)
	public String editClient(@RequestParam("clientId")long clientId,Model model,HttpServletRequest request) {
		Client client = glitService.getClientById(clientId);
		model.addAttribute("client", client);
		String url = "editClient";
		return url;
	}
}
