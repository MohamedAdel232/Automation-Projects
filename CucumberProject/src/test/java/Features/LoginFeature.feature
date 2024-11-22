Feature: Login feature

  Scenario: Login with valid username and password
    Given User is on login page
    When User enter a valid username and password
    Then User is redirected to home page


  Scenario Outline: Scenario: Login with invalid username and password
    Given User is on login page
    When User enter an invalid "<username>" and "<password>"
    Then An error message appears that tells the user he entered invalid data

    Examples:
      | username        | password        |
      | standard_user   | invalidPassword |
      | invalidUsername | secret_sauce    |