Feature: Add product to cart feature

  Scenario: Add first product to cart
    Given User is on home page
    When User click on add to cart button
    Then Product is added to cart

  Scenario: Click on cart button
    Given User is on home page
    When User click on add to cart button
    And User click on cart button
    Then User is redirected to cart page