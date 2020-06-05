package util;


import org.json.*;
public class xmlToJson {
    public static String xmlToJson(String xmlin) {
        String    jsonPrettyPrintString=null;
        try {
            JSONObject json = XML.toJSONObject(xmlin); // converts xml to json
         jsonPrettyPrintString = json.toString(4); // json pretty print
            System.out.println(jsonPrettyPrintString);

        } catch(JSONException je) {
            System.out.println(je.toString());
        }
        return jsonPrettyPrintString;
    }

    public static void main(String[] args) {
        String xmlString= "<?xml version=\"1.0\" ?><root><test       attrib=\"jsontext1\">tutorialspoint</test><test attrib=\"jsontext2\">tutorix</test></root>";
xmlToJson(xmlString);
    }
}