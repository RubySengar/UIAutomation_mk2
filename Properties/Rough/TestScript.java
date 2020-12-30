package Rough;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {
	
	WebDriver driver;
	
	
	public void LaunchTest() throws IOException {
		
		  Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");                                                                                                                                                                    
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Softwares\\Chromedriver_83\\chromedriver.exe");
		  driver = new  ChromeDriver();
		  driver.manage().window().maximize();
		  
		  driver.navigate().to("https://joinindianarmy.nic.in/Authentication.aspx");
		  
			/*
			 * File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 * FileUtils.copyFile(f, new File(""));
			 */
		  
			
			  TakesScreenshot scrShot =((TakesScreenshot)driver); File
			  SrcFile=scrShot.getScreenshotAs(OutputType.FILE); File DestFile=new File("");
			  //FileUtils.copyFile(SrcFile, DestFile);
			  
			 
	}

}
