package com.opencart.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencart.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	//Adding file path for fetching data from properties file
//	public TestBase() throws IOException {
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream("E:\\Automation\\MavenPractice\\src\\main\\java\\com\\opencart\\qa\\config\\config.properties");
//			prop.load(ip);
//		} catch(FileNotFoundException e) {
//		    e.printStackTrace();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
	 static {
		 
	        try {
	            FileInputStream ip = new FileInputStream("E:\\Automation\\MavenPractice\\src\\main\\java\\com\\opencart\\qa\\config\\config.properties");
	            prop = new Properties();
	            prop.load(ip);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static String getProperty(String key) {
	        return prop.getProperty(key);
	    }
	
	
	//Initialize browser
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
		driver = new ChromeDriver();	
	    }
		else if(browserName.equals("firefox")){
		driver = new FirefoxDriver();
		}
		
		//dynamic webdriver opeartions
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_TIMEOUT));
		
		//open the url
		driver.get(prop.getProperty("url"));
	}
}
