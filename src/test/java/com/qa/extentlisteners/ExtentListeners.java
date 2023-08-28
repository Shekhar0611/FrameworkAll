package com.qa.extentlisteners;



import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class ExtentListeners implements ITestListener {
	
	static Date d = new Date();
	static String fileName = "Extent_"+ d.toString().replace(":", "_").replace(" ","_") + ".html";
	
	public static ThreadLocal <ExtentTest> testReport = new ThreadLocal <ExtentTest>();
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+ fileName);

	

	
	@Override
	public void onTestStart(ITestResult result) {
		
    ExtentTest test=extent.createTest(result.getTestClass().getName()+" @TestCase : "+result.getMethod().getMethodName());
		
		
		testReport.set(test);
	}

	@Override
        public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE :- "+methodName.toUpperCase()+ "PASSED" +"</b>";
		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
	}

	@Override
        public void onTestFailure(ITestResult result) {
		
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" +"<font color="+ "red>" + "Exception Occured:click to see"
		+ "</font>" + "</b>" +"</summary>" +exceptionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
	
	    
		try {
			ExtentManager.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	       
	 
     String failurelog="TEST CASE FAILED";
     Markup m= MarkupHelper.createLabel(failurelog, ExtentColor.RED);
     testReport.get().log(Status.FAIL, m);
	}
	

	@Override
	
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ "Skipped"+"</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);
	}

	@Override
	
	 public void onFinish(ITestContext context) {
		 	
			
	 WebDriver driver= (WebDriver) context.getAttribute("WebDriver");
			
			if(driver != null) {
				driver.quit();
			}
	 if(extent != null) {
				
	   extent.flush();		
			
		}
	}
	}	
		
	
	
	
	
	
	
	
	
	
	
