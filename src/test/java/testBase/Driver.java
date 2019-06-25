package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	
	public static WebDriver driver = null;
	//public static String browser ="ff";
	
	public static void Intialize(){
		if(driver==null){
			if(Configuration.Browser.browser.equalsIgnoreCase("ff")){
				System.setProperty("webdriver.gecko.driver", "F://geckodriver.exe");
				driver = new FirefoxDriver();
				
			}else if(Configuration.Browser.browser.equalsIgnoreCase("ie")){
				driver = new InternetExplorerDriver();
			}else if(Configuration.Browser.browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
				driver = new ChromeDriver();
			}
			
		}
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public static void close(){
		System.out.println("Closing the browser");
		driver.close();
		driver=null;
		
	}
	public static void quit(){
		System.out.println("Quiting the browser");
		driver.quit();
		driver=null;
	}

}
