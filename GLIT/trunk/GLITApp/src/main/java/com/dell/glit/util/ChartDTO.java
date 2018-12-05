package com.dell.glit.util;

import java.io.Serializable;
import java.util.List;

public class ChartDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long fieldId;
	private List<DailyBasisDataDTO> dailyBasisDatas;
	private String reportName;
	private String reportType;
	private String reportCriteria;
	private Integer dailyBasisDatasSize;
	private Long dashboardConfigId;
	@Override
	public String toString() {
		return "ChartUtil [fieldId=" + fieldId + ", dailyBasisDatas="
				+ dailyBasisDatas + "]";
	}
	public ChartDTO(long fieldId, List<DailyBasisDataDTO> dailyBasisDatas) {
		super();
		this.fieldId = fieldId;
		this.dailyBasisDatas = dailyBasisDatas;
	}
	
	public ChartDTO() {
	}
	public long getFieldId() {
		return fieldId;
	}
	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}
	public List<DailyBasisDataDTO> getDailyBasisDatas() {
		return dailyBasisDatas;
	}
	public void setDailyBasisDatas(List<DailyBasisDataDTO> dailyBasisDatas) {
		this.dailyBasisDatas = dailyBasisDatas;
	}
	public Integer getDailyBasisDatasSize() {
		return dailyBasisDatasSize;
	}
	public void setDailyBasisDatasSize(Integer dailyBasisDatasSize) {
		this.dailyBasisDatasSize = dailyBasisDatasSize;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getReportCriteria() {
		return reportCriteria;
	}
	public void setReportCriteria(String reportCriteria) {
		this.reportCriteria = reportCriteria;
	}
	public Long getDashboardConfigId() {
		return dashboardConfigId;
	}
	public void setDashboardConfigId(Long dashboardConfigId) {
		this.dashboardConfigId = dashboardConfigId;
	}
	
	
}
