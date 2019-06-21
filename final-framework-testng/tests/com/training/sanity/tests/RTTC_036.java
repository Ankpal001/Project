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

public class RTTC_036 {
	
	private WebDriver driver;
	private String baseUrl2;
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
		baseUrl2 = properties.getProperty("baseUrl2");
		System.out.println(baseUrl2);
		screenShot = new ScreenShot(driver); 		
		//driver.get("http://retail.upskills.in/");
		//Thread.sleep(1000);
		// open the browser 
		driver.get(baseUrl2);
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
		Thread.sleep(5000);	
		WebElement order = driver.findElement(By.xpath("//i[@class = 'fa fa-user-o']"));
		Actions Myorder = new Actions(driver);
		Myorder.moveToElement(order).build().perform();		
		Thread.sleep(3000);		
		driver.findElement(By.xpath("//span[text()='MY ORDERS']")).click();
		driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("ankitadorable11@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("June@2019");
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		Thread.sleep(3000);	
		/*driver.findElement(By.linkText("Home")).click();		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,10000)");
		WebElement Ring = driver.findElement(By.xpath("//img[@class=' lazyloaded']"));
		js2.executeScript("arguments[0].scrollIntoView();", Ring);
		//js2.executeScript("arguments[0].;", Ring);
		Ring.click();*/
		driver.findElement(By.xpath("//i[@class = 'fa fa-eye']")).click();
		driver.findElement(By.xpath("//a[@class = 'btn btn-danger tb_no_text' and @title = 'Return']")).click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//input[@name= 'return_reason_id' and @value = '1' and @type = 'radio']")).click();
		
		
		//WebElement Reason = driver.findElement(By.xpath("//input[@name= 'return_reason_id' and @value = '1' and @type = 'radio']"));
		//js2.executeScript("arguments[0].scrollIntoView();", Reason);
		//Reason.click();
		driver.findElement(By.xpath("//input[@name= 'opened' and @value = '1']")).click();
		driver.findElement(By.xpath("//input[@name= 'opened' and @value = '1' and @type ='radio']")).click();
		driver.findElement(By.xpath("//textarea[@id= 'input-comment' and @name = 'comment']")).sendKeys("product is faulty");
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//input[@class= 'btn btn-primary' and @value = 'Submit']")).click();	

	}

}
