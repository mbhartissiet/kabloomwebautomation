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

    public class New_Baby_Page {

	
     public static Logger log = Logger.getLogger(New_Baby_Page.class);
	 
     @FindBy(how=How.XPATH,using="//*[@id='nav']/li[4]/span")
	 private WebElement occasions;
	  
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[4]/ul/li[8]/a/span")
	 private WebElement new_baby;
	 
	 @FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	 public List<WebElement> product_image;
	 
	 
	 public New_Baby_Page clickOnOccasions(){
		 occasions.click(); 
		 New_Baby_Page new_baby_page = new New_Baby_Page(Driver.driver);
		 return new_baby_page;
	 }
	 public void clickOnNewBaby(){
		
		 Actions actions = new Actions(Driver.driver);
		 actions.moveToElement(occasions).moveToElement(new_baby).click().build().perform();
	 }
	 public Add_To_Cart_Page selectFlower() throws InterruptedException
		{   
		    clickOnNewBaby();
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
	

	 
	  public New_Baby_Page(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	    }
	 
 
    }
