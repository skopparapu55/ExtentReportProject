package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public void initialise() throws IOException
	{
		prop=new Properties();
		String filePath=System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties";
		FileInputStream fis=new FileInputStream(filePath);
		prop.load(fis);
		String b=prop.getProperty("browser");
		if(b.equalsIgnoreCase("chrome"))
		{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",path );
		driver=new ChromeDriver();
		}
		else if(b.equalsIgnoreCase("firefox"))
		{
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver-v0.26.0-win64\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",path );
		driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void captureScreen(String s) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir")+"\\Screenshots\\"+s+".png";
		File dest=new File(filePath);
		FileUtils.copyFile(src, dest);
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
