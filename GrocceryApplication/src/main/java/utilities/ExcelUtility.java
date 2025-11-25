package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
		static FileInputStream f;// used to read excel file in the system
		static XSSFWorkbook w; // used to represent entire xssfworkbook
		static XSSFSheet sh; // to represent sheet

		public static String getStringData(int row, int col,String sheet) throws IOException {
			f = new FileInputStream("C:\\Users\\Anupama S\\eclipse-workspace\\GrocceryApplication\\src\\test\\resources\\TestDataFile.xlsx"); // used to open the location of a
																					// specific file
			w = new XSSFWorkbook(f); // to load the file to memory with help of apache. orofile workbook anna parayuna
			sh = w.getSheet(sheet); // used to select the sheet1
			XSSFRow r = sh.getRow(row); // to get details of row according to rownumber
			XSSFCell c = r.getCell(col); // to get the cell from the row
			return c.getStringCellValue(); // to return in stringformat

		}

		public static String getIntegerData(int row, int col,String sheet) throws IOException {
			f = new FileInputStream("C:\\Users\\Anupama S\\eclipse-workspace\\GrocceryApplication\\src\\test\\resources\\TestDataFile.xlsx");
			w = new XSSFWorkbook(f);
			sh = w.getSheet(sheet);
			XSSFRow r = sh.getRow(row);
			XSSFCell c = r.getCell(col);
			int val = (int) c.getNumericCellValue(); // convert double to int using typecasting
			return String.valueOf(val); // convert int to string using valueOf() method
			// return val;

		}

	}

