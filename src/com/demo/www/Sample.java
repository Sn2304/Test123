package com.demo.www;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
WebDriver driver;
String url;
String user;
String pass;
WebElement username;
WebElement password;
WebElement chkbox;
WebElement loginButton;
	@BeforeSuite
	public void setUp() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		FileInputStream f=new FileInputStream("..//Demo1/LoginDetails/LoginDetails.properties");
		Properties p=new Properties();
		p.load(f);
		 url = p.getProperty("url");
		 user = p.getProperty("user");
		 pass=p.getProperty("pass");
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	}
	
	@Test
	public void LoginPage() throws InterruptedException
	{
		//username field
		username=driver.findElement(By.id("username"));
		username.sendKeys(user);
		
		//password field
		Thread.sleep(2000);
		password=driver.findElement(By.name("pwd"));
		password.sendKeys(pass);
		
		//checkbox
		Thread.sleep(2000);
		chkbox=driver.findElement(By.id("keepLoggedInCheckBox"));
		chkbox.click();
		
		//loginButton
		Thread.sleep(2000);
		loginButton=driver.findElement(By.id("loginButton"));
		loginButton.click();
		
	}
	
	
	
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
