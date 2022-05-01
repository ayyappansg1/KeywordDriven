package org.video8;

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
	static String keyword;
	static String locatorname;
	static String locatorvalue;
	static String locatorColumnvalue;
	static int physicalNumberOfRows;
	static String actionwords;
	static String testdatavalue;

	public static void readExcel() throws Exception {
		fs=new FileInputStream("C:\\Users\\ADMIN\\Desktop\\KeywordDriven.xlsx");
		workbook=new XSSFWorkbook(fs);
		sheet = workbook.getSheet("Amazon");
		physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
	}
	public static void getCellValue(int row,int locatorColumn,int actionKeywords,int testData) {
		locatorColumnvalue = sheet.getRow(row).getCell(locatorColumn).toString().trim();
		if(!locatorColumnvalue.contains("NA"))
		{
			locatorname = locatorColumnvalue.split("=")[0].toString().trim();
			locatorvalue = locatorColumnvalue.split("=")[1].toString().trim();
		}else{
			locatorname="NA";
			locatorvalue="NA";
		}
		actionwords = sheet.getRow(row).getCell(actionKeywords).toString().trim();
		testdatavalue = sheet.getRow(row).getCell(testData).toString().trim();	

	}



}
