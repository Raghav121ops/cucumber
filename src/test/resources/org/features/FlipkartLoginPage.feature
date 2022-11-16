Feature: Flipkart Login Feature

@Smoke
Scenario: Flipkart Login Page title & Page Url
Given Flipkart User is on the login page
Then Flipkart Title of login page should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
And Flipkart Page url is displayed as "https://www.flipkart.com/"
And Flipkart Verify UserName and Password fields are displayed
And Flipkart Login button is displayed

@Smoke @Regression
Scenario: Flipkart Login successful
Given Flipkart User is on the login page
When Flipkart User enters username
And Flipkart User enters password
And Flipkart User clicks on login button
Then Flipkart My Account button is displayed
And Flipkart Tabs displayed are "Top Offers,Grocery,Mobiles,Fashion,Electronics,Home,Appliances,Travel,Beauty, Toys & More"

#Scenario Outline: Login with multiple users
#Given User is on the login page
#	When User enters username as <USERNAME>
#	And User enters passowrd as <PASSWORD>
#	And User clicks on login button
#	Then Page title should be "actiTIME -  Enter Time-Track"
#	Examples:
#	|USERNAME|PASSWORD|
#	|"admin"|"manager"|
#	|"admin1"|"manager1"|
#	|"admin2"|"manager2"|