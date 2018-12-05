package com.dell.glit.model;

import java.io.Serializable;
import java.util.Date;
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

@Entity
public class InteractionReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8416600357592946360L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long interactionId;
	@ManyToOne
	@JoinColumn(name="questionaireId")
	private Questionaire questionaire;
	@Column
	private Date interactionDate;
	@OneToMany(mappedBy="interactionReport")
	private Set<InteractionReportData> interactionReportData;
	
	@Override
	public String toString() {
		return "InteractionReport [interactionId=" + interactionId
				+ ", questionaire=" + questionaire + ", interactionDate=" + interactionDate
				+ ", interactionReportData=" + interactionReportData + "]";
	}

	public InteractionReport(long interactionId, Questionaire questionaire,
			Date date, Set<InteractionReportData> interactionReportData) {
		super();
		this.interactionId = interactionId;
		this.questionaire = questionaire;
		this.interactionDate = date;
		this.interactionReportData = interactionReportData;
	}
	
	public InteractionReport() {
	}

	public long getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(long interactionId) {
		this.interactionId = interactionId;
	}

	public Questionaire getQuestionaire() {
		return questionaire;
	}

	public void setQuestionaire(Questionaire questionaire) {
		this.questionaire = questionaire;
	}

	public Date getInteractionDate() {
		return interactionDate;
	}

	public void setInteractionDate(Date interactionDate) {
		this.interactionDate = interactionDate;
	}

	public Set<InteractionReportData> getInteractionReportData() {
		return interactionReportData;
	}

	public void setInteractionReportData(
			Set<InteractionReportData> interactionReportData) {
		this.interactionReportData = interactionReportData;
	}
	
}
