package com.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.kabloom.page.repository.HomePage;

import testBase.Driver;
import testBase.TestBase;

public class Test2 extends TestBase{
    
	     @Test(priority = 1)
         public void LoginTest1(){
		 HomePage homepage = new HomePage(Driver.driver);
		 homepage.clickOnPouUp();
		 assertTrue(Driver.driver.getTitle().contains("Fresh Flowers Delivered in Water - Send Flowers and Plants Online"));
	 }
	
   }
