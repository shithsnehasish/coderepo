/**
 * 
 */
package com.dell.coe.pts.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dell.coe.pts.technicalservice.business.ProjectTechnicalBL;
import com.dell.coe.pts.technicalservice.business.TechnologyStackTechnicalBL;
import com.dell.coe.pts.vo.ProjectVO;
import com.dell.coe.pts.vo.TechCategoryReportVO;

/**
 * @author SNEHASISH_SHITH
 *
 */
@Controller
public class ReportController {

    @Autowired
    ProjectTechnicalBL projectTechnicalBL;
    @Autowired
    TechnologyStackTechnicalBL techStackBL;

    @RequestMapping(value = "/printReport", method = RequestMethod.GET)
    public void printReport(HttpServletRequest request, HttpServletResponse response/*, @RequestParam("reportType") String reportType*/) {
        String reportType = "project";
        OutputStream outStream;
        try {
            outStream = response.getOutputStream();
            response.setContentType("application/pdf");
            InputStream is = getClass().getResourceAsStream("/PTSReport_Main.jrxml");
            JasperCompileManager.compileReport(is);
            System.out.println("Done compiling!!! ...");
            Map<String, Object> parameters = new HashMap<String, Object>();
            JRDataSource dataSource;
            if (reportType.equalsIgnoreCase("project")) {
                List<ProjectVO> projectVOs = projectTechnicalBL.getAllProject();
                dataSource = new JRBeanCollectionDataSource(projectVOs);
            } else {
                List<TechCategoryReportVO> categoryReportVOs = techStackBL.getAllTechnologyStackGroupedByTechnologyCategory();
                dataSource = new JRBeanCollectionDataSource(categoryReportVOs);
            }
            parameters.put("DataSourceP", dataSource);
            InputStream input = getClass().getResourceAsStream("/PTSReport_Main.jasper");
            JasperPrint printFileName = JasperFillManager.fillReport(input, parameters, dataSource);
            JasperExportManager.exportReportToPdfStream(printFileName, outStream);
            System.out.println("Report Generated!!! ...");
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
