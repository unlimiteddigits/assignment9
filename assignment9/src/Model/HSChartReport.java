package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;

import de.toolforge.googlechartwrapper.PieChart;
import de.toolforge.googlechartwrapper.data.PieChartSlice;
import de.toolforge.googlechartwrapper.data.PieChartSlice.PieChartSliceBuilder;
import de.toolforge.googlechartwrapper.label.ChartTitle;

//TODO figure out how to modularize piechart methods or just method for each
class HSChartReport {
	private PieChart pieTotalCholesterol;
	private PieChart pieBodyMassIndex;
	private PieChart pieBloodPressure;
	
	public HSChartReport(){
		
	}
	
	/**
	 * Saves data for pie chart total cholesterol
	 * @param high
	 * @param desirable
	 * @param borderlineHigh
	 */
	public void setPieTotalCholesterol(int high, int desirable, int borderlineHigh){
		PieChart pie = new PieChart(new Dimension(600,300));
		pie.setChartTitle(new ChartTitle("Total%20Cholesterol", Color.BLACK, 24));
		
		PieChartSliceBuilder slice1Builder = new PieChartSliceBuilder(high);
		slice1Builder.label("High");
		
		PieChartSliceBuilder slice2Builder = new PieChartSliceBuilder(desirable);
		slice2Builder.label("Desirable");

		PieChartSliceBuilder slice3Builder = new PieChartSliceBuilder(borderlineHigh);
		slice3Builder.label("Borderline%20High");
		
		PieChartSlice slice1 = slice1Builder.build();
		PieChartSlice slice2 = slice2Builder.build();
		PieChartSlice slice3 = slice3Builder.build();
		
		pie.addPieChartSlice(slice1);
		pie.addPieChartSlice(slice2);
		pie.addPieChartSlice(slice3);

		pieTotalCholesterol = pie;
	}
	
	public void createChartReport(){
//		writeUrlsToChartReport(totalCholesterolUrl, bodyMassIndexUrl, bloodPressureUrl);
	}

	private void writeUrlsToChartReport(String totalCholesterolUrl, String bodyMassIndexUrl, String bloodPressureUrl){
		String dataToWrite = 
			"<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
			"	<title>Health Screening Summary</title>" +
			"	<style type=\"text/css\">" +
			"		div img{" +
			"			display: block;" +
			"			margin: auto;" +
			"		}" +
			"	</style>" +
			"</head>" +
			"<body>" +
			"	<h1>Health Screening Results</h1>" +
			"	<div>" +
			"		<img src=\"" + totalCholesterolUrl + "\">" +
			"		<img src=\"" + bodyMassIndexUrl + "\">" +
			"		<img src=\"" + bloodPressureUrl + "\">" +
			"	</div>" +
			"</body>" +
			"</html>";
		
		FileWriter writer;
		try {
			writer = new FileWriter(new File("ChartReport.html"), false);
			
			writer.write(dataToWrite);
			
			writer.close();
		} catch (Exception e1) {
			System.out.println("Error creating chart, " + e1.getMessage());
		}
	}
}
