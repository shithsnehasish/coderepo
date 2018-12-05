
package com.dell.pmit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Santosh_Kumar14
 *
 */
@Entity
public class IssueDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
	private Long issueId;
	@Column(name = "issueForProject", nullable = false, length = 100)
	private String issueForProject;
	@Column(name = "description", nullable = false, length = 1500)
	private String description;
	@Column(name = "severity", nullable = false, length = 50)
	private String severity;
	@Column(name = "contactName", nullable = false, length = 30)
	private String contactName;
	@Column(name = "contactNumber", nullable = false, length = 10)
	private Long contactNumber;
	@Column(name = "contactEmail", nullable = false, length = 30)
	private String contactEmail;
	@Column(name = "loggedDate")
	private Date loggedDate;
	@Column
	private String filePath;
	@ManyToOne
	@JoinColumn(name="projectId")
	private Project project;
	
	@Override
	public String toString() {
		return "IssueDetail [issueId=" + issueId + ", issueForProject="
				+ issueForProject + ", description=" + description
				+ ", severity=" + severity + ", contactName=" + contactName
				+ ", contactNumber=" + contactNumber + ", contactEmail="
				+ contactEmail + ", loggedDate=" + loggedDate + ", filePath="
				+ filePath + ", project=" + project + "]";
	}

	public IssueDetail() {
	}

	public IssueDetail(Long issueId, String issueForProject,
			String description, String severity, String contactName,
			Long contactNumber, String contactEmail, Date loggedDate,
			String filePath, Project project) {
		super();
		this.issueId = issueId;
		this.issueForProject = issueForProject;
		this.description = description;
		this.severity = severity;
		this.contactName = contactName;
		this.contactNumber = contactNumber;
		this.contactEmail = contactEmail;
		this.loggedDate = loggedDate;
		this.filePath = filePath;
		this.project = project;
	}

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getIssueForProject() {
		return issueForProject;
	}

	public void setIssueForProject(String issueForProject) {
		this.issueForProject = issueForProject;
	}

	public Date getLoggedDate() {
		return loggedDate;
	}
	
	public void setLoggedDate(Date loggedDate) {
		this.loggedDate = loggedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
