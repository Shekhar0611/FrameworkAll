package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
WebDriver driver;
	
	public AlertPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(xpath="//input[@id='name']")
	WebElement alert;
	@FindBy(xpath="//input[@id='confirmbtn']")
	WebElement confirmButton;
	
	public void alertHandle() {
		alert.click();
		alert.sendKeys("Shekhar");
	}
	public void clickonConfirmBtn() {
		confirmButton.click();
	}
}
