package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOut_Payment_Information_Page {

	WebDriver driver = null;
	 
	@FindBy(how=How.XPATH,using="//*[@id='payment-buttons-container']/button")
	private WebElement continue_btn;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='firstdataglobalgateway_cc_type']")
	private WebElement credit_card_type;
	
	@FindBy(how=How.XPATH,using="//*[@id='firstdataglobalgateway_cc_number']")
	private WebElement credit_card_number;
	
	@FindBy(how=How.XPATH,using="//*[@id='firstdataglobalgateway_expiration']")
	private WebElement expiratio_date_month;
	
	@FindBy(how=How.XPATH,using="//*[@id='firstdataglobalgateway_expiration_yr']")
	private WebElement expiratio_date_year;
	
	@FindBy(how=How.XPATH,using="//*[@id='firstdataglobalgateway_cc_cid']")
	private WebElement cvn;
	
	public void setcardVerificationNumber(String CVN){
		cvn.sendKeys(CVN);
	}
	
	public void setCreditCardNumber(String cardNumber){
		credit_card_number.sendKeys(cardNumber);
	}
	
	public void selectTypeofCreditcard(int index){
		Select select = new Select(credit_card_type);
		select.selectByIndex(index);
	}
	
	public void selectExpirationMonth(int index){
		Select select = new Select(expiratio_date_month);
		select.selectByIndex(index);
	}
	
	public void selectExpirationYear(int index){
		Select select = new Select(expiratio_date_year);
		select.selectByIndex(index);
	}
	public Order_Review_Page clickOncontinue(){
		continue_btn.click();
		Order_Review_Page order_review_page = new Order_Review_Page(driver);
		return order_review_page;
	}
	public CheckOut_Payment_Information_Page(WebDriver driver){
		
		   this.driver = driver;
	       PageFactory.initElements(driver, this);
	}
}
