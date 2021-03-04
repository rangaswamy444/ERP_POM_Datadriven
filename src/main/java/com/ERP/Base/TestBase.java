package com.ERP.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\TestWorkspace\\ERP_POM\\PropertyFile\\Environment.properties"); 
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);
		
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.out.println("Executing in Chrome browser..............................................................................................................................");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.out.println("Executing in Firefox browser..............................................................................................................................");
			System.setProperty("webdriver.gecko.driver",prop.getProperty("geckopath"));	
			driver = new FirefoxDriver(); 
		}
		
		
		/*e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}
