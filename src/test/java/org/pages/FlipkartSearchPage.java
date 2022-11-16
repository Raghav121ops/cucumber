package org.pages;

import java.util.List;

import org.applicationHooks.AppHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartSearchPage {
	private WebDriver driver;
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchTxtField;
	
	public FlipkartSearchPage(WebDriver driver) {	//constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public boolean isSearchFieldDisplayed() {
		return searchTxtField.isDisplayed();
	}
	public void enterSearchText(String expText) {
		searchTxtField.sendKeys(expText,Keys.ENTER);
	}
	public boolean isSearchResultLabelDisplayed(String expText) {
		WebElement searchResult = driver.findElement
				(By.xpath("//div[div[div[a[text()='Home']]]]//span[text()='"+expText+"']"));
		return searchResult.isDisplayed();
	}
}