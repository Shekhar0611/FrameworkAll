package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowHandle {
    private WebDriver driver;

	public WindowHandle(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='openwindow']")
	WebElement openWindow;
	
	public void clickOnopenWindowButton() {
		openWindow.click();
	}
}
