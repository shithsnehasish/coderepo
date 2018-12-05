package com.dell.glit.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dell.glit.dao.DashboardDao;
import com.dell.glit.model.Dashboard;
import com.dell.glit.model.DashboardConfig;
import com.dell.glit.model.Form;
import com.dell.glit.model.FormFields;
import com.dell.glit.model.Questionaire;
import com.dell.glit.model.InteractionReportData;
import com.dell.glit.service.DashboardService;
import com.dell.glit.util.DashboardConfigDTO;
import com.dell.glit.util.EditDashboardConfigDTO;

@Service(value= "dashboardService")
public class DashboardServiceImpl implements DashboardService{
	
	@Autowired
	private DashboardDao dashboardDao;

	public DashboardConfig addDashboardConfig(String reportName,
			FormFields formField, String chartType, String criteria,
			int priority) {
	return dashboardDao.addDashboardConfig(reportName,formField, chartType, criteria, priority);
	}

	public List<DashboardConfigDTO> showAllDashboardConfig(long dashboardId) {
		return dashboardDao.showAllDashboardConfig(dashboardId);
	}

	public FormFields getFormFieldsByFieldId(long fieldId) {
		return dashboardDao.getFormFieldsByFieldId(fieldId);
	}

	public Form getFormbyFormId(long formId) {
		return dashboardDao.getFormbyFormId(formId);
	}
	public Long getTotalEntriesofDashboardConfig() {
		return dashboardDao.getTotalEntriesofDashboardConfig();
	}
	public List <Questionaire> getQuestionnaireToShowChart(long clientId,String criteria,Date startDate,Date endDate) {
		return dashboardDao.getQuestionnaireToShowChart(clientId,criteria, startDate,endDate);
	}
	public List<InteractionReportData> getAllInteractionDataByInteractionIdAndFieldId(List<Long> interactionIds, long fieldId) {
		return dashboardDao.getAllInteractionDataByInteractionIdAndFieldId(interactionIds, fieldId);
	}

	public void deleteDashboardConfigData(long dashboardConfigId) {
		dashboardDao.deleteDashboardConfigData(dashboardConfigId);
	}

	public DashboardConfig addDashboardConfig(DashboardConfig dashboardConfig) {
		return dashboardDao.addDashboardConfig(dashboardConfig);
	}

	public Dashboard addDashboard(Dashboard dashboard) {
		return dashboardDao.addDashboard(dashboard);
	}

	public Dashboard getDashBoardById(long dashboardId) {
		return dashboardDao.getDashBoardById(dashboardId);
	}

	public List<Dashboard> getAllDashboardByClientId(List<Long> questionaireIds) {
		return dashboardDao.getAllDashboardByClientId(questionaireIds);
	}

	public void deleteDashboard(long dashboardId) {
		dashboardDao.deleteDashboard(dashboardId);
	}

	public List<Dashboard> getDashboardByQuestionaireId(long questionaireId) {
		return dashboardDao.getDashboardByQuestionaireId(questionaireId);
	}

	public void deleteDashboard(Dashboard dashboard) {
		dashboardDao.deleteDashboard(dashboard);
	}

	public List<DashboardConfig> getAllDashboardConfigByDashboardId(
			long dashboardId) {
		return dashboardDao.getAllDashboardConfigByDashboardId(dashboardId);
	}

	public List<EditDashboardConfigDTO> showAllEditDashboardConfig(
			long dashboardId) {
		return dashboardDao.showAllEditDashboardConfig(dashboardId);
	}
}
