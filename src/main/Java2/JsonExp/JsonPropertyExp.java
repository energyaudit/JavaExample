package main.Java2.JsonExp;
/**
 * Created by byang on 2020-11-1.
 */

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
@JsonProperty defines a logical property used in serialization and deserialization of JSON.
 When we set JSON data to Java Object, it is called JSON deserialization and when we get JSON data from Java Object,
  it is called JSON serialization.
 */
public class JsonPropertyExp {
    public static void main(String args[]) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\" : 1}";
        Student student = mapper.readerFor(Student.class).readValue(json);
        System.out.println(student.getTheId());
    }
}

class Student {
    private int id;
    Student() {
    }
    Student(int id) {
        this.id = id;
    }
    @JsonProperty("id")
    public int getTheId() {
        return id;
    }
    @JsonProperty("id")
    public void setTheId(int id) {
        this.id = id;
    }
}