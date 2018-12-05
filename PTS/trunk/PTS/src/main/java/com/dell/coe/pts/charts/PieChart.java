package com.dell.coe.pts.charts;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.dell.coe.pts.vo.ProjectTechnologyVO;


/**
 * @author Santosh_Kumar14
 *
 */
public class PieChart {

	
    /**
     * @param projectTechnologyVOs
     * @return
     */
    public static File createChart(List<ProjectTechnologyVO> projectTechnologyVOs) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (ProjectTechnologyVO projectTechnologyVO : projectTechnologyVOs) {
			dataset.setValue(projectTechnologyVO.getTechnologyStackVO().getTechName(), projectTechnologyVO.getProjectCount());
		}

        
        JFreeChart pieChart = ChartFactory.createPieChart(
            "Top 10 Technology Distribution",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            plot.setLabelGenerator(gen);
        
        int width = 640; /* Width of the image */
        int height = 480; /* Height of the image */
        File dir = new File("tmp");
        try {
      	  	dir.mkdirs();
  	  		File fPieChart = new File("PieChart.jpeg");
			fPieChart.createNewFile();
			ChartUtilities.saveChartAsJPEG( fPieChart , pieChart , width , height );
			return fPieChart;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
        
    }
/*    public static void main(String[] args) {
		PieChart.createChart();
	}*/
}