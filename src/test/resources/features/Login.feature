Feature: Login
  As a user on http://automationpractice.com/index.phphttp://automationpractice.com/index.php
  I want to be able to login on the website
  So that I can manage my account.


  Background:
    Given I navigate to "http://automationpractice.com/index.phphttp://automationpractice.com/index.php" automation practice website
    When I click on Sign in hyperlink on the top of the page


  Scenario Outline: Valid login
    And I enter my registered "<EmailAddress>" in Email Address input field
    And I enter password "<Password>"
    And I click on Sign in button in Already registered section
    Then I am directed to my account

    Examples:
      | EmailAddress                   | Password    |
      | Testerabcde1234@Mailinator.com | Malaya12345 |

  Scenario Outline: Invalid login
    And I enter my registered "<EmailAddress>" in Email Address input field
    And I do not enter password "<Password>"
    And I click on Sign in button in Already registered section
    Then I an error message is displayed

    Examples:
      | EmailAddress                   | Password |
      | Testerabcde1234@Mailinator.com |          |