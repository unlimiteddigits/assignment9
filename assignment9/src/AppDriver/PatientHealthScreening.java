package AppDriver;

import Model.PatientRecord;
import Store.DataBase;

import org.json.JSONException;

import Model.HSChartReport;
import View.HSInputWindow;
import control.PatientInformationEntryController;

public class PatientHealthScreening {

	public static void main(String[] args) {
		
		PatientRecord thisModel;
		HSInputWindow thisView;
		try {
			thisModel = new PatientRecord("John");
			
			thisView = new HSInputWindow();
			PatientInformationEntryController controller = new PatientInformationEntryController(thisView,thisModel);
		
			thisView.setVisible(true);
			
		
			
			
				
				} catch (Exception e) {
			e.printStackTrace();
		}
		
//		dateTotals newDateTotals = new dateTotals();
		
		
		new HSChartReport();
		
		DataBase what = new DataBase();
		
		try {
			what.pieChartInfo();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
