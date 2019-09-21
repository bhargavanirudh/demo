package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		System.out.println("Demonstrate the GIT HUB importance");
		this.driver = driver;
	}
	By login = By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']");
	By title = By.xpath("//*[@id='content']/div/div/h2");
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
}
