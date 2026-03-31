Feature: SauceDemo Authentication and Session Management

  Scenario: TC-06 Direct URL access without authentication redirects to login
    Given the user is not logged in
    When they navigate directly to "/inventory.html"
    Then they are redirected to the login page
