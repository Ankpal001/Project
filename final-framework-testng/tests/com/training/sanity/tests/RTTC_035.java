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

public class RTTC_035 {
	
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
		/*driver.findElement(By.xpath("//span[text()='MY ORDERS']")).click();
		loginPOM.sendUserName("ankit64291@gmail.com");
		loginPOM.sendPassword("June@2019");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("First");
		WebElement order = driver.findElement(By.xpath("//i[@class = 'fa fa-user-o']"));
		Actions Myorder = new Actions(driver);
		Myorder.moveToElement(order).build().perform();		
		Thread.sleep(3000);	*/	
		//driver.findElement(By.xpath("//span[text()='MY ORDERS']")).click();
		
		driver.findElement(By.xpath("//input[@id = 'input-username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		Thread.sleep(3000);
		WebElement order = driver.findElement(By.xpath("//i[@class = 'fa fa-tags fw']"));
		Actions Myorder = new Actions(driver);
		Myorder.moveToElement(order).build().perform();	
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[@href = 'http://retail.upskills.in/admin/index.php?route=catalog/product&token=OUZCztUF8UngUWrxvz6LZY5flTCueTMf']")).click();
		driver.findElement(By.linkText("Products")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class = 'btn btn-primary']")).click();
		driver.findElement(By.xpath("//input[@id = 'input-name1']")).sendKeys("Finger Ring");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-meta-title1']")).sendKeys("Finger Ring for ladies");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;		
		js1.executeScript("window.scrollBy(0,-500)");
		driver.findElement(By.linkText("Data")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-model']")).sendKeys("SKU-012");
		Thread.sleep(3000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//input[@id = 'input-price']")).sendKeys("500");
		driver.findElement(By.xpath("//input[@id = 'input-quantity']")).sendKeys("50");
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-200)");
		driver.findElement(By.linkText("Links")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'input-category']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Earrings']")).click();
		driver.findElement(By.linkText("Discount")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary' and @onclick = 'addDiscount();']")).click();
		//driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		driver.findElement(By.xpath("//input[@class = 'form-control' and @name = 'product_discount[0][quantity]']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@class = 'form-control' and @name = 'product_discount[0][price]']")).sendKeys("50");
		driver.findElement(By.xpath("//input[@class = 'form-control'  and @name = 'product_discount[0][date_start]']")).sendKeys("2019-06-19");
		driver.findElement(By.xpath("//input[@class = 'form-control'  and @name = 'product_discount[0][date_end]']")).sendKeys("2019-06-20");
		Thread.sleep(3000);
		//driver.findElement(By.linkText("Reward Points")).click();
		driver.findElement(By.xpath("//a[@href = '#tab-reward']")).click();
		driver.findElement(By.xpath("//input[@id = 'input-points']")).sendKeys("20");
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary' and @form = 'form-product']")).click();
		
 
		
	

	}

}
