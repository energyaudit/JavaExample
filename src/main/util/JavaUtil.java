package main.util;
/**
 * Created by byang on 2016-08-28.
 */

import com.jayway.jsonpath.EvaluationListener;
import com.jayway.jsonpath.ReadContext;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaUtil {
    public static ArrayList<String> ArrayListStrDescendingSort(ArrayList<String> arrayList) {
        System.out.println("ArrayList Before Sorting:");
        for (String str : arrayList) {
            System.out.println(str);
        }
        /* Sorting in decreasing (descending) order*/
        Collections.sort(arrayList, Collections.reverseOrder());
        System.out.println("ArrayList in descending order:");
        for (String str : arrayList) {
            System.out.println(str);
        }
        return arrayList;
    }

    public static ArrayList ArrayListAscendingSort(ArrayList arrayList) {//Arraylist is general,it can be either integer or string
        Iterator iterator1 = arrayList.iterator();
        System.out.println("Collection elements before sorting: \n");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        //Call the Collections sort method for sorting
        Collections.sort(arrayList);
        Iterator iterator2 = arrayList.iterator();
        System.out.println("Collection elements after sorting:\n");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        return arrayList;
    }

    public static String getFiledByJpath(String data, String Jpath) {
        JsonPath jsonPath = new JsonPath(data);
        String filed = jsonPath.getString(Jpath);
        System.out.println("the field is: " + filed);
        return filed;
    }

    public static List<String> getJsonPathsByFieldName(String filepath, String[] stringArray) throws IOException {
        File jsonFile = new File(filepath).getAbsoluteFile();
        List<String> paths = new ArrayList<>();
        ReadContext findPathsContext = com.jayway.jsonpath.JsonPath.parse(jsonFile).withListeners((found) -> {
            paths.add(found.path());
            return EvaluationListener.EvaluationContinuation.CONTINUE;
        });
        List<String> properties = Arrays.asList(stringArray);
        properties.forEach(p -> findPathsContext.read("$.." + p));
        return paths;
    }

    public static List<String> getJsonPathsFrmJsonByFieldKey(String jsonStr, String[] stringArray) throws IOException {
        List<String> paths = new ArrayList<>();
        ReadContext findPathsContext = com.jayway.jsonpath.JsonPath.parse(jsonStr).withListeners((found) -> {
            paths.add(found.path());
            return EvaluationListener.EvaluationContinuation.CONTINUE;
        });
        List<String> properties = Arrays.asList(stringArray);
        properties.forEach(p -> findPathsContext.read("$.." + p));
        return paths;
    }

    public boolean ArrayContains(int[] a, int y) {
        boolean contains = IntStream.of(a).anyMatch(x -> x == y);
        return contains;
    }

    public boolean ListIntContains(List<Integer> arr, int y) {
        boolean contains = arr.contains(y);
        return contains;
    }
    public boolean ListStrContains(List<String> arr, String y) {
        boolean contains = arr.contains(y);
        return contains;
    }
    public long generateRandomNumber(int n) {
        long min = (long) Math.pow(10, n - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }
    public static <K, V> Stream<K> keys(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }

    public static <K, V> Set<K> getKeys(Map<K, V> map, V value) {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }






}