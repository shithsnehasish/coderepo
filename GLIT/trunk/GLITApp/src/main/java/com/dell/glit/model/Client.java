/**
 * 
 */
package com.dell.glit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author SNEHASISH_SHITH
 *
 */
@Entity(name="Client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8735791017363229156L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
	private long clientId;
	@Column
	private String clientName;
	@Column
	private String clientAddress;
	@Column(unique=true, nullable= false)
	private String clientEmail;
	@Column
	private String clientSPOCName;
	@Column
	private long clientContactNo;
	@OneToMany(mappedBy="client")
	private Set<Form> forms;
	@OneToMany(mappedBy="client")
	private Set<Questionaire> questionnaires;
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName
				+ ", clientAddress=" + clientAddress + ", clientEmail="
				+ clientEmail + ", clientSPOCName=" + clientSPOCName
				+ ", clientContactNo=" + clientContactNo + ", forms=" + forms
				+ ", questionnaires=" + questionnaires + "]";
	}
	
	public Client() {
	}

	public Client(long clientId, String clientName, String clientAddress,
			String clientEmail, String clientSPOCName, long clientContactNo,
			Set<Form> forms, Set<Questionaire> questionnaires) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientEmail = clientEmail;
		this.clientSPOCName = clientSPOCName;
		this.clientContactNo = clientContactNo;
		this.forms = forms;
		this.questionnaires = questionnaires;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientSPOCName() {
		return clientSPOCName;
	}

	public void setClientSPOCName(String clientSPOCName) {
		this.clientSPOCName = clientSPOCName;
	}

	public long getClientContactNo() {
		return clientContactNo;
	}

	public void setClientContactNo(long clientContactNo) {
		this.clientContactNo = clientContactNo;
	}

	public Set<Form> getForms() {
		return forms;
	}

	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}

	public Set<Questionaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Set<Questionaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
}
