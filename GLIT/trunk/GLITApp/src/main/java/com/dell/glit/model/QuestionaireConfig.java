package com.dell.glit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class QuestionaireConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6644112953019840434L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long qConfigId;
	@ManyToOne
	@JoinColumn(name="questionaireId")
	private Questionaire questionaire;
	@ManyToOne
	@JoinColumn(name="formId")
	private Form form;
	@Override
	public String toString() {
		return "QuestionaireConfig [qConfigId=" + qConfigId + ", questionaire="
				+ questionaire + ", form=" + form + "]";
	}
	
	public QuestionaireConfig() {
	}

	public QuestionaireConfig(long qConfigId, Questionaire questionaire,
			Form form) {
		super();
		this.qConfigId = qConfigId;
		this.questionaire = questionaire;
		this.form = form;
	}

	public long getqConfigId() {
		return qConfigId;
	}

	public void setqConfigId(long qConfigId) {
		this.qConfigId = qConfigId;
	}

	public Questionaire getQuestionaire() {
		return questionaire;
	}

	public void setQuestionaire(Questionaire questionaire) {
		this.questionaire = questionaire;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}
}
