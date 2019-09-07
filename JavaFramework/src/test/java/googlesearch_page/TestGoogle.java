package googlesearch_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestGoogle {
	
	/*Method that returns the element for the google search box */
	public static WebElement Textbox(WebDriver driver) {
		
		WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
		return element;
		
	}
	
	/*Method that returns the element for the google search button */
	public static WebElement ClickOnbutton(WebDriver driver) {
		
		WebElement Onbutton = driver.findElement(By.xpath("//input[@name='btnK']"));
		return Onbutton;
	}

}
