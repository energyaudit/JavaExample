package main.Java2.Json;

import com.google.gson.Gson;
import main.util.ReadJsonFile2Str;

import java.util.Map;
import java.util.TreeMap;

public class CallWebServRespJson {

    private static WebServiceResponseJson parseJsonObj(String jsonString) {
        WebServiceResponseJson result = null;
        try {
            Gson gson = new Gson();
            result = gson.fromJson(jsonString,WebServiceResponseJson.class);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        TreeMap<String, String>  countriesCodeName=new TreeMap<String,String> ();
        countriesCodeName.put("US","United States");
        String region = "Illinois";
        String city = "Chicago";
        ReadJsonFile2Str rj2s = new ReadJsonFile2Str();
        String resultO = rj2s.inputpar("src/main/resources/weather.json");
       TreeMap<String,String> results = new TreeMap<String,String>();
        WebServiceResponseJson resultClass = parseJsonObj(resultO);
        results.put("Country", countriesCodeName.get(resultClass.sys.country));
        results.put("City", (region.isEmpty()?"":region) + ","+city);
        results.put("Weather description", resultClass.weather.get(0).description);
        results.put("Current temperature", resultClass.main.temp.toString() + " °C");
        results.put("Maximum temperature", resultClass.main.temp_max.toString() + " °C");
        results.put("Minimum temperature", resultClass.main.temp_min.toString() + " °C");
        results.put("Humidity level", resultClass.main.humidity.toString());
        results.put("Wind speed", resultClass.wind.speed.toString() + " Km");
        for (Map.Entry<String, String> entry : results.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("%s : %s\n", key, value);
        }
    }
}