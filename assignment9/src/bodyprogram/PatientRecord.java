package bodyprogram;

import java.awt.Color;

/**
 *
 * @author jacob psimos
 */
public class PatientRecord {
    private String name;
    private String age;
    private String heightFeet;
    private String heightInches;
    private String weight;
    private String cholesterol;
    private String bmi;
    private String bloodPressure;
    private String date;
    private String cholesterolRisk;
    private String bloodPressureIndicator;
    public PatientRecord(final String name){
        this.name = name;
    }
    
   public void setName(final String name){
	   this.name = name;
   }
    
    public void setAge(final String age){
        this.age = age;
    }
    
    public String indicateCholesterolRisk(String cholesterol) {
		String Indicator = "";
		if (cholesterol.isEmpty()) {
			Indicator = "";
		} else {
			double value = Conversion.SafeParseInteger(cholesterol);
			Indicator = "BORDERLINE HIGH";
			if (value < 200) {
				Indicator = "DESIRABLE";
			}
			if (value >= 240) {
				Indicator = "HIGH";
			}
			;
		}
		;
		cholesterolRisk = Indicator;
		return cholesterolRisk;
	}
    
    
    public boolean checkBloodPressure(String bloodPressure){
    	boolean result = true;
		if (!bloodPressure.matches("[0-9]+/[0-9]+")) {
			//bloodPressure.setBackground(Color.PINK);
			result = false;
		} 
		return result;
    }
    
    
   public String indicateBloodPressureRisk(String bloodPressure) {
		String Indicator = "";
		if (bloodPressure.isEmpty()) {
			Indicator = "";
		} else {
			int systolic = 0;
			int diastolic = 0;
			int positionOfSlash;
			String bp = bloodPressure;
			int lengthOfBP = bloodPressure.length();
			positionOfSlash = bloodPressure.indexOf('/');

			systolic = Conversion.SafeParseInteger(bp.substring(0, positionOfSlash));
			diastolic = Conversion.SafeParseInteger(bp.substring(positionOfSlash + 1, lengthOfBP));
			// Indicator=Integer.toString(systolic)+";;"+Integer.toString(diastolic)+";;"+Integer.toString(positionOfSlash);
			if (systolic < 120 & diastolic < 80) {
				Indicator = "NORMAL";
			}
			if (120 <= systolic & systolic <= 139 | 80 <= diastolic & diastolic <= 89) {
				Indicator = "PREHYPERTENSION";
			}
			if (140 <= systolic & systolic <= 159 | 90 <= diastolic & diastolic <= 99) {
				Indicator = "STAGE 1 HYPERTENSION ";
			}
			if (160 <= systolic & systolic <= 180 | 100 <= diastolic & diastolic <= 110) {
				Indicator = "STAGE 2 HYPERTENSION ";
			}
			if (systolic > 180 | diastolic > 110) {
				Indicator = "HYPERTENSIVE CRISIS";
			}
		}
		;
		bloodPressureIndicator = Indicator;
		return bloodPressureIndicator;
	}
    
    public void setBloodPressure(final String bp){
        this.bloodPressure = bp;
    }
    
    public void setHeight(final String feet, final String inches){
        this.heightFeet = feet;
        this.heightInches = inches;
    }
    
    public void setWeight(final String weight){
        this.weight = weight;
    }
    
    public void setCholesterol(final String cholesterol){
        this.cholesterol = cholesterol;
    }
    
    public void setBMI(final String bmi){
        this.bmi = bmi;
    }
    
    public void setDate(final String date){
        this.date = date;
    }
  
    public String getName(){
    	return name;
    }
    
    public String generateHTML(){
        StringBuilder html = new StringBuilder();
        html.append("<html>\n");
        html.append("<p style=\"font-weight:bold\">");
        html.append("Health screening for ");
        html.append(this.name);
        html.append("</p>\n");
        
        return html.toString();
    }
}
