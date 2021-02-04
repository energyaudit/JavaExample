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
import org.apache.commons.codec.EncoderException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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












}