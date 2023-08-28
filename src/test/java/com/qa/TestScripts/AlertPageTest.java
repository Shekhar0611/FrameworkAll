package com.qa.TestScripts;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pagelayer.AlertPage;
import com.qa.testbase.TestBase;

public class AlertPageTest extends TestBase {
	AlertPage alert1;
	
	@Test
	public void HandleAlert() {
	openBrowser();
	alert1=new AlertPage(driver);
	alert1.alertHandle();
	alert1.clickonConfirmBtn();
	
	Alert a=driver.switchTo().alert();
	String expectedMessage = "Hello Shekhar, Are you sure you want to confirm?";
	
	String actualMessage = a.getText();
	
	Assert.assertEquals(actualMessage, expectedMessage);
	a.accept();
}
}