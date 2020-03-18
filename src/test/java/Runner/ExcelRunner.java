package Runner;

import Utils.ExcelUtils;

public class ExcelRunner {
    public static void main(String[] args) {
        ExcelUtils.openExcelFile("Employee","Page1");
        String cellValue=ExcelUtils.getValue(4,5);
        System.out.println(cellValue); //---> Tajik
        ExcelUtils.setCellValue("USA",4,5);
        cellValue=ExcelUtils.getValue(4,5);
        System.out.println(cellValue);// ---> USA
        ExcelUtils.closeWorkBook();

        ExcelUtils.openExcelFile("Book1","Sheet1");
        ExcelUtils.getAllExcelValue();
        /*
        Create one method it will get all values from Excel
        Return type of method will be list<List<String>>
         */
    }
}
