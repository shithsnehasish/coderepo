package com.dell.glit.service;

import java.util.Date;
import java.util.List;

import com.dell.glit.model.Dashboard;
import com.dell.glit.model.DashboardConfig;
import com.dell.glit.model.Form;
import com.dell.glit.model.FormFields;
import com.dell.glit.model.InteractionReportData;
import com.dell.glit.model.Questionaire;
import com.dell.glit.util.DashboardConfigDTO;
import com.dell.glit.util.EditDashboardConfigDTO;

public interface DashboardService {

	public DashboardConfig addDashboardConfig(String reportName,FormFields formField,String chartType,String criteria,int priority);
	public List<DashboardConfigDTO> showAllDashboardConfig(long dashboardId);
	public FormFields getFormFieldsByFieldId(long fieldId);
	public Form getFormbyFormId(long formId);
	public Long getTotalEntriesofDashboardConfig();
	public List<Questionaire> getQuestionnaireToShowChart(long clientId, String criteria, Date startDate,Date endDate);
	public List<InteractionReportData> getAllInteractionDataByInteractionIdAndFieldId(
			List<Long> questIds, long fieldId);
	public void deleteDashboardConfigData(long dashboardConfigId);
	
	public DashboardConfig addDashboardConfig(DashboardConfig dashboardConfig);
	public Dashboard addDashboard(Dashboard dashboard);
	public Dashboard getDashBoardById(long dashboardId);
	public List<Dashboard> getAllDashboardByClientId(List<Long> questionaireId);
	public void deleteDashboard(long dashboardId)
	public List<Dashboard> getDashboardByQuestionaireId(long questionaireId);
	public void deleteDashboard(Dashboard dashboard);
	public List<DashboardConfig> getAllDashboardConfigByDashboardId(long dashboardId);
	public List<EditDashboardConfigDTO> showAllEditDashboardConfig(long dashboardId);
}
