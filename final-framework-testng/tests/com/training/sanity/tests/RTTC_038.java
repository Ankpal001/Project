package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_038 {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		

	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseUrl");
		System.out.println(baseUrl);
		screenShot = new ScreenShot(driver); 		
		//driver.get("http://retail.upskills.in/");
		//Thread.sleep(1000);
		// open the browser 
		driver.get(baseUrl);
			}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id = 'input-username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		Thread.sleep(3000);
		WebElement order = driver.findElement(By.xpath("//i[@class = 'fa fa-tags fw']"));
		Actions Myorder = new Actions(driver);
		Myorder.moveToElement(order).build().perform();	
		Thread.sleep(3000);
		driver.findElement(By.linkText("Categories")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class = 'fa fa-plus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-name1' and @name = 'category_description[1][name]']")).sendKeys("ORNAMENTS");
		driver.findElement(By.xpath("//div[@class = 'note-editable panel-body']")).sendKeys("ornaments for ladies");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-meta-title1' and @name = 'category_description[1][meta_title]']")).sendKeys("ORNAMENTS");
		driver.findElement(By.xpath("//textarea[@id = 'input-meta-description1' and @name ='category_description[1][meta_description]']")).sendKeys("ornaments for ladies");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary' and @data-original-title = 'Save']")).click();
	}
}