package com.qa.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicCheckboxesPage {
WebDriver driver;
	
	public DynamicCheckboxesPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> checkboxes;
	
	public List<WebElement> getCheckboxes(){
		return checkboxes;
	}	
	
	}

