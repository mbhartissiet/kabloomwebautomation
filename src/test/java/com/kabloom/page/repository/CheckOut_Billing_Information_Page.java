package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOut_Billing_Information_Page {
	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:firstname']")
	private WebElement billing_firstName;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:middlename']")
	private WebElement billing_middleName;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:lastname']")
	private WebElement billing_lastName;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:email']")
	private WebElement billing_email;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:street1']")
	private WebElement billing_address1;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:street2']")
	private WebElement billing_address2;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:city']")
	private WebElement billing_city;
	
	@FindBy(how=How.ID,using="billing:postcode")
	private WebElement billing_zipcode;
	
	@FindBy(how=How.NAME,using="billing[telephone]")
	private WebElement billing_telephone;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:region_id']")
	private WebElement select_province;
	
	@FindBy(how=How.XPATH,using="//*[@id='subscribe']")
	private WebElement uncheck_checkbox_signupforkabloom;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='login:register']")
	private WebElement uncheck_checkbox_register_with_us;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:customer_password']")
	private WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id='billing:confirm_password']")
	private WebElement confirm_password;
	
	@FindBy(how=How.XPATH,using="//*[@id='co-billing-form']/fieldset/ul/following-sibling::div[1]/button/span")
	private WebElement billing_continue;
	
	public void setFirstName(String firstname){
		
		billing_firstName.sendKeys(firstname);
	}
	
    public void setMiddleName(String middlename){
		
		billing_firstName.sendKeys(middlename);
	}
	
    public void setLastName(String lastname){
		
		billing_firstName.sendKeys(lastname);
	}
    
    public void setbillingEmail(String email){
		
    	billing_email.sendKeys(email);
	}
    
    public void setBillingzipcode(String zipcode){
    	billing_zipcode.sendKeys(zipcode);
    }
    
    public void setBillingtelephone(String telephone){
    	billing_telephone.sendKeys(telephone);
    }
    public void setBillingcity(String city){
    	billing_city.sendKeys(city);
    }
    
    public void setBillingaddress1(String address1){
    	billing_address1.sendKeys(address1);
    }
    
    public void setBillingaddress2(String address2){
    	billing_address1.sendKeys(address2);
    }
    public void selectProvince(int index){
    	Select select = new Select(select_province);
    	select.selectByIndex(index);
    }
    public void uncheckSignUpCheckbox(){
    	
    	uncheck_checkbox_signupforkabloom.click();
    }
    public void uncheckRegisterCheckbox(){
    	
    	uncheck_checkbox_register_with_us.click();
    }
    public void setPassword(String password){
    	this.password.sendKeys(password);
    }
    public void setConfirmPassword(String password){
    	confirm_password.sendKeys(password);
    }
    public CheckOut_Personal_Message_Page clickOnContinue(){
    	billing_continue.click();
    	CheckOut_Personal_Message_Page checkOut_personal_message_page=new CheckOut_Personal_Message_Page(driver);
		return checkOut_personal_message_page;
    }
    public CheckOut_Billing_Information_Page(WebDriver driver){
	   this.driver = driver;
       PageFactory.initElements(driver, this);
   }
}
