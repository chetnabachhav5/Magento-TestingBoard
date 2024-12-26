package com.magento.testrunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.magento.driverfactory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MagentoHooks {
	WebDriver driver;
	DriverFactory df;
	@Before
	public void launchBrowser() throws IOException
	{
		Properties prop=new Properties();
		
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream fis=new FileInputStream(path);
		
		prop.load(fis);
		df=new DriverFactory();
		String browsername=prop.getProperty("browser");
		driver= df.initBrowser(browsername);
		driver.manage().window().maximize();
		 
	}
	
	@After(order=2)
	public void tearDown(Scenario scenario) 
	{
	boolean isfailed = scenario.isFailed();
	if(isfailed)
	{
	String scenarioname=scenario.getName();
	String screenshotname=scenarioname.replaceAll(" ", "_");
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	byte[] source = ts.getScreenshotAs(OutputType.BYTES);
	scenario.attach(source, "image/png", screenshotname);
	}
	}
		
	@After(order=1)
	public void quitBrowser() {
		
		driver.quit();


}
}
