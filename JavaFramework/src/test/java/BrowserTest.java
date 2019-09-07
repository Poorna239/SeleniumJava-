import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		/*Get the project path */
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		
		/* set the system properties for firefox */
//		System.setProperty("webdriver.gecko.driver", ProjectPath+"\\drivers\\Geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", ProjectPath+"\\drivers\\Chromedriver\\chromedriver.exe");
//		System.setProperty(" webdriver.ie.driver", ProjectPath+"\\drivers\\IEdriver\\IEDriverServer.exe");
		
		/*Create an object or instance for the webdriver */
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new InternetExplorerDriver();
		
		/*go to url */
		driver.get("https://www.google.de/?hl=de");
		
		/* find google search box webelement using locator xpath  */
		WebElement textbox = driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']"));
		textbox.sendKeys("KKK");
		
		/*Run and validate the test */
//		System.out.println(driver.getTitle());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
		
	}

}
