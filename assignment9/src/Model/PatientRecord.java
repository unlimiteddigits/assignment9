package Model;

import control.Conversion;

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
    private String bloodPressureRisk;
    private String checkHeight;
    private String bmiRisk;
  
    
    
 
  
/**
 * Constructor, creates a new patient record 
 * 
 */
    public PatientRecord(final String name){
        this.name = name;
    }
    /**
     * Sets the name of the patient
     * @param name
     */
   public void setName(final String name){
	   this.name = name;
   }
    /**
     * Sets the age of the patient
     * @param age
     */
    public void setAge(final String age){
        this.age = age;
    }
    


    
 
    
    

    
   
    
  /**
   * Sets the blood pressure of the patient
   * @param bp
   */
    
    public void setBloodPressure(final String bp){
        this.bloodPressure = bp;
    }
    
    /**
     * Sets the blood pressure risk for the patient
     * @param bpr
     */
    public void setBloodPressureRisk(final String bpr){
    	bloodPressureRisk = bpr;
    }
    /**
     * Sets the feet of the patient
     * @param feet
     */
    public void setHeightFeet(final String feet){
        this.heightFeet = feet;
    }
    /**
     * Sets the inches of the patient
     * @param inches
     */
    public void setHeightInches(final String inches){
    	this.heightInches = inches;
    }
    /**
     * Sets the weight of the patient
     * @param weight
     */
    public void setWeight(final String weight){
        this.weight = weight;
    }
    /**
     * Sets the cholesterol of the patient
     * @param cholesterol
     */
    public void setCholesterol(final String cholesterol){
    	this.cholesterol = cholesterol;
    }
    /**
     * Sets the cholesterol risk of the patient
     * @param cholesterolRisk
     */
    public void setCholesterolRisk(final String cholesterolRisk){
        this.cholesterolRisk = cholesterolRisk;
    }
   /**
    * Sets the bmi of the patient 
    * @param bmi
    */
    public void setBMI(final String bmi){
        this.bmi = bmi;
    }
    /**
     * Sets the bmi risk of the patient
     * @param bmiRisk
     */
    public void setBmiRisk(final String bmiRisk){
    	this.bmiRisk = bmiRisk;
    }
    /**
     * Sets the date the patient record was recorded
     * @param date
     */
    public void setDate(final String date){
        this.date = date;
    }
    /**
     * Returns the date the patient record was recorded
     * @return
     */
    public String getDate(){
    	return date;
    }
  /**
   * Returns the age of the patient
   * @return
   */
    public String getAge(){
    	return age;
    }
/**
 * Returns the name of the patient    
 * @return
 */
    public String getName(){
    	return name;
    }
    /**
     * Returns the patients feet value
     * @return
     */
    public String getHeightFeet(){
    	return heightFeet;
    }
    /**
     * returns the patients inches value
     * @return
     */
    public String getHeightInches(){
    	return heightInches;
    }
    
    /**
     * Returns the patients blood pressure
     * @return
     */
    public String getBloodPressure(){
    	return bloodPressure;
    }
    /**
     * Returns the patients cholesterol value
     * @return
     */
    public String getCholesterol(){
    	return cholesterol;
    }
    
    public String getWeight(){
    	return weight;
    }
    
    public String getBmi(){
    	return bmi;
    }
    
    
    public String getBloodPressureRisk(){
    	return bloodPressureRisk;
    }
    
    public String getBmiRisk(){
    	return bmiRisk;
    }
    
   public String getCholesterolRisk(){
	   return cholesterolRisk;
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
