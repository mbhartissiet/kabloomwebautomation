package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.Driver;

public class My_Account_Page {
	
	//private WebDriver driver=null;
	
	@FindBy(how=How.XPATH,using="//*[@class='block-content']/ul/li[1]/a")
	private WebElement account_dashboard;
	
	@FindBy(how=How.XPATH,using="//*[@class='block-content']/ul/li[2]")
	private WebElement account_information;
	
	
	@FindBy(how=How.XPATH,using="//*[@class='block-content']/ul/li[3]/a")
	private WebElement address_book;
	
	@FindBy(how=How.XPATH,using="//*[@class='block-content']/ul/li[4]/a")
	private WebElement my_order_page;
	
	
	
	public Account_Information_Page clickOnAccountInformation(){
		account_information.click();
		Account_Information_Page account_information_page = new Account_Information_Page(Driver.driver);
		return account_information_page;
	}
	
	public Address_Book_Page  clickOnAddressBook(){
		address_book.click();
		Address_Book_Page address_book_page=new Address_Book_Page (Driver.driver);
		return address_book_page;
	}
	
	public My_Order_Page clickOnMyOrder(){
		my_order_page.click();
		My_Order_Page my_order_page = new My_Order_Page(Driver.driver);
		return my_order_page;
		
	}
	public My_Account_Page clickOnAccountDashbord(){
		account_dashboard.click();
		My_Account_Page my_account_page = new My_Account_Page(Driver.driver);
		return my_account_page;
	}
	public My_Account_Page(WebDriver driver){
		Driver.driver = driver;
	    PageFactory.initElements(Driver.driver, this);
	}

}
