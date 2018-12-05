package com.dell.glit.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dell.glit.dao.DashboardDao;
import com.dell.glit.model.Client;
import com.dell.glit.model.Dashboard;
import com.dell.glit.model.DashboardConfig;
import com.dell.glit.model.Form;
import com.dell.glit.model.FormFields;
import com.dell.glit.model.Questionaire;
import com.dell.glit.model.InteractionReportData;
import com.dell.glit.model.User;
import com.dell.glit.util.DashboardConfigDTO;
import com.dell.glit.util.EditDashboardConfigDTO;
import com.dell.glit.util.GlitContants;

@Repository("dashboardDao")
@Transactional(rollbackFor = { Throwable.class, SQLException.class, Exception.class })
public class DashboardDaoImpl implements DashboardDao{
	
private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;

	public DashboardConfig addDashboardConfig(String reportName,
			FormFields formField, String chartType, String criteria,
			int priority) {
		DashboardConfig dashboardConfig = new DashboardConfig();
		dashboardConfig.setCriteria(criteria);
		dashboardConfig.setFormFields(formField);
		dashboardConfig.setReportName(reportName);
		dashboardConfig.setTypeOfChart(chartType);
	
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(dashboardConfig);
			return dashboardConfig;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addDashboardConfig() IS==>" + ex.getMessage());
			return null;
		}
	}
	
	public List<DashboardConfigDTO> showAllDashboardConfig(long dashboardId) {
		try {
			List<DashboardConfigDTO> dashboardConfigUtils = new ArrayList<DashboardConfigDTO>();
			String query = "FROM " + GlitContants.DASHBOARD_CONFIG + " where dashboardId = "+ dashboardId;
			logger.info("===>QUERY @ showAllDashboardConfig() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<DashboardConfig> dashboardConfigs = sessionFactory.getCurrentSession().createQuery(query).list();
			if(dashboardConfigs != null){
				for (DashboardConfig dashboardConfig : dashboardConfigs) {
					DashboardConfigDTO util = new DashboardConfigDTO();
						util.setFieldName(getFormFieldsByFieldId(dashboardConfig.getFormFields().getFieldId()).getFieldName());
						util.setFieldId(dashboardConfig.getFormFields().getFieldId());
						util.setFormName(getFormFieldsByFieldId(dashboardConfig.getFormFields().getFieldId()).getForm().getFormName());
						util.setReportName(dashboardConfig.getReportName());
						util.setTypeOfChart(dashboardConfig.getTypeOfChart());
						util.setCriteria(dashboardConfig.getCriteria());
						util.setDashboardConfigId(dashboardConfig.getDashboardConfigId());
						util.setDashboardId(dashboardConfig.getDashboard().getDashboardId());
						util.setDashboardName(dashboardConfig.getDashboard().getDashboardName());
						dashboardConfigUtils.add(util);
					}
				}
				return dashboardConfigUtils;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ showAllDashboardConfig() IS==>" + ex.getMessage());
			return null;
		}
	}
	
	public FormFields getFormFieldsByFieldId(long fieldId) {
		try {
			String query = "FROM " + GlitContants.FORM_FIELDS + " where fieldId = " + fieldId;
			logger.info("===>QUERY @ getFormFieldsByFieldId() IS==>" + query);
			FormFields field = (FormFields) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(field != null){
				return field;
			}else{
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormFieldsByFieldId() IS==>" + ex.getMessage());
			return null;
		}
	}
	
	public Form getFormbyFormId(long formId) {
		try {
			String query = "FROM " + GlitContants.FORM + " where formId = " + formId;
			logger.info("===>QUERY @ getFormbyFormId() IS==>" + query);
			Form form = (Form) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(form != null) 
				return form;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormbyFormId() IS==>" + ex.getMessage());
			return null;
		}
	}
	public Long getTotalEntriesofDashboardConfig() {
		try {
			String query = "select count(*) from " + GlitContants.DASHBOARD_CONFIG;
			logger.info("===>QUERY @ getTotalEntriesofForm() IS==>" + query);
			Long count = (Long) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
				return count;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getTotalEntriesofForm() IS==>" + ex.getMessage());
			return null;
		}
	}
	public List <Questionaire> getQuestionnaireToShowChart(long clientId,String criteria, Date startDate,Date endDate) {
		String query = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String startDateStr = dateFormat.format(startDate);
			String endDateStr = dateFormat.format(endDate);
				query = "SELECT * FROM " + GlitContants.QUESTIONAIRE + " t WHERE t.date BETWEEN '" + startDateStr + "' AND '" + endDateStr + "'";
			logger.info("===>QUERY @ getLastTenDaysQuestionnaire() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<Object[]>  questionaire =  sessionFactory.getCurrentSession().createSQLQuery(query).list();
			if(questionaire != null) 
				return convertToQuestionaireObject(questionaire);
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormbyFormId() IS==>" + ex.getMessage());
			return null;
		}
	
	}

	private List<Questionaire> convertToQuestionaireObject(
			List<Object[]> questionaire) {
		List<Questionaire> questionaires = new ArrayList<Questionaire>();
		for (Object[] object : questionaire) {
			Questionaire questionaire2 = new Questionaire();
			Long longId= ((BigInteger)object[0]).longValue();
			questionaire2.setQuestionaireId(longId);
			questionaire2.setDate((Date)object[1]);
			Client client = new Client();
			Long longClientId =((BigInteger)object[2]).longValue();
			client.setClientId(longClientId);
			questionaire2.setClient(client);
			User user = new User();
			Long userId = ((BigInteger)object[3]).longValue();
			user.setUserId(userId);
			questionaire2.setUser(user);
			questionaires.add(questionaire2);
		}
		return questionaires;
	}

	public List<InteractionReportData> getAllInteractionDataByInteractionIdAndFieldId(List<Long> interactionIds,long fieldId) {

		try {
			String interactionId = interactionIds.toString().replaceAll("[\\[\\]]","");
			
			String query = "FROM " + GlitContants.INTERACTION_REPORT_DATA + " where interactionId IN (" + interactionId + ") AND fieldId = "+fieldId;
			logger.info("===>QUERY @ getAllInteractionDataByInteractionIdAndFieldId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<InteractionReportData> interactionDatas = sessionFactory.getCurrentSession().createQuery(query).list();
			if(interactionDatas != null) 
				return interactionDatas;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllInteractionDataByInteractionIdAndFieldId() IS==>" + ex.getMessage());
			return null;
		}	
	}
	
	public void deleteDashboardConfigData(long dashboardConfigId) {
		try {
			String query = "DELETE FROM " + GlitContants.DASHBOARD_CONFIG + " where dashboardConfigId = " + dashboardConfigId ;
			logger.info("===>QUERY @ deleteDashboardConfigData() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteDashboardConfigData() IS==>" + ex.getMessage());
		}
	}
	
	public void deleteDashboard(long dashboardId) {
		try {
			String query = "DELETE FROM " + GlitContants.DASHBOARD_CONFIG + " where dashboardId = " + dashboardId ;
			logger.info("===>QUERY @ deleteDashboardConfig() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
			
			String deleteDashboard = "DELETE FROM " + GlitContants.DASHBOARD + " where dashboardId = " + dashboardId ;
			logger.info("===>QUERY @ deleteDashboard() IS==>" + deleteDashboard);
			sessionFactory.getCurrentSession().createQuery(deleteDashboard).executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteDashboard() IS==>" + ex.getMessage());
		}
	}
	
	public DashboardConfig addDashboardConfig(DashboardConfig dashboardConfig) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(dashboardConfig);
			return dashboardConfig;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addDashboardConfig() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Dashboard addDashboard(Dashboard dashboard) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(dashboard);
			return dashboard;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addDashboard() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Dashboard getDashBoardById(long dashboardId) {
		try {
			String query = "FROM " + GlitContants.DASHBOARD + " where dashboardId = " + dashboardId;
			logger.info("===>QUERY @ getDashBoardById() IS==>" + query);
			Dashboard dashboard = (Dashboard) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(dashboard != null) 
				return dashboard;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getDashBoardById() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<Dashboard> getAllDashboardByClientId(List<Long> questionaireIds) {
		try {
			String questionaireId = questionaireIds.toString().replaceAll("[\\[\\]]","");
			String query = "FROM " + GlitContants.DASHBOARD + " where questionaireId IN (" + questionaireId + ")";
			logger.info("===>QUERY @ getAllDashboardByClientId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<Dashboard> dashboards = sessionFactory.getCurrentSession().createQuery(query).list();
			if(dashboards != null) 
				return dashboards;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllDashboardByClientId() IS==>" + ex.getMessage());
			return null;
		}	
	}

	public List<Dashboard> getDashboardByQuestionaireId(long questionaireId) {
		try {
			String query = "FROM " + GlitContants.DASHBOARD + " where questionaireId  = " + questionaireId ;
			logger.info("===>QUERY @ getDashboardByQuestionaireId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<Dashboard> dashboards = sessionFactory.getCurrentSession().createQuery(query).list();
			if(dashboards != null) 
				return dashboards;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getDashboardByQuestionaireId() IS==>" + ex.getMessage());
			return null;
		}	
	}

	public void deleteDashboard(Dashboard dashboard) {
		try {
			String query = "DELETE FROM " + GlitContants.DASHBOARD_CONFIG + " where dashboardId = " + dashboard.getDashboardId() ;
			logger.info("===>QUERY @ deleteDashboard() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
			sessionFactory.getCurrentSession().delete(dashboard);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteDashboard() IS==>" + ex.getMessage());
		}
	}

	public List<DashboardConfig> getAllDashboardConfigByDashboardId(long dashboardId) {
		try {
			String query = "FROM " + GlitContants.DASHBOARD_CONFIG + " where dashboardId = " + dashboardId;
			logger.info("===>QUERY @ getAllDashboardConfigByDashboardId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<DashboardConfig> dashboards = sessionFactory.getCurrentSession().createQuery(query).list();
			if(dashboards != null) 
				return dashboards;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllDashboardConfigByDashboardId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<EditDashboardConfigDTO> showAllEditDashboardConfig(
			long dashboardId) {
		try {
			List<EditDashboardConfigDTO> dashboardConfigUtils = new ArrayList<EditDashboardConfigDTO>();
			String query = "FROM " + GlitContants.DASHBOARD_CONFIG + " where dashboardId = "+ dashboardId;
			logger.info("===>QUERY @ showAllDashboardConfig() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<DashboardConfig> dashboardConfigs = sessionFactory.getCurrentSession().createQuery(query).list();
			if(dashboardConfigs != null){
				for (DashboardConfig dashboardConfig : dashboardConfigs) {
					List<FormFields> formFields = getFormFieldsbyFormId(dashboardConfig.getFormFields().getForm().getFormId());
					EditDashboardConfigDTO util = new EditDashboardConfigDTO();
					util.setFieldName(getFormFieldsByFieldId(dashboardConfig.getFormFields().getFieldId()).getFieldName());
					util.setFieldId(dashboardConfig.getFormFields().getFieldId());
					util.setFormName(getFormFieldsByFieldId(dashboardConfig.getFormFields().getFieldId()).getForm().getFormName());
					util.setReportName(dashboardConfig.getReportName());
					util.setTypeOfChart(dashboardConfig.getTypeOfChart());
					util.setCriteria(dashboardConfig.getCriteria());
					util.setDashboardConfigId(dashboardConfig.getDashboardConfigId());
					util.setDashboardId(dashboardConfig.getDashboard().getDashboardId());
					util.setDashboardName(dashboardConfig.getDashboard().getDashboardName());
					util.setFormFields(formFields);
					dashboardConfigUtils.add(util);
				}
			}
			return dashboardConfigUtils;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ showAllDashboardConfig() IS==>" + ex.getMessage());
			return null;
		}
	}
	
	public List<FormFields> getFormFieldsbyFormId(long formId) {
		try {
			String query = "FROM " + GlitContants.FORM_FIELDS + " where formId = " + formId;
			logger.info("===>QUERY @ getFormFieldsbyFormId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<FormFields> fields = sessionFactory.getCurrentSession().createQuery(query).list();
			if(fields != null) 
				return fields;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormFieldsbyFormId() IS==>" + ex.getMessage());
			return null;
		}
	}
}
