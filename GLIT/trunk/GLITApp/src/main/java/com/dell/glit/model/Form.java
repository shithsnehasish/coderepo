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
public class Form implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6847596730963769226L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long formId;
	@Column
	private String formName;
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;
	@OneToMany(mappedBy="form")
	private Set<FormData> formDatas;
	@OneToMany(mappedBy="form")
	private Set<QuestionaireConfig> questionaireConfig;
	@OneToMany(mappedBy="form")
	private Set<FormFields> formFields;
	
	
	@Override
	public String toString() {
		return "Form [formId=" + formId + ", formName=" + formName
				+ ", client=" + client + ", formDatas=" + formDatas
				+ ", questionaireConfig=" + questionaireConfig
				+ ", formFields=" + formFields + "]";
	}

	public Form() {
	}

	public Form(long formId, String formName, Client client,
			Set<FormData> formDatas, 
			Set<QuestionaireConfig> questionaireConfig,
			Set<FormFields> formFields) {
		super();
		this.formId = formId;
		this.formName = formName;
		this.client = client;
		this.formDatas = formDatas;
		this.questionaireConfig = questionaireConfig;
		this.formFields = formFields;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<FormData> getFormDatas() {
		return formDatas;
	}

	public void setFormDatas(Set<FormData> formDatas) {
		this.formDatas = formDatas;
	}

	public Set<QuestionaireConfig> getQuestionaireConfig() {
		return questionaireConfig;
	}

	public void setQuestionaireConfig(Set<QuestionaireConfig> questionaireConfig) {
		this.questionaireConfig = questionaireConfig;
	}

	public Set<FormFields> getFormFields() {
		return formFields;
	}

	public void setFormFields(Set<FormFields> formFields) {
		this.formFields = formFields;
	}
	
}
