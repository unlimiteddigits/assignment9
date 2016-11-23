package control;

import View.HSInputWindow;
import bodyprogram.PatientRecord;

public class TestDrive {

	public static void main(String[] args) {
		
		PatientRecord thisModel = new PatientRecord("John");
		
		HSInputWindow thisView = new HSInputWindow();
		
		
		PatientInformationEntryController controller = new PatientInformationEntryController(thisView,thisModel);
		
		
		
		
		controller.setNameField();
		
		thisView.setVisible(true);
		
		

	}

}
