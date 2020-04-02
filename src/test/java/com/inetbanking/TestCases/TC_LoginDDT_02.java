package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtils;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginDDT_02  extends BaseClass{

	
	@Test(dataProvider="LoginData")
	public void getdata(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setusername(user);
		log.info("user name provided");
		Thread.sleep(2000);
		lp.setpassword(pwd);;
		log.info("password provided");
		Thread.sleep(2000);
		lp.clicklogin();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			log.info("Login passed");
			Thread.sleep(2000);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	   {
		
		String path = "C:/Users/sande/eclipse-workspace1/inetbanking/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
		
		int rownum= XLUtils.getRowCount(path, "sheet1");
		int columncount = XLUtils.getCellCount(path, "sheet1", 1);
		 
		String logindata[][] = new String[rownum][columncount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i,j );
			}
		}
		return logindata;
	}
}
