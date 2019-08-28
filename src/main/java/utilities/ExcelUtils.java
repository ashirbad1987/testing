package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import afu.org.checkerframework.checker.formatter.FormatUtil;

public class ExcelUtils {
	
	public static FileInputStream  fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook     wb ;
	public static XSSFSheet        sheet;
	public static XSSFRow          row ;   
	public static XSSFCell         cell ;
	
	public static int getRowCount(String excelPath, String excelSheetName) {
		
		try {
		fis= new FileInputStream(excelPath);
		wb = new XSSFWorkbook(fis);
		sheet=wb.getSheet(excelSheetName);
		int rowCount=sheet.getLastRowNum();
		return rowCount;
		}

		catch(IOException e) {
		e.printStackTrace();	
		}
		return 0;
	}

	public static int getCellCount(String excelPath, String excelSheetName, int rownum) {
		
		try {
		fis=new FileInputStream(excelPath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(excelSheetName);
		row=sheet.getRow(rownum);
		int colCount=sheet.getRow(1).getLastCellNum();
		return colCount;
		
		}
		catch(IOException e) {
		e.printStackTrace();	
		}
		return 0;
	}
	
	public static String getCellData(String excelPath, String excelSheetName, int rownum, int cellno) {
		
		try {
		fis=new FileInputStream(excelPath);
		wb= new XSSFWorkbook(fis);
		sheet=wb.getSheet(excelSheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellno);
		
		}
		catch(IOException ie) {
		ie.printStackTrace();	
		}
		
		String data;
		try {
		DataFormatter formatter= new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		return cellData;
		}
		catch(Exception e) {
		data="";	
		}
		return data;
	}
	
	public static void setData(String excelPath, String excelSheetName, int rownum, int cellnum, String data) {
		
		try {
			fis=new FileInputStream(excelPath); 
			fos=new FileOutputStream(excelPath);
			wb=new XSSFWorkbook(fis);
			sheet=wb.getSheet(excelSheetName);
			row=sheet.getRow(rownum);
			cell=row.getCell(cellnum);
			cell.setCellValue(data);
			//wb.getSheet(excelPath).getRow(rownum).getCell(cellnum).setCellValue(data);
			wb.write(fos);
			wb.close();
			fis.close();
			fos.close();
	     	}
		catch(IOException e) {
	     e.printStackTrace();
		}
		
	}
}
