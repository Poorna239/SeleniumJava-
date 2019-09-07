package test_googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {
	
	public static String Projectpath = System.getProperty("user.dir"); 
	
	public static void main(String[] args) throws Exception {
		
		Google_search();
	}
	
	/*To make code modular we define methods here */
	public static void Google_search() throws InterruptedException {
		
		/*set system properties for the driver chrome */
		System.setProperty("webdriver.chrome.driver", Projectpath+"\\drivers\\Chromedriver\\chromedriver.exe");
		
		/*Create an instance for the driver */
		WebDriver driver = new ChromeDriver();
		
		/* go to google.com */
		driver.get("https://www.google.de/?hl=de");
		
		/*find the search box webelemnt using locators */
		WebElement textbox = driver.findElement(By.xpath("//input[@name='q']"));
		
		/*send any text using send_keys() method */
		textbox.sendKeys("Automation step by step ");
		
		/*Wait for the browser to load */
		Thread.sleep(3000);
		
		/* Click on search button */
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
		/* wait */
		Thread.sleep(2000);
		
		/*Get the browser title */
		String webpagetitle = driver.getTitle();
		
		/* close the browser */
		driver.quit();
		
		/* print whether the test is passed or failed */
		System.out.println("Test comnpleted successfully");
		System.out.println("Webpage title is: " + webpagetitle );
	}

}
