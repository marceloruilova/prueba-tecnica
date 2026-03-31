# TC-01 – Successful login (happy path)
Feature: SauceDemo Login

  As a registered user
  I want to log in with valid credentials
  So I can access the product catalog

  Scenario: TC-01 Successful login with standard user
    Given the user is on the SauceDemo login page
    When they log in with username "standard_user" and password "secret_sauce"
    Then they are redirected to "/inventory.html"
    And the product list is visible
    And no error messages are displayed
