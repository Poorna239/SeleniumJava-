package testNG_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DesiredCapabilities_demo {

   public WebDriver driver = null;

	@BeforeTest
	public void setup() {
		
		/* Getting Project path */
		String Projectpath = System.getProperty("user.dir");
		
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		/*set system properties for the driver chrome */
		System.setProperty("webdriver.ie.driver", Projectpath+"\\drivers\\IEdriver\\IEDriverServer.exe");
		
		/*Create an instance for the driver */
		 driver = new InternetExplorerDriver();
		
	}
	
	@Test
	public void Desired() throws Exception {
		
		/* go to google.com */
		driver.get("https://www.google.de");
		
		Thread.sleep(1000);
		/*find the search box webelemnt using locators */
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		
		Thread.sleep(1000);
		/*send any text using send_keys() method */
		textbox.sendKeys("Automation");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		
	}
	
	@AfterTest
	public void CloseBrowser() {
		
		/* close the browser *
		
		driver.quit();
		
		/* print whether the test is passed or failed */
		System.out.println("Test comnpleted successfully");
		
	}
	
}
