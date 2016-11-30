package Model;

import java.awt.Color;

import bodyprogram.Conversion;

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
    
    
 
  

    public PatientRecord(final String name){
        this.name = name;
    }
    
   public void setName(final String name){
	   this.name = name;
   }
    
    public void setAge(final String age){
        this.age = age;
    }
    

    
 
    
    

    
   
    
  
    
    public void setBloodPressure(final String bp){
        this.bloodPressure = bp;
    }
    
    public void setBloodPressureRisk(final String bpr){
    	bloodPressureRisk = bpr;
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
    
    public void setCholesterolRisk(final String cholesterolRisk){
        this.cholesterolRisk = cholesterolRisk;
    }
    
    public void setBMI(final String bmi){
        this.bmi = bmi;
    }
    
    public void setBmiRisk(final String bmiRisk){
    	this.bmiRisk = bmiRisk;
    }
    
    public void setDate(final String date){
        this.date = date;
    }
  
    public String getName(){
    	return name;
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