package main.RestAssured;

import static main.util.xmlToJson.xmlToJson;

public class callXmlToJson {
    public static void main(String[] args) {
        String xmlString= "<?xml version=\"1.0\" ?><root><test       attrib=\"jsontext1\">tutorialspoint</test><test attrib=\"jsontext2\">tutorix</test></root>";
        xmlToJson(xmlString);
        String xmlString1="<plurals name=\"numberOfSongsAvailable\">\n" +
                "        <item quantity=\"one\">Znaleziono %d piosenkę.</item>\n" +
                "        <item quantity=\"few\">Znaleziono %d piosenki.</item>\n" +
                "        <item quantity=\"other\">Znaleziono %d piosenek.</item>\n" +
                "    </plurals>";
        xmlToJson(xmlString1);
    }
}
