package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook ws;
	XSSFSheet xs;
	
	public ExcelDataConfig(String excelpath) throws IOException
	{	
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		ws=new XSSFWorkbook(fis);		
	}
	public String getData(String sheetname,int row,int column) 
	{
	        xs=ws.getSheet(sheetname);
	      String data0 = xs.getRow(row).getCell(column).getStringCellValue();   
         return data0;
    }
	public int getRowCount(String sheetname)
	{
	int countOfRows=ws.getSheet(sheetname).getLastRowNum();
	countOfRows=countOfRows+1;
	return countOfRows;
	}
	
	public int getColumnCount(String sheetname)
	{
		int columns=ws.getSheet(sheetname).getRow(0).getLastCellNum();
		return columns;
	}
}