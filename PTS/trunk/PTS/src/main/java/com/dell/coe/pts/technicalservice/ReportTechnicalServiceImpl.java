/**
 * 
 */
package com.dell.coe.pts.technicalservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dell.coe.pts.charts.BarChart;
import com.dell.coe.pts.charts.PieChart;
import com.dell.coe.pts.service.business.ProjectServiceBL;
import com.dell.coe.pts.service.business.SummaryServiceBL;
import com.dell.coe.pts.service.business.TechnologyCategoryServiceBL;
import com.dell.coe.pts.technicalservice.business.ProjectTechnicalBL;
import com.dell.coe.pts.technicalservice.business.TechnologyStackTechnicalBL;
import com.dell.coe.pts.vo.ProjectFactoryVO;
import com.dell.coe.pts.vo.ProjectVO;
import com.dell.coe.pts.vo.SummaryVO;
import com.dell.coe.pts.vo.TechCategoryFactoryVO;
import com.dell.coe.pts.vo.TechCategoryReportVO;
import com.dell.coe.virtuoso.common.service.AbstractServiceImpl;

/**
 * @author SNEHASISH_SHITH
 *
 */
@Path("/ptsReports")
public class ReportTechnicalServiceImpl extends AbstractServiceImpl implements ReportTechnicalService {

    @Autowired
    ProjectTechnicalBL projectTechnicalBL;
    @Autowired
    TechnologyStackTechnicalBL techStackBL;
    @Autowired
    TechnologyCategoryServiceBL techCatServiceBL;
    @Autowired
    ProjectServiceBL projectServiceBL;
    @Autowired
    SummaryServiceBL summaryServiceBL;
    
    @GET
    @Path("/generatePDF")
    @Produces("application/pdf")
    public Response getFile(@QueryParam("reportType") String reportType) {
        File pdf = null;
        String barChartFilePath = "";
        String pieChartFilePath = "";
        try {
        	File barChartFile = BarChart.getBarChartImage(techCatServiceBL.retrieveTechnologyCategoryDistribution());
        	if(barChartFile != null) {
        		barChartFilePath = barChartFile.getAbsolutePath();
        	}
        	File pieChartFile = PieChart.createChart(projectServiceBL.retrieveProjectCategoryDistribution());
        	if(pieChartFile != null) {
        		pieChartFilePath = pieChartFile.getAbsolutePath();
        	}
            Map<String, Object> parameters = new HashMap<String, Object>();
            JRDataSource dataSource;
            InputStream input;
            if (reportType.equalsIgnoreCase("project")) {
                InputStream is = getClass().getResourceAsStream("/PTSReport.jrxml");
                JasperCompileManager.compileReport(is);
                List<ProjectVO> projectVOs = projectTechnicalBL.getAllProject();
                List<ProjectFactoryVO> factoryVOs = new ArrayList<ProjectFactoryVO>();
                ProjectFactoryVO projectFactoryVO = new ProjectFactoryVO();
                projectFactoryVO.setId(1);
                projectFactoryVO.setProjectVOList(projectVOs);
                factoryVOs.add(projectFactoryVO);
                dataSource = new JRBeanCollectionDataSource(factoryVOs);
                input = getClass().getResourceAsStream("/PTSReport.jasper");
                SummaryVO summaryVO = summaryServiceBL.retrieveSummary();
                parameters.put("PROJECT_COUNT", summaryVO.getTotalProjects().intValue());
                parameters.put("TECH_COUNT", summaryVO.getTotalTechnologies().intValue());
                parameters.put("CAT_COUNT", summaryVO.getTotalTechnologyCategories().intValue());
                parameters.put("BAR_CHART_URL", barChartFilePath);
                parameters.put("PIE_CHART_URL", pieChartFilePath);
            } else {
                InputStream is = getClass().getResourceAsStream("/PTS_CategorizedTechStack.jrxml");
                JasperCompileManager.compileReport(is);
                List<TechCategoryFactoryVO> categoryFactoryVO = new ArrayList<TechCategoryFactoryVO>();
                TechCategoryFactoryVO techCategoryFactory = new TechCategoryFactoryVO();
                List<TechCategoryReportVO> categoryReportVOs = techStackBL.getAllTechnologyStackGroupedByTechnologyCategory();
                techCategoryFactory.setCategoryReportVOs(categoryReportVOs);
                categoryFactoryVO.add(techCategoryFactory);
                dataSource = new JRBeanCollectionDataSource(categoryFactoryVO);
                input = getClass().getResourceAsStream("/PTS_CategorizedTechStack.jasper");
                parameters.put("CAT_COUNT", categoryReportVOs.size());
                parameters.put("BAR_CHART_URL", barChartFilePath);
            }
            JasperPrint printFileName = JasperFillManager.fillReport(input, parameters, dataSource);
            pdf = File.createTempFile("output.", ".pdf");
            JasperExportManager.exportReportToPdfStream(printFileName, new FileOutputStream(pdf));

        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseBuilder responseBuilder = Response.ok((Object) pdf);
        responseBuilder.header("Content-Disposition", "attachment;");
        return responseBuilder.build();
    }

}
