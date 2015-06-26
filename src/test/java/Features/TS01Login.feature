Feature: Cash Converter Login Page
	As a registered user of CashConverter.com
	I want to successfully login the online store
	So I can start shopping
	

Scenario: Valid user logging in
	Given the user is on webshop
	When user enters valid username and password
	Then user is logged in successfully
	

#Scenario: InValid user logging in
#	Given the user is on webshop
#	When user enters invalid username and password
#	Then user is redirected to login page