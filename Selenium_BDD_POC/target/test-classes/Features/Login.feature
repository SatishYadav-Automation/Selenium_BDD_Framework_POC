@LoginFeature
Feature: Login Feature

  @Negative @Regression
  Scenario Outline: Invalid login attempt
    Given user is on the login page
    When user enters username "<username>" and password "<password>"
    And clicks the login button
    Then user should see an correct error message

    Examples:
      | username      | password   |
      | standard_user | wrong_pass |

  @Sanity @UI
  Scenario: Forgot password
    Given user is on the login page
    When user clicks on Forgot your password link
    Then user should see the password reset page
    And Log out

  @Positive @Smoke
  Scenario: Successful login
    Given user is on the login page
    When user enters username "Admin" and password "admin123"
    And clicks the login button
    Then home page should load
