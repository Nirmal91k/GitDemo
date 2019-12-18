package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		//chrome or firefox or internet explorer
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\niru\\WorkingForSomeone\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//prop.getProperty("browser");
		//assigning the prop.getProperty("browser") to variable
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			//execute it in chrome browser
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium dependencies\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("firefox"))
		{
			//execute it in firefox browser
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium dependencies\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			//execute it in IE browser
			System.setProperty("webdriver.ie.driver", "D:\\Selenium dependencies\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
