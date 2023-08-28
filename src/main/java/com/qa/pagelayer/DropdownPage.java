package com.qa.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

	WebDriver driver;
	
	public DropdownPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//select[@id='dropdown-class-example']")
	WebElement dropDownElement;
	
	public void selectOptionByVisibleText(String optionText) {
		Select select = new Select(dropDownElement);
		select.selectByVisibleText(optionText);
	}
	public String getSelectedOptionText() {
		Select select = new Select(dropDownElement);
		return select.getFirstSelectedOption().getText();
		
		
	}
}
