

Feature: discount
  
  Scenario: giving discount to  <customer>  
    Given <customer> uses the service with an amount of money > 400 NIS
    When  the <customer> frequently use this service with amount more than 400 NIS
    Then  then he have to get a <10>% discount

    Examples: 
     | customer | amount | 
     | "Ahmad" |  10 | 
     | "Ola" |  25 | 
