/**
 * 
 */
package com.dell.glit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author SNEHASISH_SHITH
 *
 */
@Entity
public class FormDataValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5876157699529438471L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long formValueId;
	@ManyToOne
	@JoinColumn(name="fieldId")
	private FormFields formFields;
	private String value;
	@ManyToOne
	@JoinColumn(name="dataId")
	private FormData formData;
	
	@Override
	public String toString() {
		return "FormDataValue [formValueId=" + formValueId + ", field=" + formFields
				+ ", value=" + value + ", formData=" + formData + "]";
	}
	
	public FormDataValue() {
	}
	
	public FormDataValue(long formValueId, FormFields field, String value,
			FormData formData) {
		super();
		this.formValueId = formValueId;
		this.formFields = field;
		this.value = value;
		this.formData = formData;
	}

	public long getFormValueId() {
		return formValueId;
	}

	public void setFormValueId(long formValueId) {
		this.formValueId = formValueId;
	}

	public FormFields getField() {
		return formFields;
	}

	public void setField(FormFields field) {
		this.formFields = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FormData getFormData() {
		return formData;
	}

	public void setFormData(FormData formData) {
		this.formData = formData;
	}
	
	
}
