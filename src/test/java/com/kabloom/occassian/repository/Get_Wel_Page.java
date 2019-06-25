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

    public class Get_Wel_Page {
	
	 
     public static Logger log = Logger.getLogger(Get_Wel_Page.class);
    
     @FindBy(how=How.XPATH,using="//*[@id='nav']/li[4]/span")
	 private WebElement occasions;
	  
	 @FindBy(how=How.XPATH,using="//*[@id='nav']/li[4]/ul/li[6]/a/span")
	 private WebElement get_well;
	 
	 @FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	 public List<WebElement> product_image;
	 
	 
	 public Get_Wel_Page clickOnOccasions(){
		 occasions.click(); 
		 Get_Wel_Page get_wel_page = new Get_Wel_Page(Driver.driver);
		 return get_wel_page;
	 }
	 public void clickOnGet_well(){
		
		 Actions actions = new Actions(Driver.driver);
		 actions.moveToElement(occasions).moveToElement(get_well).click().build().perform();
	 }
	 public Add_To_Cart_Page selectFlower() throws InterruptedException
		{   
		    clickOnGet_well();
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
	

	 
	 public Get_Wel_Page(WebDriver driver){
		   Driver.driver = driver;
	       PageFactory.initElements(Driver.driver, this);
	 }
	 
	 
	
	 
      }
