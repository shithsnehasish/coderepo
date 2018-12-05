package com.dell.glit.util;

import java.io.Serializable;
import java.util.List;

import com.dell.glit.model.FormDataValue;

public class FieldDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8986887803303791735L;
	private long fieldId;
	private String fieldName;
	private Boolean multiselect;
	private List<FormDataValue> formDataValues;
	
	@Override
	public String toString() {
		return "FieldUtil [fieldId=" + fieldId + ", fieldName=" + fieldName
				+ ", multiselect=" + multiselect + ", formDataValues="
				+ formDataValues + "]";
	}
	
	public FieldDTO() {
	}

	public FieldDTO(long fieldId, String fieldName, Boolean multiselect,
			List<FormDataValue> formDataValues) {
		super();
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.multiselect = multiselect;
		this.formDataValues = formDataValues;
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Boolean getMultiselect() {
		return multiselect;
	}

	public void setMultiselect(Boolean multiselect) {
		this.multiselect = multiselect;
	}

	public List<FormDataValue> getFormDataValues() {
		return formDataValues;
	}

	public void setFormDataValues(List<FormDataValue> formDataValues) {
		this.formDataValues = formDataValues;
	}
	
}
