package com.dell.glit.util;

import java.io.Serializable;

public class FormUtilDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long formId;
	private String formName;
	private Long totalEntries;
	private Long totalFields;
	@Override
	public String toString() {
		return "FormUtil [formId=" + formId + ", formName=" + formName
				+ ", totalEntries=" + totalEntries + ", totalFields="
				+ totalFields + "]";
	}
	
	public FormUtilDTO() {
	}

	public FormUtilDTO(long formId, String formName, Long totalEntries,
			Long totalFields) {
		super();
		this.formId = formId;
		this.formName = formName;
		this.totalEntries = totalEntries;
		this.totalFields = totalFields;
	}

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public Long getTotalEntries() {
		return totalEntries;
	}

	public void setTotalEntries(Long totalEntries) {
		this.totalEntries = totalEntries;
	}

	public Long getTotalFields() {
		return totalFields;
	}

	public void setTotalFields(Long totalFields) {
		this.totalFields = totalFields;
	}
		
}
