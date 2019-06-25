package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Account_Information_Page {
	
	private WebDriver driver = null;
	
	@FindBy(how=How.XPATH,using="//*[@id='firstname']")
	private WebElement firstname;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='lastname']")
	private WebElement lastname;
	
	@FindBy(how=How.XPATH,using="//*[@id='change_password']")
	private WebElement change_password_checkbox;
	
	@FindBy(how=How.XPATH,using="//*[@class='buttons-set']/p[2]/following-sibling::button")
	private WebElement save_btn;
	
	@FindBy(how=How.XPATH,using="//*[@id='current_password']")
	private WebElement current_password;
	
	@FindBy(how=How.XPATH,using="//*[@id='password']")
	private WebElement new_password;
	
	@FindBy(how=How.XPATH,using="//*[@id='confirmation']")
	private WebElement confirm_password;
	
	public void setFirstName(String name){
		firstname.clear();
		firstname.sendKeys(name);
	}
	public void setLastName(String name){
		lastname.clear();
		lastname.sendKeys(name);
	}
	public void setPassword(String password){
		current_password.sendKeys(password);
	}
	
	public void setNewPassword(String password){
		new_password.sendKeys(password);
	}
	public void setConfirmPassword(String password){
		confirm_password.sendKeys(password);
	}
	public void clickOnCheckBox(){
		change_password_checkbox.click();
	}
	public My_Account_Page clickOnSaveButton(){
		save_btn.click();
		My_Account_Page my_account_page = new My_Account_Page(driver);
		return my_account_page;
	}
	
	public void changeProfileName(String firstName,String lastName){
		setFirstName(firstName);
		setLastName(lastName);
		clickOnSaveButton();
	}
	public void changePassword(String password,String newPassword,String confirmPassword){
		setPassword(password);
		setNewPassword(newPassword);
		setConfirmPassword(confirmPassword);
		clickOnSaveButton();
		
		
	}
	public Account_Information_Page(WebDriver driver){
		
		this.driver = driver;
	    PageFactory.initElements(driver, this);
		
	}

}
