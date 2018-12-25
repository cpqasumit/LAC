package com.cp.lilyanncabinets.lilyanncabinets;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test {
	
 //public static String driverPath = "src/main/resources/Framework/Drivers/Windows/chromedriver_win32_2.28/";
 public static WebDriver driver;
 
	public static void main(String []args) {
		try
		{
			System.out.println("launching chrome browser");
			//System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
				
			//driver.get("http://www.lilyanncabinets.com/bristol-chocolate-kitchen-cabinets.html");
			// https://www.lilyanncabinets.com/york-driftwood-grey-kitchen-cabinets.html (256)
			driver.get("https://www.lilyanncabinets.com/york-driftwood-grey-kitchen-cabinets.html");
			
			Thread.sleep(3000);
			
			JavascriptExecutor jse = ((JavascriptExecutor) driver);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(10000);
			
	
	
			
			List<WebElement> proName = driver.findElements(By.xpath("//div[@class='pro-listing-left']/..//h4[@class='product-name']"));
			System.out.println(proName.size());
			
			for (int i = 0; i < proName.size(); i++) {
				System.out.println(proName.get(i).getText());
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
