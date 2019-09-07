package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import testNG_Demo.TestNG_GoogleSearch;

public class PropertiesFile {
	
	static WebDriver driver;
	static String browser;
	static Properties property;
	static OutputStream output;

	public static void main(String[] args) {
		
		try {
			getProperties();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("This is the cause for the exception:- " + e.getCause());
			System.out.println("This is the message for the exception:- " + e.getMessage());
			System.out.println("This is the trace for the exception:- " + e.getStackTrace());
			
		}
		googlesearch();
		closebrowser();
		
		try {
			setproperty();
		} catch (Exception e) {
			
			e.getMessage();
		}
	}

	public static void getProperties() throws Exception {
		property = new Properties();
		InputStream  input = new FileInputStream("C:\\JavaFramework\\JavaFramework\\src\\test\\java\\config\\config.properties");
		property.load(input);
		browser = property.getProperty("browser");
		TestNG_GoogleSearch.browserName = browser;
	}

	public static void googlesearch() {

		if(browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\JavaFramework\\JavaFramework\\drivers\\Geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.contains("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\JavaFramework\\JavaFramework\\drivers\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("The browser name is not supported "+ browser);
		}

		driver.get("https://www.google.de/?hl=de");

	}

	public static void closebrowser() {
		driver.quit();
	}
	
	public static void setproperty() throws Exception {
		
		try {
			OutputStream output = new FileOutputStream("C:\\JavaFramework\\JavaFramework\\src\\test\\java\\config\\config.properties");
			property.setProperty("Result", "Pass");
			property.setProperty("browser", "firefox");
			property.store(output, "Google search using .properties configuration file");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}
