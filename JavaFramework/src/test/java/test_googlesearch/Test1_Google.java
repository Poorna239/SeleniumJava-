package test_googlesearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import googlesearch_page.TestGoogle;

public class Test1_Google {

	/*Get the project path */
	public static String ProjectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) throws Exception {
		
		Google_search();
		
	}
		public static void Google_search() throws Exception {
			
			/*set system properties for the driver chrome */
			System.setProperty("webdriver.chrome.driver", ProjectPath +"\\drivers\\Chromedriver\\chromedriver.exe");
			
			/*Create an instance for the driver */
			WebDriver driver = new ChromeDriver();
			
			/* go to google.com */
			driver.get("https://www.google.de/?hl=de");
			
			/*find the search box webelemnt using locators */
			TestGoogle.Textbox(driver).sendKeys("Automation step by step ");
			
			/*Wait for the browser to load */
			Thread.sleep(3000);
			
			/* Click on search button */
			TestGoogle.ClickOnbutton(driver).click();
			
			/*Wait for the browser to load */
			Thread.sleep(2000);
			
			/* close the browser */
			driver.quit();
			
			
		}

	}

