/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodyprogram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author jacob
 */
public class GUI extends javax.swing.JFrame {
    
    public final byte CHECK_FEET = 0x20;
    public final byte CHECK_INCHES = 0x08;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        txtCholesterol.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyChar() == KeyEvent.VK_ENTER){
        			indicateCholesterolRisk();
        		};
        	}
        });
        txtCholesterol.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) {
    			indicateCholesterolRisk();
        	}
        });
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBMI = new javax.swing.JFormattedTextField();
        txtBMI.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) {
    			indicateBMIRisk();
        	}
        });
        txtBMI.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyChar() == KeyEvent.VK_ENTER){
        			indicateBMIRisk();
        		};
        	}
        });
        jLabel8 = new javax.swing.JLabel();
        txtBloodPressure = new javax.swing.JTextField();
        txtBloodPressure.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent arg0) {
    			indicateBloodPressureRisk();
        	}
        });
        jMenuBar1 = new javax.swing.JMenuBar();
        btnFileMenu = new javax.swing.JMenu();
        btnOpenFile = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnCalculateBMI = new javax.swing.JMenuItem();
        searchRecords = new javax.swing.JMenuItem();
        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SE-A9 Team 4 - Body");
        setName("mainGUI"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                GUI_FormLoad(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Record"));

        jLabel1.setText("Full Name:");

        txtPatientName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPatientName.setName("txtPatientName"); // NOI18N

        jLabel2.setText("Height:");

        txtPatientHeight1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##"))));
        txtPatientHeight1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPatientHeight1.setName("txtPatientHeight"); // NOI18N
        txtPatientHeight1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPatientHeight1_FocusLost(evt);
            }
        });
        txtPatientHeight1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatientHeight_TextChange(evt);
            }
        });

        jLabel3.setText("Weight:");

        txtPatientWeight.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtPatientWeight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPatientWeight.setName("txtPatientWeight"); // NOI18N
        txtPatientWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatientWeight_TextChange(evt);
            }
        });

        lblPatientHeightUnit1.setText("feet");
        lblPatientHeightUnit1.setName("lblPatientHeightLeftUnit"); // NOI18N

        txtPatientHeight2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##"))));
        txtPatientHeight2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPatientHeight2.setName("txtPatientHeight2"); // NOI18N
        txtPatientHeight2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPatientHeight2_FocusLost(evt);
            }
        });
        txtPatientHeight2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPatientHeight2_TextChange(evt);
            }
        });

        lblPatientHeightUnit2.setText("inches");

        jLabel4.setText("Record Date");

        btnGenerateReport.setText("Generate Report");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        jLabel5.setText("Cholesterol:");

        txtCholesterol.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
        txtCholesterol.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("Age:");

        txtAge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));
        txtAge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAge_TextChange(evt);
            }
        });

        jLabel7.setText("BMI:");

        txtBMI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtBMI.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setText("Blood Pressure:");

        txtBloodPressure.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBloodPressure.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBloodPressure_TextChanged(evt);
            }
        });
        
        JLabel lblLbs = new JLabel();
        lblLbs.setText("lbs");
        lblLbs.setName("lblPatientHeightLeftUnit");
        
        txtCholesterolIndicator = new JTextField();
        txtCholesterolIndicator.setEditable(false);
        txtCholesterolIndicator.setColumns(10);
        
        txtBMIIndicator = new JTextField();
        txtBMIIndicator.setEditable(false);
        txtBMIIndicator.setColumns(10);
        
        txtBloodPressureIndicator = new JTextField();
        txtBloodPressureIndicator.setEditable(false);
        txtBloodPressureIndicator.setColumns(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel8)
        						.addComponent(jLabel7)
        						.addComponent(jLabel5))
        					.addGap(6)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtBloodPressure)
        						.addComponent(txtBMI)
        						.addComponent(txtCholesterol, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(18)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(txtCholesterolIndicator, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        								.addComponent(txtBMIIndicator, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(txtBloodPressureIndicator, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))))
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(jLabel1)
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addComponent(jLabel3)
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(txtPatientWeight, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(lblLbs, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addComponent(txtPatientName, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(jLabel6)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addComponent(jLabel2)
        								.addGap(10)
        								.addComponent(txtPatientHeight1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(lblPatientHeightUnit1)
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(txtPatientHeight2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(lblPatientHeightUnit2)
        								.addGap(14))))
        					.addComponent(jLabel4)
        					.addGroup(jPanel1Layout.createSequentialGroup()
        						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(btnGenerateReport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(txtPatientName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6)
        				.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtPatientHeight2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPatientHeightUnit1)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3)
        				.addComponent(txtPatientHeight1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPatientHeightUnit2)
        				.addComponent(txtPatientWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblLbs))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtCholesterol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel5)
        				.addComponent(txtCholesterolIndicator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(txtBMI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtBMIIndicator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(txtBloodPressure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtBloodPressureIndicator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
        			.addComponent(jLabel4)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnGenerateReport)
        				.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(15))
        );
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
        btnCalculateBMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateBMIActionPerformed(evt);
            }
        });
        jMenu1.add(btnCalculateBMI);
        
        jMenu2.setText("Search");
       searchRecords.setText("Search by name");
       
       searchRecords.addActionListener(new java.awt.event.ActionListener() {
    	   public void actionPerformed(java.awt.event.ActionEvent evt) {
           btnSearchRecordActionPerformed(evt);
       }
   });

jMenu2.add(searchRecords);
       
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(28, Short.MAX_VALUE)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GUI_FormLoad(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_GUI_FormLoad
        //this.setLocationRelativeTo(null);
    }//GEN-LAST:event_GUI_FormLoad

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        JFileChooser jf = new JFileChooser("Open a patient record");
        jf.showOpenDialog(this);
        
        if(jf.getSelectedFile() != null){
            RecordWindow rw = new RecordWindow(RecordWindow.RECORD_OPEN, jf.getSelectedFile().getAbsolutePath());
            rw.setVisible(true);
        }
    }//GEN-LAST:event_btnOpenFileActionPerformed

    private void txtBloodPressure_TextChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBloodPressure_TextChanged
        checkBloodPressure();
		if (evt.getKeyChar() == KeyEvent.VK_ENTER){
			indicateBloodPressureRisk();
		};
    }//GEN-LAST:event_txtBloodPressure_TextChanged

    private void txtPatientWeight_TextChange(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientWeight_TextChange
        checkWeight();
    }//GEN-LAST:event_txtPatientWeight_TextChange

    private void txtPatientHeight_TextChange(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientHeight_TextChange
        checkHeights(CHECK_FEET);
    }//GEN-LAST:event_txtPatientHeight_TextChange

    private void txtPatientHeight2_TextChange(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPatientHeight2_TextChange
        checkHeights(CHECK_INCHES);
    }//GEN-LAST:event_txtPatientHeight2_TextChange

    private void btnCalculateBMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateBMIActionPerformed
        if(checkHeights( (byte)(CHECK_FEET | CHECK_INCHES) ) & checkWeight()){
            String height1 = txtPatientHeight1.getText();
            String height2 = txtPatientHeight2.getText();
            String weight = txtPatientWeight.getText();
            double BMI = Conversion.CalculateBodyMassIndex(height1, height2, weight);
            
            if(BMI > 0.0){
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.HALF_UP);
                txtBMI.setText(df.format(BMI));
                txtBMI.setBackground(Color.WHITE);
            }else{
                txtBMI.setBackground(Color.PINK);
            }
            indicateBMIRisk();
        }
    }//GEN-LAST:event_btnCalculateBMIActionPerformed

    private void  btnSearchRecordActionPerformed(java.awt.event.ActionEvent evt){
    	
    	javax.swing.JFrame searchFrame = new javax.swing.JFrame();
    	
    	
    	
    	
    	searchFrame.setSize(new Dimension(500,500));
    	
    	searchFrame.setLocationRelativeTo(null);
    	
    	javax.swing.JTextArea dbResults = new javax.swing.JTextArea(5,30);
    	
    
    	
    	
    	javax.swing.JPanel NorthPanel = new javax.swing.JPanel();
    	
    	NorthPanel.setLayout(new GridLayout(1,3));
    	
    	
    	
    	javax.swing.JLabel newLabel = new javax.swing.JLabel();
    	javax.swing.JTextField newField = new javax.swing.JTextField();
    	javax.swing.JButton btnSearch = new javax.swing.JButton();
    	
    	btnSearch.setText("search records");
    	
    	
    	newLabel.setText("Enter Name: ");
    	newLabel.setSize(new Dimension(200,30));
    	
    	btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	DataBase search = new DataBase(null);
            	
            	
            	
            	try {
            		dbResults.setText(search.search(1,newField.getText()));
        			
        		} catch (JSONException e) {
        			// TODO Auto-generated catch block
        			dbResults.setText("no records found");
        		}
            
            }
        });
    	
    	NorthPanel.add(newLabel);
    	NorthPanel.add(newField);
    	NorthPanel.add(btnSearch);
    	
    	
    	
    	javax.swing.JScrollPane records = new javax.swing.JScrollPane(dbResults);
    	
    	records.setSize(new Dimension(200,200));
    	
    	searchFrame.getContentPane().add(NorthPanel, BorderLayout.NORTH);
    	searchFrame.getContentPane().add(records,BorderLayout.CENTER);
    	

    	
    	searchFrame.pack();
    	
    	
    	searchFrame.setVisible(true);
    	
    	

    
    	
    }
    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        if(checkAllFields()){
        	String[] patientInfo = {txtPatientName.getText(),txtDate.getDate().toString(),txtAge.getText(),txtPatientHeight1.getText(),txtPatientHeight2.getText(),txtPatientWeight.getText(),txtCholesterol.getText(),txtBMI.getText(),txtBloodPressure.getText()};
    		String date = "1";
    		String line = "";
    		
    		
    		DataBase insert = new DataBase(patientInfo);
    		
    		insert.insertRecord();
    		
    		
    		
        }
        }
    //GEN-LAST:event_btnGenerateReportActionPerformed

    private void txtPatientHeight1_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPatientHeight1_FocusLost
        checkHeights(CHECK_FEET);
    }//GEN-LAST:event_txtPatientHeight1_FocusLost

    private void txtPatientHeight2_FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPatientHeight2_FocusLost
        checkHeights(CHECK_INCHES);
    }//GEN-LAST:event_txtPatientHeight2_FocusLost

    private void txtAge_TextChange(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAge_TextChange
        checkAge();
    }//GEN-LAST:event_txtAge_TextChange

    private boolean checkAllFields(){
        return checkHeights((byte)(CHECK_FEET | CHECK_INCHES)) & checkWeight() 
                & checkBloodPressure() & checkAge() & checkCholesterol();
    }
    
    private boolean checkAge(){
        String value = txtAge.getText();
        boolean result = true;
        if(!Conversion.IsValidInteger(value, 1, 120)){
            txtAge.setBackground(Color.PINK);
            result =  false;
        }else{
            txtAge.setBackground(Color.WHITE);
        }
        return result;
    }
    
    private boolean checkCholesterol(){
        String value = txtCholesterol.getText();
        boolean result = true;
        if(!Conversion.IsValidInteger(value)){
            txtCholesterol.setBackground(Color.PINK);
            result = false;
        }else{
            txtCholesterol.setBackground(Color.WHITE);
        }
        return result;
    }
    
    private boolean checkWeight(){
        String value = txtPatientWeight.getText();
        boolean result = true;
        if(!Conversion.IsValidInteger(value, 1, 500)){
            txtPatientWeight.setBackground(Color.PINK);
            result = false;
        }else{
            txtPatientWeight.setBackground(Color.WHITE);
        }
        return result;
    }
    
    private boolean checkHeights(final byte boxes){
        String value1 = txtPatientHeight1.getText();
        String value2 = txtPatientHeight2.getText();
        boolean result = true;
        
        if( (boxes & CHECK_FEET) == CHECK_FEET){
            if(!Conversion.IsValidInteger(value1, 0, 10)){    
                txtPatientHeight1.setBackground(Color.PINK);
                result = false;
            }else{
                txtPatientHeight1.setBackground(Color.WHITE);
            }
        }
        
        if( (boxes & CHECK_INCHES) == CHECK_INCHES ){
            if(!Conversion.IsValidInteger(value2, 0, 11)){
                txtPatientHeight2.setBackground(Color.PINK);
                result = false;
            }else{
                txtPatientHeight2.setBackground(Color.WHITE);
            }
        }
        return result;
    }
    
    private boolean checkBloodPressure(){
        boolean result = true;
        if(!txtBloodPressure.getText().matches("[0-9]+/[0-9]+")){
            txtBloodPressure.setBackground(Color.PINK);
            result = false;
        }else{
            txtBloodPressure.setBackground(Color.WHITE);
        }
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCalculateBMI;
    private javax.swing.JMenuItem searchRecords;
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

	private void indicateBMIRisk() {
		String Indicator ="";
		if (txtBMI.getText().isEmpty()){
			Indicator="";
		} else {
		double value = Double.parseDouble(txtBMI.getText());
		if  (value  < 18.5) {
			Indicator="UNDERWEIGHT";
		} else 
		if  (value  >= 18.5 & value<= 24.9) {
			Indicator="NORMAL";
		} else 
    		if  (value  >= 25.0 & value<= 29.9) {
    			Indicator="OVERWEIGHT";
    	} else {
			Indicator="OBESE";
    	};
		};
		txtBMIIndicator.setText(Indicator);
	}
	private void indicateCholesterolRisk() {
		String Indicator ="";
		if (txtCholesterol.getText().isEmpty()){
			Indicator="";
		} else {
			double value = Conversion.SafeParseInteger(txtCholesterol.getText());
			Indicator ="BORDERLINE HIGH";
			if  (value  < 200) {
				Indicator="DESIRABLE";
			}
			if  (value  >= 240) {
				Indicator="HIGH";
			};
		};
		txtCholesterolIndicator.setText(Indicator);
	}
	private void indicateBloodPressureRisk() {
		String Indicator ="";
		if (txtBloodPressure.getText().isEmpty()){
			Indicator="";
		} else {
			int systolic =0;
			int diastolic =0;
			int positionOfSlash;
			String bp = txtBloodPressure.getText();
			int lengthOfBP = txtBloodPressure.getText().length();
			positionOfSlash = txtBloodPressure.getText().indexOf('/');
			
			systolic = Conversion.SafeParseInteger(bp.substring(0, positionOfSlash));
			diastolic = Conversion.SafeParseInteger(bp.substring(positionOfSlash+1,lengthOfBP));
			//Indicator=Integer.toString(systolic)+";;"+Integer.toString(diastolic)+";;"+Integer.toString(positionOfSlash);
			if (systolic < 120 & diastolic < 80){
				Indicator="NORMAL";
			}
			if (120 <= systolic & systolic <= 139 | 80 <= diastolic & diastolic <= 89) {
				Indicator="PREHYPERTENSION";
			}
			if (140 <= systolic & systolic <= 159 | 90 <= diastolic & diastolic <= 99) {
				Indicator="STAGE 1 HYPERTENSION ";
			}
			if (160 <= systolic & systolic <= 180 | 100 <= diastolic & diastolic <= 110) {
				Indicator="STAGE 2 HYPERTENSION ";
			}
			if (systolic > 180 | diastolic > 110) {
				Indicator="HYPERTENSIVE CRISIS";
			}
		};
		txtBloodPressureIndicator.setText(Indicator);
	}
}
