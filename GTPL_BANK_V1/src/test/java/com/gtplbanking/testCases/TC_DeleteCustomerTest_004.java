package com.gtplbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.gtplbanking.pageObjects.DeleteCustomerPage;
import com.gtplbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_DeleteCustomerTest_004 extends BaseClass{

	//Do you really want to delete this Customer?
	@Test
	public void deleteCustomer() throws InterruptedException, IOException {
		
		LoginPage lp=new LoginPage(driver);
		TC_AddCustomerTest_003 x=new TC_AddCustomerTest_003();
		DeleteCustomerPage d=new DeleteCustomerPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		d.clickDD();
		d.custID(x.customerID);
		logger.info("Customer ID is provided");
		d.clickDelete();
		String c= driver.switchTo().alert().getText();
		if(c.equals("Do you really want to delete this Customer?")) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed....");
			//captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
}
