package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.qa.datadriven.DataDriven;

public class LoginTest extends Base {
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialise();
	}
	
	@Test(dataProvider="getData")
	public void verifyLogin(String user,String pwd)
	{
		driver.findElement(By.id("user_login")).sendKeys(user);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		
		String actual=driver.getTitle();
		String expected="Zero - Account Summary";
		
		Assert.assertEquals(actual, expected,"Title does not match");
	}
	
	@DataProvider
	public Object [][] getData() throws IOException
	{
		Object data[][]=new Object[2][2];
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				data[i][j]=DataDriven.getDataFromExcel("Login", i, j);
			}
		}
		return data;
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowser();
	}

}
