package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	public WebDriver driver;
	public Properties properties;
public WebDriver initializeDriver() throws IOException
{
	FileInputStream fis = new FileInputStream("C:\\Users\\welcome\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
	properties = new Properties();
	properties.load(fis);
	String browsername = properties.getProperty("browser");
	if(browsername.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver.exe");
		 driver = new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("firefox"))
	{
		 driver = new FirefoxDriver();
	}
	else if(browsername.equalsIgnoreCase("IE"))
	{
		 driver = new InternetExplorerDriver();
	}
	else
	{
		System.out.println("Please give correct or suitable Browser name");
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("The driver object has been created and returned");
	return driver;
	
}
}
