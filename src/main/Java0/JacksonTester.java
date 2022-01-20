package main.Java0;
/*
@JsonRawValue allows to serialize a text without escaping or without any decoration.
 */
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonRawValue;

public class JacksonTester {
    public static void main(String args[]){
        ObjectMapper mapper = new ObjectMapper();
        try {
            StudentJsonRaw student = new StudentJsonRaw("Mark", 1, "{\"attr\":false}");
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            StudentNoJsonRaw student = new StudentNoJsonRaw("Mark", 1, "{\"attr\":false}");
            String jsonString = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(student);
            System.out.println(jsonString);
        }
        catch (IOException e) {
            e.printStackTrace();
        }




    }
}
