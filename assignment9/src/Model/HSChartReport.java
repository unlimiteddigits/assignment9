package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;

import org.json.JSONException;

import bodyprogram.DataBase;
import de.toolforge.googlechartwrapper.PieChart;
import de.toolforge.googlechartwrapper.color.ChartColor;
import de.toolforge.googlechartwrapper.data.PieChartSlice;
import de.toolforge.googlechartwrapper.data.PieChartSlice.PieChartSliceBuilder;
import de.toolforge.googlechartwrapper.label.ChartTitle;

//TODO figure out how to modularize piechart methods or just method for each
public class HSChartReport {
	private PieChart pieTotalCholesterol = null;
	private PieChart pieBodyMassIndex = null;
	private PieChart pieBloodPressure = null;
	private DataBase pieChartInformation = new DataBase();
	private static final int CHART_TITLE_SIZE = 24;
	private static final int CHART_WIDTH = 550;
	private static final int CHART_HEIGHT = 300;
	
	public HSChartReport(){
		int[] pieChartArray = new int[12];
		try {
			 pieChartArray = pieChartInformation.pieChartInfo();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test data, fill from constructor? or call somewhere else
		fillPieChartTotalCholesterol(pieChartArray[0], pieChartArray[1], pieChartArray[2]);
		fillPieChartBodyMassIndex(pieChartArray[3], pieChartArray[4], pieChartArray[5], pieChartArray[6]);
		fillPieChartBloodPressure(pieChartArray[7], pieChartArray[8], pieChartArray[9], pieChartArray[10], pieChartArray[11]);
		
		createChartReport();

//		fillPieChartTotalCholesterol(desirable, borderlineHigh, high);
//		fillPieChartBodyMassIndex(underweight, normal, overweight, obese);
//		fillPieChartBloodPressure(normal, prehypertension, stage1Hypertension, stage2Hypertension, hypertensiveCrisis);
		
	}

	/**
	 * Saves data for pie chart total cholesterol
	 * @param desirable
	 * @param borderlineHigh
	 * @param high
	 */
	public void fillPieChartTotalCholesterol(int desirable, int borderlineHigh, int high){
		PieChart pie = new PieChart(new Dimension(CHART_WIDTH,CHART_HEIGHT));
		pie.setChartTitle(new ChartTitle("Total%20Cholesterol", Color.BLACK, CHART_TITLE_SIZE));
		pie.addChartColor(new ChartColor(Color.PINK));
		
		PieChartSliceBuilder slice1Builder = new PieChartSliceBuilder(desirable);
		slice1Builder.label("Desirable");
		
		PieChartSliceBuilder slice2Builder = new PieChartSliceBuilder(borderlineHigh);
		slice2Builder.label("Borderline%20High");

		PieChartSliceBuilder slice3Builder = new PieChartSliceBuilder(high);
		slice3Builder.label("High");
		
		PieChartSlice slice1 = slice1Builder.build();
		PieChartSlice slice2 = slice2Builder.build();
		PieChartSlice slice3 = slice3Builder.build();
		
		pie.addPieChartSlice(slice1);
		pie.addPieChartSlice(slice2);
		pie.addPieChartSlice(slice3);

		pieTotalCholesterol = pie;
	}
	
	/**
	 * Saves data for pie chart body mass index
	 * @param underweight
	 * @param normal
	 * @param overweight
	 * @param obese
	 */
	public void fillPieChartBodyMassIndex(int underweight, int normal, int overweight, int obese){
		PieChart pie = new PieChart(new Dimension(CHART_WIDTH,CHART_HEIGHT));
		pie.setChartTitle(new ChartTitle("Body%20Mass%20Index", Color.BLACK, CHART_TITLE_SIZE));
		pie.addChartColor(new ChartColor(Color.BLUE));
		
		PieChartSliceBuilder slice1Builder = new PieChartSliceBuilder(underweight);
		slice1Builder.label("Underweight");
		
		PieChartSliceBuilder slice2Builder = new PieChartSliceBuilder(normal);
		slice2Builder.label("Normal");

		PieChartSliceBuilder slice3Builder = new PieChartSliceBuilder(overweight);
		slice3Builder.label("Overweight");
		
		PieChartSliceBuilder slice4Builder = new PieChartSliceBuilder(obese);
		slice4Builder.label("Obese");
		
		PieChartSlice slice1 = slice1Builder.build();
		PieChartSlice slice2 = slice2Builder.build();
		PieChartSlice slice3 = slice3Builder.build();
		PieChartSlice slice4 = slice4Builder.build();
		
		pie.addPieChartSlice(slice1);
		pie.addPieChartSlice(slice2);
		pie.addPieChartSlice(slice3);
		pie.addPieChartSlice(slice4);

		pieBodyMassIndex = pie;
	}

	/**
	 * Saves data for pie chart blood pressure
	 * @param normal
	 * @param prehypertension
	 * @param stage1Hypertension
	 * @param stage2Hypertension
	 * @param hypertensiveCrisis
	 */
	public void fillPieChartBloodPressure(int normal, int prehypertension, int stage1Hypertension, int stage2Hypertension, int hypertensiveCrisis){
		PieChart pie = new PieChart(new Dimension(CHART_WIDTH,CHART_HEIGHT));
		pie.setChartTitle(new ChartTitle("Blood%20Pressure", Color.BLACK, CHART_TITLE_SIZE));
		pie.addChartColor(new ChartColor(Color.RED));
		
		PieChartSliceBuilder slice1Builder = new PieChartSliceBuilder(normal);
		slice1Builder.label("Normal");
		
		PieChartSliceBuilder slice2Builder = new PieChartSliceBuilder(prehypertension);
		slice2Builder.label("Prehypertension");

		PieChartSliceBuilder slice3Builder = new PieChartSliceBuilder(stage1Hypertension);
		slice3Builder.label("Stage%201%20Hypertension");
		
		PieChartSliceBuilder slice4Builder = new PieChartSliceBuilder(stage2Hypertension);
		slice4Builder.label("Stage%202%20Hypertension");

		PieChartSliceBuilder slice5Builder = new PieChartSliceBuilder(hypertensiveCrisis);
		slice5Builder.label("Hypertensive%20Crisis");
		
		PieChartSlice slice1 = slice1Builder.build();
		PieChartSlice slice2 = slice2Builder.build();
		PieChartSlice slice3 = slice3Builder.build();
		PieChartSlice slice4 = slice4Builder.build();
		PieChartSlice slice5 = slice5Builder.build();
		
		pie.addPieChartSlice(slice1);
		pie.addPieChartSlice(slice2);
		pie.addPieChartSlice(slice3);
		pie.addPieChartSlice(slice4);
		pie.addPieChartSlice(slice5);

		pieBloodPressure = pie;
	}
	
	/**
	 * Creates chart html file, given all three pie charts are filled with the appropriate fill methods.
	 */
	public void createChartReport(){
		if(!((pieTotalCholesterol == null) || (pieBodyMassIndex == null) || (pieBloodPressure == null))){
			writeUrlsToChartReport(pieTotalCholesterol.getUrl(), pieBodyMassIndex.getUrl(), pieBloodPressure.getUrl());
		}else{
			System.out.println("[ERROR] HSChartReport:createChartReport(): All pie charts must be filled with data before html file is written");
		}
	}
	
	private void writeUrlsToChartReport(String totalCholesterolUrl, String bodyMassIndexUrl, String bloodPressureUrl){
		String dataToWrite = 
			"<!DOCTYPE html>" + "\n" +
			"<html>" + "\n" +
			"<head>" + "\n" +
			"	<title>Health Screening Summary</title>" + "\n" +
			"	<style type=\"text/css\">" + "\n" +
			"		div img{" + "\n" +
			"			display: block;" + "\n" +
			"			margin: 1em auto;" + "\n" +
			"			border: 1px solid black;" + "\n" +
			"			box-shadow: 0px 0px 17px black;" + "\n" +
			"		}" + "\n" +
			"		h1{" + "\n" +
			"			text-align: center;" + "\n" +
			"		}" + "\n" +
			"	</style>" + "\n" +
			"</head>" + "\n" +
			"<body>" + "\n" +
			"	<h1>Health Screening Results</h1>" + "\n" +
			"	<div>" + "\n" +
			"		<img src=\"" + totalCholesterolUrl + "\">" + "\n" +
			"		<img src=\"" + bodyMassIndexUrl + "\">" + "\n" +
			"		<img src=\"" + bloodPressureUrl + "\">" + "\n" +
			"	</div>" + "\n" +
			"</body>" + "\n" +
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
