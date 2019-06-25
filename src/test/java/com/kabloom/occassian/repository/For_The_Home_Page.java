package com.kabloom.occassian.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kabloom.page.repository.Add_To_Cart_Page;

import testBase.Driver;

public class For_The_Home_Page {
	
	
     public static Logger log = Logger.getLogger(For_The_Home_Page.class);
     @FindBy(how=How.XPATH,using="//*[@id='nav']/li[4]/span")
	 private WebElement occasions;
	  
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[4]/ul/li[5]/a/span")
	 private WebElement corporate_gifting;
	 
	 @FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	 public List<WebElement> product_image;
	 
	 public For_The_Home_Page clickOnOccasions(){
		 occasions.click(); 
		 For_The_Home_Page for_the_home_page = new For_The_Home_Page(Driver.driver);
		 return for_the_home_page;
	 }
	 public void clickOnFor_the_home(){
		
		 Actions actions = new Actions(Driver.driver);
		 actions.moveToElement(occasions).moveToElement(corporate_gifting).click().build().perform();
	 }
	 public Add_To_Cart_Page selectFlower() throws InterruptedException
		{   
		    clickOnFor_the_home();
		    Thread.sleep(3000);
			try
			{
		     	System.out.println(product_image.size());
				if (product_image.size() > 0) {
					for (WebElement option : product_image)
					{
						if(option.isEnabled()){
						String product_name=option.getAttribute("title");
						Thread.sleep(5000);
						option.click();
						log.info("Clicked on "+product_name+" ");
						System.out.println(product_name);
						}
						break;
					}
				}
				
			}catch(Exception e)
			{
				log.error("Unable to click on Product Image");
				 Assert.fail("Unable to click on Product Image");
			}
			
			Add_To_Cart_Page add_to_cart_page = new Add_To_Cart_Page(Driver.driver);
			return add_to_cart_page;
		}
	

	 
	   public For_The_Home_Page(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	    }
	 
	 
	 
	 
     }
