package com.kabloom.flower.type.repository;

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


public class Flower_Types_Roses {
	
     public static Logger log = Logger.getLogger(Flower_Types_Roses.class);
    
     @FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/span")
	 private WebElement flower_types;
	  
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/ul/li[1]/a/span")
	 private WebElement roses;
	 
	 @FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	 public List<WebElement> product_image; 
	 
	 public Add_To_Cart_Page selectFlower() throws InterruptedException
		{   
		    
		    clickOnRoses();
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
	 
	    public void clickOnRoses(){
		
			 Actions actions = new Actions(Driver.driver);
			 actions.moveToElement(flower_types).moveToElement(roses).click().build().perform();
		 }
	     
	    public Flower_Types_Roses clickOnFlowertype(){
			 flower_types.click(); 
			 Flower_Types_Roses flower_types_roses = new Flower_Types_Roses(Driver.driver);
			 return flower_types_roses;
		 }
	   public Flower_Types_Roses(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	    }
	 
	 
	 
}
