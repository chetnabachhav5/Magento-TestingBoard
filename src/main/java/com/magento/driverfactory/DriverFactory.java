package com.magento.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	static WebDriver driver;
	public WebDriver initBrowser(String browsername)
	{
		if(browsername.equals("Chrome"))
		{
		   driver=new ChromeDriver();
		}
		else if(browsername.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
	  else {
         throw new IllegalArgumentException("Unsupported browser: " + browsername);
     }
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
