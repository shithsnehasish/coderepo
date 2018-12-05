package com.dell.glit.util;

import java.io.Serializable;
import java.util.List;

public class DailyBasisDataDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7292419449007943384L;
	private String value;
	private String color;
	private List<String> dateList;
	private List<Long> counts;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<String> getDateList() {
		return dateList;
	}
	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}
	public List<Long> getCounts() {
		return counts;
	}
	public void setCounts(List<Long> counts) {
		this.counts = counts;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
