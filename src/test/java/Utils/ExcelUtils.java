package Utils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

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

        public void setCellValues(String value,int rowNumb,int cellNumb){
            String excelFilePath = "JavaBooks.xls";

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

                inputStream.close();

                FileOutputStream outputStream = new FileOutputStream("JavaBooks.xls");
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

            } catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
                ex.printStackTrace();
            }
        }
}
