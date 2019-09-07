package googlesearch_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	/*making driver variable to null */
	private WebDriver driver = null;
	
	/* locators finding using the xpath elements */
	By text_box = By.xpath("//input[@name='q']");
	By button_name = By.xpath("//input[@name='btnK']");
	
	/* constructor for the class with webdriver argument */
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	/*  method for entering the text in the text box */
	public void SearchInTextBox(String input) {
		this.driver.findElement(text_box).sendKeys(input);
	}
	
	/* method for clicking on google search button */
	public void ClickSearchButton() {
		this.driver.findElement(button_name).click();
	}

}
