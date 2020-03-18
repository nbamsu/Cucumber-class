package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    private static Workbook excelBook;
    private static Sheet sheet;
    private static Row row;
    private static Cell cell;
    private static String filePath;

    /*
    Create the method will take two params
    @Param1 --> FileName
    @Param2 --> SheetName
    This method will open the excel file
     */
    public static void openExcelFile(String fileName, String sheetName) {
        filePath = "src/test/resources/com.cucumber.features.ExcelData/" + fileName + ".xlsx";
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            excelBook = new XSSFWorkbook(fileInputStream);
            sheet = excelBook.getSheet(sheetName);

        } catch (Exception e) {
            System.out.println("The file is not exist");
        }

    }

    /*
    Create the method will take two param
    @Param1 --> rowNUmber
    @Param2 --> cellNumber
    this method will return cell value as String
     */
    public static String getValue(int rowNumber, int cellNumber) {
        rowNumber=rowNumber-1;
        cellNumber=cellNumber-1;
        row = sheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);
        return cell.toString();
    }
    /*
    Create the method, it will take tree param
    @Param1 --> value
    @Param2 --> rowNumber
    @PAram --> cellNumber
     This method will set new value to your excel file

     */


    public static void setCellValue(String value, int rowNumber, int cellNumber) {
        rowNumber=rowNumber-1;
        cellNumber=cellNumber-1;
        row = sheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);
        if (cell == null) {
            row = sheet.createRow(rowNumber);
            cell = row.createCell(cellNumber);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(value);
        }else{
            cell.setCellValue(value);
        }
    }
    /*
    Create getAll method
    It will print all the values in excel
     */
        public static void getAllExcelValue(){

            for (int i=sheet.getFirstRowNum();i<=sheet.getLastRowNum();i++){
                Row row=sheet.getRow(i);
                for (int k=row.getFirstCellNum();k<row.getLastCellNum();k++){
                    Cell cell=row.getCell(k);
                    System.out.print(cell+"|");
                }
                System.out.println();
            }
        }
        /*
        Create
         */
        public static void closeWorkBook(){
            try {
                excelBook.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
}
