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

@Entity
public class Dashboard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7684329844222941735L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long dashboardId;
	@ManyToOne
	@JoinColumn(name="questionaireId")
	private Questionaire questionaire;
	@Column
	private String dashboardName;
	@OneToMany(mappedBy="dashboard")
	private Set<DashboardConfig> dashboardConfig;
	@Override
	public String toString() {
		return "Dashboard [dashboardId=" + dashboardId + ", questionaire="
				+ questionaire + ", dashboardName=" + dashboardName
				+ ", dashboardConfig=" + dashboardConfig + "]";
	}
	public Dashboard(long dashboardId, Questionaire questionaire,
			String dashboardName, Set<DashboardConfig> dashboardConfig) {
		super();
		this.dashboardId = dashboardId;
		this.questionaire = questionaire;
		this.dashboardName = dashboardName;
		this.dashboardConfig = dashboardConfig;
	}
	
	public Dashboard() {
	}
	public long getDashboardId() {
		return dashboardId;
	}
	public void setDashboardId(long dashboardId) {
		this.dashboardId = dashboardId;
	}
	public Questionaire getQuestionaire() {
		return questionaire;
	}
	public void setQuestionaire(Questionaire questionaire) {
		this.questionaire = questionaire;
	}
	public String getDashboardName() {
		return dashboardName;
	}
	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}
	public Set<DashboardConfig> getDashboardConfig() {
		return dashboardConfig;
	}
	public void setDashboardConfig(Set<DashboardConfig> dashboardConfig) {
		this.dashboardConfig = dashboardConfig;
	}
	
}
