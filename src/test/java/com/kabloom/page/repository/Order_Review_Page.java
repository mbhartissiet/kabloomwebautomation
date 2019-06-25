package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Order_Review_Page {
	
	WebDriver driver =null;
	
	@FindBy(how=How.XPATH,using="//*[@id='checkout-review-load']/div[2]/div[1]/p/following-sibling::button/span")
	private WebElement place_order;
	
	@FindBy(how=How.XPATH,using="//*[@id='review-buttons-container']/p/a")
	private WebElement edit_your_cart;
	
	public Shopping_Cart_Page editYourCart(){
		 edit_your_cart.click();
		 Shopping_Cart_Page shopping_cart_page = new Shopping_Cart_Page(driver);
		 return shopping_cart_page;
	}
	
	public void placeOrder(){
		place_order.click();
	}
	
	public Order_Review_Page(WebDriver driver){
		   this.driver = driver;
	       PageFactory.initElements(driver, this);
	}
	

}
