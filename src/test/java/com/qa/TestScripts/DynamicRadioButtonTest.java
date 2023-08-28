package com.qa.TestScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.pagelayer.DynamicRadioButtonPage;
import com.qa.testbase.TestBase;

public class DynamicRadioButtonTest extends TestBase{ 
	
	DynamicRadioButtonPage dynamicradiopage;
	
	@Test
	public void HandleDynamicRadioButtonTest() {
		openBrowser();
		dynamicradiopage=new DynamicRadioButtonPage(driver);
		
		List <WebElement> radiobuttons =dynamicradiopage.getCheckboxes();
		
		for(int i=0;i<radiobuttons.size();i++) {
			
			WebElement local_radiobutton=radiobuttons.get(i);
			
			String value =local_radiobutton.getAttribute("value");
			
			if(value.equalsIgnoreCase("option1")) {
				
				local_radiobutton.click();
			}
		}
	}
}

