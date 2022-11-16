Feature: Actitime Login Feature

Scenario Outline: Login with multiple users
Given User is on the login page
When User enters "USERNAME" and "PASSWORD"
And User clicks on login button
Then Page title should be "actiTIME -  Enter Time-Track123"
When User clicks on Tasks tab
Then Task tab is selected
When User clicks on Add New and New Customer button
Then "Create New Customer" popup should be displayed
When User enters <CustName> and <CustDescName>
And Clicks on Create Customer button
Then Verify <CustName> is created successfully
	Examples:
	|CustName|CustDescName|
	|"CustName A_21"|"CustDescName D_21"|
	|"CustName A_22"|"CustDescName D_22"|
	|"CustName A_23"|"CustDescName D_23"|
	
Scenario Outline: Delete multiple users
Given User is on the login page
When User enters "USERNAME" and "PASSWORD"
And User clicks on login button
Then Page title should be "actiTIME -  Enter Time-Track123"
When User clicks on Tasks tab
Then Task tab is selected
When User Search <CustName> Customer button
Then Click on delete button
And Click on Yes button on confirm popup
Then Verify <CustName> is deleted successfully
	Examples:
	|CustName|
	|"CustName A_21"|
	|"CustName A_22"|
	|"CustName A_23"|