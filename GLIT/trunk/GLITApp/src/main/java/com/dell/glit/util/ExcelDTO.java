package com.dell.glit.util;

import java.util.List;
import java.util.Map;

public class ExcelDTO {
	
	private List<FormDTO> formList;
	private Map<String, String> errorList;
	
	public ExcelDTO() {
	}
	
	public ExcelDTO(List<FormDTO> formList, Map<String, String> errorList) {
		super();
		this.formList = formList;
		this.errorList = errorList;
	}

	@Override
	public String toString() {
		return "ExcelDTO [formList=" + formList + ", errorList=" + errorList + "]";
	}

	public List<FormDTO> getFormList() {
		return formList;
	}

	public void setFormList(List<FormDTO> formList) {
		this.formList = formList;
	}

	public Map<String, String> getErrorList() {
		return errorList;
	}

	public void setErrorList(Map<String, String> errorList) {
		this.errorList = errorList;
	}
}

