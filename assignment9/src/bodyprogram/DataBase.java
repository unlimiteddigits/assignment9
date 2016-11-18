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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataBase {

	
	private String[] patientInfo;
	private final byte BY_DATE = 0x01;
	private final byte BY_NAME = 0x09;
	
	public DataBase(String[] patientInfo){
		this.patientInfo = patientInfo;
	}
	
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
        		URLEncoder.encode("pressure","UTF-8")+"="+URLEncoder.encode(patientInfo[8],"UTF-8");
//System.out.println(post_data);
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


public String search(int choice,String searchTerm) throws JSONException{
	
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
        
        if(choice == 0){
         post_data =    URLEncoder.encode("searchBy","UTF-8")+"="+URLEncoder.encode("date","UTF-8")+"&"
        + URLEncoder.encode("searchTerm","UTF-8")+"="+URLEncoder.encode(searchTerm,"UTF-8");
         
  
        
        }else if(choice == 1){
            post_data =    URLEncoder.encode("searchBy","UTF-8")+"="+URLEncoder.encode("name","UTF-8")+"&"
                    + URLEncoder.encode("searchTerm","UTF-8")+"="+URLEncoder.encode(searchTerm,"UTF-8");

        }
        


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
             printme += jsonObject.optString("name")
            		+ " " + jsonObject.optString("date")
            		+ " " +jsonObject.optString("age")
            		+ " " +jsonObject.optString("feet")
            		+ " " +jsonObject.optString("inches")
            		+ " " +jsonObject.optString("weight")
            		+ " " +jsonObject.optString("cholesterol")
            		+ " " +jsonObject.optString("bmi")
            		+ " " +jsonObject.optString("pressure") + "\n";
            		


       
        }
     
        bufferedReader.close();
        inputStream.close();

    }catch(MalformedURLException e){
        e.printStackTrace();
    } catch(IOException e){
        e.printStackTrace();
    }	
	

	return printme;
	
}

public String[] getPatientInfo(){
	String[] copy = new String[patientInfo.length];
	 System.arraycopy(patientInfo, 0, copy, 0, patientInfo.length);
	 return copy;
	 
}

public void setPatientInfo(String[] patientInfo){
	this.patientInfo = patientInfo;
}


}