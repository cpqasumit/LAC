package com.cp.lilyanncabinets.lilyanncabinets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test {
	
 
 public static WebDriver driver;
 
 public XSSFSheet sheet=null;
 public XSSFWorkbook wrkbook=null;
 
	public static void main(String []args) {
		try
		{
			System.out.println("Hey Sumit :- Chrome browser is opening for LAC ");
		
			driver = new ChromeDriver();
			
			//https://www.lilyanncabinets.com/grey-shaker-elite-kitchen-cabinets.html (262)	
			//driver.get("http://www.lilyanncabinets.com/bristol-chocolate-kitchen-cabinets.html");
			// https://www.lilyanncabinets.com/york-driftwood-grey-kitchen-cabinets.html (256)
			driver.get("https://www.lilyanncabinets.com/grey-shaker-elite-kitchen-cabinets.html");
			
			
			Thread.sleep(3000);
			
			// java script executer for scroll down the window 
			JavascriptExecutor jse = ((JavascriptExecutor) driver);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(10000);
			
	
	
			// Loop for collecting all product name 
			List<WebElement> proName = driver.findElements(By.xpath("//div[@class='pro-listing-left']/..//h4[@class='product-name']"));
			System.out.println(proName.size());
			
			for (int i = 0; i < proName.size(); i++) {
				System.out.println(proName.get(i).getText());
				
				
			}
			
			
			//-------------
			
			Thread.sleep(5000);
		
			File src=new File("E:\\TestProject_Git\\LAC\\lilyanncabinets\\Test.xls");
			FileInputStream fis=new FileInputStream(src);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sh1= wb.getSheetAt(0);
			
			System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
			 
			 System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());
			 
			 System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
			 
			 System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());
			 
			 System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
			 
			 System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());
			
			
			
			
			
			
			
			
			//----
			
			
			
			
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
}
