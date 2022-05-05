Feature: Update existing account
  As a user of Practice automation website
  I want to be able to register to the Newsletter
  So that I can receive recent activities of the website

  Scenario Outline:
    Given I navigate to "WebPage" automation practice website
    When I click on Sign in hyperlink on the top of the page
    And I enter my registered "<EmailAddress>" in Email Address input field
    And I enter password "<Password>"
    And I click on Sign in button in Already registered section
    And I click on My personal information button
    And I enter a different "<FirstName>" in the first name input field
    And I enter "<CurrentPassword>" in the current password input field
    And I click on Save button
    Then my personal information is successfully updated

    Examples:
      | EmailAddress                   | Password    | FirstName | CurrentPassword |
      | Testerabcde1234@Mailinator.com | Malaya12345 | Aila      | Malaya12345     |
