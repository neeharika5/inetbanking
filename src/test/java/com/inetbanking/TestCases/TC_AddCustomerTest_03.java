package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_03 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		log.info("User name is provided");
		lp.setpassword(password);
		log.info("Passsword is provided");
		lp.clicklogin();
		
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		WebElement myelement = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		jse2.executeScript("arguments[0].scrollIntoView()", myelement );
		addcust.clickAddNewCustomer();
		
		log.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(2000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(2000);
		
		log.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("test case passed....");
			
		}
		else
		{
			log.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}