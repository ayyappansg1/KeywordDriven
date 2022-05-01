package org.keyword;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class Engine {
	ActiveKeywords activekeyword;
	Method[] methods;
	static String keyword;

	public void methoddata() {
		activekeyword=new ActiveKeywords();

		methods = activekeyword.getClass().getMethods();
	}
	public void combining() throws Exception {
		for(int i=0;i<methods.length;i++)
		{
			if(methods[i].getName().equalsIgnoreCase(keyword))
			{
				methods[i].invoke(activekeyword);
				break;
			}

		}
	}

public static void main(String[] args) throws Exception {
	ReadingExcel excelraed=new ReadingExcel();
	excelraed.readExcel();
	Engine engine=new Engine();
	engine.methoddata();
	
	System.out.println(ReadingExcel.cellvalue);
	
	for(int row=1;row<=6;row++)
	{
		keyword = ReadingExcel.getCellValue(row,3);
		engine.combining();
	}
	
}

}
