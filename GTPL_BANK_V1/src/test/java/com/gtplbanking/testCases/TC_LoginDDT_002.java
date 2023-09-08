package com.gtplbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gtplbanking.pageObjects.LoginPage;

import jxl.Sheet;
import jxl.Workbook;

public class TC_LoginDDT_002 extends BaseClass {
	
	Workbook w;
	Sheet s;
	int rw;

	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			captureScreen(driver,"loginDDT");
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() 
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
	
	@DataProvider
	public Object[][] LoginData() {
	    try {
	    w = Workbook.getWorkbook(new File("C:\\Mohit\\GTPL_BANK_V1\\src\\test\\java\\com\\gtplbanking\\testData\\demobank.xls"));
	    s = w.getSheet(0);
	  }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	    Object[][] a = new Object[s.getRows()][s.getColumns()];
	    for(int i=0; i<s.getRows(); i++) {
	        for(int j=0; j<s.getColumns(); j++) {
	            a[i][j] = s.getCell(j , i).getContents();
	        }
	    }
	  return a;
	}

}
