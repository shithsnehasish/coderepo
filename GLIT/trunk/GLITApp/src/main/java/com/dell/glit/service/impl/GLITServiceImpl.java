package com.dell.glit.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dell.glit.dao.GLITDao;
import com.dell.glit.model.Client;
import com.dell.glit.model.Form;
import com.dell.glit.model.FormData;
import com.dell.glit.model.FormDataValue;
import com.dell.glit.model.FormFields;
import com.dell.glit.model.InteractionReport;
import com.dell.glit.model.InteractionReportData;
import com.dell.glit.model.Questionaire;
import com.dell.glit.model.QuestionaireConfig;
import com.dell.glit.model.User;
import com.dell.glit.service.GLITService;
import com.dell.glit.util.ExcelDTO;
import com.dell.glit.util.ExcelUtility;
import com.dell.glit.util.ExcelUtilityImpl;

@Service(value= "glitService")
public class GLITServiceImpl implements GLITService {

	@Autowired
	private GLITDao glitDao;

	public List<Client> getAllClients() {
		return glitDao.getAllClients();
	}

	public Client addClient(Client client) {
		return glitDao.addClient(client);
	}

	public String getRoleNameBasedonUserId(long userId) {
		return glitDao.getRoleNameBasedonUserId(userId);
	}

	public List<Form> getAllFormBasedOnClientId(long clientId) {
		return glitDao.getAllFormBasedOnClientId(clientId);
	}

	public Long getTotalEntriesofForm(long formId) {
		return glitDao.getTotalEntriesofForm(formId);
	}

	public Long getTotalFieldsofForm(long formId) {
		return glitDao.getTotalFieldsofForm(formId);
	}

	public Form addForm(Form form) {
		return glitDao.addForm(form);
	}

	public FormFields addFormFields(FormFields fields) {
		return glitDao.addFormFields(fields);
	}

	public Client getClientById(long clientId) {
		return glitDao.getClientById(clientId);
	}

	public List<FormFields> getFormFieldsbyFormId(long formId) {
		return glitDao.getFormFieldsbyFormId(formId);
	}

	public Form getFormbyFormId(long formId) {
		return glitDao.getFormbyFormId(formId);
	}

	public FormData addFormData(FormData formData) {
		return glitDao.addFormData(formData);
	}

	public FormDataValue addFormDataValue(FormDataValue dataValue) {
		return glitDao.addFormDataValue(dataValue);
	}

	public List<Questionaire> getAllQuestionaireBasedOnClient(long clientId) {
		return glitDao.getAllQuestionaireBasedOnClient(clientId);
	}
	public List<InteractionReportData> getInteractionReportDatabyInteractionReportId(
			long questionaireId) {
		return glitDao.getInteractionReportDatabyInteractionReportId(questionaireId);
	}

	public List<FormData> getAllFormDatabyFormId(long formId) {
		return glitDao.getAllFormDatabyFormId(formId);
	}

	public FormDataValue getFormDataValueObject(long dataId, long fieldId) {
		return glitDao.getFormDataValueObject(dataId, fieldId);
	}

	public FormData getFormDatabyDataId(long dataId) {
		return glitDao.getFormDatabyDataId(dataId);
	}

	public Questionaire addQuestionaire(Questionaire questionaire) {
		return glitDao.addQuestionaire(questionaire);
	}
	public List<FormFields> getFormFieldsbyFormIds(List<Long> formIds) {
		return glitDao.getFormFieldsbyFormIds(formIds);
	}

	public List<FormDataValue> getFormDataValuebyFieldId(Long fieldId) {
		return glitDao.getFormDataValuebyFieldId(fieldId);
	}

	public User getUserbyUserId(long userId) {
		return glitDao.getUserbyUserId(userId);
	}

	public User getUserbyUserName(String username) {
		return glitDao.getUserbyUserName(username);
	}

	public void deleteForm(Form form) {
		glitDao.deleteForm(form);
	}

	public boolean isClientHaveQuestionaire(long clientId) {
		return glitDao.isClientHaveQuestionaire(clientId);
	}

	public void deleteFormData(long formDatatId) {
		glitDao.deleteFormData(formDatatId);
	}

	public FormDataValue getFormDataValueById(long formValueId) {
		return glitDao.getFormDatabyId(formValueId);
	}
	public void deleteFormFields(long formId) {
		glitDao.deleteFormFields(formId);		
	}
	public QuestionaireConfig addQuestionaireConfig(QuestionaireConfig questionaireConfig) {
		return glitDao.addQuestionaireConfig(questionaireConfig);
	}

	public List<QuestionaireConfig> getQuestionaireConfigBasedOnQId(
			long questionaireId) {
		return glitDao.getQuestionaireConfigBasedOnQId(questionaireId);
	}

	public Questionaire getQuestionaireBasedOnId(long questionaireId) {
		return glitDao.getQuestionaireBasedOnId(questionaireId);
	}

	public InteractionReport addInteractionReport(
			InteractionReport interactionReport) {
		return glitDao.addInteractionReport(interactionReport);
	}

	public InteractionReportData addInretactionReportData(
			InteractionReportData interactionReportData) {
		return glitDao.addInretactionReportData(interactionReportData);
	}

	public List<InteractionReport> getInteractionReportbyquestionaireId(
			long questionaireId) {
		return glitDao.getInteractionReportbyquestionaireId(questionaireId);
	}

	public InteractionReportData getInteractionReportDatabyInteractionIdAndFieldId(
			long interactionId, long fieldId) {
		return glitDao.getInteractionReportDatabyInteractionIdAndFieldId(interactionId, fieldId);
	}

	public FormFields getFormFieldsById(long fieldId) {
		return glitDao.getFormFieldsById(fieldId);
	}

	public String checkFormName(String formName,long clientId) {
		return glitDao.checkFormName(formName,clientId);
	}

	public ExcelDTO uploadExcelData(MultipartFile uploadItem) {
		try {
			InputStream stream = uploadItem.getInputStream();
			ExcelUtility utility = new ExcelUtilityImpl();
			ExcelDTO excelDTO = utility.getFormDTOFromExcelSheetsList(stream);
			return excelDTO;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public String checkClientName(String clientName) {
		return glitDao.checkClientName(clientName);
	}

	public boolean isQuestionaireHasInteraction(long questionaireId) {
		return glitDao.isQuestionaireHasInteraction(questionaireId);
	}

	public void deleteQuestionaire(Questionaire questionaire) {
		glitDao.deleteQuestionaire(questionaire);
	}

	public void deleteInteractionReport(InteractionReport interactionReport) { 
		glitDao.deleteInteractionReport(interactionReport);
	}

	public void deleteClient(Client client) {
		glitDao.deleteClient(client);
	}	
}
