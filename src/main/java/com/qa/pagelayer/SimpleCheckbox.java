package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleCheckbox {
	
	WebDriver driver;
	
	public SimpleCheckbox (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[contains(@id,'checkBoxOption1')]")
	WebElement checkbox1;
	
	@FindBy(xpath="//input[contains(@id,'checkBoxOption3')]")
	WebElement checkbox3;
	

  public void clickCheckbox1() {
	  checkbox1.click();	  
  } 
  public void clickCheckbox3() {
	  checkbox3.click();
  }
  public boolean isCheckbox1Selected() {
	  
	  return checkbox1.isSelected();
  }
  
  public boolean isCheckbox3Selected() {
	  
	  return checkbox3.isSelected();
  }
  
  
}