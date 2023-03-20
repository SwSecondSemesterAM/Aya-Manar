Feature: generate invoice for customer
@invoice
#Background:

#Given customer has already logged_In 

Scenario Outline: generate invoice for <customer> is valid

Given <customer> has already logged_In to his profile 
And he requests the service 
When the service done 
Then an invoice should generate for him

Examples:
|customer|
|"Aya"|
|"manar"|