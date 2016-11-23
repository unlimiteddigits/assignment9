package control;



import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Model.*;
import View.*;
import bodyprogram.PatientRecord;

public class PatientInformationEntryController {

	private final HSInputWindow view;
	private final PatientRecord model;
	
	public PatientInformationEntryController(HSInputWindow view,PatientRecord model){
		
		this.view = view;
		this.model = model;
		
		view.addCholesterolFieldKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					setIndicator(view.getCholesterolText());
				}
				;
			}
		});
		
		
		view.addCholesteroldFieldFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				setIndicator(view.getCholesterolText());
			}
		});
		
	
		view.addBloodPressureKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent e) {
				if(!model.checkBloodPressure(view.getBloodPressureText())){
					setViewBackground(Color.RED);
					
				}else{
					setViewBackground(Color.WHITE);
				}
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					setBloodPressureIndicator(view.getBloodPressureText());
				}
				;
			}
		});
		
		
		
	}	
		
		

	
	public void setIndicator(String indicator){
		view.setRiskIndicator(model.indicateCholesterolRisk(indicator));
	}
	
	public void setBloodPressureIndicator(String indicator){
		view.setBloodPressureIndicator(model.indicateBloodPressureRisk(indicator));
	}
	
	public void setPatientName(String name){
		model.setName(name);
	}
	
	public void setNameField(){
		view.setNameField(model.getName());
	}
	
	public void setViewBackground(Color color){
	
		view.setBloodPressureBackground(color);
		
	}
	
	
	
	
	
}
