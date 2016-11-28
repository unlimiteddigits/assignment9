package control;

import Model.PatientRecord;
import View.HSInputWindow;

public class TestDrive {

	public static void main(String[] args) {
		
		PatientRecord thisModel = new PatientRecord("John");
		
		HSInputWindow thisView = new HSInputWindow();
		
		
		PatientInformationEntryController controller = new PatientInformationEntryController(thisView,thisModel);
		
		
		
		
		
		
		thisView.setVisible(true);
		
		

	}

}
