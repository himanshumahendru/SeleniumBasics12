package excellearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatingData {

	public static void main(String[] args) throws IOException {
        // create workbook
		//XSSFWorkbook workbook = new XSSFWorkbook();
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		// create sheet for the created workbook
		XSSFSheet sheet1 = workbook.createSheet("first sheet");
		// create row for the created sheet
		XSSFRow row1 = sheet1.createRow(0);
		// create columns for the created rows 
		XSSFCell cell0 = row1.createCell(0);
		XSSFCell cell1 = row1.createCell(1);
		XSSFCell cell2 = row1.createCell(2);
		
		cell0.setCellValue("himanshu");
		cell0.setCellValue("mahendru");
		cell0.setCellValue("automation tester");
		
		// create file at the desired location 
		File f = new File(".\\excel\\excel1.xlsx");
		FileOutputStream fo = new FileOutputStream(f);
		workbook.write(fo);
		fo.close();
		System.out.println("file created and written succcessfully");
		
		
		
		
	}

}
