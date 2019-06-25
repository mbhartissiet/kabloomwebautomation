package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.Driver;

public class CheckOut_Shipping_Information_Page {
	
	//private WebDriver driver;
    
	@FindBy(how=How.XPATH,using="//*[@id='shipping:firstname']")
	private WebElement setFirstname;
	
	@FindBy(xpath="//*[@id='shipping:middlename']")
	private WebElement middlename;
	
	@FindBy(how=How.XPATH,using ="//*[@id='shipping:lastname']")
	private WebElement setLastname;
	
	@FindBy(how = How.XPATH,using ="//*[@id='shipping:street3']")
	private WebElement location_type;
	
	@FindBy(how=How.XPATH,using="//*[@id='shipping:street1']")
	private WebElement address_line1;
	
	@FindBy(how = How.XPATH,using="//*[@id='shipping:street2']")
	private WebElement address_line2;
	
	@FindBy(how=How.XPATH,using="//*[@id='shipping:telephone']")
	private WebElement shipping_telephone;
	
	@FindBy(how=How.ID,using="shipping:same_as_shipping_check")
	private WebElement checkbox_for_use_this_address_for_billing;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='shipping-buttons-container']/button")
	private WebElement continue_btn;
	
	@FindBy(how=How.XPATH,using="//*[@id='shipping:company']")
	private WebElement bussiness_name;
	
	
	public void setFirstName(String firstName){
		setFirstname.sendKeys(firstName);
		
	}
	
	public void setMiddleName(String middleName){
		middlename.sendKeys(middleName);
		
	}
	
	public void setLastName(String lastName){
		setLastname.sendKeys(lastName);
		
	}
	
	public void setBussinessName(String bussinessname){
		bussiness_name.sendKeys(bussinessname);
	}
	
	public void selectAddressLocation(int index){
		Select select = new Select(location_type);
		select.selectByIndex(index);
		
	}
	
	public void setAddressline1(String address1){
		address_line1.sendKeys(address1);
		
	}
	
	public void setAddressline2(String address2){
		address_line2.sendKeys(address2);
		
	}
	
	public void setShippingTelephone(String number){
		shipping_telephone.sendKeys(number);
		
	}
	
	public void clickOnCheckboxUseThisAsBillingAddress(){
		checkbox_for_use_this_address_for_billing.click();
	}
	
	
	public CheckOut_Billing_Information_Page clickOnContinue(){
		continue_btn.click();
		CheckOut_Billing_Information_Page checkOut_billing_information_page= new CheckOut_Billing_Information_Page(Driver.driver);
		return checkOut_billing_information_page;
	}
	public CheckOut_Shipping_Information_Page(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	}
}
