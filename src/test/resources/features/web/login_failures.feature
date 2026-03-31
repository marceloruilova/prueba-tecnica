Feature: SauceDemo Login Failures

  Background:
    Given the user is on the SauceDemo login page

  Scenario Outline: <description>
    When they log in with username "<username>" and password "<password>"
    Then an error message is displayed
    And the URL still shows the login page

    Examples:
      | description          | username      | password       |
      | TC-02 Wrong password | standard_user | wrong_password |
