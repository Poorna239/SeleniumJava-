package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	/**
	 * Example for data driven Test using selenium javaframework
	 */
	static WebDriver driver = null;
	
	@BeforeTest
	public void TestSetUp() {
	String Projectpath = System.getProperty("user.dir");
	
	System.setProperty("webdriver.chrome.driver", Projectpath+"\\drivers\\Chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	
	}
	
	
	@Test(dataProvider ="testData" )
	public void test1(String username, String password) {
		System.out.println(username + " | " + password);
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.xpath("//input[@name = 'txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name = 'txtPassword']")).sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] getData() {
		
		String excelpath = "C:\\JavaFramework\\JavaFramework\\excel\\Datasheet.xlsx";
		Object data[][] = testData(excelpath,"Tabelle1" );
		return data;
	}
	
	public static Object[][] testData(String excelPath, String Sheetname ) {
		
		Excelutils excel = new Excelutils(excelPath, Sheetname);
		
		int rowCount =  excel.getRowNumber();
		int colCount  = excel.getColNumber();

		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j= 0; j<colCount; j++) {
			String celldata = excel.getStringValue(i, j);
			System.out.println(celldata);
			data[i-1][j] = celldata;
			}
		}
		return data;
	}

}
