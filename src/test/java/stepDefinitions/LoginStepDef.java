package stepDefinitions;

import org.applicationHooks.AppHooks;
import org.junit.Assert;
import org.pages.LoginPage;
import org.qa.factory.DriverFactory;
import org.qa.utility.ElementUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	private static String title;
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("url"));
	}
	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = lp.getLoginPageTitle();
		AppHooks.scn.log("Login page title is : "+title);
	}
	@Then("Title of login page should be {string}")
	public void title_of_the_login_page_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
		AppHooks.scn.log("- Login page title verified.");
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String password) {
		lp.enterUserName(username);
		AppHooks.scn.log("- Entered username.");
		lp.enterPassword(password);
		AppHooks.scn.log("- Entered password.");
	}
	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		lp.clickLoginButton();
		AppHooks.scn.log("- Clicked on Login button.");
	}
	@Then("Keep me logged in checkbox should be displayed")
	public void keep_me_logged_in_checkbox_should_be_displayed() {
		Assert.assertTrue(lp.isKeepMeLoggedInCheckBoxDisplayed());
		AppHooks.scn.log("- Keep Me Login check box is displayed.");
	}
	@Then("Page title should be {string}")
	public void home_Page_title_should_be(String expectedTitle) { // throws InterruptedException {
//		Thread.sleep(5000);
		ElementUtil.eu.waitForPageLoad(DriverFactory.getDriver());
		String actualTitle = lp.getLoginPageTitle();
		System.out.println("actualTitle : "+actualTitle);
		System.out.println("expectedTitle : "+expectedTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
	@When("User enters username as {string}")
	public void user_enters_username_as(String uName) {
		lp.enterUserName(uName);
	}
	@When("User enters passowrd as {string}")
	public void user_enters_passowrd_as(String pwd) {
		lp.enterPassword(pwd);
	}
}
