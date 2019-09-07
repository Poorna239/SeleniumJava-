package test_googlesearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import googlesearch_page.GoogleSearchPageObjects;

public class Test1_GooglePOM {

	public static void main(String[] args) throws Exception {
		
		 String ProjectPath = System.getProperty("user.dir");
		 
		/*set system properties for the driver chrome */
		System.setProperty("webdriver.chrome.driver", ProjectPath +"\\drivers\\Chromedriver\\chromedriver.exe");
		
		/*Create an instance for the driver */
		WebDriver driver = new ChromeDriver();
		
		/* go to google.com */
		driver.get("https://www.google.de/?hl=de");
		
		/* object or instance for GoogleSearchPageObjects class */
		GoogleSearchPageObjects pom = new GoogleSearchPageObjects(driver);
		
		/*calling the method using object for entering the text*/
		pom.SearchInTextBox("Automation step by step");
		/* wait for 3 sec */ 
		Thread.sleep(3000);
		/*click on the search button */
		pom.ClickSearchButton();
		/* wait for 3 sec */
		Thread.sleep(2000);
		/*Close the web browser */
		driver.quit();

	}

}
