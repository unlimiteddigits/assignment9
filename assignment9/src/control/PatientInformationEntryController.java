package control;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

import org.json.JSONException;

import com.beetledev.www.BmiServiceSoapProxy;
import com.beetledev.www.ConverterServiceSoapProxy;

import Model.*;
import Store.DataBase;
import View.*;

public class PatientInformationEntryController {

	private final HSInputWindow view;
	private final PatientRecord model;
	private final Indications indications = new Indications();
	private final DateTotals dateInformation = new DateTotals();
	/**
	 * Constructor, Moderates the interaction between the PatientRecord and HSInputwindow
	 * Also adds all the necessary listeners to the view
	 * 
	 */
	public PatientInformationEntryController(HSInputWindow view,PatientRecord model){
		
		this.view = view;
		this.model = model;
		
		
		view.addSearchByDateActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
		
				
				dateInformation.searchRecordsByDate();				
				
				
			}
		});
		
		view.addSearchTotalsByDate(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				dateInformation.searchTotalsByDate();				
				
			}
			});
		
		view.addCholesterolFieldKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					setPatientCholesterolRisk();
					setPatientCholesterol(view.getCholesterolText());
					setIndicator(view.getCholesterolText());
				}
				;
			}
		});
		
		
		view.addCholesteroldFieldFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setPatientCholesterolRisk();
				setPatientCholesterol(view.getCholesterolText());
				setIndicator(view.getCholesterolText());
			}
		});
		
	
		view.addBloodPressureKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent e) {
				if(!indications.checkBloodPressure(view.getBloodPressureText())){
					setViewBackground(Color.RED);
					
				}else{
					setViewBackground(Color.WHITE);
				}
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					setBloodPressureRisk();
					setBloodPressure(view.getBloodPressureText());
					setBloodPressureIndicator(view.getBloodPressureText());
				}
				;
			}
		});
		

	view.addBloodPressureFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
			setBloodPressureRisk();
			setBloodPressure(view.getBloodPressureText());
			setBloodPressureIndicator(view.getBloodPressureText());
		}
	});
		
	
	view.addBmiKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				setBmiRisk();
				setPatientBmi(view.getBmiText());
				setBmiClassification();
			}
			
		}
	});
	
	view.addBmiFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
			setBmiRisk();
			setPatientBmi(view.getBmiText());
			setBmiClassification();
		}
	});

	view.addShowPieChartsActionListener(new ActionListener(){
		@Override
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			
			HSChartReport chart = new HSChartReport();
			
			try {
				chart.openChartReportInDefaultApplication();;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	});

view.addBmiMenuCalculationactionListener(new ActionListener(){
	@Override
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		BmiServiceSoapProxy newProxy = new BmiServiceSoapProxy();
		
		
		
		ConverterServiceSoapProxy newConverter = new ConverterServiceSoapProxy();
		
		try {
			setBmiRisk();
			setPatientBmi(view.getBmiText());
			view.setBmiText(formatMyDouble(newProxy.getBmiValue(newConverter.lbs2Kg(Integer.parseInt(view.getWeightText())), newConverter.in2Cm(Integer.parseInt(view.getPatientHeightInFeetText()) * 12) + Integer.parseInt(view.getPatientHeightInInchesText()))) + "");
			setBmiRisk();
			setPatientBmi(view.getBmiText());
			setBmiClassification();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
});
	
	
	view.addPatientHeightInFeetListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {
			if(!indications.checkHeights(indications.getFeetByte(),view.getPatientHeightInFeetText())){
				setFeetBackground(Color.RED);
			}
			else{
				setPatientHeightFeet(view.getPatientHeightInFeetText());
				setFeetBackground(Color.WHITE);
			}
		}
	});
	
	
	view.addPatientHeightInInchesListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {
			if(!indications.checkHeights(indications.getInchesByte(),view.getPatientHeightInInchesText())){
				setInchesBackground(Color.RED);
			}
			else{
				setPatientHeightInches(view.getPatientHeightInInchesText());
				setInchesBackground(Color.WHITE);
			}
		}
	});
	
	
	view.addWeightListener(new KeyAdapter(){
		
	public void keyReleased(KeyEvent e){
		if(!indications.checkWeight(view.getWeightText())){
			
			setWeightBackground(Color.RED);
		}else{
			setPatientWeight(view.getWeightText());
			setWeightBackground(Color.WHITE);
		}
	}
	
	});	
	
	
	view.addNameListener(new KeyAdapter(){
		
		
		public void keyPressed(KeyEvent e){
			setPatientName(view.getName());
		}
		
	});
	
	
	view.addLastNameListener(new KeyAdapter(){
		

		public void keyPressed(KeyEvent e){
			setPatientName(view.getName());
		}
		
	});
	
	view.addAgeListener(new KeyAdapter(){
		
		public void keyPressed(KeyEvent e){
			setPatientAge(view.getAgeText());
		}
		
		
		
	});
	
	view.addAgeFocusListener(new FocusAdapter(){
		public void focusLost(FocusEvent arg0){
			setPatientAge(view.getAgeText());
		}
	});
	
	view.addNameFocusListener(new FocusAdapter(){
		public void focusLost(FocusEvent arg0){
			setPatientName(view.getName());
		}
	});
	
	view.addLastNameFoucsListener(new FocusAdapter(){
		public void focusLost(FocusEvent arg0){
			setPatientName(view.getName());
		}
	});
	
	
	view.addReportButtonActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String[] patientInfo = { model.getName(), view.getDateText(), model.getAge(),
					model.getHeightFeet(), model.getHeightInches(), model.getWeight(),
					model.getCholesterol(), model.getBmi(), model.getBloodPressure(),model.getCholesterolRisk()
					,model.getBmiRisk(),model.getBloodPressureRisk()};
			String date = "1"; 
			String line = "";

			DataBase insert = new DataBase(patientInfo);
			view.clearComponents();
			
			insert.insertRecord();
		}
	});
	
	view.addDatePickerFocusListener(new FocusAdapter(){
		
		public void focusLost(FocusEvent arg0) {
			setPatientDate(view.getDateText());
		}
		
		
		
	});
	
		
	}

	
	/**
	 * Sets the views cholesterol classification textfield
	 * 
	 */
	public void setIndicator(String indicator){
		view.setRiskIndicator(model.getCholesterolRisk());
	}
	/**
	 * Sets the views blood pressure classification text field
	 * 
	 */
	public void setBloodPressureIndicator(String indicator){
		view.setBloodPressureIndicator(model.getBloodPressureRisk());
	}
	/**
	 * sets the views bmi classification text field
	 */
	public void setBmiClassification(){
	view.setBmiIndicator(model.getBmiRisk());
	}
	/**
	 * Sets the name of the patient
	 * 
	 */
	public void setPatientName(String name){
		
		model.setName(name);
	}
	/**
	 * sets the patients bmi risk
	 */
	public void setBmiRisk(){
		model.setBmiRisk(indications.indicateBMIRisk(view.getBmiText()));
	}
	/**
	 * Sets the patients age
	 * 
	 */
	public void setPatientAge(String currentAge){
		model.setAge(currentAge);
	}
	/**
	 *Sets the patients cholesterol value 
	 *
	 */
	public void setPatientCholesterol(String currentCholesterol){
		model.setCholesterol(currentCholesterol);
	}
	/**
	 * Sets the patients bmi value
	 * 
	 */
	public void setPatientBmi(String currentBmiText){
		model.setBMI(currentBmiText);
	}
	/**
	 * Sets the patients weight value
	 * 
	 */
	public void setPatientWeight(String currentWeight){
		model.setWeight(currentWeight);
	}
	/**
	 * Sets the patients blood pressure value
	 * 
	 */
	public void setBloodPressure(String currentBloodPressure){
		model.setBloodPressure(currentBloodPressure);
	}
	/**
	 * Sets the patients feet value
	 * @param currentFeet
	 */
	public void setPatientHeightFeet(String currentFeet){
		model.setHeightFeet(currentFeet);
	}
	/**
	 * Sets the patients inches value
	 * 
	 */
	public void setPatientHeightInches(String currentInches){
		model.setHeightInches(currentInches);
	}
	/**
	 * Sets the cholesterol risk of the patient
	 */
	public void setPatientCholesterolRisk(){
		model.setCholesterolRisk(indications.indicateCholesterolRisk(view.getCholesterolText()));
	}
	/**
	 * sets the patients blood pressure risk
	 */
	public void setBloodPressureRisk(){
		model.setBloodPressureRisk(indications.indicateBloodPressureRisk(view.getBloodPressureText()));
	}
	
	/**
	 * Sets the name field of the view
	 */
	public void setNameField(){
		view.setNameField(model.getName());
	}
	/**
	 * Sets the date the patient record was entered
	 * 
	 */
	public void setPatientDate(String currentDate){
		model.setDate(currentDate);
	}
	/**
	 * Sets the background of the feet text field
	 * 
	 */
	public void setFeetBackground(Color color){
		view.setFeetBackground(color);
	}
	/**
	 * Sets the background of the inches text field
	 * 
	 */
	public void setInchesBackground(Color color){
		view.setInchesBackground(color);
	}
	/**
	 * Sets the background of the blood pressure text feild
	 *
	 */
	public void setViewBackground(Color color){
	
		view.setBloodPressureBackground(color);
		
	}
	/**
	 * Sets the background of the weight text field
	 * 
	 */
	public void setWeightBackground(Color color){
		view.setWeightBackground(color);
	}
	
/**
 * Returns a formatted double ex: 33.892 would become 33.89
 * 
 */
	public  double formatMyDouble(double formatMe){
		
		DecimalFormat myFormat = new DecimalFormat("##.##");
		
		return Double.valueOf(myFormat.format(formatMe));
		
		
	}
	
	
}
