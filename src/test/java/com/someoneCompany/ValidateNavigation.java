package com.someoneCompany;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigation extends Base {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePagenavigation() throws IOException {
		// use inheritance concepts to call the base class access the class
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url")); //moving this initialization steps to before tests annotation and adding one method says closing the driver object- here browser window 

		// LandingPage
		LandingPage lp = new LandingPage(driver); // giving the driver object life to Landing page using constructor
		
		//check if it is returning true or not		
		//Assert.assertTrue(condition)
		Assert.assertTrue(lp.getnavigation().isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();		
	}
	
}
