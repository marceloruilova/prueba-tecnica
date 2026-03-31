Feature: SauceDemo Shopping Cart

  Background:
    Given the user is logged in as "standard_user" with password "secret_sauce"

  Scenario: TC-07 Adding a product increments the cart badge and shows Remove button
    When they add the first product to the cart
    Then the cart badge shows 1
    And the remove button is visible

  Scenario: TC-08 Cart persists after page refresh
    When they add the first product to the cart
    And they refresh the page
    And they navigate to the cart
    Then the cart still contains the product
