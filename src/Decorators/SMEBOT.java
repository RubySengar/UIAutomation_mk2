package Decorators;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SMEBOT {
	
	static  WebDriver driver ;
	static ExtentTest test;
	static ExtentReports report;
	
	public static void Extentreports() {
		
		report = new ExtentReports("C:\\Users\\Azad\\eclipse-workspace\\UIAutomation_mk2\\test-output\\Extentreports\\Smebot.html");
		test = report.startTest("ExtentDemo");
	 	test.log(LogStatus.PASS, "Navigated to the specified URL");
		report.endTest(test);
		report.flush();
		
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		  Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");                                                                                                                                                                    
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Softwares\\Chromedriver_87\\chromedriver.exe");
		  driver = new  ChromeDriver();
		  driver.get("https://creditcard-aiguat.democrance.com/broker/");
		  driver.manage().window().maximize();
		  Extentreports();
		  DemocranceLoginPageVerification();
		 // DemocranceHomePageValidation();
		  DemocranceReportExtraction();
		  DemocranceReportDownloading();
		  
		  test.log(LogStatus.PASS, "Navigated to the specified URL");

	}
	
	

	public  static void DemocranceLoginPageVerification() throws  InterruptedException{
		
		//driver = new ChromeDriver();		
		try {
			  (new WebDriverWait(driver,30)).until(ExpectedConditions.
                and(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']"))));   
			  WebElement Username = driver.findElement(By.xpath("//input[@name='username']"));
			  Username.sendKeys("azad.sengar@aig.com");	  
			
		  
		  	  (new WebDriverWait(driver,30)).until(ExpectedConditions.
	                and(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']"))));
			  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test12345!");			  
			  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			  
			  
		      driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();	
		      
		      System.out.println("Login page validated successfully");
		      test.log(LogStatus.PASS, "Login page verified successfully");
		     // additionalParams.getExtentTest().log(Status.INFO, "Login page validated successfully");
		}
		
	catch(Exception e) {
		
		e.printStackTrace();
	}		
			 
	}
	
	
	
	public static void DemocranceHomePageValidation() throws  InterruptedException{
		
		try {
			
			//Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			driver.navigate().refresh();
			
			test.log(LogStatus.PASS, "Home page verified successfully");
			
			//additionalParams.getExtentTest().log(Status.INFO, "Home page validated successfully");
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		} 
		
		
	}
	
	
	
	
	public static void DemocranceReportExtraction() throws  InterruptedException{
	
	
		try {
			////a[@role='button']/span[contains(text(),'20')]
			
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
			   LocalDateTime now = LocalDateTime.now();  
			   String date = dtf.format(now);
			   int date1 = Integer.parseInt(date);
			   date1-=1;
			   
			   String date2 = Integer.toString(date1);
			   
			 (new WebDriverWait(driver,30)).until(ExpectedConditions.
		                and(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),' Reports')]"))));
			driver.findElement(By.linkText("Reports")).click();
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@placeholder='Please select one']")).sendKeys("Sme Production Report");
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[contains(text(),'SME')]")).click();
			
			
			(new WebDriverWait(driver,30)).until(ExpectedConditions.
	                and(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@placeholder='dd/mm/yyyy'])[1]"))));
			driver.findElement(By.xpath("(//input[@placeholder='dd/mm/yyyy'])[1]")).click();

			
			/*
			 * driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			 * driver.findElement(By.xpath("//header[@class='datepicker-header']//i")).click
			 * ();
			 */
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@role='button']/span[contains(text(),"+date2+")]")).click();
			
			
			(new WebDriverWait(driver,30)).until(ExpectedConditions.
	                and(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@placeholder='dd/mm/yyyy'])[2]"))));
			driver.findElement(By.xpath("(//input[@placeholder='dd/mm/yyyy'])[2]")).click();
			
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//a[@role='button']/span[contains(text(),"+date2+")])[2]")).click();
			
			List<WebElement> alllnks = driver.findElements(By.tagName("a"));
			
			for(WebElement a : alllnks) {
				alllnks.size();
				System.out.println(a.getText());
			}
			
			test.log(LogStatus.PASS, "Report extracted successfully successfully");
			
			
			
			//additionalParams.getExtentTest().log(Status.INFO, "Report Extraction page validated successfully");
			
			
			
		}
		
	catch(Exception e) {
			
			e.printStackTrace();
		} 
		
		
		
	}
	
	
	
	
	public static void DemocranceReportDownloading() throws  InterruptedException{
		
		
		try {
			
			
			////a[contains(text(),'Generate')]			
			Thread.sleep(4000);
			WebElement gnbtn = driver.findElement(By.linkText("Generate"));
			
			Actions action = new Actions(driver);
			action.moveToElement(gnbtn).click().build().perform();
			
			test.log(LogStatus.PASS, "Report downloaded successfully");
			
			/*
			 * String autoITExecutable =
			 * "C:\\Users\\Softwares\\Chromedriver_87\\FileDownload.exe";
			 * //additionalParams.getExtentTest().log(Status.INFO,
			 * "Report is downloaded successfully");
			 * 
			 * Runtime.getRuntime().exec(autoITExecutable);
			 */
			
			/*
			 * Wait wait = new FluentWait(driver).withTimeout(30,
			 * TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
			 * 
			 * wait.until(ExpectedConditions.invisibilityOfElementLocated(""));
			 */
			
			
			
		}
		
	catch(Exception e) {
			
			e.printStackTrace();
		} 
		
		
		
	}
	
	
	
	 
	

}
