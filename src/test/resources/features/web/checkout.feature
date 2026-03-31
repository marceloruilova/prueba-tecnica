Feature: SauceDemo Checkout

  Background:
    Given the user is logged in as "standard_user" with password "secret_sauce"
    And they add the first product to the cart
    And they navigate to the cart
    And they proceed to checkout

  Scenario: TC-09 Checkout with empty form shows required field error
    When they fill in the checkout form with first name "", last name "", and postal code ""
    Then a checkout error is displayed
    And the checkout error contains "First Name is required"

  Scenario: TC-10 Checkout with missing last name shows required field error
    When they fill in the checkout form with first name "Juan", last name "", and postal code "0901"
    Then a checkout error is displayed
    And the checkout error contains "Last Name is required"

  Scenario: TC-11 Complete checkout shows order confirmation
    When they fill in the checkout form with first name "Juan", last name "Perez", and postal code "0901"
    And they complete the order
    Then the order confirmation is displayed
    And the confirmation message says "Thank you for your order"
