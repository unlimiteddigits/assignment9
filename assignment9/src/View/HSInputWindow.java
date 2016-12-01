/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.JFileChooser;

import org.json.JSONException;

import bodyprogram.Conversion;
import bodyprogram.DataBase;
import bodyprogram.RecordWindow;
import javafx.scene.control.DatePicker;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jacob
 */
public class HSInputWindow extends javax.swing.JFrame {

	

	/**
	 * Creates new form GUI
	 */
	public HSInputWindow() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jMenuItem1 = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtPatientName = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtPatientHeight1 = new javax.swing.JFormattedTextField();
		jLabel3 = new javax.swing.JLabel();
		txtPatientWeight = new javax.swing.JFormattedTextField();
		lblPatientHeightUnit1 = new javax.swing.JLabel();
		txtPatientHeight2 = new javax.swing.JFormattedTextField();
		lblPatientHeightUnit2 = new javax.swing.JLabel();
		txtDate = new org.jdesktop.swingx.JXDatePicker();
		jLabel4 = new javax.swing.JLabel();
		btnGenerateReport = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		txtCholesterol = new javax.swing.JFormattedTextField();
	

		jLabel6 = new javax.swing.JLabel();
		txtAge = new javax.swing.JFormattedTextField();
		jLabel7 = new javax.swing.JLabel();
		txtBMI = new javax.swing.JFormattedTextField();

		jLabel8 = new javax.swing.JLabel();
		txtBloodPressure = new javax.swing.JTextField();

		jMenuBar1 = new javax.swing.JMenuBar();
		btnFileMenu = new javax.swing.JMenu();
		btnOpenFile = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		btnCalculateBMI = new javax.swing.JMenuItem();
		searchRecords = new javax.swing.JMenuItem();
		searchByDate = new javax.swing.JMenuItem();
		jMenuItem1.setText("jMenuItem1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("SE-A9 Team 4 - Body");
		setName("mainGUI"); // NOI18N
		setResizable(false);
	

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Record"));

		jLabel1.setText("Full Name:");

		txtPatientName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtPatientName.setName("txtPatientName"); // NOI18N

		jLabel2.setText("Height:");

		txtPatientHeight1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##"))));
		txtPatientHeight1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtPatientHeight1.setName("txtPatientHeight"); // NOI18N
		
	

		jLabel3.setText("Weight:");

		txtPatientWeight.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
		txtPatientWeight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtPatientWeight.setName("txtPatientWeight"); // NOI18N
	

		lblPatientHeightUnit1.setText("feet");
		lblPatientHeightUnit1.setName("lblPatientHeightLeftUnit"); // NOI18N

		txtPatientHeight2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##"))));
		txtPatientHeight2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtPatientHeight2.setName("txtPatientHeight2"); // NOI18N
		
	

		lblPatientHeightUnit2.setText("inches");

		jLabel4.setText("Record Date");

		btnGenerateReport.setText("Generate Report");


		jLabel5.setText("Cholesterol:");

		txtCholesterol.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
		txtCholesterol.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		jLabel6.setText("Age:");

		txtAge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
		txtAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtAge_TextChange(evt);
			}
		});

		jLabel7.setText("BMI:");

		txtBMI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
		txtBMI.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		jLabel8.setText("Blood Pressure:");

		txtBloodPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	

		JLabel lblLbs = new JLabel();
		lblLbs.setText("lbs");
		lblLbs.setName("lblPatientHeightLeftUnit");

		txtCholesterolIndicator = new JTextField();
		txtCholesterolIndicator.setEnabled(false);
		txtCholesterolIndicator.setDisabledTextColor(Color.BLACK);
		txtCholesterolIndicator.setColumns(10);

		txtBMIIndicator = new JTextField();
		txtBMIIndicator.setEnabled(false);
		txtBMIIndicator.setDisabledTextColor(Color.BLACK);
		txtBMIIndicator.setColumns(10);

		txtBloodPressureIndicator = new JTextField();
		txtBloodPressureIndicator.setEnabled(false);
		txtBloodPressureIndicator.setDisabledTextColor(Color.BLACK);
		txtBloodPressureIndicator.setColumns(10);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel8)
										.addComponent(jLabel7).addComponent(jLabel5))
								.addGap(6).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtBloodPressure).addComponent(txtBMI).addComponent(
												txtCholesterol, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout
										.createSequentialGroup().addGap(18).addGroup(
												jPanel1Layout.createParallelGroup(Alignment.LEADING)
														.addComponent(txtCholesterolIndicator, GroupLayout.DEFAULT_SIZE,
																232, Short.MAX_VALUE)
														.addComponent(txtBMIIndicator, GroupLayout.DEFAULT_SIZE, 232,
																Short.MAX_VALUE)))
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(18).addComponent(
												txtBloodPressureIndicator, GroupLayout.DEFAULT_SIZE,
												232, Short.MAX_VALUE))))
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false).addGroup(jPanel1Layout
								.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel1)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(
														txtPatientWeight, GroupLayout.PREFERRED_SIZE, 33,
														GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblLbs, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(txtPatientName, GroupLayout.PREFERRED_SIZE, 178,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel6)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtAge,
														GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel2).addGap(10)
												.addComponent(txtPatientHeight1, GroupLayout.PREFERRED_SIZE, 34,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblPatientHeightUnit1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(txtPatientHeight2, GroupLayout.PREFERRED_SIZE, 36,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblPatientHeightUnit2).addGap(14))))
								.addComponent(jLabel4)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 169,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnGenerateReport,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1)
								.addComponent(txtPatientName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6).addComponent(txtAge, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPatientHeight2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPatientHeightUnit1).addComponent(jLabel2).addComponent(jLabel3)
								.addComponent(txtPatientHeight1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPatientHeightUnit2)
								.addComponent(txtPatientWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLbs))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCholesterol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel5).addComponent(txtCholesterolIndicator, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel7)
								.addComponent(txtBMI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBMIIndicator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel8)
								.addComponent(txtBloodPressure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBloodPressureIndicator, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE).addComponent(jLabel4)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(btnGenerateReport)
								.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(15)));
		jPanel1.setLayout(jPanel1Layout);

		lblPatientHeightUnit1.getAccessibleContext().setAccessibleName("jLabel4");

		jMenuBar1.setBorder(null);

		btnFileMenu.setText("File");

		btnOpenFile.setText("Open");
		btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOpenFileActionPerformed(evt);
			}
		});
		btnFileMenu.add(btnOpenFile);

		jMenuBar1.add(btnFileMenu);

		jMenu1.setText("Tools");

		btnCalculateBMI.setText("Calculate BMI");
	
		jMenu1.add(btnCalculateBMI);

		jMenu2.setText("Search");
		searchRecords.setText("Search by name");
		searchByDate.setText("search by date");

//		searchRecords.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnSearchRecordActionPerformed(evt);
//			}
//		});
		
//TODO asdfas
		
//		searchByDate.addActionListener(new java.awt.event.ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				btnSearchByDate(evt);
//				
//			}
//			
//			
//			
//		});

		jMenu2.add(searchRecords);
		jMenu2.add(searchByDate);

		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenu2);
		setJMenuBar(jMenuBar1);

		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(28, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void GUI_FormLoad(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_GUI_FormLoad
		// this.setLocationRelativeTo(null);
	}// GEN-LAST:event_GUI_FormLoad

	private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOpenFileActionPerformed
		JFileChooser jf = new JFileChooser("Open a patient record");
		jf.showOpenDialog(this);

		if (jf.getSelectedFile() != null) {
			RecordWindow rw = new RecordWindow(RecordWindow.RECORD_OPEN, jf.getSelectedFile().getAbsolutePath());
			rw.setVisible(true);
		}
	}





	

	
	
	
	public void btnSearchRecordActionPerformed(java.awt.event.ActionEvent evt) {

		javax.swing.JFrame searchFrame = new javax.swing.JFrame();

		searchFrame.setSize(new Dimension(500, 500));

		searchFrame.setLocationRelativeTo(null);
		searchFrame.setResizable(false);

		javax.swing.JTextArea dbResults = new javax.swing.JTextArea(5, 30);

		dbResults.setEditable(false);

		javax.swing.JPanel NorthPanel = new javax.swing.JPanel();

		NorthPanel.setLayout(new GridBagLayout());

		javax.swing.JLabel newLabel = new javax.swing.JLabel();
		javax.swing.JTextField newField = new javax.swing.JTextField();
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

		NorthPanel.add(newField, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 0;
		gbc.weightx = .2;
		gbc.weighty = 1;

		NorthPanel.add(btnSearch, gbc);

		btnSearch.setText("search records");

		newField.requestFocusInWindow();
		newLabel.setText("Enter Name: ");

		class MyAdapter implements ActionListener, KeyListener {

			@Override
			public void keyPressed(KeyEvent evt) {

				DataBase search = new DataBase(null);

				try {
					dbResults.setText(search.search(1, newField.getText()));

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
					dbResults.setText(search.search(1, newField.getText()));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		MyAdapter adapter = new MyAdapter();

		newField.addActionListener(adapter);
		btnSearch.addActionListener(adapter);

		searchFrame.getRootPane().setDefaultButton(btnSearch);

		javax.swing.JScrollPane records = new javax.swing.JScrollPane(dbResults);

		records.setSize(new Dimension(200, 200));

		searchFrame.add(NorthPanel, BorderLayout.NORTH);
		searchFrame.add(records, BorderLayout.CENTER);
		searchFrame.setTitle("Search Records by Name");

		searchFrame.setVisible(true);

	}




	
	private void txtAge_TextChange(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtAge_TextChange
		checkAge();
		
	}
	
	private boolean checkAge() {
		String value = txtAge.getText();
		boolean result = true;
		if (!Conversion.IsValidInteger(value, 1, 120)) {
			txtAge.setBackground(Color.PINK);
			result = false;
		} else {
			txtAge.setBackground(Color.WHITE);
		}
		return result;
	}

	

	

	

	

	
	

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem btnCalculateBMI;
	private javax.swing.JMenuItem searchRecords;
	private javax.swing.JMenuItem searchByDate;
	private javax.swing.JMenu btnFileMenu;
	private javax.swing.JButton btnGenerateReport;
	private javax.swing.JMenuItem btnOpenFile;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblPatientHeightUnit1;
	private javax.swing.JLabel lblPatientHeightUnit2;
	private javax.swing.JFormattedTextField txtAge;
	private javax.swing.JFormattedTextField txtBMI;
	private javax.swing.JTextField txtBloodPressure;
	private javax.swing.JFormattedTextField txtCholesterol;
	private org.jdesktop.swingx.JXDatePicker txtDate;
	private javax.swing.JFormattedTextField txtPatientHeight1;
	private javax.swing.JFormattedTextField txtPatientHeight2;
	private javax.swing.JTextField txtPatientName;
	private javax.swing.JFormattedTextField txtPatientWeight;
	private JTextField txtCholesterolIndicator;
	private JTextField txtBMIIndicator;
	private JTextField txtBloodPressureIndicator;



	
	
	public String getCholesterolText(){
		
		return txtCholesterol.getText();
	}
	
	public String getName(){
		return txtPatientName.getText();
	}
	
	public void setRiskIndicator(String indicator){
		txtCholesterolIndicator.setText(indicator);
	}
	
	public void setBloodPressureIndicator(String inidcator){
		txtBloodPressureIndicator.setText(inidcator);
	}
	
	public String getBloodPressureText(){
		return txtBloodPressure.getText();
	}
	
	public String getBmiText(){
		return txtBMI.getText();
	}
	
	public void setBmiText(String bmiValue){
		txtBMI.setText(bmiValue);
	}
	public String getWeightText(){
		return txtPatientWeight.getText();
	}
	
	public void setBmiIndicator(String indicator){
		txtBMIIndicator.setText(indicator);
	}
	
	public String getPatientHeightInFeetText(){
		return txtPatientHeight1.getText();
	}
	
	public String getPatientHeightInInchesText(){
		
		return txtPatientHeight2.getText();
	}
	
	
	
	public void setNameField(String name){
		jLabel1.setText(name);
	}

	public void addBloodPressureKeyListener(KeyListener k){
		txtBloodPressure.addKeyListener(k);
		
	}
	
	public void setBloodPressureBackground(Color color){
		txtBloodPressure.setBackground(color);
	}
	
	public void setFeetBackground(Color color){
		txtPatientHeight1.setBackground(color);
	}
	
	public void setInchesBackground(Color color){
		txtPatientHeight2.setBackground(color);
	}
	
	public void addBloodPressureFocusListener(FocusListener f){
		txtBloodPressure.addFocusListener(f);
	}

	public void addCholesteroldFieldFocusListener(FocusListener f){
		txtCholesterol.addFocusListener(f);
	}
	
	public void addNameListener(KeyListener k){
		txtPatientName.addKeyListener(k);
	}
	
	public void addCholesterolFieldKeyListener(KeyListener k){
		txtCholesterol.addKeyListener(k);
	}
	
	public void addBmiKeyListener(KeyListener k){
		txtBMI.addKeyListener(k);
	}
	
	public void addBmiMenuCalculationactionListener(ActionListener a){
		btnCalculateBMI.addActionListener(a);
	}

	public void addBmiFocusListener(FocusListener f){
		txtBMI.addFocusListener(f);
	}
	
	public void addPatientHeightInFeetListener(KeyListener k){
		txtPatientHeight1.addKeyListener(k);
	}
	
	public void addPatientHeightInInchesListener(KeyListener k){
		txtPatientHeight2.addKeyListener(k);
	
	}
	
	public void addWeightListener(KeyListener k){
		txtPatientWeight.addKeyListener(k);
	}
	
	public void addAgeListener(KeyListener k){
		txtAge.addKeyListener(k);
	}
	
	public String getAgeText(){
		return txtAge.getText();
	}
	
	public void setWeightBackground(Color color){
		txtPatientWeight.setBackground(color);
	}
	
	public void addDatePickerFocusListener(FocusListener f){
		txtDate.addFocusListener(f);
	}
	
	public String getDateText(){
		return txtDate.getDate().toString();
	}
	
	public void addReportButtonActionListener(ActionListener a){
		btnGenerateReport.addActionListener(a);
	}
	
	public void addSearchRecordsActionListener(ActionListener a){
		searchRecords.addActionListener(a);
	}
	
	public void addSearchByDateActionListener(ActionListener a){
		searchByDate.addActionListener(a);
	}
}
