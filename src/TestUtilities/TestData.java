package TestUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public interface TestData {
	
	public  final WebDriver driver = null;
	public static  String Data(String objectKey) throws FileNotFoundException, IOException {
		
		  String value = "" ;
		  Properties config = new Properties();
		  FileInputStream fis = new FileInputStream("C:\\Users\\Azad\\eclipse-workspace\\UIAutomation_mk2\\Properties\\DataProviders\\Config");
		  config.load(fis);
		  
		  value = config.getProperty(objectKey);
		
		
		return value;
	}
	
	 default void takeScreenShot(String snapname) {
		
		
		/*
		 * File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(f, new File(""));
		 */
		
		/*
		 * TakesScreenshot scrShot =((TakesScreenshot)driver); File
		 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE); File DestFile=new File("");
		 * FileUtils.copyFile(SrcFile, DestFile);
		 */
		 
		
		
		 
    	
	}
	
	

}
