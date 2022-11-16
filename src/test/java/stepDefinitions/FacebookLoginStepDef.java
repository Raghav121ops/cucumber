package stepDefinitions;

import org.applicationHooks.AppHooks;
import org.pages.FacebookLoginPage;
import org.qa.factory.DriverFactory;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLoginStepDef {
	FacebookLoginPage fb_obj = new FacebookLoginPage(DriverFactory.getDriver());
	
	@Given("FB User is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("url"));
	}
	@Then("FB Title of login page should be {string}")
	public void title_of_login_page_should_be(String expTitle) {
		String actTitle = fb_obj.getLoginPageTitle();
		Assert.assertEquals(actTitle, expTitle);
		AppHooks.scn.log("Login page title matched!");
	}
	@Then("FB Page url is displayed as {string}")
	public void page_url_is_displayed_as(String expUrl) {
		String actUrl = fb_obj.getLoginPageUrl();
		Assert.assertEquals(actUrl, expUrl);
		AppHooks.scn.log("Login page URL matched!");
	}
	@Then("FB Verify UserName and Password fields are displayed")
	public void verify_user_name_and_password_fields_are_displayed() {
		Assert.assertTrue(fb_obj.isUserNameFieldDisplayed());
		Assert.assertTrue(fb_obj.isPasswordFieldDisplayed());
	}
	@Then("FB Login button is displayed")
	public void login_button_is_displayed() {
		Assert.assertTrue(fb_obj.isLoginBtnDisplayed());
	}
	@When("FB User enters username")
	public void user_enters_username() {
		fb_obj.enterUserName(AppHooks.prop.getProperty("userName"));
	}
	@When("FB User enters password")
	public void user_enters_password() {
		fb_obj.enterPassword(AppHooks.prop.getProperty("password"));
	}
	@When("FB User clicks on login button")
	public void user_clicks_on_login_button() {
		fb_obj.clickLoginButton();
	}
}