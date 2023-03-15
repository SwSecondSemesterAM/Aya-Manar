

Feature: discount

Background:
Given these customers and those information
#name|id|phone|address|password|payedMoney|
|lana|200|
|omar|7000|
  @discount_tag
  Scenario: giving discount to  <customer>  
    Given <customer> uses the service with an amount of money > 400 NIS
    When  the <customer> frequently use this service with amount more than 400 NIS
    Then  then he have to get a <10>% discount

    Examples: 
     | customer | amount | 
     | "Ahmad" |  10 | 
     | "Ola" |  25 | 

     
     