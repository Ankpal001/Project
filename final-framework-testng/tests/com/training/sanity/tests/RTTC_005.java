package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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

public class RTTC_005 {
	
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
		baseUrl = properties.getProperty("baseURL");
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
		/*driver.findElement(By.xpath("//span[text()='MY ORDERS']")).click();
		loginPOM.sendUserName("ankit64291@gmail.com");
		loginPOM.sendPassword("June@2019");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("First");*/
		WebElement orders = (driver.findElement(By.xpath("//i[@class = 'fa fa-user-o']")));
		Actions action = new Actions(driver);
		action.moveToElement(orders).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='MY ACCOUNT']")).click();
		//driver.findElement(By.xpath("//a[@class = 'btn btn-primary']")).click();
		//driver.findElement(By.linkText("Edit your account information")).click();
		driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("ank.pal007@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("June@2019");
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Edit your account information")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id = 'input-firstname']")).clear();
		driver.findElement(By.xpath("//input[@id = 'input-firstname']")).sendKeys("manzoor");
		driver.findElement(By.xpath("//input[@id = 'input-lastname']")).clear();
		driver.findElement(By.xpath("//input[@id = 'input-lastname']")).sendKeys("mehadi");
		driver.findElement(By.xpath("//input[@id = 'input-email']")).clear();
		driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("manzoor@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'input-telephone']")).clear();
		driver.findElement(By.xpath("//input[@id = 'input-telephone']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
		
	

	}

}
