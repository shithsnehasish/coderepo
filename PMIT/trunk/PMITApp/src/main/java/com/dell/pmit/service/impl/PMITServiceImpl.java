package com.dell.pmit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dell.pmit.dao.PMITDao;
import com.dell.pmit.model.Login;
import com.dell.pmit.model.Project;
import com.dell.pmit.model.IssueDetail;
import com.dell.pmit.service.PMITService;

@Service(value = "pmitService")
public class PMITServiceImpl implements PMITService{

	@Autowired
	private PMITDao pmitDao;
	
	public List<Project> getAllProjects() {
		return pmitDao.getAllProjects();
	}
	
	public IssueDetail addIssueDetail(IssueDetail issueDetail) {
		return pmitDao.addIssueDetail(issueDetail);
	}

	public Login getLogin(String userName) {
		return pmitDao.getLogin(userName);
	}

	public List<IssueDetail> getAllIssueDetails() {
		return pmitDao.getAllIssueDetails();
	}

}
