package com.gtplbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	
	
WebDriver ldriver;
	
	public DeleteCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[4]/a")
	@CacheLookup
	WebElement clickdelete;
	
	@FindBy(how = How.XPATH, using ="/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input")
	@CacheLookup
	WebElement inputcustomerid;
	
	@FindBy(how = How.XPATH, using ="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input[1]")
	@CacheLookup
	WebElement submit;
	
	
	
	
	public void custID(String cid) {
		inputcustomerid.sendKeys(cid);
		
	}
	public void clickDelete() {
		submit.click();
			
	}
	
	public void clickDD() {
		clickdelete.click();
			
	}
	
}
