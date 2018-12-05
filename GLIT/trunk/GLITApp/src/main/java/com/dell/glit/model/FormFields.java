/**
 * 
 */
package com.dell.glit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author SNEHASISH_SHITH
 *
 */
@Entity
public class FormFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8741669373919036147L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long fieldId;
	@Column
	private String fieldName;
	@Column
	private String fieldType;
	@Column
	private String fieldDataType;
	@Column
	private Integer fieldLimit;
	@Column
	private boolean multiSelect;
	@Column
	private boolean mandatory;
	@ManyToOne
	@JoinColumn(name="formId")
	private Form form;
	@OneToMany(mappedBy="formFields")
	private Set<FormDataValue> formDataValues;
	@OneToMany(mappedBy="formFields")
	private Set<InteractionReportData> questionnaireData;
	@OneToMany(mappedBy="formFields")
	private Set<DashboardConfig> dashboardConfig ;
	
	@Override
	public String toString() {
		return "FormFields [fieldId=" + fieldId + ", fieldName=" + fieldName
				+ ", fieldType=" + fieldType + ", fieldDataType="
				+ fieldDataType + ", fieldLimit=" + fieldLimit
				+ ", multiSelect=" + multiSelect + ", mandatory=" + mandatory
				+ ", form=" + form + ", formDataValues=" + formDataValues
				+ ", questionnaireData=" + questionnaireData
				+ ", dashboardConfig=" + dashboardConfig + "]";
	}


	public FormFields() {
	}


	public FormFields(long fieldId, String fieldName, String fieldType,
			String fieldDataType, Integer fieldLimit, boolean multiSelect,
			boolean mandatory,
			Form form, Set<FormDataValue> formDataValues,
			Set<InteractionReportData> questionnaires,
			Set<DashboardConfig> dashboardConfig) {
		super();
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.fieldDataType = fieldDataType;
		this.fieldLimit = fieldLimit;
		this.multiSelect = multiSelect;
		this.mandatory = mandatory;
		this.form = form;
		this.formDataValues = formDataValues;
		this.questionnaireData = questionnaires;
		this.dashboardConfig = dashboardConfig;
	}



	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
	
	public boolean getMandatory() {
		return mandatory;
	}
	
	
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldDataType() {
		return fieldDataType;
	}

	public void setFieldDataType(String fieldDataType) {
		this.fieldDataType = fieldDataType;
	}

	public Integer getFieldLimit() {
		return fieldLimit;
	}

	public void setFieldLimit(Integer fieldLimit) {
		this.fieldLimit = fieldLimit;
	}

	public boolean isMultiSelect() {
		return multiSelect;
	}

	public void setMultiSelect(boolean multiSelect) {
		this.multiSelect = multiSelect;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Set<FormDataValue> getFormDataValues() {
		return formDataValues;
	}

	public void setFormDataValues(Set<FormDataValue> formDataValues) {
		this.formDataValues = formDataValues;
	}
	public Set<InteractionReportData> getQuestionnaires() {
		return questionnaireData;
	}
	public void setQuestionnaires(Set<InteractionReportData> questionnaires) {
		this.questionnaireData = questionnaires;
	}

	public Set<DashboardConfig> getDashboardConfig() {
		return dashboardConfig;
	}

	public void setDashboardConfig(Set<DashboardConfig> dashboardConfigs) {
		this.dashboardConfig = dashboardConfigs;
	}	
}
