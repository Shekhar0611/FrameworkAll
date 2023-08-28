package com.qa.pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicRadioButtonPage {
	
		WebDriver driver;
			
			public DynamicRadioButtonPage (WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath="//input[@type='radio']")
			private List<WebElement> radioButton;
			
			public List<WebElement> getCheckboxes(){
				return radioButton;
			}	
			
			}

