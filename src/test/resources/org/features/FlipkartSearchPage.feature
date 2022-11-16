Feature: Flipkart Search Feature

@Smoke @Regression
Scenario: Flipkart search successful
Given User is on the login page
When User enters username
And User enters password
And User clicks on login button
Then My Account button is displayed
And Search field is displayed
When User enters "samsung m32" mobile in search
Then Verify search result displayed for "samsung m32"