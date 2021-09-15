package excellearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		File f = new File("C:\\Users\\HP\\IdeaProjects\\Selenium\\exceldxata.xlsx");
		FileInputStream fi = new FileInputStream(f);
		// create virtual workbook for a physical workbook
		Workbook workbook = WorkbookFactory.create(fi);
		Sheet sheet1 = workbook.getSheet("First Sheet");
		//Sheet sheet1 = workbook.getSheetAt(0);
		// get first row 
		
		
		
		/*// Understanding the concept using a single row 
		Row row0 = sheet1.getRow(0);
		// get columns inside a row 1 
		int columns0 = row0.getLastCellNum();
		
		for(int i =0;i<columns0;i++) {
			Cell cell = row0.getCell(i);
			
			switch(cell.getCellType()) {
			
			case Cell.CELL_TYPE_STRING:
				System.out.println(cell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				System.out.println(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_BLANK:
				System.out.println("Cell is blank");
				break;
			}*/
		
		//generalised code for number of rows and columns 
		//	sheet1.getLastRowNum() - returns number of row indeces starting from 0 in place of number of rows 
		for(int k =0;k<sheet1.getLastRowNum()+1;k++) {
			Row row = sheet1.getRow(k);
			for(int i = 0; i<row.getLastCellNum();i++) {
				 Cell cell = row.getCell(i);
				 
				 switch(cell.getCellType()) {
				 case Cell.CELL_TYPE_STRING :
					 System.out.println(cell.getStringCellValue());
					 break;
				 case Cell.CELL_TYPE_NUMERIC:
					 System.out.println(cell.getNumericCellValue());
					 break;
				 case Cell.CELL_TYPE_BLANK :
					 System.out.println("Blank cell");
					 break;
				 }
			}
			
			System.out.println("Navigated to next row");
		
		}
		}
	
}
