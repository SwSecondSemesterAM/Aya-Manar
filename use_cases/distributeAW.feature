Feature: Distribute orders on available workers

Scenario Outline: Distribute orders to workers

  Given there are <NomOfOrder> orders to be completed
  And there are <numWorkers> workers available to complete the orders
  When the orders are distributed among the available workers
  Then each worker has  one order assigned to them
  
  
 
Examples:

|NomOfOrder|numWorkers|
|  7       |   7      |
|  20      |   13     |
|  8       |   20     |