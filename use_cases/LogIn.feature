Feature: logIn 
  Background:
  Given these customers names and their passwords are contained in the system
    
 # |customer|password|
  |Aya|123|
  |yasmeen|5466|
  |manar|897|
  
  
  
@scenario1
  Scenario Outline: logIn
  the customer want to logIn to his profile
  
    Given the <customer> enter his name and his password correctly
    When  he press logIn
    Then his profile will open 

    Examples: 
      | customer| 
      | "manar" |     
      #| "aya"   |    

      
 @scenario2
 
 Scenario Outline: logIn
  the customer want to logIn to his profile
  
    Given the <customer> enter his password wrong
    When  he press logIn
    Then A message will appear saying that the password was entered incorrectly

    Examples: 
      | customer| 
      | "bashar" |     
    #  | "omar"   |  