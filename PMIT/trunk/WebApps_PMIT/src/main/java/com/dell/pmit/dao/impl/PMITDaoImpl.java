package com.dell.pmit.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dell.pmit.dao.PMITDao;
import com.dell.pmit.model.IssueDetail;
import com.dell.pmit.model.Login;
import com.dell.pmit.model.Project;
import com.dell.pmit.util.PMITConstants;

@Repository("pmitDao")
@Transactional(rollbackFor = { Throwable.class, SQLException.class, Exception.class })
public class PMITDaoImpl implements PMITDao {

	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Project> getAllProjects() {
		try {
			String query = "FROM " + PMITConstants.PROJECT;
			logger.info("===>QUERY @ getAllProjects() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<Project> projects = sessionFactory.getCurrentSession().createQuery(query).list();
			if(projects != null) 
				return projects;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllProjects() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Project getProjectBasedOnId(long projectId) {
		try {
			String query = "FROM " + PMITConstants.PROJECT + " where projectId = " + projectId;
			logger.info("===>QUERY @ getProjectBasedOnId() IS==>" + query);
			Project project = (Project) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(project != null) 
				return project;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getProjectBasedOnId() IS==>" + ex.getMessage());
			return null;
		}
	}

	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProject(long projectId) {
		// TODO Auto-generated method stub
		
	}

	public List<IssueDetail> getAllIssueDetails() {
		try {
			String query = "FROM " + PMITConstants.ISSUE_DETAIL + " ORDER BY loggedDate DESC";
			logger.info("===>QUERY @ getAllIssueDetails() IS==>" + query);
			@SuppressWarnings("unchecked")
			List<IssueDetail> issueDetails = sessionFactory.getCurrentSession().createQuery(query).list();
			if(issueDetails != null) 
				return issueDetails;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getAllIssueDetails() IS==>" + ex.getMessage());
			return null;
		}
	}

	public IssueDetail getIssueDetailById(long issueId) {
		// TODO Auto-generated method stub
		return null;
	}

	public IssueDetail addIssueDetail(IssueDetail issueDetail) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(issueDetail);
			return issueDetail;
		} catch (Exception ex) {
			logger.error("===>EXCEPTION @ addIssueDetail() IS==>" + ex.getMessage());
			return null;
		}
	}

	public void deleteIssueDetail(long issueId) {
		// TODO Auto-generated method stub
		
	}

	public List<IssueDetail> getIssueDetailsForADate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public Login getLogin(String userName) {
		try {
			String query = "FROM " + PMITConstants.LOGIN + " where userName = '" + userName + "'";
			logger.info("===>QUERY @ getProjectBasedOnId() IS==>" + query);
			Login login = (Login) sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			if(login != null) 
				return login;
			else 
				return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("===>EXCEPTION @ getLogin() IS==>" + ex.getMessage());
			return null;
		}
	}

}
