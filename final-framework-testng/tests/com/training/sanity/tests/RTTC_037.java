package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_037 {
	
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
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("123456@123");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-username']")).clear();
		driver.findElement(By.xpath("//input[@id = 'input-password']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-username']")).clear();
		driver.findElement(By.xpath("//input[@id = 'input-password']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-username']")).sendKeys("manzoor");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-username']")).clear();
		driver.findElement(By.xpath("//input[@id = 'input-password']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-username']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		Thread.sleep(3000);

}
}	
