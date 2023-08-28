package com.qa.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pagelayer.WindowHandle;
import com.qa.testbase.TestBase;

public class WindowHandleTest extends TestBase {
 
	WindowHandle windowhandle;
	
	@Test
	public void HandleWindows() {
		openBrowser();
		windowhandle=new WindowHandle(driver);
		
		String parentHandle=driver.getWindowHandle();
		windowhandle.clickOnopenWindowButton();
		
		for(String handle : driver.getWindowHandles()) {
			if(!handle.equals(parentHandle)) {
			driver.switchTo().window(handle);
			
			Assert.assertEquals(driver.getTitle(), "QAClick Academy - A Testing Academy to Learn, Earn and Shine");
			break;
		}
	}
         driver.switchTo().window(parentHandle);
	}	
}
