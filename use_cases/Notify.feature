
Feature: Notify
  
  
  //@tag1
  Scenario Outline: send a notify to the customer
    Given I want to send an email to <customer>
    When the order is complete 
    Then I will send an email to Notify <customer>
    
    Examples: 
      | customer  |
      | "yasmeen" |     
      | "lana"    | 


   