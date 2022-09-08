Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed


@One

Scenario: Login with correct credentials

Given user is on login page
When user enters username "achubala1619@gmail.com"
And user enters password "selenium@123"
And user clicks on Login button
And user gets the title of the page
Then page title should be "My account - My Store"