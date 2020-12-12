package main.Java2;
/**
 * Append new rows to an existing sheet.
 ** byang, 2012 December 9th
 */
import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;

import main.util.JavaUtil;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
        import org.apache.poi.ss.usermodel.Cell;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.ss.usermodel.Sheet;
        import org.apache.poi.ss.usermodel.Workbook;
        import org.apache.poi.ss.usermodel.WorkbookFactory;


public class UpdateExcel {


    public static void main(String[] args) {
        String excelFilePath = "src/main/resources/JavaBooks.xls";
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Object[][] bookData = {
                    {"The Passionate Programmer", "Chad Fowler", 16},
                    {"Software Craftmanship", "Pete McBreen", 26},
                    {"The Art of Agile Development", "James Shore", 32},
                    {"Continuous Delivery", "Jez Humble", 41},
            };

            int rowCount = sheet.getLastRowNum();
            for (Object[] aBook : bookData) {
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

            Row sheetrow = sheet.getRow(3);
            if(sheetrow == null){
                sheetrow = sheet.createRow(3);
            }
//Update the value of cell
         Cell   cell = sheetrow.getCell(4);
            if(cell == null){
                cell = sheetrow.createCell(4);
            }
            cell.setCellValue("Pass");
            // call function update excel cell

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream("src/main/resources/JavaBooks.xls");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

}