package com.dell.glit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dell.glit.dao.GLITDao;
import com.dell.glit.model.Client;
import com.dell.glit.model.Form;
import com.dell.glit.model.FormData;
import com.dell.glit.model.FormDataValue;
import com.dell.glit.model.FormFields;
import com.dell.glit.model.InteractionReport;
import com.dell.glit.model.Questionaire;
import com.dell.glit.model.QuestionaireConfig;
import com.dell.glit.model.InteractionReportData;
import com.dell.glit.model.User;
import com.dell.glit.util.GlitContants;

@Repository("glitDao")
@Transactional(rollbackFor = { Throwable.class, SQLException.class, Exception.class })
public class GLITDaoImpl implements GLITDao {

	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Client> getAllClients() {
		try {
			String query = "FROM " + GlitContants.CLIENT;
			logger.info("===>QUERY @ getAllClients() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<Client> clients = sessionFactory.getCurrentSession().createQuery(query).list();
			if(clients != null) 
				return clients;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllClients() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Client addClient(Client client) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(client);
			return client;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addClient() IS==>" + ex.getMessage());
			return null;
		}
	}

	public String getRoleNameBasedonUserId(long userId) {
		try {
			String query = "select r.roleName from " + GlitContants.ROLE + " r LEFT OUTER JOIN " + GlitContants.USER_ROLE + " ur ON r.roleId = ur.role_id AND ur.user_id = 1";
			logger.info("===>QUERY @ getRoleNameBasedonUserId() IS==>" + query);
			String roleName = sessionFactory.getCurrentSession().createQuery(query).toString();
			if(roleName != null) 
				return roleName;
			else 
				return null;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ getRoleNameBasedonUserId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<Form> getAllFormBasedOnClientId(long clientId) {
		try {
			String query = "FROM " + GlitContants.FORM + " where clientId = " + clientId;
			logger.info("===>QUERY @ getAllFormBasedOnClientId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<Form> forms = sessionFactory.getCurrentSession().createQuery(query).list();
			if(forms != null) 
				return forms;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllFormBasedOnClientId() IS==>" + ex.getMessage());
			return null;
		}
	}
	
	public Long getTotalEntriesofForm(long formId) {
		try {
			String query = "select count(*) from " + GlitContants.FORM_DATA + " where formId = " + formId;
			logger.info("===>QUERY @ getTotalEntriesofForm() IS==>" + query);
			Long count = (Long) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
				return count;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getTotalEntriesofForm() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Long getTotalFieldsofForm(long formId) {
		try {
			String query = "select count(*) from " + GlitContants.FORM_FIELDS + "  WHERE formId = " + formId ;
			logger.info("===>QUERY @ getTotalFieldsofForm() IS==>" + query);
			Long count = (Long) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
				return count;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getTotalFieldsofForm() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Form addForm(Form form) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(form);
			return form;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addForm() IS==>" + ex.getMessage());
			return null;
		}
	}

	public FormFields addFormFields(FormFields fields) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(fields);
			return fields;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addFormFields() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Client getClientById(long clientId) {
		try {
			String query = "FROM " + GlitContants.CLIENT + " where clientId = " + clientId;
			logger.info("===>QUERY @ getClientById() IS==>" + query);
			Client client = (Client) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(client != null) 
				return client;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getClientById() IS==>" + ex.getMessage());
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

	public FormData addFormData(FormData formData) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(formData);
			return formData;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addFormData() IS==>" + ex.getMessage());
			return null;
		}
	}

	public FormDataValue addFormDataValue(FormDataValue dataValue) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(dataValue);
			return dataValue;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addFormDataValue() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<Questionaire> getAllQuestionaireBasedOnClient(long clientId) {
		try {
			String query = "FROM " + GlitContants.QUESTIONAIRE + " where clientId = " + clientId;
			logger.info("===>QUERY @ getAllQuestionaireBasedOnClient() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<Questionaire> questionnaires = sessionFactory.getCurrentSession().createQuery(query).list();
			if(questionnaires != null) 
				return questionnaires;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllQuestionaireBasedOnClient() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<InteractionReportData> getInteractionReportDatabyInteractionReportId(
			long interactionReportId) {
		try {
			String query = "FROM " + GlitContants.INTERACTION_REPORT_DATA + " where interactionId = " + interactionReportId;
			logger.info("===>QUERY @ getInteractionReportDatabyInteractionReportId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<InteractionReportData> interactionReportDatas = sessionFactory.getCurrentSession().createQuery(query).list();
			if(interactionReportDatas != null) 
				return interactionReportDatas;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getInteractionReportDatabyInteractionReportId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<FormData> getAllFormDatabyFormId(long formId) {
		try {
			String query = "FROM " + GlitContants.FORM_DATA + " where formId = " + formId;
			logger.info("===>QUERY @ getAllFormDatabyFormId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<FormData> formDatas = sessionFactory.getCurrentSession().createQuery(query).list();
			if(formDatas != null) 
				return formDatas;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllFormDatabyFormId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public FormDataValue getFormDataValueObject(long dataId, long fieldId) {
		try {
			String query = "FROM " + GlitContants.FORM_DATA_VALUE + " where dataId = " + dataId + " AND fieldId = " + fieldId;
			logger.info("===>QUERY @ getvalueofFormDatavalue() IS==>" + query);
			FormDataValue value =  (FormDataValue) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(value != null) 
				return value;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getvalueofFormDatavalue() IS==>" + ex.getMessage());
			return null;
		}
	}

	public FormData getFormDatabyDataId(long dataId) {
		try {
			String query = "FROM " + GlitContants.FORM_DATA + " where dataId = " + dataId;
			logger.info("===>QUERY @ getAllFormDatabyFormId() IS==>" + query);
			FormData formData = (FormData) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(formData != null) 
				return formData;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllFormDatabyFormId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Questionaire addQuestionaire(Questionaire questionaire) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(questionaire);
			return questionaire;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addQuestionaire() IS==>" + ex.getMessage());
			return null;
		}
	}
	public List<FormFields> getFormFieldsbyFormIds(List<Long> formIds) {
		try {
			String formId = formIds.toString().replaceAll("[\\[\\]]","");
			String query = "FROM " + GlitContants.FORM_FIELDS + " where formId IN (" + formId + ")";
			logger.info("===>QUERY @ getFormFiledsbyFormIds() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<FormFields> fields = sessionFactory.getCurrentSession().createQuery(query).list();
			if(fields != null) 
				return fields;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormFiledsbyFormIds() IS==>" + ex.getMessage());
			return null;
		}	
	}

	public List<FormDataValue> getFormDataValuebyFieldId(Long fieldId) {
		try {
			String query = "FROM " + GlitContants.FORM_DATA_VALUE + " where fieldId = " + fieldId;
			logger.info("===>QUERY @ getFormDataValuebyFieldId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<FormDataValue> dataValues = sessionFactory.getCurrentSession().createQuery(query).list();
			if(dataValues != null) 
				return dataValues;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormDataValuebyFieldId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public User getUserbyUserId(long userId) {
		try {
			String query = "FROM " + GlitContants.USER + " where userId = " + userId;
			logger.info("===>QUERY @ getUserbyUserId() IS==>" + query);
			User user = (User) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(user != null) 
				return user;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getUserbyUserId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public User getUserbyUserName(String username) {
		try {
		String query = "FROM " + GlitContants.USER + " where name = '" + username +"'";
		logger.info("===>QUERY @ getUserbyUserName() IS==>" + query);
		User user = (User) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
		if(user != null) 
			return user;
		else 
			return null;
	} catch (Exception ex) {
		ex.printStackTrace();
		logger.error("===>EXCEPTION @ getUserbyUserName() IS==>" + ex.getMessage());
		return null;
	}
	}

	public void deleteForm(Form form) {
		try {
			String query = "DELETE FROM " + GlitContants.FORM_FIELDS + " where formId = '" + form.getFormId() +"'";
			logger.info("===>QUERY @ deleteForm() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
			sessionFactory.getCurrentSession().delete(form);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteForm() IS==>" + ex.getMessage());
		}
		
	}

	public boolean isClientHaveQuestionaire(long clientId) {
		try {
			String query = "FROM " + GlitContants.QUESTIONAIRE+ " where clientId = " + clientId;
			logger.info("===>QUERY @ isClientHaveQuestionaire() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<InteractionReportData> questionnaires = sessionFactory.getCurrentSession().createQuery(query).list();
			if(questionnaires != null && questionnaires.size() > 0) 
				return true;
			else 
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ isClientHaveQuestionaire() IS==>" + ex.getMessage());
			return false;
		}
	}

	public void deleteFormData(long formDatatId) {
		try {
			String query = "DELETE FROM " + GlitContants.FORM_DATA_VALUE + " where dataId = " + formDatatId ;
			logger.info("===>QUERY @ deleteFormData() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
			sessionFactory.getCurrentSession().delete(getFormDatabyDataId(formDatatId));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteFormData() IS==>" + ex.getMessage());
		}
	}

	public FormDataValue getFormDatabyId(long formValueId) {
		try {
			String query = "FROM " + GlitContants.FORM_DATA_VALUE + " where formValueId = " + formValueId;
			logger.info("===>QUERY @ getFormDatabyId() IS==>" + query);
			FormDataValue dataValue = (FormDataValue) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(dataValue != null) 
				return dataValue;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormDatabyId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public void deleteFormFields(long formId) {
		try {
			String query = "DELETE FROM " + GlitContants.FORM_FIELDS + " where formId = " + formId ;
			logger.info("===>QUERY @ deleteFormFields() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteFormFields() IS==>" + ex.getMessage());
		}
	}

	public QuestionaireConfig addQuestionaireConfig(QuestionaireConfig questionaireConfig) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(questionaireConfig);
			return questionaireConfig;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addQuestionaireConfig() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<QuestionaireConfig> getQuestionaireConfigBasedOnQId(
			long questionaireId) {
		try {
			String query = "FROM " + GlitContants.QUESTIONAIRE_CONFIG + " where questionaireId = " + questionaireId;
			logger.info("===>QUERY @ getQuestionaireConfigBasedOnQId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<QuestionaireConfig> questionaireConfigs = sessionFactory.getCurrentSession().createQuery(query).list();
			if(questionaireConfigs != null) 
				return questionaireConfigs;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getQuestionaireConfigBasedOnQId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Questionaire getQuestionaireBasedOnId(long questionaireId) {
		try {
			String query = "FROM " + GlitContants.QUESTIONAIRE + " where questionaireId = " + questionaireId;
			logger.info("===>QUERY @ getQuestionaireBasedOnId() IS==>" + query);
			Questionaire questionaire = (Questionaire) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(questionaire != null) 
				return questionaire;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getQuestionaireBasedOnId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public InteractionReport addInteractionReport(
			InteractionReport interactionReport) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(interactionReport);
			return interactionReport;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addInteractionReport() IS==>" + ex.getMessage());
			return null;
		}
	}

	public InteractionReportData addInretactionReportData(
			InteractionReportData interactionReportData) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(interactionReportData);
			return interactionReportData;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addInretactionReportData() IS==>" + ex.getMessage());
			return null;
		}
	}

	public List<InteractionReport> getInteractionReportbyquestionaireId(
			long questionaireId) {
		try {
			String query = "FROM " + GlitContants.INTERACTION_REPORT + " where questionaireId = " + questionaireId;
			logger.info("===>QUERY @ getInteractionReportbyquestionaireId() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<InteractionReport> interactionReports = sessionFactory.getCurrentSession().createQuery(query).list();
			if(interactionReports != null) 
				return interactionReports;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getInteractionReportbyquestionaireId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public InteractionReportData getInteractionReportDatabyInteractionIdAndFieldId(
			long interactionId, long fieldId) {
		try {
			String query = "FROM " + GlitContants.INTERACTION_REPORT_DATA + " where interactionId = '" + interactionId + "' AND fieldId = '" + fieldId + "'";
			logger.info("===>QUERY @ getInteractionReportDatabyInteractionIdAndFieldId() IS==>" + query);
			InteractionReportData interactionReport = (InteractionReportData) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(interactionReport != null) 
				return interactionReport;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getInteractionReportDatabyInteractionIdAndFieldId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public FormFields getFormFieldsById(long fieldId) {
		try {
			String query = "FROM " + GlitContants.FORM_FIELDS + " where fieldId = " + fieldId;
			logger.info("===>QUERY @ getFormFieldsById() IS==>" + query);
			FormFields formField = (FormFields) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(formField != null) 
				return formField;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getFormFieldsById() IS==>" + ex.getMessage());
			return null;
		}
	}

	public String checkFormName(String formName,long clientId) {
		try {
			String query = "FROM " + GlitContants.FORM + " where formname = '" + formName+"' AND clientId="+clientId;
			logger.info("===>QUERY @ checkFormName() IS==>" + query);
			Form form = (Form) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(form != null) 
				return GlitContants.IN_USE;
			else 
				return GlitContants.AVAILABLE;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ checkFormName() IS==>" + ex.getMessage());
			return null;
		}
	}

	public String checkClientName(String clientName) {
		try {
			String query = "FROM " + GlitContants.CLIENT + " where clientName = '" + clientName+"'";
			logger.info("===>QUERY @ checkClientName() IS==>" + query);
			Client client = (Client) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(client != null) 
				return GlitContants.IN_USE;
			else 
				return GlitContants.AVAILABLE;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ checkClientName() IS==>" + ex.getMessage());
			return null;
		}
	}

	public boolean isQuestionaireHasInteraction(long questionaireId) {
		try {
			String query = "FROM " + GlitContants.INTERACTION_REPORT+ " where questionaireId = " + questionaireId;
			logger.info("===>QUERY @ isQuestionaireHasInteraction() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<InteractionReport> questionnaires = sessionFactory.getCurrentSession().createQuery(query).list();
			if(questionnaires != null && questionnaires.size() > 0) 
				return true;
			else 
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ isQuestionaireHasInteraction() IS==>" + ex.getMessage());
			return false;
		}
	}

	public void deleteQuestionaire(Questionaire questionaire) {
		try {
			String query = "DELETE FROM " + GlitContants.QUESTIONAIRE_CONFIG + " where questionaireId = '" + questionaire.getQuestionaireId() +"'";
			logger.info("===>QUERY @ deleteQuestionaire() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
			sessionFactory.getCurrentSession().delete(questionaire);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteQuestionaire() IS==>" + ex.getMessage());
		}
	}

	public void deleteInteractionReport(InteractionReport interactionReport) {
		try {
			String query = "DELETE FROM " + GlitContants.INTERACTION_REPORT_DATA + " where interactionId = '" + interactionReport.getInteractionId() +"'";
			logger.info("===>QUERY @ deleteInteractionReport() IS==>" + query);
			sessionFactory.getCurrentSession().createQuery(query).executeUpdate();
			sessionFactory.getCurrentSession().delete(interactionReport);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteInteractionReport() IS==>" + ex.getMessage());
		}
	}

	public void deleteClient(Client client) {
		try {
			sessionFactory.getCurrentSession().delete(client);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ deleteInteractionReport() IS==>" + ex.getMessage());
		}
		
	}

}
