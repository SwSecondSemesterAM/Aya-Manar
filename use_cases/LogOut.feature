
Feature: LogOut 
customer will logOut from his profile and the LogIn page will open
  @tag3
  Scenario Outline: LogOut from customer profile
    Given <customer> has signed up to the app
    And he is now in his profile 
    When he presses on logOut
    Then he will return to logIn page

    Examples: 
     |customer|
      | "Ahmad" |   
      |"Tala"|  
      |"Solafa"|
