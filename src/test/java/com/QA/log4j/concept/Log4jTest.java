package com.QA.log4j.concept;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4jTest {
	
	
	WebDriver driver;
	Logger log = Logger.getLogger(Log4jTest.class);
	
	@BeforeMethod
	public void setUp()
	{
		log.info("################## info - before method#############");
		System.setProperty("webdriver.chrome.driver", "C:/SeleniumDrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/index.html");
	}
	
	@Test
	public void getFreeCRMTitleTest()
	{
		
		log.warn("################## Warn#  @Test1 method############");
		String title = driver.getTitle();
		System.out.println("Title " + title);
		Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");
	}
	
	@Test
	public void getFreeCRMLogo()
	{
		
		log.debug("################## Debug @Test2 method############");
		String title = driver.getTitle();
		boolean b = driver.findElement(By.xpath("//span[@class='brand-slogan']")).isDisplayed();
		Assert.assertTrue(b);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
