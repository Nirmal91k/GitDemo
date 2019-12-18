package com.someoneCompany;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base {
	
	  @BeforeTest 
	  public void initializeBrowser() throws IOException { 
		  driver =  initializeDriver(); 
		  //driver.get(prop.getProperty("url")); we are using data provider--multiple data in this test, browser opens only once here, hence it is failing, so moving this step in to @Test method  
		  }
	 
	@Test(dataProvider = "getData")
	public void basePagenavigation(String userName, String Password, String text) throws IOException {
		// use inheritance concepts to call the base class access the class
		//Here the initializeDriver(); methods takes care of browser initialization -- this method returns driver so putting it in driver object
		//moving this initialization steps to before tests annotation and adding one method says closing the driver object- here browser window
		//driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		// if we want to call the methods of landing page we have 2 ways
		// 1 is by using inheritance
		// 2 is by creating the landing page object -- if we create a object then we see
		// that import pageObjects.LandingPage;

		//LandingPage
		LandingPage lp = new LandingPage(driver); // giving the driver object life to Landing page using constructor
		lp.getLogin().click();
		
		//LoginPage 
		LoginPage lp1 = new LoginPage(driver);
		lp1.enterEmail().sendKeys(userName);
		lp1.enterPassword().sendKeys(Password);
		System.out.println(text);
		
		lp1.clickonLogin().click();

	}
	
	
	  @AfterTest public void tearDown() { driver.close(); }
	 

	//data provide and parameterization 
	@DataProvider
	public Object[][] getData() {
		//creating an object array
		Object[][] data = new Object[2][3];
		
		//0th row
		data [0][0] = "nonrestricteduser@mail.com";
		data [0][1] = "12345";
		data [0][2] = "nonrestricted user";
		
		
		  //1st row 
		  data [1][0] = "restricteduser@mail.com"; 
		  data [1][1] = "12345";
		  data [1][2] = "restricted user";
		 
		return data;
	}
	
	
}
