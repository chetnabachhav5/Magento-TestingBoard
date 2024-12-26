package com.megento.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount_Page {

	@FindBy(xpath="//a[contains(text(),'Create an Account')]")
	WebElement createAccountNavigationLink;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	 
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement confirmPass;
	
	@FindBy(xpath="//span[contains(text(),'Create an Account')]//parent::button")
	WebElement createAccountButton;
	
	@FindBy(xpath="//span[contains(text(),'Welcome')]")
	WebElement welcomeMessage;
	
	WebDriverWait wait;
	WebDriver driver;
	
	
	public CreateAccount_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public String fetchTitleOfPage()
	{
		String titleOfPage=driver.getTitle();
		return titleOfPage;
	}
	
	public void createAccountNavigationLink()
	{
		createAccountNavigationLink.click();
	}
	
	
	public void firstName(String fname)
	{
		firstName.sendKeys(fname);	
	}
	
	public void lastName(String lname)
	{
		lastName.sendKeys(lname);	
	}
	
	public void emailAddress(String email)
	{
		emailAddress.sendKeys(email);	
	}
	
	public void password(String pass)
	{
		password.sendKeys(pass);	
	}
	public void confirmPass(String cpass)
	{
		confirmPass.sendKeys(cpass);	
	}
	public void createAccount()
	{
		createAccountButton.click();	
	}

	public boolean isUserLoggedIn() {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Welcome')]")));

	    return welcomeMessage.isDisplayed();
	    
	}
	
}
