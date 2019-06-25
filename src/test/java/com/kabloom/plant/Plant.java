package com.kabloom.plant;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kabloom.page.repository.Add_To_Cart_Page;

import testBase.Driver;

public class Plant {
	
	public static Logger log = Logger.getLogger(Plant.class);
	
	@FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	public List<WebElement> all_image;
	
	/*@FindBy(how=How.XPATH,using="//*[@id='nav']/li[5]/a/span")
	private WebElement plant;
	*/
	/*public Plant clickOnPlant(){
		plant.click();
		Plant plant = new Plant(Driver.driver);
		return plant;
	}
	*/
	 public Plant(WebDriver driver){
		 Driver.driver = driver;
	     PageFactory.initElements(Driver.driver, this);
	 }
	 public Add_To_Cart_Page selectPlant() throws InterruptedException
		{   
		    
		   
			Thread.sleep(10000);
			try
			{
				List<WebElement> product_image = all_image;
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
