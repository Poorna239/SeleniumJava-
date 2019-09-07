package testNG_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNG_Extentreport {

	ExtentTest test1;
	WebDriver driver = null;
	String webpagetitle;
	ExtentReports extent;
	String Projectpath = System.getProperty("user.dir"); 
	ExtentTest test2;
	ExtentHtmlReporter htmlReporter;

	@BeforeSuite
	public void setextentreport() {

		//initialize the HtmlReporter
		 htmlReporter = new ExtentHtmlReporter("extent22.html");
		// initialize ExtentReports and attach the HtmlReporter
		extent  = new ExtentReports();
		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);
		
		

		


	}

//	@BeforeTest
//	public void setup() {
//		
//		System.setProperty("webdriver.chrome.driver", Projectpath+"\\drivers\\Chromedriver\\chromedriver.exe");
//
//		/*Create an instance for the driver */
//		driver = new ChromeDriver();
//	}

	@Test
	public void test_case1() {
		// creating a test and add all events to it
		test1 = extent.createTest("Google Search for Automation with Chrome", "Search report");
		
		System.setProperty("webdriver.chrome.driver", Projectpath+"\\drivers\\Chromedriver\\chromedriver.exe");

		/*Create an instance for the driver */
		driver = new ChromeDriver();

//		test1 = extent.createTest("Google Search for Automation", "Search report");
		
		test1.log(Status.INFO, "Starting Test case 1");
		/* go to google.com */
		driver.get("https://www.google.de/?hl=de");
		test1.pass("Navigated to google homepage");

		/*find the search box webelemnt using locators */
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		test1.pass("search box element found");

		/*send any text using send_keys() method */
		textbox.sendKeys("Automation step by step ");
		test1.pass("Searched for automation step by step");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* Click on search button */
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		test1.pass("found the click button");

		/* wait */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		webpagetitle = driver.getTitle();
		test1.pass("webpage title has been copied ");


	}
//	@AfterTest
//	public void teardown() {
//	
//		driver.quit();
//	}
	
//	@BeforeTest
//	public void setup() {
//		
//		System.setProperty("webdriver.gecko.driver", Projectpath+"\\drivers\\Geckodriver\\geckodriver.exe");
//		
//		/*Create an instance for the driver */
//		driver = new FirefoxDriver();
//	}
//
	@Test
	public void FF_Test() {
		
		test1 = extent.createTest("Google Search for Automation with firefox", "Search report");
		System.setProperty("webdriver.gecko.driver", Projectpath+"\\drivers\\Geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		test1.log(Status.INFO, "Starting Test case 2");
		/* go to google.com */
		driver.get("https://www.google.de/?hl=de");
		test1.pass("Navigated to google homepage in firefox");

		/*find the search box webelemnt using locators */
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		test1.pass("search box element found");

		/*send any text using send_keys() method */
		textbox.sendKeys("Automation step by step ");
		test1.pass("Searched for automation step by step in Firefox");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* Click on search button */
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		test1.pass("found the click button Firefox");

		/* wait */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test1.pass("webpage title has been copied in Firefox ");


	}
//	
//	@AfterTest
//	public void teardown() {
//	
//		driver.quit();
//		test2.log(Status.INFO, "Test case completed in Firefox ");
//	}

	@AfterSuite
	public void extentflush() {
		
		driver.quit();

		System.out.println("Webpage title is: " + webpagetitle );

		test1.log(Status.INFO, "Test case completed ");

		// calling flush writes everything to log file
		extent.flush();


	}


}

