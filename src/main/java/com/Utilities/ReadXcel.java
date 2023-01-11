package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXcel {
	 ArrayList<HashMap<String, String>> data=new ArrayList<>();
	 File file;
	 FileInputStream input;
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 String path;
	 
	 public ReadXcel(String path) {
		this.path=path;
	}
	 
	public int getRowCount(String sheetName) {
		int rowcount = 0;
		try {
			file=new File(path);
			input=new FileInputStream(file);
			workbook=new XSSFWorkbook(file);
			sheet=workbook.getSheet(sheetName);
			rowcount= sheet.getLastRowNum();
			workbook.close();
			
		} catch (IOException | InvalidFormatException e) {
			
		}
		return rowcount;
	}
	
	public int getColumnCount(String sheetName) {
		int colCount = 0;
		try {
			file=new File(path);
			input=new FileInputStream(file);
			workbook=new XSSFWorkbook(file);
			sheet=workbook.getSheet(sheetName);
			colCount= sheet.getRow(0).getLastCellNum();
			workbook.close();
			
		} catch (IOException | InvalidFormatException e) {
			
		}
		return colCount;
	}
	
	public String getCelValue(String sheetName,int rowNo,int colNo) {
		String value=null;
		try {
			file=new File(path);
			input=new FileInputStream(file);
			workbook=new XSSFWorkbook(file);
			sheet=workbook.getSheet(sheetName);
			value= sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
			workbook.close();
			
		} catch (IOException | InvalidFormatException e) {
			
		}
		return value;
	}
}
