package amazon_test.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ExcelUtility {

    public static String GetASpecificData(String searchText) {
        String dataReturn = "";
        String path = "src/test/resources/Data.xlsx";

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);
        } catch (Exception e) {
        }

        for (int i = 0; i < Objects.requireNonNull(sheet).getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(searchText)) {

                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    dataReturn += sheet.getRow(i).getCell(j) + "";
                }
            }
        }
       return dataReturn;
    }

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int colCnt) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i < Objects.requireNonNull(sheet).getPhysicalNumberOfRows(); i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < colCnt; j++) {
                row.add(sheet.getRow(i).getCell(j).toString());
            }

            tablo.add(row);
        }

        return tablo;
    }
    public static void writeExcel(ITestResult result) {

        String path = "src/test/resources/TestResult.xlsx";
        File file = new File(path);
        String testDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());

        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("amazonTest");

            Row newRows = sheet.createRow(0);

            Cell newCells = newRows.createCell(0);
            newCells.setCellValue(result.getName());

            newCells = newRows.createCell(1);
            newCells.setCellValue(result.getStatus() == 1 ? "Passed" : "Fail");

            newCells = newRows.createCell(2);
            newCells.setCellValue(testDateTime);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {

            }
        } else {

            Sheet sheet = null;
            Workbook workbook = null;
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet("amazonTest");
            } catch (Exception e) {
            }

            Row newRows = sheet.createRow(sheet.getPhysicalNumberOfRows());

            Cell newCells = newRows.createCell(0);
            newCells.setCellValue(result.getName());

            newCells = newRows.createCell(1);
            newCells.setCellValue(result.getStatus() == 1 ? "Passed" : "Fail");

            newCells = newRows.createCell(2);
            newCells.setCellValue(testDateTime);

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {

            }

        }
    }
}