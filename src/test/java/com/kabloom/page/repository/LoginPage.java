package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.Driver;

public class LoginPage {
	
	//private WebDriver driver= null;
	
	@FindBy(how=How.XPATH,using="//*[@id='email']")
	private WebElement username;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='pass']")
	private WebElement password;
	
	@FindBy(how=How.XPATH,using="//*[@id='send2']")
	private WebElement login;
	
	@FindBy(how=How.XPATH,using="//*[@class='f-left']")
	private WebElement forgot_password;
	
	public void setUserName(String email){
		 username.sendKeys(email);
	}
	
	public void setPassword(String Password){
		password.sendKeys(Password);
	}
	public  My_Account_Page clickOnlogin(){
		login.click();
		My_Account_Page my_account_page = new My_Account_Page(Driver.driver);
		return my_account_page;
	}
	
	public void logInLotheApplication(String username,String password){
		
		setUserName(username);
		setPassword(password);
		clickOnlogin();
		/*My_Account_Page my_account_page = new My_Account_Page(Driver.driver);
		return my_account_page;*/
		
	}
    public LoginPage(){
    	//Driver.driver = driver;
	    PageFactory.initElements(Driver.driver, this);
    }
}
