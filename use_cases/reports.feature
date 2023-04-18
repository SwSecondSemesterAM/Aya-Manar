
Feature: Reports

  Scenario: generate customized reports about business
    Given I want to generate customized reports
    When the day is end 
    Then  reports should be generated
   

 