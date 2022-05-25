package main.util;
/**
 * Created by byang on 2016-08-28.
 */

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.EvaluationListener;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.bson.Document;
import org.javatuples.Quintet;
import org.javatuples.Triplet;
import org.json.JSONArray;
//import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.mongodb.client.model.Projections.include;

public class JavaUtil {
    Logger log = LoggerFactory.getLogger(JavaUtil.class);
    public static List<String> sortedList;

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

    public static List set2LinkedList(Set set) {
        List<String> aList = new LinkedList<String>(set);
        System.out.println("Set to linked list: ");
        for (String x : aList) {
            System.out.println(x);
        }
        return aList;
    }

    public void setExcelCellValue(String filePath, int row, int col, Integer SheetNumber, String value) {
        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(SheetNumber);
            Row sheetrow = sheet.getRow(row);
            if (sheetrow == null) {
                sheetrow = sheet.createRow(row);
            }
//Update the value of cell
            Cell cell = sheetrow.getCell(col);
            if (cell == null) {
                cell = sheetrow.createCell(col);
            }
            cell.setCellValue(value);
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

    public void appendExcelCellValues(String filePath, Object[][] append, Integer sheetIndex) {
        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(sheetIndex);

            int rowCount = sheet.getLastRowNum();
            for (Object[] aBook : append) {
                Row row = sheet.createRow(++rowCount);
                int columnCount = 0;
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);

                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }

            }

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

    public void createNewSheetInExcel(String filePath, Object[][] insert, Integer sheetIndex,String sheetName) {
        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
                Random random = new Random();
                Integer inputId = random.nextInt(1000000);
            String sheetname = sheetName + inputId;
            Sheet newSheet = workbook.createSheet(sheetname);
            int rowCount = 0;
            for (Object[] aBook : insert) {
                Row row = newSheet.createRow(++rowCount);
                int columnCount = 0;
                for (Object field : aBook) {
                    Cell cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
            }

            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

public ArrayList<String> getSelectAllOptions (Select select){
    List<WebElement> options = select.getOptions();
    ArrayList<String> allOptions=new ArrayList<String>();
    for(WebElement option: options){
        allOptions.add(option.getText());
    }
    return allOptions;
}

public String encodeUrl (String url) throws EncoderException {
    org.apache.commons.codec.net.URLCodec urlS = new org.apache.commons.codec.net.URLCodec();
    String urlSafe = urlS.encode(url);
    System.out.println("The encode url is : "+urlSafe);
    return urlSafe;
}
    public boolean mapContainKey (Map map, String key)  {
        boolean present=map.containsKey(key);
        System.out.println("Is the key  present? "
                + present);
        return present;
    }
    public boolean mapContainValue (Map map, String value)  {
        boolean present=map.containsValue(value);
        System.out.println("Is the value present? "
                + present);
        return present;
    }
 public static String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }

    public static String[] splitStringByWhiteSpace (String str){
        String[] words=str.split("\\s");//splits the string based on whitespace, string split() method splits this string against given regular expression and returns a char array.
//using java foreach loop to print elements of string array
        System.out.println("splits the string based on whitespace:");
        for(String w:words) {
            System.out.println(w);
           }
        return words;
    }
    public static void appendJsonStr2File(String JsonStr, String filepath){
        try {

            FileWriter w = new FileWriter(filepath,true);
            BufferedWriter out = new BufferedWriter(w);
            out.write(",");
            out.newLine();
            out.write(JsonStr);
            out.newLine();
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println("exception " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static List listDifference (List a, List b)  {
        List toReturn = new ArrayList(a);
        toReturn.removeAll(b);
        System.out.println(toReturn);
        return toReturn;
    }
   public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static int getRandomNumberInRange1(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }


    public static BigInteger getRandomBigInteger() {
        BigInteger maxLimit = new BigInteger("5000000000000");
        BigInteger minLimit = new BigInteger("25000000000");
        BigInteger bigInteger = maxLimit.subtract(minLimit);
        Random randNum = new Random();
        int len = maxLimit.bitLength();
        BigInteger res = new BigInteger(len, randNum);
        if (res.compareTo(minLimit) < 0)
            res = res.add(minLimit);
        if (res.compareTo(bigInteger) >= 0)
            res = res.mod(bigInteger).add(minLimit);
        System.out.println("The random BigInteger = "+res);
        return res;
    }

    public static void gotoWindow(WebDriver driver, Integer index) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(index));
    }
    public boolean isIpAddressValid(String value) {
        Pattern pattern =
                Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
        Matcher matcher = pattern.matcher(value);
        try {
            if (!matcher.matches()) {
                return false;
            } else {
                for (int i = 1; i <= 4; i++) {
                    int octet = Integer.valueOf(matcher.group(i));
                    if (octet > 255) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static String  byteArrayToStr(byte[] payload) {
        String s = new String(payload);
        return s;
    }
    public static JSONArray getJSONArrayFromResponse(String APIresponse, String path) throws JSONException {
        JSONObject JsonArray = new JSONObject(APIresponse);
        JSONArray JArray = JsonArray.getJSONArray(path);
        return JArray;
    }

    public static Map DB2Map(Map a, String dburl, String user, String pwd, Integer KeyColumn, Integer ValueColumn, String query) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException, JSONException {
        // TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://" + dburl, user, pwd);
        //object of statement class will help to execute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            a.put(rs.getString(KeyColumn), rs.getString(ValueColumn));
        }
        conn.close();
        return a;
    }

    public static Triplet DB2Triplet(String dburl, String user, String pwd, String query, Integer col1, Integer col2, Integer col3) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException, JSONException {
        // TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://" + dburl, user, pwd);
        //object of statement class will help to execute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Triplet<String, String, String> triplet = null;
        if (rs.next()) {
            triplet
                    = Triplet.with(rs.getString(col1), rs.getString(col2), rs.getString(col3));
        }
        conn.close();
        return triplet;
    }

    public static Quintet DB2Quintet(String dburl, String user, String pwd, String query) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException, JSONException {
        // TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:postgresql://" + dburl, user, pwd);
        //object of statement class will help to execute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Quintet<String, String, String, String, String> quintet = null;
        if (rs.next()) {
            quintet
                    = Quintet.with(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        }
        conn.close();
        return quintet;
    }

public String file2JsonString (String filePath) throws IOException {
    String exampleRequest = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

    Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
            .mappingProvider(new JacksonMappingProvider()).build();
    DocumentContext json = com.jayway.jsonpath.JsonPath.using(configuration).parse(exampleRequest);
    System.out.println(json.jsonString());
    return json.jsonString();
}
    public int findMiddleOfArray (int array[]) throws IOException {
        int startIndex = 0, lastIndex = array.length - 1;
        // Setting the mid index
        int midIndex = startIndex + (lastIndex-startIndex)/2;
        System.out.println("The mid index is "+midIndex+" and the element at mid is "+array[midIndex]);
        return array[midIndex];
    }
    public String findMiddleOfArray (String array[]) throws IOException {
        int startIndex = 0, lastIndex = array.length - 1;
        // Setting the mid index
        int midIndex = startIndex + (lastIndex-startIndex)/2;
        System.out.println("The mid index is "+midIndex+" and the element at mid is "+array[midIndex]);
        return array[midIndex];
    }
    public int MiddleIndexOfArray (String array[]) throws IOException {
        int startIndex = 0, lastIndex = array.length - 1;
        int midIndex = startIndex + (lastIndex-startIndex)/2;
        System.out.println("The mid index is "+midIndex+" and the element at mid is "+array[midIndex]);
        return midIndex;
    }

    public static Boolean checkListSorted(List<String> arrayList) {
        sortedList = arrayList;
        Collections.sort(arrayList);
        Boolean equal = sortedList.equals(arrayList);
        return equal;
    }

    public JSONArray  parseJsonArrayWithoutPath(String filePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
       JSONArray countries = (JSONArray) parser.parse(new FileReader(filePath));
        System.out.println("Array is :");
        for(Object country : countries)
        {
            System.out.println("\t"+country.toString());
        }
        return countries;
    }

    public MongoIterable<Document> readDataFromMongodb(String dbUrl, String dataBaseName, String collectionName, int limitNum) throws InterruptedException {
        java.util.logging.Logger mongoLogger = java.util.logging.Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        Thread.sleep(15000);
        MongoClient mongoCli = new MongoClient(dbUrl, 27017);
        MongoDatabase database1 = mongoCli.getDatabase(dataBaseName);
        MongoCollection<Document> collection1 = database1.getCollection(collectionName);
        MongoIterable<Document> iter_collection = collection1.find().limit(limitNum);
        iter_collection.forEach(new Block<Document>() {
            public void apply(Document doc_content) {
                log.debug("" + doc_content.toJson());
            }
        });
        return iter_collection;
    }

    public MongoIterable<Document> readFromMongoField(String dbUrl,String dataBaseName, String collectionName,String field,int limitNum) throws InterruptedException {
        java.util.logging.Logger mongoLogger = java.util.logging.Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        Thread.sleep(15000);
        MongoClient mongoCli = new MongoClient(dbUrl, 27017);
        MongoDatabase database1 = mongoCli.getDatabase(dataBaseName);
        MongoCollection<Document> collection1 = database1.getCollection(collectionName);
        MongoIterable<Document> iter_collection = collection1.find().projection(include(field)).limit(limitNum);
        iter_collection.forEach(new Block<Document>() {
            public void apply(Document doc_content) {
                log.debug("" + doc_content.toJson());
            }
        });
        return iter_collection;
    }

    public MongoIterable<Document> readFromMongo2Field(String dbUrl, String dataBaseName, String collectionName, String field1, String field2,int limitNum) throws InterruptedException {
        java.util.logging.Logger mongoLogger = java.util.logging.Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        Thread.sleep(15000);
        MongoClient mongoCli = new MongoClient(dbUrl, 27017);
        MongoDatabase database1 = mongoCli.getDatabase(dataBaseName);
        MongoCollection<Document> collection1 = database1.getCollection(collectionName);
        MongoIterable<Document> iter_collection = collection1.find().projection(include(field1,field2)).limit(limitNum);
        iter_collection.forEach(new Block<Document>() {
            public void apply(Document doc_content) {
                log.debug("" + doc_content.toJson());
            }
        });
        return iter_collection;
    }







}