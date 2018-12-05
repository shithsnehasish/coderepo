package com.dell.glit.util;

import java.io.Serializable;
import java.util.List;

import com.dell.glit.model.FormFields;

public class EditDashboardConfigDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long dashboardConfigId;
	private String reportName;
	private String fieldName;
	private String typeOfChart;
	private String criteria;
	private String formName;
	private long fieldId;
	private long dashboardId;
	private String dashboardName;
	private List<FormFields> formFields;
	public Long getDashboardConfigId() {
		return dashboardConfigId;
	}
	public void setDashboardConfigId(Long dashboardConfigId) {
		this.dashboardConfigId = dashboardConfigId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public long getFieldId() {
		return fieldId;
	}
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
	public long getDashboardId() {
		return dashboardId;
	}
	public void setDashboardId(long dashboardId) {
		this.dashboardId = dashboardId;
	}
	public String getDashboardName() {
		return dashboardName;
	}
	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}
	public List<FormFields> getFormFields() {
		return formFields;
	}
	public void setFormFields(List<FormFields> formFields) {
		this.formFields = formFields;
	}
}
