package com.kabloom.page.repository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Personal_Message_Page {
	
	   private WebDriver driver=null;
	   
	   @FindBy(how=How.XPATH,using="//*[@class='details']/div[1]/ul//*[@class='wide']/div[1]/textarea")
	   private WebElement message_box;
	   
	   @FindBy(how=How.XPATH,using="//*[@id='checkout-step-shipping_method']/form//*[@id='shipping-method-buttons-container']/button/span")
	   private WebElement continue_btn;
	   
	   
	   public void setTextMessage(String message) throws InterruptedException{
		   message_box.sendKeys(Keys.ENTER);
		   Thread.sleep(3000);
		   message_box.sendKeys(message);
		   
	   }
	   
	   public CheckOut_Payment_Information_Page clickOnContinue(){
		   continue_btn.click();
		   CheckOut_Payment_Information_Page checkOut_payment_information_page = new CheckOut_Payment_Information_Page(driver);
		   return checkOut_payment_information_page;
	   }
       public CheckOut_Personal_Message_Page(WebDriver driver){
    	   this.driver = driver;
	       PageFactory.initElements(driver, this);
       }
}
