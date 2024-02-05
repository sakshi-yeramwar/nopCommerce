package nopCommerce;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataExtract {

	public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException {
		//getting data from excel and storing it in the form of object
		
		//connecting the file with test script by creating an object of FileInputStream
		FileInputStream fls = new FileInputStream("C:\\Users\\HP\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\MySeleniumProject\\src\\main\\resources\\nopCommerce.xlsx");
			
		//create a workbook
		Workbook book = WorkbookFactory.create(fls);
		
		//mention sheet name of excel file and store it in a local variable
		Sheet sheet1 = book.getSheet("Sheet1");
		
		//get last row and last column
		//last column
		short cellSize = sheet1.getRow(0).getLastCellNum();
		
		//row
		int rowSize = sheet1.getLastRowNum();
		
		Object[][] obj = new Object[rowSize][cellSize];
		
		for (int i = 0; i < rowSize; i++) {
			
			for (int j = 0; j < cellSize; j++) {
				
				obj[i][j] = sheet1.getRow(i+1).getCell(j).getStringCellValue();
				
			}
			
		}
		return obj;
	}
}