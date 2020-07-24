package com.qa.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public static String getDataFromExcel(String sheetName, int rowno, int colno) throws IOException
	{
		// create object of XSSFWorkbook
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\test.xlsx";
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		// optional if you want to know how many sheets are there in the workbook
		int noOfSheets=workbook.getNumberOfSheets();
		//System.out.println("No of sheets in a workbook: "+noOfSheets);
		
		//Get Access to the Sheet
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		// optional if you want to know how many rows are there in a sheet
		int noOfRows=sheet.getLastRowNum();
		//System.out.println("No of rows in a sheet: "+noOfRows);
		
		// Access the specific row
		XSSFRow row=sheet.getRow(rowno);
		
		//Access specific column
		XSSFCell cell=row.getCell(colno);
		
		// get the value
		String s=cell.getStringCellValue();
		
		return s;
	}

}
