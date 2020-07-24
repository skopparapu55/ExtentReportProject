package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class PayBillsTest extends Base {
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialise();
	}
	
	@Test
	public void verifyPayBills()
	{
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		String actual=driver.getTitle();
		String expected="Zero - Account Summary";
		
		Assert.assertEquals(actual, expected,"Title does not match");
		
		driver.findElement(By.xpath("//a[contains(text(),'Pay Bills')]")).click();
		Assert.assertTrue(false);
		WebElement e=driver.findElement(By.xpath("//div[@id='ui-tabs-1']"));
		Assert.assertTrue(e.isDisplayed());
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}

}
