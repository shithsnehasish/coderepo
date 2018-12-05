package com.dell.pmit.service;

import java.util.List;

import com.dell.pmit.model.IssueDetail;
import com.dell.pmit.model.Login;
import com.dell.pmit.model.Project;


public interface PMITService {

	public List<Project> getAllProjects();

	public IssueDetail addIssueDetail(IssueDetail issueDetail);
	public List<IssueDetail> getAllIssueDetails();
	
	public Login getLogin(String userName);
}
