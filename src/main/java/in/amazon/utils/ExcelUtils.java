package in.amazon.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Object[] getTestData(String filePath, String sheetName) throws IOException, InterruptedException {
		String[] searchString = new String[1];
		FileInputStream file = new FileInputStream(filePath);
        /* Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                String value = cell.getStringCellValue();
                data[i][j] = value;
            }
        } */
        
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);
        
        Row row = sheet.getRow(0);
    	Cell cell = row.getCell(0);
        searchString[0] = cell.getStringCellValue();
 
        workbook.close();
        return searchString;
        //workbook.close();
        //return data;
    }

}
