package com.computechis.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell col;

	public ExcelReader() {
		File excelFilePath = new File(System.getProperty("user.dir") + "\\TestData\\ProjectData.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ExcelReader(String filePath) {
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void m1() {
		
	}
	
public String getCellData(String sheetName,int row,int column) {
		
		String data = null;
		
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			 data=String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK){
			data="";
		}
		
		return data;
		
	}
	
	public int rowsCount(String sheetName) {
		int rowsCount = wb.getSheet(sheetName).getPhysicalNumberOfRows();
		return rowsCount;
	}

	public int colsCount(String sheetName, int rowNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getPhysicalNumberOfCells();
	}

	public String getStringData(int sheetIndex, int rowNo, int colNo) {
		return wb.getSheetAt(sheetIndex).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	public String getStringData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
		/*
		 * sheet = wb.getSheet(sheetName); row=sheet.getRow(rowNo);
		 * col=row.getCell(colNo); String data =col.getStringCellValue(); return data;
		 */
	}

	public int getIntegerData(String sheetName, int rowNo, int colNo) {
		int intData = (int) wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
		return intData;
	}

	public double getDecimalData(String sheetName, int rowNo, int colNo) {
		double decimalData = wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
		return decimalData;
	}
	public boolean getBooleanData(String sheetName, int rowNo, int colNo) {
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getBooleanCellValue();
	}
}
