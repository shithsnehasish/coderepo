/**
 * 
 */
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

/**
 * @author SNEHASISH_SHITH
 *
 */
@Entity
public class InteractionReportData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3362947686539844976L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="increment", strategy = "increment")
	private long interactionDataId ;
	@ManyToOne
	@JoinColumn(name="fieldId")
	private FormFields formFields;
	@ManyToOne
	@JoinColumn(name="interactionId")
	private InteractionReport interactionReport;
	@Column
	private String value;
	
	@Override
	public String toString() {
		return "InteractionReportData [interactionDataId=" + interactionDataId
				+ ", formFields=" + formFields + ", interactionReport="
				+ interactionReport + ", value=" + value + "]";
	}

	public InteractionReportData(long interactionDataId, FormFields formFields,
			InteractionReport interactionReport, String value) {
		super();
		this.interactionDataId = interactionDataId;
		this.formFields = formFields;
		this.interactionReport = interactionReport;
		this.value = value;
	}
	
	
	public InteractionReportData() {
	}

	public long getInteractionDataId() {
		return interactionDataId;
	}

	public void setInteractionDataId(long interactionDataId) {
		this.interactionDataId = interactionDataId;
	}

	public FormFields getFormFields() {
		return formFields;
	}

	public void setFormFields(FormFields formFields) {
		this.formFields = formFields;
	}

	public InteractionReport getInteractionReport() {
		return interactionReport;
	}

	public void setInteractionReport(InteractionReport interactionReport) {
		this.interactionReport = interactionReport;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
