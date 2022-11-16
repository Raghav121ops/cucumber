package stepDefinitions;

import org.applicationHooks.AppHooks;
import org.pages.FlipkartSearchPage;
import org.qa.factory.DriverFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSearchStepDef {
	FlipkartSearchPage fsp_obj = new FlipkartSearchPage(DriverFactory.getDriver());
	
	@Then("Search field is displayed")
	public void search_field_is_displayed() {
		Assert.assertTrue(fsp_obj.isSearchFieldDisplayed());
		AppHooks.scn.log("Search field displayed successfully.");
	}
	@When("User enters {string} mobile in search")
	public void user_enters_mobile_in_search(String expText) {
		fsp_obj.enterSearchText(expText);
	}
	@Then("Verify search result displayed for {string}")
	public void verify_search_result_displayed_for(String expText) {
		Assert.assertTrue(fsp_obj.isSearchResultLabelDisplayed(expText));
		AppHooks.scn.log("Search result displayed for "+expText);
	}
}