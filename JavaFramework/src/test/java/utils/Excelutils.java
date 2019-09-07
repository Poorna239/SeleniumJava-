package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	/*Get the project path using system properties method "user.dir"*/
	static String projectpath = System.getProperty("user.dir");
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;


	public static void main(String[] args) {
		Excelutils excel = new Excelutils(projectpath +"\\excel\\Datasheet.xlsx","Tabelle1");
		excel.getRowNumber();
		excel.getColNumber();
		excel.getStringValue(0,0);
		excel.getNumericalValue(1,1);
	}

	/* Creating a constructor */
	public Excelutils(String excelpath, String sheetNumber) {
		/* Create a reference for the workbook i.e. excel */
		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetNumber);
		}
		catch(Exception e) {
			e.getMessage();
		}

	}

	/*creating a method to get the rows used in the excel sheet */
	public  int getRowNumber() {
		int rowCount = 0 ;
		try {
			/* Create a reference for the workbook i.e. excel */
			//			workbook = new XSSFWorkbook(projectpath +"\\excel\\Datasheet.xlsx");
			/* Create a reference for Worksheet i.e. sheet */
			//			sheet = workbook.getSheet("Tabelle1");
			/*get the row count number*/
		    rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows used is :- " + rowCount);
			
		}
		catch(Exception exp) {
			exp.getMessage();
		}

		return rowCount;
	}
	
	/*creating a method to get the columns count used in the excel sheet */
	public int getColNumber() {
		int columnCount = 0; 
		try {
			/* Create a reference for the workbook i.e. excel */
			//			workbook = new XSSFWorkbook(projectpath +"\\excel\\Datasheet.xlsx");
			/* Create a reference for Worksheet i.e. sheet */
			//			sheet = workbook.getSheet("Tabelle1");
			/*get the row count number*/
			columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of columns used is :- " + columnCount);

		}
		catch(Exception exp) {
			exp.getMessage();
		}
		return columnCount;
	}
	

	/* Method to get the string value in the cell */
	public  String getStringValue(int rowNum, int colNum) {
		String name = null;
		try {
			//			workbook = new XSSFWorkbook(projectpath +"\\excel\\Datasheet.xlsx");
			//			sheet = workbook.getSheet("Tabelle1");
			/*call the functions to get the cell data */
			 name = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//			System.out.println(name);
		}
		catch(Exception exp){
			exp.getMessage();
		}
		return name;
	}

	/* Method to get the string value in the cell */
	public double getNumericalValue(int rowNum, int colNum) {
		/*call the functions to get the cell numerical data */
		double value = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
//		System.out.println(value);
		return value;
	}

}
