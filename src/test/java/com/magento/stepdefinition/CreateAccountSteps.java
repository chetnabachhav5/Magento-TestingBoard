package com.magento.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.magento.driverfactory.DriverFactory;
import com.megento.pages.CreateAccount_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountSteps {

	CreateAccount_Page createAccount = new CreateAccount_Page(DriverFactory.getDriver());

	@Given("the user is at Magento homepage")
	public void the_user_is_on_the_magento_homepage() {
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://magento.softwaretestingboard.com/");

	}

	@Then("page title should contains {string}")
	public void page_title_should_contains(String titletext) {
		String title = createAccount.fetchTitleOfPage();
		boolean istitlepresent = title.contains(titletext);
		Assert.assertTrue(istitlepresent);
		
	}

	@When("the user clicks on Create an Account link")
	public void the_user_clicks_on_link() {
	  createAccount.createAccountNavigationLink();
	}

	@When("the user enters {string} as the first name")
	public void the_user_enters_as_the_first_name(String fname) {
       createAccount.firstName(fname);
	}

	@When("the user enters {string} as the last name")
	public void the_user_enters_as_the_last_name(String lname) {
		createAccount.lastName(lname);
	}

	@When("the user enters {string} as the email address")
	public void the_user_enters_as_the_email_address(String email) {
		createAccount.emailAddress(email);
	}

	@When("the user enters {string} as the password")
	public void the_user_enters_as_the_password(String pass) {
		createAccount.password(pass);
	}

	@When("the user confirms {string} as the confirm password")
	public void the_user_confirms_as_the_confirm_password(String cPass) {
		createAccount.confirmPass(cPass);
	}

	@When("the user clicks on Create an Account button")
	public void the_user_clicks_on_button() {
		createAccount.createAccount();
	}

	@Then("the user account should be created successfully")
	public void the_user_account_should_be_created_successfully() {
		createAccount.isUserLoggedIn();
	}

}
