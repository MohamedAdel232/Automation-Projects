Feature: Overview feature

  Scenario: Click on finish button
    Given User is on overview page
      | Mohamed | Adel | 32019232 |
    When User click on finish button
    Then User is redirected to finish page
