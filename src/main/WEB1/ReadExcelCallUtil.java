package WEB1;

import WEB1.util.ReadExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class ReadExcelCallUtil {
    public static void main(String... strings) throws IOException, InvalidFormatException {
        ReadExcel objExcelFile = new ReadExcel();
        String filePath = "src/main/resources/source.xls";
        objExcelFile.readExcel(filePath);
        String filePath1 = "src/main/resources/source.xlsx";
        objExcelFile.readExcel(filePath1);
    }
}
