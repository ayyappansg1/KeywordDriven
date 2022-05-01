package org.video8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;

public class Engine {
	ActiveKeywords activekeyword;
	Method[] methods;
	static String keyword;
	static By locator;

	public  void methoding() {
		activekeyword=new ActiveKeywords();

		methods = activekeyword.getClass().getMethods();
	}
	public void combining() throws Exception {
		for(int i=0;i<methods.length;i++)
		{
			if(methods[i].getName().equalsIgnoreCase(ReadingExcel.actionwords))
			{
				methods[i].invoke(activekeyword);
				break;
			}

		}
	}
	public void getElements() {
		switch (ReadingExcel.locatorname) {
		case "id":
			locator =Locators.getID(ReadingExcel.locatorvalue);
			break;
		case "xpath":
			locator =Locators.getXpath(ReadingExcel.locatorvalue);
			break;

		default:
			break;
		}
	}

public static void main(String[] args) throws Exception {
	ReadingExcel.readExcel();
	Engine engine=new Engine();
	engine.methoding();
	int locatorcolumn=3;
	int keywordcolumn=locatorcolumn+1;
	int testdatacolumn=locatorcolumn+2;
	for(int row=1;row<ReadingExcel.physicalNumberOfRows;row++)
	{
		ReadingExcel.getCellValue(row,locatorcolumn,keywordcolumn,testdatacolumn);
		engine.getElements();
		engine.combining();
	}
	
}

}
