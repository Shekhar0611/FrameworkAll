package com.qa.TestScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pagelayer.WebTable;
import com.qa.testbase.TestBase;

public class WebTableTest extends TestBase {

	WebTable table;
	
	@Test
	public void testCellValue() {
		openBrowser();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		
		table=new WebTable(driver);
		String cellValue=table.getcellValue(4, 4);
		Assert.assertEquals(cellValue,"18");
		
	}
}
