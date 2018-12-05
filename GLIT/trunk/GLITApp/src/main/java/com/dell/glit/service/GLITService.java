package com.dell.glit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
import com.dell.glit.util.ExcelDTO;


public interface GLITService {
	
	public List<Client> getAllClients();
	public Client addClient(Client client);
	public Client getClientById(long clientId);
	
	public String getRoleNameBasedonUserId(long userId); 
	
	public List<Form> getAllFormBasedOnClientId(long clientId);
	public Long getTotalEntriesofForm(long formId);
	public Long getTotalFieldsofForm(long formId);
	public Form addForm(Form form);
	public void deleteForm(Form form);
	public Form getFormbyFormId(long formId);
	
	public List<FormData> getAllFormDatabyFormId(long formId);
	public FormData addFormData(FormData formData);
	public FormData getFormDatabyDataId(long dataId);
	
	public FormFields addFormFields(FormFields fields);
	public FormFields getFormFieldsById(long fieldId);
	public List<FormFields> getFormFieldsbyFormId(long formId);
	public List<FormFields> getFormFieldsbyFormIds(List<Long> formIds);
	
	public FormDataValue getFormDataValueObject(long dataId, long fieldId);
	public FormDataValue addFormDataValue(FormDataValue dataValue);
	public List<FormDataValue> getFormDataValuebyFieldId(Long fieldId);
	
	public Questionaire  addQuestionaire(Questionaire questionaire);
	public List<Questionaire> getAllQuestionaireBasedOnClient(long clientId);
	
	public List<InteractionReportData> getInteractionReportDatabyInteractionReportId(long interactionReportId);
	public User getUserbyUserId(long userId);
	public User getUserbyUserName(String username);
	public boolean isClientHaveQuestionaire(long clientId);
	public void deleteFormData(long formDatatId);
	public FormDataValue getFormDataValueById(long formValueId);
	public void deleteFormFields(long formId);
	public QuestionaireConfig addQuestionaireConfig(QuestionaireConfig questionaireConfig);
	public List<QuestionaireConfig> getQuestionaireConfigBasedOnQId(
			long questionaireId);
	public Questionaire getQuestionaireBasedOnId(long questionaireId);
	public InteractionReport addInteractionReport(
			InteractionReport interactionReport);
	public InteractionReportData addInretactionReportData(
			InteractionReportData interactionReportData);
	public List<InteractionReport> getInteractionReportbyquestionaireId(
			long questionaireId);
	public InteractionReportData getInteractionReportDatabyInteractionIdAndFieldId(
			long interactionId, long fieldId);
	public String checkFormName(String formName,long clientId);
	
	public ExcelDTO uploadExcelData(MultipartFile multipartFile);
	public String checkClientName(String clientName);
	public boolean isQuestionaireHasInteraction(long qusetionaireId);
	public void deleteQuestionaire(Questionaire questionaire);
	public void deleteInteractionReport(InteractionReport interactionReport);
	public void deleteClient(Client client);
}
