package com.gtplbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gtplbanking.pageObjects.AddCustomerPage;
import com.gtplbanking.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass
{
	
	public static String customerID;

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Mohit");
		addcust.custgender("male");
		addcust.custdob("10","10","1999");
		Thread.sleep(1000);
		addcust.custaddress("INDIA");
		addcust.custcity("Dhanbad");
		addcust.custstate("JHARKHAND");
		addcust.custpinno("838304");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef123");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		customerID=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}