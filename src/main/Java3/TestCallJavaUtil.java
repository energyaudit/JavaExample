package main.Java3;

import com.google.common.collect.HashBiMap;
import main.util.JavaUtil;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

import java.util.*;
import java.util.stream.Collectors;

import static main.util.JavaUtil.extractInt;
import static main.util.JavaUtil.splitStringByWhiteSpace;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class TestCallJavaUtil {
    @Test
    public void arrayContainsInt(){
JavaUtil jul=new JavaUtil();
        int[] a = {1,2,3,4};
        boolean contains=jul.ArrayContains(a,4);
        System.out.println("array contains this int?"+contains);
    }

    @Test
    public void ListContainsInt(){
        JavaUtil jul=new JavaUtil();
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        boolean contains=jul.ListIntContains(arr,4);
        System.out.println("List contains this int?"+contains);
    }
    @Test
    public void ListContainsStr(){
        JavaUtil jul=new JavaUtil();
        List<String> arr = new ArrayList<String>();
        arr.add("geeks");
        arr.add("for");
        arr.add("geeks");
        boolean contains=jul.ListStrContains(arr,"geeks");
        System.out.println("List contains this int?"+contains);
    }
    @Test
    public void assertInMultipleValue() {
        assertThat("hello").isIn("hello", "world");
        assertThat(201).isIn(201, 409);
    }
    @Test
    public void whenUsingImperativeWayForSingleKey_shouldReturnSingleKey() {
        Map<String, String> capitalCountryMap = new HashMap<>();
        capitalCountryMap.put("Tokyo", "Japan");
        capitalCountryMap.put("New Delhi", "India");
        assertEquals("New Delhi", JavaUtil.getKey(capitalCountryMap, "India"));
    }

    @Test
    public void whenUsingImperativeWayForAllKeys_shouldReturnAllKeys() {
        Map<String, String> capitalCountryMap = new HashMap<>();
        capitalCountryMap.put("Tokyo", "Japan");
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Cape Town", "South Africa");
        capitalCountryMap.put("Pretoria", "South Africa");
        capitalCountryMap.put("Bloemfontein", "South Africa");

        assertEquals(new HashSet<String>(Arrays.asList(
                new String[] {"Cape Town", "Pretoria", "Bloemfontein"})),
                JavaUtil.getKeys(capitalCountryMap, "South Africa"));
    }

    @Test
    public void whenUsingFunctionalWayForSingleKey_shouldReturnSingleKey() {
        Map<String, String> capitalCountryMap = new HashMap<>();
        capitalCountryMap.put("Tokyo", "Japan");
        capitalCountryMap.put("Berlin", "Germany");
        assertEquals("Berlin", JavaUtil.keys(capitalCountryMap, "Germany").findFirst().get());
    }

    @Test
    public void whenUsingFunctionalWayForAllKeys_shouldReturnAllKeys() {
        Map<String, String> capitalCountryMap = new HashMap<>();
        capitalCountryMap.put("Tokyo", "Japan");
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Cape Town", "South Africa");
        capitalCountryMap.put("Pretoria", "South Africa");
        capitalCountryMap.put("Bloemfontein", "South Africa");
        assertEquals(new HashSet<String>(Arrays.asList(
                new String[] {"Cape Town", "Pretoria", "Bloemfontein"})),
                JavaUtil.keys(capitalCountryMap, "South Africa").collect(Collectors.toSet()));
    }

    @Test
    public void whenUsingBidiMap_shouldReturnKey() {
        BidiMap<String, String> capitalCountryMap = new DualHashBidiMap<String, String>();
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Cape Town", "South Africa");
        assertEquals("Berlin", capitalCountryMap.getKey("Germany"));
    }

    @Test
    public void whenUsingBidiMapAddDuplicateValue_shouldRemoveOldEntry() {
        BidiMap<String, String> capitalCountryMap = new DualHashBidiMap<String, String>();
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Cape Town", "South Africa");
        capitalCountryMap.put("Pretoria", "South Africa");// DualHashBidiMap not allowed dupliated keys,it only
        System.out.println(capitalCountryMap.getKey("South Africa"));//return the last one then
        assertEquals("Pretoria", capitalCountryMap.getKey("South Africa"));
    }

    @Test
    public void whenUsingBiMap_shouldReturnKey() {
        HashBiMap<String, String> capitalCountryMap = HashBiMap.create();
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Cape Town", "South Africa");
        assertEquals("Berlin", capitalCountryMap.inverse().get("Germany"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void whenUsingBiMapAddDuplicateValue_shouldThrowException() {
        HashBiMap<String, String> capitalCountryMap = HashBiMap.create();
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Cape Town", "South Africa");
        capitalCountryMap.put("Pretoria", "South Africa");
        assertEquals("Berlin", capitalCountryMap.inverse().get("Germany"));
    }

    //Junit5 @tag sample begin
    @Test
    @Tag("feature-168")
   public void test1Plus1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Tag("integration")
    @Tag("fast")
   public void testFastAndIntegration() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Tag("slow")
public void testSlow() {
        assertEquals(2, 1 + 1);
    }
    //Junit5 @tag sample finished

    @Test
    public void updateExcelCellValue() {
        JavaUtil jul=new JavaUtil();
        Random random = new Random();
        Integer inputId = random.nextInt(1000000);
        String value=String.valueOf(inputId);
        System.out.println(value);
        jul.setExcelCellValue("src/main/resources/JavaBooks.xls",2,3,0,value);
    }
    @Test
    public void appendExcelCellValue() {
        JavaUtil jul=new JavaUtil();
                    Object[][] bookData = {
                    {"The Passionate Programmer", "Chad Fowler", 16},
                    {"Software Craftmanship", "Pete McBreen", 26},
                    {"The Art of Agile Development", "James Shore", 32},
                    {"Continuous Delivery", "Jez Humble", 41},
            };
        jul.appendExcelCellValues("src/main/resources/JavaBooks.xls",bookData,0);
    }

    @Test
    public void createNewSheetInExcelTest() {
        JavaUtil jul=new JavaUtil();
                    Object[][] bookComments = {
                    {"Head First Java", "Funny and Exciting"},
                    {"Effective Java", "Insightful tips and advices"},
                    {"Clean Code", "Write Readable Code"},
                    {"Thinking in Java", "Classic"},
            };
        jul.createNewSheetInExcel("src/main/resources/JavaBooks.xls",bookComments,0,"Comments");
    }
    @Test
    public void extractIntegerFrmStringTest() {
        String str = "avbkjd1122klj4 543 af";
        System.out.print(extractInt(str));
    }

    @Test
    public void splitStringByWhiteSpaceTest() {
        String sSplit1="java string split method by javatpoint";
        String[] words=splitStringByWhiteSpace(sSplit1);
        System.out.println("The first words is : "+words[0]);
    }





}
