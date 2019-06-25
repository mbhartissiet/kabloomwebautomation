package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class My_Order_Page {
	
	
	private WebDriver driver = null;
	
	public My_Order_Page(WebDriver driver){
		this.driver = driver;
	    PageFactory.initElements(driver, this);
		
	}

}
