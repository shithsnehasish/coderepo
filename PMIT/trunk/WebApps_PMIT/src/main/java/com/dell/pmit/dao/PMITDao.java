package com.dell.pmit.dao;

import java.util.Date;
import java.util.List;

import com.dell.pmit.model.IssueDetail;
import com.dell.pmit.model.Login;
import com.dell.pmit.model.Project;

public interface PMITDao {
	
	public List<Project> getAllProjects();
	public Project getProjectBasedOnId(long projectId);
	public Project addProject(Project project);
	public void deleteProject(long projectId);
	
	public List<IssueDetail> getAllIssueDetails();
	public IssueDetail getIssueDetailById(long issueId);
	public IssueDetail addIssueDetail(IssueDetail issueDetail);
	public void deleteIssueDetail(long issueId);
	public List<IssueDetail> getIssueDetailsForADate(Date date);
	
	public Login getLogin(String userName);

}
