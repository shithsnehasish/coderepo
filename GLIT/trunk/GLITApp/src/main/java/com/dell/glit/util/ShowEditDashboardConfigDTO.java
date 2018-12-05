package com.dell.glit.util;

import java.io.Serializable;
import java.util.List;

public class ShowEditDashboardConfigDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dashboardName;
	private Long dashboardId;
	private List<EditDashboardConfigDTO> configUtils;
	public String getDashboardName() {
		return dashboardName;
	}
	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}
	public List<EditDashboardConfigDTO> getConfigUtils() {
		return configUtils;
	}
	public void setConfigUtils(List<EditDashboardConfigDTO> configUtils) {
		this.configUtils = configUtils;
	}
	public Long getDashboardId() {
		return dashboardId;
	}
	public void setDashboardId(Long dashboardId) {
		this.dashboardId = dashboardId;
	}
 }
