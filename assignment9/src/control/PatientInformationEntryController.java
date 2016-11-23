package control;



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
		
		
		
		
		
	}
	
	public void setIndicator(String indicator){
		view.setRiskIndicator(model.indicateCholesterolRisk(indicator));
	}
	
	public void setPatientName(String name){
		model.setName(name);
	}
	
	public void setNameField(){
		view.setNameField(model.getName());
	}
	
	
	
	
	
	
	
}
