package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static File src;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook work;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	
	// method for getting the data using xlfile, xlsheet,rownumber,column number
			public static void setCellData(String sheetName,int rowNum,int colnum, String data) throws IOException
			{
				fis=new FileInputStream("ExcelTestData/ExcelData.xlsx");
				work=new XSSFWorkbook(fis);
				fis.close();
				sheet=work.getSheet(sheetName);
				row=sheet.getRow(rowNum);
				CellStyle wrapCellStyle=work.createCellStyle();
				wrapCellStyle.setWrapText(true);
				if(row==null) {
					row=sheet.createRow(rowNum);
				}
				cell=row.createCell(colnum);
				cell.setCellValue(data);
				cell.setCellStyle(wrapCellStyle);
				sheet.autoSizeColumn(colnum);
				fos=new FileOutputStream("ExcelTestData/ExcelData.xlsx");
				work.write(fos);		
				work.close();
				//fis.close();
				fos.close();
			}
			
			// method for filling green colour to the data using xlfile, xlsheet,rownumber,column number
			public static void fillGreenColor(String sheetName,int rowNum,int colnum) throws IOException
			{
				fis=new FileInputStream("ExcelTestData/ExcelData.xlsx");
				work=new XSSFWorkbook(fis);
				sheet=work.getSheet(sheetName);
				row=sheet.getRow(rowNum);
				cell=row.getCell(colnum);
				style=work.createCellStyle();
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());//34
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				cell.setCellStyle(style);
				fos=new FileOutputStream("ExcelTestData/ExcelData.xlsx");
				work.write(fos);
				work.close();
				fis.close();
				fos.close();
			}
			
			//Method to clear the previous data in the Excel sheet
			public static void clearExcel(String sheetName) throws IOException {
				fis = new FileInputStream("ExcelTestData/ExcelData.xlsx");
				work = new XSSFWorkbook(fis);
				fis.close();
				sheet = work.getSheet(sheetName);
				while(sheet.getLastRowNum() >= 0) {
					 row = sheet.getRow(sheet.getLastRowNum());
					sheet.removeRow(row);
				}
				fos = new FileOutputStream("ExcelTestData/ExcelData.xlsx");
				work.write(fos);
				fos.close();
				work.close();
				
			}
	
	
	

}
