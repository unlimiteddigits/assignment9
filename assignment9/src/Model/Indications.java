package Model;

import control.Conversion;
/**
 * Provides the indicators for bmi,bloodpressure, and cholesterol
 * @author Daniel Tayloe
 *
 */
public class Indications {
	   private String bloodPressureIndicator;
	    private final byte CHECK_FEET = 0x20;
		private final byte CHECK_INCHES = 0x08;
		private String cholesterolRisk;
		  private String bmiClassification;
		  
		  /**
		   * Constructor
		   */
	public Indications(){
		
	}
	/**
	 * Indicates the bmi risk
	 * @param indicator
	 * @return
	 */
	public String indicateBMIRisk(String indicator) {
		String Indicator = "";
		if (indicator.isEmpty()) {
			Indicator = "";
		} else {
			double value = Double.parseDouble(indicator);
			if (value < 18.5) {
				Indicator = "UNDERWEIGHT";
			} else if (value >= 18.5 & value <= 24.9) {
				Indicator = "NORMAL";
			} else if (value >= 25.0 & value <= 29.9) {
				Indicator = "OVERWEIGHT";
			} else {
				Indicator = "OBESE";
			}
			;
		}
		;
		bmiClassification = Indicator;
		return bmiClassification;
	}
	
	/**
	 * Makes sure the patients weight fits a given range
	 * @param weight
	 * @return
	 */
	public boolean checkWeight(final String weight) {
		
		boolean result = true;
		if (!Conversion.IsValidInteger(weight, 1, 500)) {
		
			result = false;
		} else {
		
		}
		return result;
	}
	
	
	/**
	 * Indicates the blood pressure classification
	 * @param bloodPressure
	 * @return
	 */
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
	
	  /**
	   * Makes sure the patients height fits within a given range
	   * @param boxes
	   * @param feetOrInches
	   * @return
	   */
	  public boolean checkHeights(final byte boxes,String feetOrInches) {
			
			boolean result = true;

			if ((boxes & CHECK_FEET) == CHECK_FEET) {
				if (!Conversion.IsValidInteger(feetOrInches, 0, 10)) {
					
					result = false;
				} 
			}

			if ((boxes & CHECK_INCHES) == CHECK_INCHES) {
				if (!Conversion.IsValidInteger(feetOrInches, 0, 11)) {
					
					result = false;
				}
			}
			return result;
		}
	  
	  /**
	   * Indicates the cholesterol risk
	   * @param cholesterol
	   * @return
	   */
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
	  
	  
	  
	
/**
 * Gets the feet byte
 * @return
 */
	  public byte getFeetByte(){
	    	return CHECK_FEET;
	    }
	    /**
	     * Checks the patients blood pressures
	     * @param bloodPressure
	     * @return
	     */
	    public boolean checkBloodPressure(String bloodPressure){
	    	boolean result = true;
			if (!bloodPressure.matches("[0-9]+/[0-9]+")) {
				//bloodPressure.setBackground(Color.PINK);
				result = false;
			} 
			return result;
	    }
	    
	    public byte getInchesByte(){
	    	return CHECK_INCHES;
	    }
	  
}
