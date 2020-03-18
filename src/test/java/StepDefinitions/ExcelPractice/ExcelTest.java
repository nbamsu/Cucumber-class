package StepDefinitions.ExcelPractice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExcelTest {

    public static void main(String[] args) throws Exception {
        //System.getProperty  ---> This will give current project directory
        System.out.println(System.getProperty("user.dir"));
        String filePath = "src/test/resources/com.cucumber.features.ExcelData/Book1.xlsx";
        //C:\Users\Nurkulov\Downloads\Cucumber-Class\src\test\resources\com.cucumber.features.ExcelData\Book1.xlsx
        //Inside the file class we need to give the file path
        File file = new File(filePath);
        //FileInputStream will open the file wich we provided
        FileInputStream inputStream = new FileInputStream(file);
        //XSSFWorkbook requires location of the excel file
        Workbook excelWorkBook = new XSSFWorkbook(inputStream);
        Sheet excelSheet = excelWorkBook.getSheet("Sheet1");
        Row row = excelSheet.getRow(3);
        Cell cell = row.getCell(1);

        System.out.println(cell);

        //first we are creating the row
        row = excelSheet.createRow(5);
        //after that we create the cell
        cell = row.createCell(0);
        //cell type
        cell.setCellType(CellType.STRING);
        //cell value
        cell.setCellValue("Test16");
        //if you want to store values in your excel files we need to use FileOutputStream Class
        //we need to give file path
        FileOutputStream outputStream = new FileOutputStream(filePath);
        excelWorkBook.write(outputStream);

        String expected = "Test16";
        row = excelSheet.getRow(5);
        cell = row.getCell(0);
        String actual = cell.toString();
        Assert.assertTrue(expected.equals(actual));

//        row = sheet.getRow(2);
//        cell = row.getCell(1);
//        cell.setCellValue("Techtorial");
//        FileOutputStream outputStream1 = new FileOutputStream(filePath);
//        excelWorkbook.write(outputStream1);
//        System.out.println(cell);

    }


}
