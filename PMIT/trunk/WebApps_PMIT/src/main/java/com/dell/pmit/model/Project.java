package com.dell.pmit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Santosh_Kumar14
 *
 */
@Entity
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
	private Long projectId;
	@Column(name = "projectName", nullable = false, length = 100)
	private String projectName;
	@OneToMany(mappedBy="project")
	private List<IssueDetail> issueDetails;
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", issueDetails=" + issueDetails + "]";
	}
	
	public Project() {
	}

	public Project(Long projectId, String projectName,
			List<IssueDetail> issueDetails) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.issueDetails = issueDetails;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<IssueDetail> getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(List<IssueDetail> issueDetails) {
		this.issueDetails = issueDetails;
	}
	
}
