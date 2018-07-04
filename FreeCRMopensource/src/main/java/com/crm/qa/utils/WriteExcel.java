package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	XSSFWorkbook wb;
	XSSFSheet ws;
	
	
	public WriteExcel(String excelpath) throws IOException
	{
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		wb= new XSSFWorkbook(fis);
		ws=wb.getSheetAt(0);
		int columns=ws.getRow(0).getLastCellNum();
		//ws.getRow(0).createCell(columns).setCellValue("pass");
		ws.getRow(1).createCell(columns).setCellValue("Fail");
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}
	

}
