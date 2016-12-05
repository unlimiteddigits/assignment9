package AppDriver;

import Model.PatientRecord;
import View.HSInputWindow;
import View.DateTotals;
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
		
		
		

	}

}
