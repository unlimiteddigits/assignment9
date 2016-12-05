package bodyprogram;

import java.util.HashMap;

/**
 *
 * @author jacob psimos
 */
public class Conversion {
    
    /***
     * Convert imperial height measurement feet mod inches to centimeters
     * @param feet
     * @param inches
     * @return centimeters
     */
    public static double FeetToCentimeters(final int feet, final int inches){
        double conversionFeet = (feet * 12.0) * 0.393701;
        double conversionInches = (inches * 0.393701);
        return (conversionFeet + conversionInches);
    }
    
    /***
     * Converts centimeters to imperial measurement of feet mod inches
     * The resulting HashMap contains two keys `feet` and `inches`.
     * @param cm
     * @return `feet` and `inches` (keys) as Integers stored in a HashMap
     */
    public static HashMap<String, Integer> CentimetersToImperial(final double cm){
        double base = cm * 0.393701;
        int feet = (int)(base / 12.0);
        int inches = (int)(base % 12);
        
        HashMap<String, Integer> result = new HashMap<>();
        result.put("feet", feet);
        result.put("inches", inches);
        return result;
    }
    
    public static boolean IsValidInteger(final String val){
        return IsValidInteger(val, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public static boolean IsValidInteger(final String val, final int min, final int max){
        try{
            int number = Integer.parseInt(val);
            if(number >= min && number <= max){
                return true;
            }
        }catch(Exception npex){  System.err.println(npex.getMessage()); }
        return false;
    }
    
    /***
     * Returns a non-negative integer from a string
     * @param val
     * @return positive integer on success or negative 1 on failure
     */
    public static int SafeParseInteger(final String val){
        try{
            return Integer.parseInt(val);
        }catch(Exception e){    }
        return -1;
    }
    
    /***
     * Returns the body mass index for a given patient
     * A value less than 0.0 means the program method has failed and the
     * user input needs to be further validated before using the value
     * @param feet
     * @param inches
     * @param weight
     * @return body mass index
     */
    public static double CalculateBodyMassIndex(final String feet, final String inches, final String weight){
        double metricWeight = (double)SafeParseInteger(weight);
        int heightFeet = SafeParseInteger(feet);
        int heightInches = SafeParseInteger(inches);
        double totalHeight = 0.0;
        
        if(metricWeight < 0.0 || heightFeet < 0 || heightInches < 0){
            return -1.0;
        }
        
        metricWeight *= 0.45;
        totalHeight = (((double)heightFeet * 12.0) + (double)heightInches) * 0.025;
        totalHeight *= totalHeight;
        
        return metricWeight / totalHeight;
    }
}
