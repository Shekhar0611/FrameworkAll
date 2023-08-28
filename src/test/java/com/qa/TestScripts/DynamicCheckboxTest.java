package com.qa.TestScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.pagelayer.DynamicCheckboxesPage;
import com.qa.testbase.TestBase;

public class DynamicCheckboxTest extends TestBase {
	
	DynamicCheckboxesPage checkboxesPage;
	
    @Test
	public void HandleDynamicCheckboxesTest() throws InterruptedException {
		openBrowser();
		checkboxesPage=new DynamicCheckboxesPage(driver);
		List <WebElement> checkboxes =checkboxesPage.getCheckboxes();
		
		for(int i=0;i<checkboxes.size();i++) {
			
			WebElement local_checkbox=checkboxes.get(i);
			
			String value =local_checkbox.getAttribute("value");
			
			if(value.equalsIgnoreCase("option2")) {
				
				local_checkbox.click();
				Thread.sleep(5000);
			}
			if(value.equalsIgnoreCase("option3")) {
				local_checkbox.click();
				Thread.sleep(5000);
			}
			
		}
	}
}
