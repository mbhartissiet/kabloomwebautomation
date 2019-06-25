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

public class Flower_Types_Mixed_Bouquets {
	
	 
	 public static Logger log = Logger.getLogger(Flower_Types_Mixed_Bouquets.class);
	
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/span")
	 private WebElement flower_types;
	  
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/ul/li[8]/a/span")
	 private WebElement mixed_bouquets;
	 
	 @FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	 public List<WebElement> product_image;
	 
	 public Flower_Types_Mixed_Bouquets clickOnFlowertype(){
		 flower_types.click(); 
		 Flower_Types_Mixed_Bouquets flower_types_mixed_bouquets = new Flower_Types_Mixed_Bouquets(Driver.driver);
		 return flower_types_mixed_bouquets ;
	 }
	 public void clickOnMixed_Bouquets(){
		
		 Actions actions = new Actions(Driver.driver);
		 actions.moveToElement(flower_types).moveToElement(mixed_bouquets).click().build().perform();
	 }
	 
	 public Add_To_Cart_Page selectFlower() throws InterruptedException
		{   
		    clickOnMixed_Bouquets();
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
	

	 public Flower_Types_Mixed_Bouquets(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	 }

	 
   }
