package com.dell.glit.util;

import java.io.Serializable;

import com.dell.glit.model.FormFields;

public class FormDataDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536142818231671480L;
	private String value;
	private FormFields formFields;
	
	public FormDataDTO() {
	}
	
	public FormDataDTO(String value, FormFields formFields) {
		super();
		this.value = value;
		this.formFields = formFields;
	}
	
	@Override
	public String toString() {
		return "FormDataUtil [value=" + value + ", formFields=" + formFields
				+ "]";
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FormFields getFormFields() {
		return formFields;
	}

	public void setFormFields(FormFields formFields) {
		this.formFields = formFields;
	}
	
	
}
