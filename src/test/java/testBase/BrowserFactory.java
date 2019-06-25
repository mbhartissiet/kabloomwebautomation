package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public WebDriver getBrowser(String browserName){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("CHROME")){
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("FIREFOX")){
			driver = new FirefoxDriver();
		}
		//maximum time to wait for web element
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//maximum time to wait page to load 
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}

}
