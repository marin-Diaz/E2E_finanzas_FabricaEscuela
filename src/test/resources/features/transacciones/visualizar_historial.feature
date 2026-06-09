#Actor:User

Feature: View transaction history
  I as a registered user
  need to view my transaction history
  to have control of my personal finances

  Scenario: Successful history query with transactions
    Given I am an authenticated user with registered transactions
    When I query my transaction history
    Then the system displays my transactions