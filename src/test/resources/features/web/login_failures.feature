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

  Scenario: TC-03 Locked user is shown a locked-out error
    When they log in with username "locked_out_user" and password "secret_sauce"
    Then an error message is displayed
    And the error message contains "Sorry, this user has been locked out"
    And the URL still shows the login page
