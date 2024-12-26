package com.magento.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			features= {"src\\test\\resources\\features"},
			glue={"com.magento.stepdefinition","com.magento.testrunner"}
			//tags="@Test"
			)
	public class TestRunner extends AbstractTestNGCucumberTests {
		
		
	}


