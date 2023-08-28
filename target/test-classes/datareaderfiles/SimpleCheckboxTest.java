package com.qa.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pagelayer.SimpleCheckbox;
import com.qa.testbase.TestBase;

public class SimpleCheckboxTest extends TestBase{
	
	@Test
    public void testCheckbox()  {
	     openBrowser(); 
         SimpleCheckbox firstpage=new SimpleCheckbox(driver);
         
         WebElement ele= driver.findElement(By.xpath("//input[contains(@id,'checkBoxOption1')]"));
	     WebDriverWait wait=new WebDriverWait(driver,10);
	     wait.until(ExpectedConditions.visibilityOf(ele));
	     
         firstpage.clickCheckbox1();  
         firstpage.clickCheckbox3();
         Assert.assertTrue(firstpage.isCheckbox1Selected(), "Checkbox should be selected");
         Assert.assertTrue(firstpage.isCheckbox3Selected(), "Checkbox should be selected");
        
         firstpage.clickCheckbox1();
         firstpage.clickCheckbox3();
         Assert.assertFalse(firstpage.isCheckbox1Selected(), "Checkbox should not be selected"); 
         Assert.assertFalse(firstpage.isCheckbox3Selected(), "Checkbox should not be selected");
}
}