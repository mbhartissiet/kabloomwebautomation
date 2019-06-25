package com.kabloom.page.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.kabloom.flower.type.repository.Best_Sellers_Page;
import com.kabloom.flower.type.repository.Flower_Type_Sunflowers;
import com.kabloom.flower.type.repository.Seasonal_Favorites_Page;
import com.kabloom.plant.Plant;

import testBase.Driver;

public class HomePage {

	//private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[@id='nav']/li[1]/a")
	private WebElement seasonal_favorites;
	
	@FindBy(how=How.XPATH,using="//*[@id='nav']/li[2]/a/span")
	private WebElement best_seller;
	
	@FindBy(how=How.XPATH,using ="//*[@id='myModal']/div/div/span")
	private  WebElement pop_up;
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li/span")
	private WebElement account;
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li/ul/li[2]/a")
	private WebElement login;
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li/ul/li[1]/a")
	private WebElement create_account;
	
	@FindBy(how=How.XPATH,using="//*[@id='nav']/li[5]/a/span")
	private WebElement plant;
	
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/a")
	private WebElement sustainability;
	
	@FindBy(how=How.XPATH,using="html/body/div[2]/div/div[2]/div[2]/div[1]/div[2]/div[1]/span/a")
	private WebElement cart;
	
	@FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/span")
	private WebElement flowers;
	
	@FindBy(how=How.XPATH,using="//*[@id='nav']/li[4]/span")
	private WebElement occassions;
	
	@FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/ul/li[4]/a/span")
	private WebElement sunflower;
	
	public Plant clickOnPlant(){
		plant.click();
		Plant plant = new Plant(Driver.driver);
		return plant;
	}
	
	public Seasonal_Favorites_Page clickOnSeasonalFavorites(){
		seasonal_favorites.click();
		Seasonal_Favorites_Page seasonal_favorites_page = new Seasonal_Favorites_Page(Driver.driver);
		return seasonal_favorites_page;
	}
	public Best_Sellers_Page clickOnBestseller(){
		best_seller.click();
		Best_Sellers_Page best_sellers_page = new Best_Sellers_Page(Driver.driver);
		return best_sellers_page;
	}
	public Flower_Type_Sunflowers clickOnSunflower(){
		Actions actions = new Actions(Driver.driver);
		actions.moveToElement(flowers).moveToElement(sunflower).click().build().perform();
		Flower_Type_Sunflowers flower_type_sunflowers = new Flower_Type_Sunflowers(Driver.driver);
		return flower_type_sunflowers;
	}
	public  void clickOnPouUp(){
		pop_up.click();
	}
	
	public LoginPage gotoLoginPage(){
		clickOnPouUp();
		Actions actions = new Actions(Driver.driver);
		actions.moveToElement(account).moveToElement(login).click().build().perform();
		LoginPage loginpage = new LoginPage();
		return loginpage;
	}
	public HomePage(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	}
}
