package com.qa.TestScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qa.pagelayer.MouseHoverPage;
import com.qa.testbase.TestBase;

public class MouseHoverTest extends TestBase{

	MouseHoverPage mousehoverpage;
	
	@Test
	public void MouseHoverAction() {
		openBrowser();
		mousehoverpage=new MouseHoverPage(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		
		mousehoverpage.HowerMouse();		
	}
}
