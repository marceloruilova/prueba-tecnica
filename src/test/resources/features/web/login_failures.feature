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
      | TC-04 Empty fields   |               |                |

  # TC-05: Uses a standalone Scenario (not an outline row) because Cucumber
  # trims whitespace in Examples table cells, making " " identical to "".
  Scenario: TC-05 Whitespace-only credentials are rejected
    When they log in with username " " and password " "
    Then an error message is displayed
    And the URL still shows the login page

  Scenario: TC-03 Locked user is shown a locked-out error
    When they log in with username "locked_out_user" and password "secret_sauce"
    Then an error message is displayed
    And the error message contains "Sorry, this user has been locked out"
    And the URL still shows the login page
