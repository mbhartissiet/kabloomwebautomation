package com.testscript;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kabloom.flower.type.repository.Best_Sellers_Page;
import com.kabloom.flower.type.repository.Flower_Type_Sunflowers;
import com.kabloom.flower.type.repository.Flower_Types_Daisies;
import com.kabloom.flower.type.repository.Flower_Types_Iris;
import com.kabloom.flower.type.repository.Flower_Types_Lilies;
import com.kabloom.flower.type.repository.Flower_Types_Roses;
import com.kabloom.occassian.repository.Annivarsary_Page;
import com.kabloom.occassian.repository.For_The_Home_Page;
import com.kabloom.occassian.repository.Wedding_Page;
import com.kabloom.page.repository.Add_To_Cart_Page;
import com.kabloom.page.repository.CheckOut_Billing_Information_Page;
import com.kabloom.page.repository.CheckOut_Payment_Information_Page;
import com.kabloom.page.repository.CheckOut_Personal_Message_Page;
import com.kabloom.page.repository.CheckOut_Shipping_Information_Page;
import com.kabloom.page.repository.HomePage;
import com.kabloom.page.repository.LoginPage;
import com.kabloom.page.repository.My_Account_Page;
import com.kabloom.page.repository.Order_Review_Page;
import com.kabloom.page.repository.Shopping_Cart_Page;
import com.kabloom.plant.Plant;
import com.kabloom.testscript.BookwithoutLogin;
import com.relevantcodes.extentreports.LogStatus;

import pageobjectrepository.ExtentFactory;
import testBase.BrowserFactory;
import testBase.Configuration;
import testBase.Driver;
import testBase.TestBase;
import utils.ReadpropertiesUtils;




        public class Test1 extends TestBase{
	     
	      //WebDriver driver;
        
      
         
         @Test(priority = 1)
         public void LoginTest1() throws InterruptedException{
        	 HomePage homepage = new HomePage(Driver.driver);
        	 LoginPage loginpage= homepage.gotoLoginPage();
        	 Driver.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        	 //Thread.sleep(4000);
        	 //String str = Driver.driver.getTitle();
        	// Assert.assertEquals(str, "Customer Login");
        	
         }
        @Test(priority = 2)
         public void loginTest2(){
        	 LoginPage loginpage = new LoginPage();
        	 //My_Account_Page my_account_page=loginpage.logInLotheApplication("maheshssietece@gmail.com" , "yuvraj");
        	 Driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        	 //String str = Driver.driver.getTitle();
        	// Assert.assertEquals(str, "My Account");
        	 
        	 
        	 
         }
        @Test(priority = 3)
        public void test1() throws InterruptedException{
        	
        	/*Flower_Type_Sunflowers flower_type_sunflowers = new Flower_Type_Sunflowers(Driver.driver);
        	flower_type_sunflowers.clickOnFlowertype();
        	 Driver.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        	Thread.sleep(4000);
        	flower_type_sunflowers.clickOnSunflowers();
        	String str =Driver.driver.getTitle();
        	assertTrue(Driver.driver.getTitle().contains("Buy Fresh Sunflower Bouquets Online"));*/
        	/*HomePage homepage = new HomePage(Driver.driver);
        	Plant plant = new Plant(Driver.driver);
        	homepage.clickOnPlant();
        	Thread.sleep(4000);
        	plant.selectPlant();*/
        	/*Flower_Types_Daisies flower_types_daisies = new Flower_Types_Daisies(Driver.driver);
        	flower_types_daisies.clickOnFlowertype();
        	//Driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        	Thread.sleep(4000);
        	flower_types_daisies.clickOnDaisies();
        	Driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        	assertTrue(Driver.driver.getTitle().contains("Online Delivery of Fresh Daisies Flower Arrangements"));
        	flower_types_daisies.selectFlower(Driver.driver);
        	Driver.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        	String str1 =Driver.driver.getTitle();
        	System.out.println(str1);
        	assertTrue(Driver.driver.getTitle().contains("Purchase Bountiful Bouquet of Assorted Daisies Online"));*/
        	/*Flower_Types_Iris flower_types_iris = new Flower_Types_Iris(Driver.driver);
        	flower_types_iris.clickOnFlowertype();
        	Thread.sleep(4000);
        	flower_types_iris.clickOnIris();
        	flower_types_iris.selectFlower(Driver.driver);
        	Flower_Types_Lilies flower_types_lilies = new Flower_Types_Lilies(Driver.driver);
        	flower_types_lilies.clickOnFlowertype();
        	Thread.sleep(4000);
        	flower_types_lilies.clickOnlilies();
        	flower_types_lilies.selectFlower();*/
        	/*Flower_Types_Roses flower_types_roses = new Flower_Types_Roses(Driver.driver);
        	flower_types_roses.clickOnFlowertype();
        	Thread.sleep(4000);
        	flower_types_roses.clickOnRoses();
        	flower_types_roses.selectFlower();*/
        	/*Annivarsary_Page annivarsary_page = new Annivarsary_Page(Driver.driver);
        	annivarsary_page.clickOnOccasions();
        	Thread.sleep(4000);
        	annivarsary_page.clickOnAnniversary();
        	annivarsary_page.selectFlower();
        	For_The_Home_Page for_the_home_page = new For_The_Home_Page(Driver.driver);
        	for_the_home_page.clickOnOccasions();
        	Thread.sleep(4000);
        	for_the_home_page.clickOnFor_the_home();
        	for_the_home_page.selectFlower();*/
        	Wedding_Page wedding_page = new Wedding_Page(Driver.driver);
        	wedding_page.clickOnOccasions();
        	Thread.sleep(4000);
        	wedding_page.clickOnWedding();
        	wedding_page.selectFlower();
        }
        @Test(priority=4)
        public void selectDateForDelivery() throws InterruptedException{
        	
        	Add_To_Cart_Page add_to_cart_page = new Add_To_Cart_Page(Driver.driver);
        	//add_to_cart_page.setZipcode( Configuration.Zipcode.zipcode);
        	//Thread.sleep(3000);
        	//add_to_cart_page.clickOncalendar();
        	//Thread.sleep(3000);
        	add_to_cart_page.selectDate();
        	Thread.sleep(5000);
        	add_to_cart_page.clickOnAddToCartButton();
        	Thread.sleep(3000);
        	add_to_cart_page.clickOnViewCartandCheckout();
        	
        }
        @Test(priority=5)
        public void applyCoupon() throws InterruptedException{
        	Shopping_Cart_Page shopping_cart_page = new Shopping_Cart_Page(Driver.driver);
        	shopping_cart_page.insertCouponcode(Configuration.Coupon.coupon);
        	Thread.sleep(3000);
        	shopping_cart_page.clickOnApplyCoupon();
        	shopping_cart_page.clickOnProceedToCheckout();
        	
        }
        @Test(priority=6)
        public void fillupShippingAddress() throws InterruptedException{
        	CheckOut_Shipping_Information_Page CheckOut_Shipping_Information_Page = new CheckOut_Shipping_Information_Page(Driver.driver);
        	CheckOut_Billing_Information_Page checkOut_billing_information_page = CheckOut_Shipping_Information_Page.clickOnContinue();
        	Thread.sleep(5000);
        	checkOut_billing_information_page.clickOnContinue();
        	Thread.sleep(5000);
        }
        @Test(priority=7)
        public void enterPersonalmessage() throws InterruptedException{
        	CheckOut_Personal_Message_Page checkOut_personal_message_page = new CheckOut_Personal_Message_Page(Driver.driver);
        	checkOut_personal_message_page.setTextMessage(Configuration.Message.message);
        	Thread.sleep(3000);
        	checkOut_personal_message_page.clickOnContinue();
        	Thread.sleep(5000);
        }
        @Test(priority=8)
        public void paymentIformation() throws InterruptedException{
        CheckOut_Payment_Information_Page checkOut_payment_information_page = new CheckOut_Payment_Information_Page(Driver.driver);
        Order_Review_Page order_review_page=checkOut_payment_information_page.clickOncontinue();
        Thread.sleep(6000);
        order_review_page.placeOrder();
        
        }
}
        


