package main.util;

import org.json.JSONObject;
import org.json.XML;


public class jsonToXml {
    public static String jsonToXml(String jsonin) {
        JSONObject json = new JSONObject(jsonin);
        String xml = XML.toString(json);
        System.out.println(xml);
        return xml;
    }

    public static void main(String[] args) {
        // 1. Convert Json String -> XML String
        String jsonStr = "{\"Customer\": {" +
                "\"address\": {" +
                "\"street\": \"NANTERRE CT\"," +
                "\"postcode\": 77471" +
                "}," +
                "\"name\": \"Mary\"," +
                "\"age\": 37" +
                "}}";
        jsonToXml(jsonStr);

    }
}
