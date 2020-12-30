package TestNGClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Decorators.INDIANARMY_Decorators;

public class TestNG_01 {

	// TestNGClass.TestNG_01
	static  WebDriver driver ;
	static INDIANARMY_Decorators iadeco = null;

	@Test(priority = 0, description = "Launch the Application", enabled = true)
	public void IndianArmysiteLaunch() throws IOException {
		
		  
		  Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");                                                                                                                                                                    
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Softwares\\Chromedriver_87\\chromedriver.exe");
		  driver = new  ChromeDriver();
		  driver.manage().window().maximize();
		  
		  Properties config = new Properties();
		  FileInputStream fis = new FileInputStream("C:\\Users\\Azad\\eclipse-workspace\\UIAutomation_mk2\\Properties\\DataProviders\\Config");
		  config.load(fis);
		
		  driver.get(config.getProperty("URL"));
		  System.out.println("INDIAN ARMY is being processed");
		
		
	};

	
	@Test(priority = 1, description = "LogIn To The Application", enabled = true)
	public void IndianArmyRegistrationLaunch() throws IOException {
		
		  iadeco.indianArmyRegistration(driver);
		  iadeco.indianArmyLogin(driver);		
		
	};
	
	
	@Test(priority = 2, description = "User Validation", enabled = true)
	public void IndianArmyUserValidation() throws IOException {
		
		  iadeco.indianArmyUserValidation(driver);
		  System.out.println("Passed");
		
	};
	
	

}
