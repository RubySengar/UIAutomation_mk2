package Decorators;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Locators.INDIANARMY_Locators;
import TestUtilities.TestData;

public class INDIANARMY_Decorators implements TestData {
	
	static  INDIANARMY_Locators ialocat = null;
	static ExtentTest test;
	static ExtentReports report;
	
	
	public static void Extentreports() {
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	
		
		
	}
	
	public static void indianArmyRegistration(WebDriver driver) {
		
		try {
			
			 System.out.println("Entered in decorators");
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Thread.sleep(10000);
			
			 WebElement enterbtn =  driver.findElement(By.xpath(ialocat.enterWebsiteBtn()));
			 
			 // ACTION CLASS
			 Actions action = new Actions(driver);
			 action.moveToElement(enterbtn).click().build().perform();
			 
			 
			 System.out.println("The Pop-Up says >> " +  driver.switchTo().alert().getText());
			 driver.switchTo().alert().accept();			 
				
			 driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
			 
			 // JAVASCRIPT EXECUTOR
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("window.scrollBy(0,250)");
			 
			
			 test.log(LogStatus.PASS, "Navigated to the specified URL");
			 
			 Assert.assertTrue(true);
			 
			 

		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	};
	
	
	
	
	public static void indianArmyLogin(WebDriver driver) {
		
		try {
			
						
			(new WebDriverWait(driver,20)).until(ExpectedConditions.
					  and(ExpectedConditions.presenceOfElementLocated(By.xpath(ialocat.loginLink()))));
			driver.findElement(By.xpath(ialocat.loginLink())).click();	
			
			
			
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	};
	
	
	
	
	public static void indianArmyUserValidation(WebDriver driver) {
		
		try {
			
			(new WebDriverWait(driver,20)).until(ExpectedConditions.
					  and(ExpectedConditions.presenceOfElementLocated(By.xpath(ialocat.userName()))));
			driver.findElement(By.xpath(ialocat.userName())).sendKeys(TestData.Data("username"));	
			driver.findElement(By.xpath(ialocat.passWord())).sendKeys(TestData.Data("password"));
			Thread.sleep(8000);
			
			(new WebDriverWait(driver,20)).until(ExpectedConditions.
					  and(ExpectedConditions.presenceOfElementLocated(By.xpath(ialocat.loginBtn()))));
			driver.findElement(By.xpath(ialocat.loginBtn())).click();
			
			
			 // System.out.println("The alert text is >> " +  driver.switchTo().alert().getText()); 
			  //driver.switchTo().alert();  Communication Details
			 	
			driver.switchTo().alert().accept();
			//Alert swt = driver.switchTo().alert();  ContentPlaceHolder1_UserProfile1_lnkCommunication
			
			
					
			(new WebDriverWait(driver,20)).until(ExpectedConditions.
					  and(ExpectedConditions.presenceOfElementLocated(By.xpath(ialocat.updateBtn()))));
			driver.findElement(By.xpath(ialocat.updateBtn())).click();
			
			driver.switchTo().alert().accept();
			
			System.out.println("The version detail is >>"  +  TestData.Data("detail"));
			
			JavascriptExecutor jse =  (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,400)");
			
    		
				 			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
	}






}
