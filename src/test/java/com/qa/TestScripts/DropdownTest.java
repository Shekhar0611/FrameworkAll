package com.qa.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pagelayer.DropdownPage;
import com.qa.testbase.TestBase;

public class DropdownTest extends TestBase {
  
	DropdownPage dropdownpage;
	
	@Test
	public void testDropdownSelection() {
		openBrowser();
		dropdownpage=new DropdownPage(driver);
		
		String optionText="Option1";
		
		dropdownpage.selectOptionByVisibleText(optionText);
		
		String selectedOptionText= dropdownpage.getSelectedOptionText();
		Assert.assertEquals(selectedOptionText,optionText,"Selected option text is incorrect.");
		
	}
}
