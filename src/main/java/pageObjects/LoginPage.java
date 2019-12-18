package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	//throwing By.cssSelector("a[href*='sign in']"); into  = variable (By signin)	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login = By.xpath("//*[@id=\"new_user\"]/div[3]/input");
	
	public LoginPage(WebDriver driver) { //this was created to talk to driver in HomePage class
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement enterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement enterPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickonLogin()
	{
		return driver.findElement(login);
	}

}
