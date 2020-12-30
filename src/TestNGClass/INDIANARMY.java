package TestNGClass;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Decorators.INDIANARMY_Decorators;

class INDIANARMY {
	
	static  WebDriver driver ;
	static INDIANARMY_Decorators iadeco = null;

	@Test
	public void IndianArmysiteLaunch() throws IOException {
		
		  
		  Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");                                                                                                                                                                    
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Softwares\\Chromedriver_83\\chromedriver.exe");
		  driver = new  ChromeDriver();
		  driver.manage().window().maximize();
		  
		  Properties config = new Properties();
		  FileInputStream fis = new FileInputStream("C:\\Users\\Azad\\eclipse-workspace\\UIAutomation_mk2\\Properties\\DataProviders\\Config");
		  config.load(fis);
		
		  driver.get(config.getProperty("URL"));
		  System.out.println("INDIAN ARMY is being processed");
		
	};

	
	@Test
	public void IndianArmyRegistrationLaunch() throws IllegalCharException {
		
		  iadeco.indianArmyRegistration(driver);
		  iadeco.indianArmyLogin(driver);
		  System.out.println("Passed");
		

		
	};
	
	

}
