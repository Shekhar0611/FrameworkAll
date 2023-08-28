package com.qa.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverPage {
WebDriver driver;
	
	public MouseHoverPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@id='mousehover']")
	WebElement MouseHovering;
	
	public void HowerMouse() {
		Actions a=new Actions(driver);
		a.moveToElement(MouseHovering).perform();
	}
			
}
