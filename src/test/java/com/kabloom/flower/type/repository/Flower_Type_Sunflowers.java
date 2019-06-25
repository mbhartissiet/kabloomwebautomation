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
import com.kabloom.page.repository.HomePage;

import testBase.Driver;

public class Flower_Type_Sunflowers {
	//public Actions actions;
	public static Logger log = Logger.getLogger(Flower_Type_Sunflowers.class);
	
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/span")
	 private WebElement flower_types;
	  
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[3]/ul/li[4]/a/span")
	 private WebElement sunflowers;
	 
	 @FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	 public List<WebElement> product_image;
	 
	 public Flower_Type_Sunflowers clickOnFlowertype(){
		 flower_types.click(); 
		 Flower_Type_Sunflowers flower_type_sunflowers = new Flower_Type_Sunflowers(Driver.driver);
		 return flower_type_sunflowers;
	 }
	 public void clickOnSunflowers(){
		
		 Actions actions = new Actions(Driver.driver);
		 actions.moveToElement(flower_types).moveToElement(sunflowers).click().build().perform();
	 }
	 
	 public Flower_Type_Sunflowers(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	 }
	 
	 
	 public Add_To_Cart_Page selectFlower() throws InterruptedException
		{   
		    clickOnSunflowers();
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
	

}
