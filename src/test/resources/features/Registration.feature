Feature: Registration on Automation Practice website
  As a new user of Automation practice website
  I want to get registered
  So that I can navigate into the website


  Background:
    Given I navigate to "WebPage" automation practice website
    When I click on Sign in hyperlink on the top of the page


  Scenario Outline: Valid Registration
    And I enter my "EmailAddress" in Email Address input field
    And I click on Create an account button
    And I click on a "<Title>" radio button to select a title
    And I enter "<FirstName>" in the First Name input field
    And I enter "<LastName>" in the Last Name input field
    And I enter "<Password>" in the Password input field
    And I select a "<Day>", "<Month>", "<Year>" in the date of birth dropdown list
    And I enter "<Address>" in the Address input field
    And I enter "<City>" in the City input field
    And I select a "<State>" from the State drop down list
    And I enter "<ZipPostalCode>" in the Zip or Postal code field
    And I select a "<Country>" from the Country drop down list
    And I enter"<AdditionalInformation>" in the Additional Information input area
    And I enter "<HomePhone>" in the Home Phone input field
    And I enter "<MobilePhone>" in the Mobile Phone input field
    And I click on the Register button
    Then I must be able to register successfully

    Examples:
      | Title | FirstName | LastName | Password    | Day | Month | Year | Address         | City    | State      | ZipPostalCode | Country       | AdditionalInformation | HomePhone  | MobilePhone  |
      | Mrs   | Aghata    | Malaya   | Malaya12345 | 6   | 6     | 2000 | ABC King Street | Seattle | Washington | 98124         | United States | To be tested          | 5555551234 | +16505130514 |

  Scenario Outline: Invalid Registration
    And I enter my "<EmailAddress>" in Email Address input field
    And I click on Create an account button
    And I click on a "<Title>" radio button to select a title
    And I do not enter any "<FirstName>" in the First Name input field
    And I enter "<LastName>" in the Last Name input field
    And I enter "<Password>" in the Password input field
    And I select a "<Day>", "<Month>", "<Year>" in the date of birth dropdown list
    And I enter "<ZipPostalCode>" in the Zip or Postal code field
    And I enter "<Address>" in the Address input field
    And I enter "<City>" in the City input field
    And I select a "<State>" from the State drop down list
    And I select a "<Country>" from the Country drop down list
    And I enter"<AdditionalInformation>" in the Additional Information input area
    And I enter "<HomePhone>" in the Home Phone input field
    And I enter "<MobilePhone>" in the Mobile Phone input field
    And I click on the Register button
    Then an error message is displayed

    Examples:
      | EmailAddress                   | Title | FirstName | LastName | Password    | Day | Month | Year | Address         | City    | State      | ZipPostalCode | Country       | AdditionalInformation | HomePhone  | MobilePhone  |
      | Testerabcde1234@Mailinator.com | Mr    |           | Malaya   | Malaya12345 | 6   | 6     | 2000 | ABC King Street | Seattle | Washington | 98124         | United States | To be tested          | 5555551234 | +16505130514 |


  Scenario Outline: Registration with already registered Email Address
    And I enter an existing "<EmailAddress>" in Email Address input field
    And I click on Create an account button
    Then a message should be displayed warning me that the email has already been registered

    Examples:
      | EmailAddress                |
      | Testerabc123@Mailinator.com |