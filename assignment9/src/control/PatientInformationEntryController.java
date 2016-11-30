package control;



import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.text.DecimalFormat;

import com.beetledev.www.BmiServiceSoapProxy;
import com.beetledev.www.ConverterServiceSoapProxy;

import Model.*;
import View.*;

public class PatientInformationEntryController {

	private final HSInputWindow view;
	private final PatientRecord model;
	private final Indications indications = new Indications();
	public PatientInformationEntryController(HSInputWindow view,PatientRecord model){
		
		this.view = view;
		this.model = model;
		
		view.addCholesterolFieldKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					setPatientCholesterolRisk();
					setIndicator(view.getCholesterolText());
				}
				;
			}
		});
		
		
		view.addCholesteroldFieldFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setPatientCholesterolRisk();
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
					setBloodPressureIndicator(view.getBloodPressureText());
				}
				;
			}
		});
		

	view.addBloodPressureFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
			setBloodPressureRisk();
			setBloodPressureIndicator(view.getBloodPressureText());
		}
	});
		
	
	view.addBmiKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				setBmiRisk();
				setBmiClassification();
			}
			
		}
	});
	
	view.addBmiFocusListener(new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent arg0) {
			setBmiRisk();
			setBmiClassification();
		}
	});
	
view.addBmiMenuCalculationactionListener(new ActionListener(){
	@Override
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		BmiServiceSoapProxy newProxy = new BmiServiceSoapProxy();
		
		
		
		ConverterServiceSoapProxy newConverter = new ConverterServiceSoapProxy();
		
		try {
			setBmiRisk();
			view.setBmiText(formatMyDouble(newProxy.getBmiValue(newConverter.lbs2Kg(Integer.parseInt(view.getWeightText())), newConverter.in2Cm(Integer.parseInt(view.getPatientHeightInFeetText()) * 12) + Integer.parseInt(view.getPatientHeightInInchesText()))) + "");
			setBmiClassification();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBmiRisk();
		setBmiClassification();
	}
	
	
});
	
	
	view.addPatientHeightInFeetListener(new java.awt.event.KeyAdapter() {
		public void keyReleased(java.awt.event.KeyEvent evt) {
			if(!indications.checkHeights(indications.getFeetByte(),view.getPatientHeightInFeetText())){
				setFeetBackground(Color.RED);
			}
			else{
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
				setInchesBackground(Color.WHITE);
			}
		}
	});
	
	
		
	}	
		
		

	
	
	public void setIndicator(String indicator){
		view.setRiskIndicator(model.getCholesterolRisk());
	}
	
	public void setBloodPressureIndicator(String indicator){
		view.setBloodPressureIndicator(model.getBloodPressureRisk());
	}
	
	public void setBmiClassification(){
	view.setBmiIndicator(model.getBmiRisk());
	}
	
	public void setPatientName(String name){
		
		model.setName(name);
	}
	
	public void setBmiRisk(){
		model.setBmiRisk(indications.indicateBMIRisk(view.getBmiText()));
	}
	
	public void setPatientCholesterolRisk(){
		model.setCholesterolRisk(indications.indicateCholesterolRisk(view.getCholesterolText()));
	}
	
	public void setBloodPressureRisk(){
		model.setBloodPressureRisk(indications.indicateBloodPressureRisk(view.getBloodPressureText()));
	}
	
	
	public void setNameField(){
		view.setNameField(model.getName());
	}
	
	public void setFeetBackground(Color color){
		view.setFeetBackground(color);
	}
	
	public void setInchesBackground(Color color){
		view.setInchesBackground(color);
	}
	
	public void setViewBackground(Color color){
	
		view.setBloodPressureBackground(color);
		
	}
	

	public static double formatMyDouble(double formatMe){
		
		DecimalFormat myFormat = new DecimalFormat("##.##");
		
		return Double.valueOf(myFormat.format(formatMe));
		
		
	}
	
	
}
