Feature: Generate customized reports about cleaning carpets and covers system

Background:
Given the following Customer and their Ids are contained in the system:

    | Customer Id | Customer | 
    | 12345       |  Aya     |
    | 11111       |  Aya     |
    | 19836       | yasmeen  | 
    | 48932       | lana     |    
    | 55587       |  omar    |    
    | 66928       |  omar    |  




  And the following cleaning jobs have been completed:
  
    | Job ID | Customer Id   | item name   | Cleaning Date | Rating |
    | 1      |   12345       | carpet      | 2022-01-05    | 5      | 
    | 2      |   12345       | cover       | 2022-02-15    | 4      | 
    | 3      |   19836       | carpet      | 2022-03-23    | 3      |    
    | 4      |   48932       | carpet      | 2022-04-10    | 5      |    
    | 5      |   55587       | cover       | 2022-05-18    | 4      |     
    | 6      |   66928       | cover       | 2023-01-01    | 5      |   
    

Scenario: Generate a report for all cleaning jobs
  Given Admin logged in to the application
  When he selects the option to generate a report
  And he chooses to generate a report for all cleaning jobs
  Then a report is generated showing all cleaning jobs

Scenario: Generate a report for cleaning jobs between specific dates
  Given Admin logged in to the application
  When he selects the option to generate a report
  And he chooses to generate a report for cleaning jobs between "2022-01-01" and "2022-12-31"
  Then a report is generated showing cleaning jobs between the specified dates

Scenario: Generate a report for cleaning jobs with a minimum rating
  Given Admin logged in to the application
  When he selects the option to generate a report
  And he chooses to generate a report for cleaning jobs with a minimum rating of 4
  Then a report is generated showing cleaning jobs with a rating of 4 or higher
