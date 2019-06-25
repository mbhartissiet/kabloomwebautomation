package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.kabloom.page.repository.HomePage;

public class TestBase {
	
	 @BeforeClass
     public void setUp() throws InterruptedException, IOException{
	 Driver.Intialize();
	 Driver.driver.get(Configuration.url.app_url);
	 Driver.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	 //Driver.driver.findElement(By.xpath("//*[@id='myModal']/div/div/span")).click();
	 
	 }

}
