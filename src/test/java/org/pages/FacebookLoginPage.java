package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.utility.ElementUtil;

public class FacebookLoginPage {
	private WebDriver driver;
	
	@FindBy(css="#email")
	private WebElement userName;
	
	@FindBy(css="#pass")
	private WebElement password;
	
	@FindBy(css="button[name='login']")
	private WebElement loginButton;
	
	public FacebookLoginPage(WebDriver driver) {	//constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	public boolean isUserNameFieldDisplayed() {
		ElementUtil.eu.waitForVisibilityByWebElement(driver,20, userName);
		return userName.isDisplayed();
	}
	public boolean isPasswordFieldDisplayed() {
		return userName.isDisplayed();
	}
	public boolean isLoginBtnDisplayed() {
		return loginButton.isDisplayed();
	}
	public void enterUserName(String username) {
		userName.sendKeys(username);
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickLoginButton() {
		loginButton.click();
//		ElementUtil.eu.waitForVisibilityByWebElement(driver, 10, myAccBtn);
	}
}