package com.synechron.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public Object[][] getData() throws IOException {
		Object[][] data;
		String filePath = "./src/test/java/TestNG/TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(filePath);
		XSSFSheet sheet = wb.getSheet("logindata");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		data = new Object[rowCount-1][colCount];
		//System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		
		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row-1][col] = sheet.getRow(row).getCell(col).getStringCellValue();	
			}
		}
		
		return data;
	}

	
	
}
