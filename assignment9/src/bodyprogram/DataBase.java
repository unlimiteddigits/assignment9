package bodyprogram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataBase {

	
	private String[] patientInfo;
	private final byte BY_DATE = 0x01;
	private final byte BY_NAME = 0x09;
	/**
	 * Constructor 
	 */
	public DataBase(){
		
	}
	/**
	 * Constructor with parameter
	 * @param patientInfo
	 */
	public DataBase(String[] patientInfo){
		this.patientInfo = patientInfo;
	}
	/**
	 * Inserts the patient record into the database
	 */
public void insertRecord(){	
	try{
        URL url = new URL("http://www.sullens.net/~sice/PHP5/insertRecord.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
        String post_data =    URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(patientInfo[0],"UTF-8")+"&"+
                URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(patientInfo[1],"UTF-8")+"&"+
        		URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(patientInfo[2],"UTF-8")+"&"+
        		URLEncoder.encode("feet","UTF-8")+"="+URLEncoder.encode(patientInfo[3],"UTF-8")+"&"+
        		URLEncoder.encode("inches","UTF-8")+"="+URLEncoder.encode(patientInfo[4],"UTF-8")+"&"+
        		URLEncoder.encode("weight","UTF-8")+"="+URLEncoder.encode(patientInfo[5],"UTF-8")+"&"+
        		URLEncoder.encode("cholesterol","UTF-8")+"="+URLEncoder.encode(patientInfo[6],"UTF-8")+"&"+
        		URLEncoder.encode("bmi","UTF-8")+"="+URLEncoder.encode(patientInfo[7],"UTF-8")+"&"+
        		URLEncoder.encode("pressure","UTF-8")+"="+URLEncoder.encode(patientInfo[8],"UTF-8")+"&"+
        		URLEncoder.encode("cholesterolIndicator","UTF-8")+"="+URLEncoder.encode(patientInfo[9],"UTF-8")+"&"+
        		URLEncoder.encode("bmiIndicator","UTF-8")+"="+URLEncoder.encode(patientInfo[10],"UTF-8")+"&"+
        		URLEncoder.encode("bloodPressureIndicator","UTF-8")+"="+URLEncoder.encode(patientInfo[11],"UTF-8");

        bufferedWriter.write(post_data);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
  
        httpURLConnection.disconnect();

      InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

        
       
        bufferedReader.close();
        inputStream.close();

    }catch(MalformedURLException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }

}

/**
 * Searches the database for records by date
 * @param choice
 * @param searchTerm
 * @return
 * @throws JSONException
 */
public String search(String searchTerm) throws JSONException{
	
	String printme = "";
	
	
	
	try{
        URL url = new URL("http://www.sullens.net/~sice/PHP5/searchRecords.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
        String post_data = "";
        
   
         post_data =    URLEncoder.encode("searchBy","UTF-8")+"="+URLEncoder.encode("date","UTF-8")+"&"
        + URLEncoder.encode("searchTerm","UTF-8")+"="+URLEncoder.encode(searchTerm,"UTF-8");
         
  
        
      
       


        bufferedWriter.write(post_data);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
  
        httpURLConnection.disconnect();

      InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

        
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) !=null){
        	result += line + "\n" ;
        	
        }
      
      
        
        JSONObject jsonRootObject = new JSONObject(result);
        JSONArray jsonArray = jsonRootObject.optJSONArray("json");
        

     
        
        
        for (int x = 0; x < jsonArray.length(); x++) {
            JSONObject jsonObject = jsonArray.getJSONObject(x);
             printme += "Health Screening for " + jsonObject.optString("name")
            		+ "\nDate: " + jsonObject.optString("date")
            		+ "\nAge: " +jsonObject.optString("age")
            		+ "\tHeight: " +jsonObject.optString("feet")
            		+ "' " +jsonObject.optString("inches")
            		+ "'\tWeight: " +jsonObject.optString("weight")
            		+ "\nTotal Cholesterol: " +jsonObject.optString("cholesterol")
            		+ "\t" + jsonObject.optString("cholesterolIndicator")
            		+ "\nBody Mass Index: " +jsonObject.optString("bmi")
            		+ "\t" + jsonObject.optString("bmiIndicator")
            		+ "\nBlood Pressure: " +jsonObject.optString("pressure") 
            		+ "\t" + jsonObject.optString("bloodPressureIndicator")
            		+ "\n\n";
            		


       
        }
     
        bufferedReader.close();
        inputStream.close();

    }catch(MalformedURLException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }	
	if(printme.equals("")){
		return "no records found";
	}

	return printme;
	
}



public String getDateTotals(String date) throws JSONException{
	
	String printme = "";
	
	try{
        URL url = new URL("http://www.sullens.net/~sice/PHP5/dateTotals.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
        String post_data = "";
        
       
         post_data =    URLEncoder.encode("searchBy","UTF-8")+"="+URLEncoder.encode("date","UTF-8")+"&"
        + URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8");
         
  
        
        
        


        bufferedWriter.write(post_data);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
  
        httpURLConnection.disconnect();

      InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

        
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) !=null){
        	result += line + "\n" ;
        	
        }
      
      
        
        JSONObject jsonRootObject = new JSONObject(result);
        JSONArray jsonArray = jsonRootObject.optJSONArray("json");
        

     
        
        
        for (int x = 0; x < jsonArray.length(); x++) {
            JSONObject jsonObject = jsonArray.getJSONObject(x);
            if(jsonObject.optString("total").equals("0")){
            	printme = "";
            }else{
             printme += "Health Screening Results" + "\n"
            		 +	"Date: " + jsonObject.optString("date") + "\n"
            		 + 	"Number of individuals Screened: " + jsonObject.optString("total")
             		 +  "\n\nTotal Cholesterol" + "\n\n" 
            		 +  "DESIRABLE \t\t" + jsonObject.optString("desireableCount") + "\n"
            		 +	"BORDERLINE \t\t" + jsonObject.optString("borderLineCount") + "\n"
            		 + 	"HIGH \t\t" + jsonObject.optString("highCount") + "\n\n"
            		 +	"Body Mass Index" + "\n\n"
            		 + 	"UNDERWEIGHT \t" + jsonObject.optString("underweight") + "\n"
            		 +	"NORMAL \t\t" + jsonObject.optString("normalbmi") + "\n"
            		 + 	"OVERWEIGHT \t\t" + jsonObject.optString("overweight") + "\n"
            		 +  "OBESE \t\t" + jsonObject.optString("obese")
            		 + 	"\n\n Blood Pressure \n\n"
            		 + 	"NORMAL\t\t" + jsonObject.optString("normalblood") + "\n"
            		 +  "PREHYPERTENSION \t" + jsonObject.optString("prehype") + "\n"
            		 +	"STAGE 1 HYPERTENSION \t" + jsonObject.optString("stage1") + "\n"
            		 +  "STAGE 2 HYPERTENSION \t" + jsonObject.optString("stage2") + "\n"
            		 +	"HYPERTENSIVE CRISIS \t" + jsonObject.optString("hyper");
            	

            }
       
        }
     
   
        
        bufferedReader.close();
        inputStream.close();

    }catch(MalformedURLException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }	
	if(printme.equals("")){
		return "no records found";
	}
	
	
	return printme;
	
}

public int[] pieChartInfo() throws JSONException{
	
	
    int[] pieChartInfo = new int[12];
	
	try{
        URL url = new URL("http://www.sullens.net/~sice/PHP5/pieChartInfo.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

         
  
        
        
        


  
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
  
        httpURLConnection.disconnect();

      InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

        
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) !=null){
        	result += line + "\n" ;
        	
        }
      
      
        
        JSONObject jsonRootObject = new JSONObject(result);
        JSONArray jsonArray = jsonRootObject.optJSONArray("json");
        

     
        
   
  
        for (int x = 0; x < jsonArray.length(); x++) {
            JSONObject jsonObject = jsonArray.getJSONObject(x);
     
            
            pieChartInfo[0] = jsonObject.optInt("desirablecholesterol");
            pieChartInfo[1] = jsonObject.optInt("borderlinehighcholesterol");
            pieChartInfo[2] = jsonObject.optInt("highcholesterol");
            pieChartInfo[3] = jsonObject.optInt("underweight");
            pieChartInfo[4] = jsonObject.optInt("normalweight");
            pieChartInfo[5] = jsonObject.optInt("overweight");
            pieChartInfo[6] = jsonObject.optInt("obese");
            pieChartInfo[7] = jsonObject.optInt("normalBlood");
            pieChartInfo[8] = jsonObject.optInt("prehyper");
            pieChartInfo[9] = jsonObject.optInt("stage1");
            pieChartInfo[10] = jsonObject.optInt("stage2");
            pieChartInfo[11] = jsonObject.optInt("hyper");
            
            
            
            
            
        }
  
        bufferedReader.close();
        inputStream.close();

    }catch(MalformedURLException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }	

	
	
	
	return pieChartInfo;
	}
	
	
	
}




