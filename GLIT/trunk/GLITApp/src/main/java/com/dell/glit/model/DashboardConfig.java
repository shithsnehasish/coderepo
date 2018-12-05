package com.dell.glit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class DashboardConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7450205269678786092L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long dashboardConfigId;
	@Column
	private String reportName;
	@ManyToOne
	@JoinColumn(name="fieldId")
	private FormFields formFields;
	@ManyToOne
	@JoinColumn(name="dashboardId")
	private Dashboard dashboard;
	@Column
	private String typeOfChart;
	@Column
	private String criteria;
	@Override
	public String toString() {
		return "DashboardConfig [dashboardConfigId=" + dashboardConfigId
				+ ", reportName=" + reportName + ", formFields=" + formFields
				+ ", dashboard=" + dashboard + ", typeOfChart=" + typeOfChart
				+ ", criteria=" + criteria + "]";
	}
	public DashboardConfig(long dashboardConfigId, String reportName,
			FormFields formFields, Dashboard dashboard, String typeOfChart,
			String criteria) {
		super();
		this.dashboardConfigId = dashboardConfigId;
		this.reportName = reportName;
		this.formFields = formFields;
		this.dashboard = dashboard;
		this.typeOfChart = typeOfChart;
		this.criteria = criteria;
	}
	
	public DashboardConfig() {
	}
	public long getDashboardConfigId() {
		return dashboardConfigId;
	}
	public void setDashboardConfigId(long dashboardConfigId) {
		this.dashboardConfigId = dashboardConfigId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public FormFields getFormFields() {
		return formFields;
	}
	public void setFormFields(FormFields formFields) {
		this.formFields = formFields;
	}
	public Dashboard getDashboard() {
		return dashboard;
	}
	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
	public String getTypeOfChart() {
		return typeOfChart;
	}
	public void setTypeOfChart(String typeOfChart) {
		this.typeOfChart = typeOfChart;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	
}