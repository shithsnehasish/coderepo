package com.dell.coe.pts.charts;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.dell.coe.pts.vo.ProjectTechCategoryVO;

public class BarChart
{
	public static File getBarChartImage(List<ProjectTechCategoryVO> projectTechCategoryVOs) 
   {
      final String speed = "";
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      for (ProjectTechCategoryVO projectTechCategoryVO : projectTechCategoryVOs) {
		dataset.addValue(projectTechCategoryVO.getProjectCount(), projectTechCategoryVO.getTechnologyCategoryVO().getCatName(), speed);
	}
   
      JFreeChart barChart = ChartFactory.createBarChart3D(
         "Top 10 Category Distribution", 
         "Technology Category", "Project Count",
         dataset,PlotOrientation.VERTICAL, 
         true, true, false);
   // set the background color for the chart...
      barChart.setBackgroundPaint(Color.white);

      // get a reference to the plot for further customisation...
      CategoryPlot plot = barChart.getCategoryPlot();
      plot.setBackgroundPaint(Color.lightGray);
      plot.setDomainGridlinePaint(Color.lightGray);
      plot.setDomainGridlinesVisible(false);
      plot.setRangeGridlinePaint(Color.lightGray);
      plot.setNoDataMessage("NO DATA!");

      // set the range axis to display integers only...
      final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
      rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

      int width = 640; /* Width of the image */
      int height = 480; /* Height of the image */
      File dir = new File("tmp");
      try {
    	  dir.mkdirs();
    	  File fBarChart = new File(dir, "BarChart.jpeg");
    	  fBarChart.createNewFile();
    	  ChartUtilities.saveChartAsJPEG( fBarChart , barChart , width , height );
    	  return fBarChart;
	} catch (IOException e) {
		e.printStackTrace();
		return null;
	}
   }
}