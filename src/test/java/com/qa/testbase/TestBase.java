package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.qa.utility.DriverFactory;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
  
	public static WebDriver driver;
	static Properties config = new Properties();   //to read the config Properties file 
	FileInputStream file;
	
	@BeforeMethod
	public void frameworkSetUp() 
	{
		
		DriverFactory.setConfigPropertyFile(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.prop");
		DriverFactory.setChromeDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
		DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
		
		System.out.println(System.getProperty("user.dir"));
		
		//loading properties file
		try {
			file = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	    try {
		config.load(file);
	    } catch (IOException e) 
	    {
		    e.printStackTrace();
	    }
	    
	    //setup grid location
	    DriverFactory.setGridPath(config.getProperty("huburl"));
	}
	
	public static void openBrowser() {
		
	     DriverFactory.setRemote(Constants.REMOTE_STATUS);
	     
	     if(DriverFactory.isRemote()) {
	    	 DesiredCapabilities cap = null;
	    	 
	    	 if(config.getProperty("browser").equals("chrome")) {
	    		 cap = DesiredCapabilities.chrome();
	    		 cap.setBrowserName("chrome");
	    		 cap.setPlatform(Platform.ANY); 
	    	 } else if (config.getProperty("browser").equals("firefox")) {
	    		 cap = DesiredCapabilities.firefox();
	    		 cap.setBrowserName("firefox");
	    		 cap.setPlatform(Platform.ANY);
	    	 }
	    	  	    		
					try {
						driver = new RemoteWebDriver(new URL(DriverFactory.getGridPath()),cap);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				 				
	    	}
	     	     
	        else if(config.getProperty("browser").equals("chrome")) {
		    	
	        	// Driver location
			    System.setProperty("webdriver.chrome.driver",DriverFactory.getChromeDriverExePath());
		      
			    //open a chrome browser
			    
			    driver=new ChromeDriver();
		    }else if (config.getProperty("browser").equals("firefox")){
		        //Driver Location
			    System.setProperty("webdriver.firefox.driver",DriverFactory.getGeckoDriverExePath());
		        driver=new FirefoxDriver();
		    }
		    
	     driver.manage().window().maximize();
		    
		    //launch testurl
		 driver.get(config.getProperty("testurl"));
		 driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_TIME, TimeUnit.SECONDS);
		    
	}	   
	@AfterMethod
	public void teardown()
	{
		System.out.println("tearDownMethod");
		driver.quit();
	}
}
