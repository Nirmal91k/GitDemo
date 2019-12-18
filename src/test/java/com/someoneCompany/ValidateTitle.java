package com.someoneCompany;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage; // this gets imported due to created of constructor object of Landing page in curent class
import resources.Base; //this gets imported due to extends of Base class

public class ValidateTitle extends Base {

	@BeforeTest
	public void initializeBrowser() throws IOException{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePagenavigation() throws IOException {
		// use inheritance concepts to call the base class access the class
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url"));

		// LandingPage
		LandingPage lp = new LandingPage(driver); // giving the driver object life to Landing page using constructor
		//*[@id="homepage"]/header/div[2]/div/nav
		//compare the text from the browser and validate with actual text - Error...		
		//lp.getTitle().getText();
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();		
	}

}
