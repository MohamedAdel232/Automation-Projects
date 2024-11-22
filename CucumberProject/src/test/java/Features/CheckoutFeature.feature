Feature: Checkout feature

  @now
  Scenario: Enter checkout info
    Given User is on checkout page
    When User enter checkout info and click continue
      | Mohamed | Adel | 32019232 |
    Then User is redirected to overview page