Feature: Actitime Login Feature

@Smoke
Scenario: ActiTime Login Page title
Given User is on the login page
When User gets the title of the page
Then Title of login page should be "actiTIME - Login"

#Scenario: Keep me logged in checkbox
#Given User is on the login page
#Then Keep me logged in checkbox should be displayed
#
#@Smoke @Regression
#Scenario: ActiTime Login Test Case
#Given User is on the login page
#When User enters "admin" and "manager"
#And User clicks on login button
#Then Page title should be "actiTIME -  Enter Time-Track123"

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