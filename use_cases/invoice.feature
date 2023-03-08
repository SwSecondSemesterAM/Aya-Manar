Feature: generate invoice for customer
@invoice
#Background:

#Given customer has already logged_In 

Scenario Outline: generate invoice for <customer> is valid

Given <customer> has already logged_In 
When <customer> requests the service
Then should generate invoice 

Examples:
|customer|
|"Aya"|
|"manar"|