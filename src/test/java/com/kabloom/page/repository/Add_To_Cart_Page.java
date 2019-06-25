package com.kabloom.page.repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import testBase.Configuration;
import testBase.Driver;
import testUtils.Excel_Reader;

    public class Add_To_Cart_Page {
	
	//private WebDriver driver;
	@FindBy(xpath="//*[starts-with(@id,'options_')][starts-with(@class,'validate-zipcode')]")
	private WebElement zipcode;
	
	@FindBy(xpath="//*[contains(@title,'Date') and (@class='required-entry-date validate-date input-text date_picker')]")
	private WebElement click_on_calendar;
	
	@FindBy(xpath="//*[contains(@style,'position: absolute; display: block')]")
	private WebElement date_picker;
	
	@FindAll({@FindBy(tagName = "td")})
	public List<WebElement> all_date;
	
	@FindBy(xpath="//*[@id='product_addtocart_form']/div[7]/div/button")
	private WebElement add_to_cart_button;
	
	@FindBy(xpath="//*[@id='added-content']/a[2]")
	private WebElement view_cart_and_checkout;
	
	@FindBy(xpath="//*[@id='hidewindow']")
	private WebElement continue_shopping;
	
	@FindBy(xpath="//*[@class='button btn-cart']")
	private WebElement update_cart;
	
	@FindAll({@FindBy(xpath = "//*[contains(@style,'position: absolute; display: block')]//*[@class='day disabled']")})
	public List<WebElement> disabledDate;
	
    public Add_To_Cart_Page(WebDriver driver){
	   
	   Driver.driver = driver;
       PageFactory.initElements(Driver.driver, this);
    }
   
    public void setZipcode(String zipCode){
    	zipcode.sendKeys(zipCode);
    }
    
    public void clickOncalendar(){
    	click_on_calendar.click();
    }
    
    public void clickOnAddToCartButton(){
    	add_to_cart_button.click();
    }
    
    public Shopping_Cart_Page clickOnUpdateCart(){
    	update_cart.click();
    	Shopping_Cart_Page shopping_cart_page = new Shopping_Cart_Page(Driver.driver);
		return shopping_cart_page;
    }
    
    public Shopping_Cart_Page clickOnViewCartandCheckout(){
    	view_cart_and_checkout.click();
    	Shopping_Cart_Page shopping_cart_page = new Shopping_Cart_Page(Driver.driver);
		return shopping_cart_page;
    }
    
    public void clickOnContinueShopping(){
    	continue_shopping.click();
    }
    
    public void selectDate() throws InterruptedException{
		Date d = new Date();
		 SimpleDateFormat dt = new SimpleDateFormat("MM/d/yyyy");
		 //PropertiesReader pr = new PropertiesReader();
	     String zip;
	     String zip1;
	    // String path = "C:\\Users\\Kabloom\\Desktop\\Zipcode.xslx";
		// Excel_Reader obj = new Excel_Reader(path);
		 String currentDate=dt.format(d);
		 System.out.println(currentDate);
		 System.out.println("Current Date: " + dt.format(d));
	
		    String  udate,umonth,uyear;
			
			udate= Integer.toString(d.getDate()+1);
			System.out.println("Hi i am udate" +udate);
			umonth=Integer.toString(d.getMonth()+1);
			uyear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
			String modifiedDate=umonth+"/"+udate+"/"+uyear;
			System.out.println("This is the modified date...." +modifiedDate);
		String[] split = currentDate.split("/");
		System.out.println(split[0]+" " +split[1]+" " +split[2]);
		String[] split1 = modifiedDate.split("/");
		System.out.println(split1[0]+" " +split1[1]+" " +split1[2]);
		//String month = split[0]+", "+split[2];
		//System.out.println("month--------"+month);
		System.out.println(split[1]);
		System.out.println(split1[1]);
		zip = Configuration.Zipcode.zipcode;
		setZipcode(zip);
		Thread.sleep(5000);
		 String path = "C:\\Users\\Kabloom\\Desktop\\Zipcode.xlsx";
		 Excel_Reader excelzipcode= new Excel_Reader(path);
	   
		
		
	        	while(true){
			    try{
			    	clickOncalendar();
			    	 Thread.sleep(5000);
			    	 
			        
			         List<WebElement>   dates = all_date;
			      //   List list = ArrayList(dates);
			         int count = dates.size();
			         System.out.println(count);
			         for(WebElement date1 :dates){
			        	String str= date1.getText();
			        	 
			        	for(WebElement disabledDate1: disabledDate){
				        	String strdis =disabledDate1.getText();
				        	if(str.equalsIgnoreCase(strdis)){
				        		Calendar c = Calendar.getInstance();
				        		c.setTime(dt.parse(currentDate));
				        		c.add(Calendar.DATE, 1);
				        		currentDate = dt.format(c.getTime()); 
				        		
				        		
				        	}
				        	
				         }
			        	
			        	 for(int i=2;i<=129;i++){
			        	 zip1 =excelzipcode.getCellData("Sheet1", "zipcode", i);
			        	 if(zip1.equalsIgnoreCase(zip)){
			        		 if(str.equalsIgnoreCase(split[1])){
			        			 date1.click();
			        		 }
			        	 }else{
			        		 if(str.equalsIgnoreCase(split1[1])){
			        			 date1.click();
			        		 }
			        	 }
			        	 }
			        		 
			        	 
			        	
			                      }
			                    	  
			                      
			         }
		         	
			     catch(Exception e){
				 
			     }
	        break;
	      }
	}
}
