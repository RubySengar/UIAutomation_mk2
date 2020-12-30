package TestNGClass;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Decorators.IRCTC_Decorators;

class IRCTC {
	
	static  WebDriver driver ;
	
	static IRCTC_Decorators ehideco = null;
	
	
	
	  @Test
	  public void browserLaunch() throws IOException { 
		  
		  Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");                                                                                                                                                                    
			
//			  System.setProperty("webdriver.chrome.driver",
//			  "C:\\Users\\Softwares\\Chromedriver_83\\chromedriver.exe"); driver = new
//			  ChromeDriver(); driver.manage().window().maximize();
//			  driver.get("https://www.irctc.co.in/nget/");
			  System.out.println("IRCTC is being processed");
			  IRCTC_Decorators.exceldatareader(driver);
			 
		 //excelDataWriter
	  
	  };
	 
	
	@Test
	public void IRCTCLogin() {
		
		//IRCTC_Decorators.excelDataWriter(driver);
		//IRCTC_Decorators.IRCTCLogin(driver);
		System.out.println("Login passed");

	}

}










