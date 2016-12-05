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
import View.*;
import bodyprogram.DataBase;

public class PatientInformationEntryController {

	private final HSInputWindow view;
	private final PatientRecord model;
	private final Indications indications = new Indications();
	public PatientInformationEntryController(HSInputWindow view,PatientRecord model){
		
		this.view = view;
		this.model = model;
		
		view.addSearchByDateActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				javax.swing.JFrame searchDateFrame = new javax.swing.JFrame();

				searchDateFrame.setSize(new Dimension(500, 500));

				searchDateFrame.setLocationRelativeTo(null);
				searchDateFrame.setResizable(false);

				javax.swing.JTextArea dbResults = new javax.swing.JTextArea(5, 30);

				dbResults.setEditable(false);

				javax.swing.JPanel NorthPanel = new javax.swing.JPanel();

				NorthPanel.setLayout(new GridBagLayout());

				javax.swing.JLabel newLabel = new javax.swing.JLabel();
				org.jdesktop.swingx.JXDatePicker datePicker = new org.jdesktop.swingx.JXDatePicker();
				javax.swing.JButton btnSearch = new javax.swing.JButton();

				GridBagConstraints gbc = new GridBagConstraints();

				gbc.gridx = GridBagConstraints.RELATIVE;

				gbc.gridy = 0;

				gbc.weightx = .1;

				gbc.weighty = 1;

				NorthPanel.add(newLabel, gbc);

				gbc.fill = GridBagConstraints.BOTH;

				gbc.gridx = GridBagConstraints.RELATIVE;
				gbc.gridy = 0;
				gbc.insets = new Insets(1, 1, 1, 20);
				gbc.weightx = 1;
				gbc.weighty = .7;

				NorthPanel.add(datePicker, gbc);

				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.gridx = GridBagConstraints.RELATIVE;
				gbc.gridy = 0;
				gbc.weightx = .2;
				gbc.weighty = 1;

				NorthPanel.add(btnSearch, gbc);

				btnSearch.setText("search records");

				datePicker.requestFocusInWindow();
				newLabel.setText("Select Date: ");

				class MyAdapter implements ActionListener, KeyListener {

					@Override
					public void keyPressed(KeyEvent evt) {

						DataBase search = new DataBase(null);

						try {
							dbResults.setText(search.search(0, datePicker.getDate().toString()));

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void actionPerformed(ActionEvent evt) {
						DataBase search = new DataBase(null);

						try {
							dbResults.setText(search.search(0, datePicker.getDate().toString()));

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}

				MyAdapter adapter = new MyAdapter();

				datePicker.addActionListener(adapter);
				btnSearch.addActionListener(adapter);

				searchDateFrame.getRootPane().setDefaultButton(btnSearch);

				
				
				
				
				javax.swing.JScrollPane records = new javax.swing.JScrollPane(dbResults);

				
			
				
				records.setSize(new Dimension(200, 200));

				searchDateFrame.add(NorthPanel, BorderLayout.NORTH);
				searchDateFrame.add(records, BorderLayout.CENTER);
				searchDateFrame.setTitle("Search Records by Date");

				searchDateFrame.setVisible(true);
			
				
				
				
				
			}
		});
		
//		view.
		
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
	
view.addBmiMenuCalculationactionListener(new ActionListener(){
	@Override
	public void actionPerformed(java.awt.event.ActionEvent evt) {
		BmiServiceSoapProxy newProxy = new BmiServiceSoapProxy();
		
		
		
		ConverterServiceSoapProxy newConverter = new ConverterServiceSoapProxy();
		
		try {
			setBmiRisk();
			setPatientBmi(view.getBmiText());
			view.setBmiText(formatMyDouble(newProxy.getBmiValue(newConverter.lbs2Kg(Integer.parseInt(view.getWeightText())), newConverter.in2Cm(Integer.parseInt(view.getPatientHeightInFeetText()) * 12) + Integer.parseInt(view.getPatientHeightInInchesText()))) + "");
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
	
	
	view.addAgeListener(new KeyAdapter(){
		
		public void keyPressed(KeyEvent e){
			setPatientAge(view.getAgeText());
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

			insert.insertRecord();
		}
	});
	
	view.addDatePickerFocusListener(new FocusAdapter(){
		
		public void focusLost(FocusEvent arg0) {
			setPatientDate(view.getDateText());
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
	
	public void setPatientAge(String currentAge){
		model.setAge(currentAge);
	}
	
	public void setPatientCholesterol(String currentCholesterol){
		model.setCholesterol(currentCholesterol);
	}
	
	public void setPatientBmi(String currentBmiText){
		model.setBMI(currentBmiText);
	}
	
	public void setPatientWeight(String currentWeight){
		model.setWeight(currentWeight);
	}
	
	public void setBloodPressure(String currentBloodPressure){
		model.setBloodPressure(currentBloodPressure);
	}
	
	public void setPatientHeightFeet(String currentFeet){
		model.setHeightFeet(currentFeet);
	}
	
	public void setPatientHeightInches(String currentInches){
		model.setHeightInches(currentInches);
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
	
	public void setPatientDate(String currentDate){
		model.setDate(currentDate);
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
	
	public void setWeightBackground(Color color){
		view.setWeightBackground(color);
	}
	

	public  double formatMyDouble(double formatMe){
		
		DecimalFormat myFormat = new DecimalFormat("##.##");
		
		return Double.valueOf(myFormat.format(formatMe));
		
		
	}
	
	
}
