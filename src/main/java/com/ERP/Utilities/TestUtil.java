package com.ERP.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String excelpath,String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	public static String getValueForKey(String key) throws Throwable
	{
		Properties configProperties=new Properties();
		configProperties.load(new FileInputStream("C:\\TestWorkspace\\ERP_Stock_Accounting\\PropertyFile\\Environment.properties"));		
		return configProperties.getProperty(key);
		
	}
	public static String Dateformat()
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd hh_mm_ss");
		return sdf.format(d);
	}

}
