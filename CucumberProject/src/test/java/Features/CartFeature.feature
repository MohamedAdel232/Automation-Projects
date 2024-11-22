Feature: Cart feature

  @now
  Scenario: Click on checkout button
    Given User is on the cart page
    When User click on checkout button
    Then User is redirected to checkout button