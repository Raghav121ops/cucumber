package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	private WebDriver driver;
	
	@FindBy(xpath="")
	private WebElement addNewBtn;
	
	@FindBy(xpath="")
	private WebElement addNewCustomerBtn;
	
	public CustomerPage(WebDriver driver) {	//constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//write page action methods as per the steps
}