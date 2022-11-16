package org.testRunners;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/failedReRun.txt",
		glue = {"stepDefinitions","org/applicationHooks"},
		monochrome=true,
		dryRun = false,
		tags="@Smoke or @Regression",
		plugin = {"pretty",
			"html:target/html_report/cucumber_reports.html",
			"junit:target/junit_report/junit_reports.xml",
			"json:target/json_report/json_reports.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			}
//		format = {"pretty","html:report"} //for older versions
		)
public class FailedRunner { //extends AbstractTestNGCucumberTests {
	
}
//Extent 1: new html create-> htmlreport_date.html
///automatic create html report