package org.pages;

import java.util.ArrayList;
import java.util.List;

import org.applicationHooks.AppHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.utility.ElementUtil;

public class FlipkartLoginPage {
	private WebDriver driver;
	
	@FindBy(css="._2IX_2-.VJZDxU")
	private WebElement userName;
	
	@FindBy(css="._2IX_2-._3mctLh.VJZDxU")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']//span")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myAccBtn;
	
	@FindBy(className="xtXmba")
	private List<WebElement> dashboardTabs;
	
	public FlipkartLoginPage(WebDriver driver) {	//constructor
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
	public boolean isMyAccountBtnDisplayed() {
//		driver.navigate().refresh();
		//myAccBtn = driver.findElement(By.xpath("//div[text()='My Account']"));
		//return myAccBtn.isDisplayed();
		try {
			return driver.findElement(By.xpath("//div[text()='My Account']")).isDisplayed();
		} catch(StaleElementReferenceException e) {
			return driver.findElement(By.xpath("//div[text()='My Account']")).isDisplayed();
		}
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
	public boolean verifyDashboardTabs(String allTabs) {
		ArrayList<String> actTabs = new ArrayList<String>();
		for(int i=0; i<dashboardTabs.size(); i++) {
			actTabs.add(dashboardTabs.get(i).getText());
		}
		String[] str = allTabs.split(",");
		ArrayList<String> expTabs = new ArrayList<String>();
		for(int i=0; i<str.length; i++) {
			expTabs.add(str[i]);
		}
		AppHooks.scn.log("act tabs: "+actTabs);
		AppHooks.scn.log("exp tabs: "+expTabs);
		return (actTabs.containsAll(expTabs));
	}
}