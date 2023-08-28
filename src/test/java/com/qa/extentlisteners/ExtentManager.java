package com.qa.extentlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.testbase.TestBase;

public class ExtentManager extends TestBase {
	
private static ExtentReports extent;
	
   public static ExtentReports createInstance (String fileName) {
	    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
	    
	    sparkReporter.config().setTheme(Theme.STANDARD);
	    sparkReporter.config().setDocumentTitle(fileName);
	    sparkReporter.config().setEncoding("UTF-8");
	    sparkReporter.config().setReportName(fileName);
	    
	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    extent.setSystemInfo("Automation Tester", "Shekhar Zambare");
	    extent.setSystemInfo("Project Domain","BankApplication");
	    extent.setSystemInfo("Build no", "1.0");
	    
	    
	    return extent;
   }
	
	  public static String screenshotPath;
	  public static String screenshotName;
	
	  
	  public static void captureScreenshot()  {
		  
		   File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   
		   Date d =new Date();
		   screenshotName = d.toString().replace(":","_").replace(" ","_") + ".jpg";
		   
		   try {
			    FileHandler.copy(srcFile, new File(System.getProperty("user.dir")+"\\reports\\"+ screenshotName));
		   } catch (IOException e) {
			
			e.printStackTrace();
		   }
		   
	  }
	


}
