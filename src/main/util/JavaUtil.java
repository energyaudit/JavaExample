package main.util;
/**
 * Created by byang on 2016-08-28.
 */
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class JavaUtil {
    public static ArrayList<String> ArrayListStrDescendingSort(ArrayList<String> arrayList) {
        System.out.println("ArrayList Before Sorting:");
        for(String str: arrayList){
            System.out.println(str);
        }
        /* Sorting in decreasing (descending) order*/
        Collections.sort(arrayList, Collections.reverseOrder());
         System.out.println("ArrayList in descending order:");
        for(String str: arrayList){
            System.out.println(str);
        }
        return arrayList;
    }
    public static ArrayList ArrayListAscendingSort(ArrayList arrayList) {//Arraylist is general,it can be either integer or string
        Iterator iterator1=arrayList.iterator();
        System.out.println("Collection elements before sorting: \n");
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        //Call the Collections sort method for sorting
        Collections.sort(arrayList);
        Iterator iterator2=arrayList.iterator();
        System.out.println("Collection elements after sorting:\n");
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        return arrayList;
    }
    public static String getFiledByJpath(String data,String Jpath)  {
        JsonPath jsonPath=new JsonPath(data);
        String filed=jsonPath.getString(Jpath);
        System.out.println("the field is: "+filed);
        return filed;
    }




}
