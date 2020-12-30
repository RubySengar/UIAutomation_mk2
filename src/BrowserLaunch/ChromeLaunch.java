package BrowserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLaunch {

	static WebDriver driver ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Softwares\\Chromedriver_86\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.selenium.dev/");
		driver.manage().window().maximize();
		//driver.get("https://www.irctc.co.in/nget/");
		
		
		String page1 = driver.getTitle();
		System.out.println("Page title is > " + page1);
		
		driver.navigate().to("https://www.google.co.in/");
		
		String page2 = driver.getTitle();
		System.out.println("Page title is > " + page2);
		
		driver.navigate().back();
		
		String page3 = driver.getTitle();
		System.out.println("Page title is > " + page3);
		
		 driver.navigate().forward();
		 
		 String page4 = driver.getTitle();
		 System.out.println("Page title is > " + page4);
		 
		 driver.navigate().refresh();
		 
		 String page5 = driver.getTitle();
		 System.out.println("Page title is > " + page5);
		 
		 
			
			

	}

}
