
Feature: find available workers
  
  Background:
  Given these worker names are contained in the system
    
 # |worker |avialabilty|
  |bashar|true|
  |omar|true|
  |jamal|false|
  
   And these order names are contained in the system
# |order-name |
  |carpets|
  |covers|
  |covers|
   
 @distribute1
  

  Scenario Outline: find available workers
    Given there is <orders> needs <workers> to receive
    When there is <workers> available
    Then he will take this <orders>
    
       Examples: 
      | workers   | orders       |   
      | "bashar"  |   "carpets"  | 
      |  "omar"   |    "covers"  | 
      
 @distribute2
      
  Scenario: No available workers
    Given there is orders needs 'workers' to receive
    When there is no available workers
    Then No one will take the order
    
      
     
    
