/**
 * 
 */
package com.dell.glit.model;

import java.io.Serializable;
import java.util.Set;

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
public class FormData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4583532744577924217L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long dataId;
	@ManyToOne
	@JoinColumn(name="formId")
	private Form form;
	@OneToMany(mappedBy="formData")
	private Set<FormDataValue> formDataValues;
	
	public FormData(long dataId, Form form, Set<FormDataValue> formDataValues) {
		super();
		this.dataId = dataId;
		this.form = form;
		this.formDataValues = formDataValues;
	}
	public FormData() {
	}
	@Override
	public String toString() {
		return "FormData [dataId=" + dataId + ", form=" + form
				+ ", formDataValues=" + formDataValues + "]";
	}

	public long getDataId() {
		return dataId;
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
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
}
