package Utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFWorkbook ExcelWorkbook;
    private static XSSFSheet ExcelSheet;
    private static XSSFCell Cell;
    private static XSSFRow Row;


    public static Object[][] getExcelData(String Filepath, String Sheetname) throws Exception {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(Filepath);
            ExcelWorkbook = new XSSFWorkbook(ExcelFile);
            ExcelSheet = ExcelWorkbook.getSheet(Sheetname);

            int initialRow = 1;
            int initialColumn = 1;

            int ci ,cj;

            int totalRows = ExcelSheet.getLastRowNum();
            int totalColumns = 5;

            tabArray = new String[totalRows][totalColumns];
            ci = 0;
            for(int i = initialRow; i<=totalRows;i++, ci++){
                cj = 0;
                for(int j = initialColumn;j<=totalColumns;j++,cj++) {
                    tabArray[ci][cj] = getCellData(i,j);
                    System.out.println(tabArray[ci][cj]);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Excel File could not be found");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Could not read the Excel Sheet");
            e.printStackTrace();
        }
        return(tabArray);
    }
    public static String getCellData(int row, int column) throws Exception{
        try {
            Cell = ExcelSheet.getRow(row).getCell(column);
            CellType dataType = Cell.getCellType();

            switch (dataType) {
                case STRING:
                    String stringCellData = Cell.getStringCellValue();
                    return stringCellData;
                case NUMERIC:
                    double numericCellData = Cell.getNumericCellValue();
                    String formattedValue = String.format("%.0f", numericCellData);
                    return String.valueOf(formattedValue);
                default:
                    return "";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }

}
