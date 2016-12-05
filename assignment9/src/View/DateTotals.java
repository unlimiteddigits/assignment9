package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import org.json.JSONException;

import bodyprogram.DataBase;

public class DateTotals extends JFrame {
	
	
public DateTotals(){
	
	
	
	
	
	
	
}


public void searchTotalsByDate(){
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
	GridBagConstraints gbc2 = new GridBagConstraints();
	GridBagConstraints gbc3 = new GridBagConstraints();

	gbc.gridx = GridBagConstraints.RELATIVE;

	gbc.gridy = 0;

	gbc.weightx = .1;

	gbc.weighty = 1;

	NorthPanel.add(newLabel, gbc);

	gbc2.fill = GridBagConstraints.BOTH;

	gbc2.gridx = GridBagConstraints.RELATIVE;
	gbc2.gridy = 0;
	gbc2.insets = new Insets(1, 1, 1, 20);
	gbc2.weightx = 1;
	gbc2.weighty = .7;

	NorthPanel.add(datePicker, gbc2);

	gbc3.fill = GridBagConstraints.HORIZONTAL;
	gbc3.gridx = GridBagConstraints.RELATIVE;
	gbc3.gridy = 0;
	gbc3.weightx = .2;
	gbc3.weighty = 1;

	NorthPanel.add(btnSearch, gbc3);

	btnSearch.setText("totals by date");

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
				dbResults.setText(search.getDateTotals(datePicker.getDate().toString()));

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
	searchDateFrame.setTitle("Total count by Date");

	searchDateFrame.setVisible(true);





}


public void searchRecordsByDate(){
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

}
