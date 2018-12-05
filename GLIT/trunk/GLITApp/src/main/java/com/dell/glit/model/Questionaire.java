/**
 * 
 */
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

/**
 * @author SNEHASISH_SHITH
 *
 */
@Entity
public class Questionaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 901832928788435153L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long questionaireId;
	@Column
	private String name;
	@Column
	private Date date;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;
	@OneToMany(mappedBy="questionaire")
	private Set<QuestionaireConfig> questionaireConfig;
	@OneToMany(mappedBy="questionaire")
	private Set<InteractionReport> interactionReport;
	@OneToMany(mappedBy="questionaire")
	private Set<Dashboard> dashboard;
	@Override
	public String toString() {
		return "Questionaire [questionaireId=" + questionaireId + ", name="
				+ name + ", date=" + date + ", user=" + user + ", client="
				+ client + ", questionaireConfig=" + questionaireConfig
				+ ", interactionReport=" + interactionReport + ", dashboard="
				+ dashboard + "]";
	}

	public Questionaire() {
	}

	public Questionaire(long questionaireId, String name, Date date, User user,
			Client client, Set<QuestionaireConfig> questionaireConfig,
			Set<InteractionReport> interactionReport, Set<Dashboard> dashboard) {
		super();
		this.questionaireId = questionaireId;
		this.name = name;
		this.date = date;
		this.user = user;
		this.client = client;
		this.questionaireConfig = questionaireConfig;
		this.interactionReport = interactionReport;
		this.dashboard = dashboard;
	}

	public long getQuestionaireId() {
		return questionaireId;
	}

	public void setQuestionaireId(long questionaireId) {
		this.questionaireId = questionaireId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<QuestionaireConfig> getQuestionaireConfig() {
		return questionaireConfig;
	}

	public void setQuestionaireConfig(Set<QuestionaireConfig> questionaireConfig) {
		this.questionaireConfig = questionaireConfig;
	}

	public Set<InteractionReport> getInteractionReport() {
		return interactionReport;
	}

	public void setInteractionReport(Set<InteractionReport> interactionReport) {
		this.interactionReport = interactionReport;
	}

	public Set<Dashboard> getDashboard() {
		return dashboard;
	}

	public void setDashboard(Set<Dashboard> dashboard) {
		this.dashboard = dashboard;
	}
	
}
