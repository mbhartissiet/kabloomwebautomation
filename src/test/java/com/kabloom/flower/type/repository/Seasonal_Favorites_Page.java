package com.kabloom.flower.type.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.Driver;

public class Seasonal_Favorites_Page {
	public static Logger log = Logger.getLogger(Seasonal_Favorites_Page.class);
	
	 @FindAll({@FindBy(xpath = "//*[@class='product-image']")})
	 public List<WebElement> all_image;  
	 
	 
	 public Seasonal_Favorites_Page(WebDriver driver){
		Driver.driver = driver;
	    PageFactory.initElements(Driver.driver, this);
	}
	 
	 public void selectFlower(WebDriver driver) throws InterruptedException
		{
		    //driver.findElement(By.xpath("//*[@id='nav']/li[1]/a/span")).click();
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
			
		}
	
     }
