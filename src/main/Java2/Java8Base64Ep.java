package src.main.Java2;

/**
 * Created by byang on 2018-06-13.
 */

import java.util.Base64;
        import java.util.UUID;

public class Java8Base64Ep {
    public static void main(String args[]){
        try {

            // Encode using basic encoder
            String base64encodedString = Base64.getEncoder().encodeToString(
                    "CodesJava?java8".getBytes("utf-8"));
            System.out.println("Original: "+"CodesJava?java8"+"Base64 Encoded String (Basic) :" + base64encodedString);

            // Decode
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

            System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
            base64encodedString = Base64.getUrlEncoder().encodeToString(
                    "CodesJava?java8".getBytes("utf-8"));
            System.out.println("Base64 Encoded String (URL) :" + base64encodedString);

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());//UUID class provides a simple means for generating unique ids.
            }
            System.out.println("Original UUID :  " + stringBuilder.toString());
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);
//encode and decode a url
            // Getting encoder
            Base64.Encoder encoder = Base64.getUrlEncoder();
            // Encoding URL
            String eStr = encoder.encodeToString("http://www.javatpoint.com/java-tutorial/".getBytes());
            System.out.println("Encoded URL: "+eStr);
            // Getting decoder
            Base64.Decoder decoder = Base64.getUrlDecoder();
            // Decoding URl
            String dStr = new String(decoder.decode(eStr));
            System.out.println("Decoded URL: "+dStr);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
