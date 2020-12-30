package Decorators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Locators.IRCTC_Locators;

public class IRCTC_Decorators {
	
	//static WebDriver driver ;
	static IRCTC_Locators ehilocat = null;
	
public static void IRCTCLogin(WebDriver driver) {
	

	 try { 
	  System.out.println("Entered in decorators");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  Thread.sleep(6000);
	  
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  
	  (new WebDriverWait(driver,20)).until(ExpectedConditions.
			  and(ExpectedConditions.presenceOfElementLocated(By.linkText(ehilocat.loginlink()))));
	  driver.findElement(By.linkText(ehilocat.loginlink())).click();
	  
	  (new WebDriverWait(driver,20)).until(ExpectedConditions.
			  and(ExpectedConditions.presenceOfElementLocated(By.xpath(ehilocat.userName()))));
	  driver.findElement(By.xpath(ehilocat.userName())).sendKeys("azadsengar");
	  
	  (new WebDriverWait(driver,20)).until(ExpectedConditions.
			  and(ExpectedConditions.presenceOfElementLocated(By.xpath(ehilocat.passWord()))));
	  driver.findElement(By.xpath(ehilocat.passWord())).sendKeys("Azad1234");
	  
	  Thread.sleep(15000);
	  
	  (new WebDriverWait(driver,20)).until(ExpectedConditions.
			  and(ExpectedConditions.presenceOfElementLocated(By.xpath(ehilocat.signInBtn()))));
	  driver.findElement(By.xpath(ehilocat.signInBtn())).click();
	
	  
	  
	  
	  
	  
	  
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
	
};




public static void exceldatareader(WebDriver driver) {
	
	try {
		
		File f = null;
		FileInputStream fis = null;
		
		//f = new File("C:\\Users\\Azad\\Desktop\\azad.xlsx");
		fis = new FileInputStream("C:\\Users\\Azad\\Desktop\\azad.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1   = wb.getSheetAt(0);
		String username = sh1.getRow(1).getCell(0).getStringCellValue();
		String pwd      = sh1.getRow(1).getCell(1).getStringCellValue();
		String pwd1     = sh1.getRow(1).getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
		
		
		
		System.out.println("Username is: " + username); 
		System.out.println("password is: " + pwd);
		System.out.println("password01 is: " + pwd1);
		
		
		
		
		
		
	}
 catch (Exception e) {
	
	e.printStackTrace();
}
	
	
}




public static void excelDataWriter(WebDriver driver) {
	
	try {
	
		File f1 = new File("C:\\Users\\Azad\\Desktop\\azad_Writer.xlsx");
		FileOutputStream fos = new FileOutputStream(f1);
		
		XSSFWorkbook wb1 = new XSSFWorkbook();
		XSSFSheet sh2    = wb1.createSheet("Ruby");
		sh2.createRow(0).createCell(0).setCellValue("USERNAME");
		sh2.getRow(0).createCell(1).setCellValue("PASSWORD");
		/*
		 * System.out.println("Last cell no. is -> " + sh2.getRow(1).getLastCellNum());
		 * System.out.println("Last Row No. is -> " + sh2.getLastRowNum());;
		 */
		
		
		wb1.write(fos);
		fos.close();
		wb1.close();
		
		//f1.delete();
		   
		
	}
 catch (Exception e) {
	
	e.printStackTrace();
}
	
	
}



}
