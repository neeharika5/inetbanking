package com.inetbanking.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass {
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		
			
		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		log.info("username enterd successfully");
		
		Thread.sleep(2000);
		lp.setpassword(password);
		log.info("password entered successfully");
		Thread.sleep(2000);
		lp.clicklogin();
		log.info("clicked successfully");
		
		Thread.sleep(1000);
		
		Assert.assertTrue(lp.validatetitle());
		log.info("successfully validated");
		
		
		}

}
