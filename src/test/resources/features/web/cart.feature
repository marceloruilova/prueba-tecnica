Feature: SauceDemo Shopping Cart

  Background:
    Given the user is logged in as "standard_user" with password "secret_sauce"

  Scenario: TC-07 Adding a product increments the cart badge and shows Remove button
    When they add the first product to the cart
    Then the cart badge shows 1
    And the remove button is visible
