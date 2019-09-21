package testcases.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base
{
	public static Logger log =  LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void gearUp() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");	
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String user,String password) throws IOException
	{
		LandingPage lp = new LandingPage(driver);
		//Before I kept below in the before test but it's issue because again a new browser and login
		//locator is not finding as it's in login page, because qaclick opens only one time
		driver.get("http://qaclickacademy.com/");
		lp.getLogin().click();
		LoginPage lop = new LoginPage(driver);
		lop.getEmail().sendKeys(user);
		lop.getPassword().sendKeys(password);
		lop.getLogin().click();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "non-restrictiveuser";
		data[0][1] = "123";
		
		data[1][0] = "restrictiveuser";
		data[1][1] = "456";
		
		return data;
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
