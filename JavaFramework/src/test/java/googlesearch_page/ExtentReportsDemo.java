package googlesearch_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {

	/**
	 * 
	 * @param args
	 * @throws Exception
	 * 
	 * Step1:- initialize the HtmlReporter
	 * step2:- initialize ExtentReports and attach the HtmlReporter
	 * step3:- attach only HtmlReporter
	 * step4:- creating a test and add all events to it
	 * step5:- test.log(Status.INFO, "Starting Test case"); for the information that logging has started
	 * step6:- use extent report functions like "log", "info", "pass", "fail"[ test.pass("Navigated to google homepage");]
	 * step7:-  calling flush writes everything to log file
	 * 
	 * 
	 */
	public static void main(String[] args) throws Exception {

		// initialize the HtmlReporter
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);

		// creating a test and add all events to it
		ExtentTest test = extent.createTest("Google Search", "Search report");

		String Projectpath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", Projectpath+"\\drivers\\Chromedriver\\chromedriver.exe");

		/*Create an instance for the driver */
		WebDriver driver = new ChromeDriver();

		test.log(Status.INFO, "Starting Test case");
		/* go to google.com */
		driver.get("https://www.google.de/?hl=de");
		test.pass("Navigated to google homepage");
		
		/*find the search box webelemnt using locators */
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		test.pass("search box element found");
		
		/*send any text using send_keys() method */
		textbox.sendKeys("Automation step by step ");
		test.pass("Searched for automation step by step");
		
		/*Wait for the browser to load */
		Thread.sleep(3000);
		
		/* Click on search button */
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		test.pass("found the click button");
		
		/* wait */
		Thread.sleep(2000);
		
		/*Get the browser title */
		String webpagetitle = driver.getTitle();
		test.pass("webpage title has been copied ");
		
		/* close the browser */
		driver.quit();

		System.out.println("Webpage title is: " + webpagetitle );
		
		test.log(Status.INFO, "Test case completed ");
		
		// calling flush writes everything to log file
		extent.flush();



	}




}
