package main.Java2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.Java3.JavaCompleteBeginner.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonStr2FromObj {
    public static void main(String[] args) throws IOException {
        //Json str to car object matched to class car
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        try {
            Car car = objectMapper.readValue(carJson, Car.class);
            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //car.json file to car object
        try {
            File file = new File("./src/main/TESTRESULT/car.json");
            Car car1 = objectMapper.readValue(file, Car.class);
            System.out.println("car brand = " + car1.getBrand());
            System.out.println("car doors = " + car1.getDoors());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//JSON Array String to list of object
        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";
        List<Car> cars2 = null;
        try {
            cars2 = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        for (Car ca : cars2) {//because doors no values in the json array, so both car doors set default 0
            ca.print();
        }
//Read Map from JSON String
        String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";
        Map<String, Object> jsonMap = null;
        try {
            jsonMap = objectMapper.readValue(jsonObject,
                    new TypeReference<Map<String, Object>>() {
                    });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonMap);
//Fail on Null JSON Values for Primitive Types
        ObjectMapper objectMapper1 = new ObjectMapper();
        objectMapper1.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        String carJson1 = "{ \"brand\":\"Toyota\", \"doors\":null }";
//        Car car = null;
//        try {
//            car = objectMapper1.readValue(carJson1, Car.class);
//        } catch (JsonProcessingException e) {//this will throw exception that para not allowed null if configure true above
//            e.printStackTrace();
//        }
//        car.print();
        Car car1 = objectMapper.readValue(carJson1, Car.class);
        car1.print();
//object 2 json str to file
        Car car3 = new Car();
        car3.setBrand("BMW");
        car3.setDoors(4);
        objectMapper.writeValue(
                new FileOutputStream("./src/main/TESTRESULT/car3.json"), car3);
// object 2 json str only
        String jsonCar3 = objectMapper.writeValueAsString(car3);
        System.out.println("object car3 to str: " + jsonCar3);
        //josn str 2 json node objec
        String car4 =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        try {
            JsonNode jsonNode = objectMapper.readValue(car4, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String car5 =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";
        try {
            JsonNode jsonNode = objectMapper.readValue(car5, JsonNode.class);
            System.out.println(jsonNode);
            JsonNode brandNode = jsonNode.get("brand");
            String brand = brandNode.asText();
            System.out.println("brand = " + brand);

            JsonNode doorsNode = jsonNode.get("doors");
            int doors = doorsNode.asInt();
            System.out.println("doors = " + doors);

            JsonNode array = jsonNode.get("owners");
            jsonNode = array.get(0);
            String john = jsonNode.asText();
            System.out.println("john  = " + john);

            JsonNode child = jsonNode.get("nestedObject");
            System.out.println("nestedObject = " + child);
            JsonNode childField = child.get("field");
            String field = childField.asText();
            System.out.println("field = " + field);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
