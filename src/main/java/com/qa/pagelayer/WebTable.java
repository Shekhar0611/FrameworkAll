package com.qa.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable {

	private WebDriver driver;

	public WebTable (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locator
	//@FindBy(xpath="//table[@id='product']")
     private By tableLocator=By.id("product");
	
	//methods
	public WebElement getCellElement(int row, int col) {
		WebElement table=driver.findElement(tableLocator);
		String cellXpath="//table[@id='product']/tbody/tr["+row+"]/td["+col+"]";
		return table.findElement(By.xpath(cellXpath));
	}
	public String getcellValue(int row ,int col) {
		return getCellElement(row,col).getText();
	}
}
