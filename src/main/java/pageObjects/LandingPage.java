package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//throwing By.cssSelector("a[href*='sign in']"); into  = variable (By signin)	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navbar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav");
	
	public LandingPage(WebDriver driver) { //this was created to talk to driver in HomePage class
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getnavigation() {
		return driver.findElement(navbar);
	}

}
