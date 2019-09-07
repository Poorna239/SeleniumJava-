package multibrowsing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import googlesearch_page.TestGoogle;

public class TestNGMultiBrowsing {

	WebDriver driver = null;
	String ProjectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		
		System.out.println("Browser running is "+ browserName);
		System.out.println("Thread runnning id "+ Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ProjectPath +"\\drivers\\Geckodriver\\geckodriver.exe");

			/*Create an instance for the driver */
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ProjectPath +"\\drivers\\Chromedriver\\chromedriver.exe");

			/*Create an instance for the driver */
			 driver = new ChromeDriver();
		}
	}
	
	@Test
	public void run() {
		driver.get("https://www.google.de/?hl=de");
		TestGoogle.Textbox(driver).sendKeys("Automation step by step ");
		
	}
	@AfterTest	
	public void close() {
		driver.quit();
	}

}
