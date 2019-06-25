package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shopping_Cart_Page {
	
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id='coupon_code']")
	private WebElement insert_coupon_text_box;
	
	@FindBy(xpath="//*[@id='discount-coupon-form']/div/div/div[2]/button[1]")
	private WebElement apply_coupon_btn;
	
	@FindBy(xpath="//*[@class ='button btn-continue' ][@title='Continue Shopping' ]")
	private WebElement continue_shopping_button;
	
	@FindBy(xpath ="//*[@id='shopping-cart-totals-table']/following-sibling::ul/li/button/span")
	private WebElement proceed_to_checkout_btn;
	
	@FindBy(xpath="//*[@class='button btn-update'][@title ='Update Cart' ]")
	private WebElement update_cart_btn;
	
	@FindBy(xpath="//*[@class='a-center item-product-quantity']/input[3]")
	private WebElement increase_item;
	
	@FindBy(xpath="//*[@class='checkout-edit']")
	private WebElement edit_product;
	
	@FindBy(xpath="//*[@class='a-center item-product-quantity']/input[1]")
	private WebElement decrease_item;
	
	@FindBy(xpath="//*[text()='delete']")
	private WebElement delete_item;
	
	
	public void insertCouponcode(String coupon){
		insert_coupon_text_box.sendKeys(coupon);
	}
	
	public void clickOnApplyCoupon(){
		apply_coupon_btn.click();
	}
	public void increaseItemOfTheCart(){
		increase_item.click();
	}
	
	public void decreaseItemOfTheCart(){
		decrease_item.click();
	}
	
	public HomePage clickOnContinueShopping(){
		continue_shopping_button.click();
		HomePage homepage = new HomePage(driver);
		return homepage;
	}
	
	public CheckOut_Shipping_Information_Page clickOnProceedToCheckout(){
		proceed_to_checkout_btn.click();
		CheckOut_Shipping_Information_Page checkout_shipping_information_page = new CheckOut_Shipping_Information_Page(driver);
		return checkout_shipping_information_page;
	}
	
	public void clickOnUpdateCartButton(){
		update_cart_btn.click();
	}
	
	public Add_To_Cart_Page editItemParameter(){
		edit_product.click();
		Add_To_Cart_Page add_to_cart_page = new Add_To_Cart_Page(driver);
		return add_to_cart_page;
	}
	
	public Shopping_Cart_Page(WebDriver driver){
		   this.driver = driver;
	       PageFactory.initElements(driver, this);
	}
	

}
