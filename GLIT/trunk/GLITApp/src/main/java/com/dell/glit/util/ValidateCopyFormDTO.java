package com.dell.glit.util;

import java.io.Serializable;

import com.dell.glit.model.Form;

public class ValidateCopyFormDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4030305012865120816L;
	private Boolean nameExist;
	private Form form;
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public Boolean getNameExist() {
		return nameExist;
	}
	public void setNameExist(Boolean nameExist) {
		this.nameExist = nameExist;
	}
}
