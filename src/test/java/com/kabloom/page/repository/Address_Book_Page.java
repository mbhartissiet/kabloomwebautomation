package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.Driver;

public class Address_Book_Page {
	
	//private WebDriver driver = null;
	
	@FindBy(how=How.XPATH,using="//*[@class='col-1 addresses-primary']/h2/following-sibling::ol/li[2]/h3/following-sibling::address/following-sibling::p/a")
	private WebElement change_shipping_address;
	
	 @FindBy(how=How.XPATH,using="//*[@class='col-1 addresses-primary']/h2/following-sibling::ol/li[1]/h3/following-sibling::address/following-sibling::p/a")
	 private WebElement change_billing_address;
	 
	public Address_Book_Page(WebDriver driver){
		Driver.driver = driver;
	    PageFactory.initElements(Driver.driver, this);
	}

}
