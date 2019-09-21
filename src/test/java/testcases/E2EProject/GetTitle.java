package testcases.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class GetTitle extends Base
{
	public static Logger log =  LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	@BeforeTest
	public void gearUp() throws IOException
	{
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com/");
		
	}
	@Test
	public void validateTtle() throws IOException
	{
	driver = initializeDriver();
	driver.get(properties.getProperty("url"));
	LandingPage lp = new LandingPage(driver);
	
	Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
	log.info("Successfully validated the title");
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
