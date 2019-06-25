package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Order_Complition_Page {
	
	WebDriver driver = null;
	
	@FindBy(how =How.XPATH,using="//*[@class='button' and (@title='Continue Shopping')]")
	private WebElement continue_shopping;
	
	
	public HomePage clickOnContinueShopping(){
		continue_shopping.click();
		HomePage homepage = new HomePage(driver);
		return homepage;
	}
	public Order_Complition_Page(){
		   this.driver = driver;
	       PageFactory.initElements(driver, this);
	}
	

}
