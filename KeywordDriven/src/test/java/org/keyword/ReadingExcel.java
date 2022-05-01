package org.keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	static FileInputStream fs;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFCell cell;
	static String cellvalue;
	static String locatorname;
	static String locatorvalue;
	static String locatorColumnvalue;

	public static void readExcel() throws Exception {
		fs=new FileInputStream("D:\\KeywordDriven.xlsx");
		workbook=new XSSFWorkbook(fs);
		sheet = workbook.getSheet("Amazon");
	}
	public static String getCellValue(int row,int column) {
		cell = sheet.getRow(row).getCell(column);
		cellvalue = cell.getStringCellValue();
		return cellvalue;
	
	}
	
}
