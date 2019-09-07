package testNG_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_GoogleSearch2 {

	public WebDriver driver = null;
	public String webpagetitle;
	
	@BeforeTest
	public void TestSetUp() {
		
		/* Getting Project path */
		String Projectpath = System.getProperty("user.dir");
		
		/*set system properties for the driver chrome */
		System.setProperty("webdriver.chrome.driver", Projectpath+"\\drivers\\Chromedriver\\chromedriver.exe");
		
		/*Create an instance for the driver */
		 driver = new ChromeDriver();

	}
	
	@Test
	public void SearchBMW() {
		
		/* go to google.com */
		driver.get("https://www.google.de/?hl=de");
		
		/*find the search box webelemnt using locators */
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		
		/*send any text using send_keys() method */
		textbox.sendKeys("BMW Hoch Haus ");
		
		/*Wait for the browser to load */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		
		/* Click on search button */
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
		/* wait */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*Get the browser title */
		webpagetitle = driver.getTitle();
		
	}
	
	@Test
	public void SearchBMWFIZ() {
		
		/* go to google.com */
		driver.get("https://www.google.de/?hl=de");
		
		/*find the search box webelemnt using locators */
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		
		/*send any text using send_keys() method */
		textbox.sendKeys("BMW FIZ ");
		
		/*Wait for the browser to load */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		
		/* Click on search button */
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
		/* wait */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*Get the browser title */
		webpagetitle = driver.getTitle();
		
	}
	
	@AfterTest
	public void CloseBrowser() {
		
		/* close the browser */
		driver.close();
		
		driver.quit();
		
		/* print whether the test is passed or failed */
		System.out.println("Test comnpleted successfully");
		System.out.println("Webpage title is: " + webpagetitle );
		
	}
	
	
}
