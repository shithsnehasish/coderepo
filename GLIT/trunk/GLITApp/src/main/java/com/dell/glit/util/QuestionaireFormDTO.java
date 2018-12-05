package com.dell.glit.util;

import java.io.Serializable;
import java.util.List;

public class QuestionaireFormDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5454935668462855032L;
	private long formId;
	private String name;
	private List<FieldDTO> fieldUtilList;
	
	public QuestionaireFormDTO() {
	}

	public QuestionaireFormDTO(long formId, String name,
			List<FieldDTO> fieldUtilList) {
		super();
		this.formId = formId;
		this.name = name;
		this.fieldUtilList = fieldUtilList;
	}

	@Override
	public String toString() {
		return "QuestionaireFormUtil [formId=" + formId + ", name=" + name
				+ ", fieldUtilList=" + fieldUtilList + "]";
	}

	public long getFormId() {
		return formId;
	}

	public void setFormId(long formId) {
		this.formId = formId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FieldDTO> getFieldUtilList() {
		return fieldUtilList;
	}

	public void setFieldUtilList(List<FieldDTO> fieldUtilList) {
		this.fieldUtilList = fieldUtilList;
	}
	
}
