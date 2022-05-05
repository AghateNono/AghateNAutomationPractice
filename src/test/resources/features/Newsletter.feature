Feature: Newsletter
  As a user of Practice automation website
  I want to be able to register to the Newsletter
  So that I can receive recent activities of the website

  Scenario: Valid Newsletter
    Given I navigate to "http://automationpractice.com/index.phphttp://automationpractice.com/index.php" automation practice website
    And I enter my "EmailAddress" in the Newsletter Email Address input field
    And I click on the forward button next to the Input field
    Then I am able to successfully subscribe to Newsletter

