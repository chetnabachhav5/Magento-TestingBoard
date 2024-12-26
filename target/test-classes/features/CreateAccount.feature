Feature: Create Account Feature

  Scenario: Navigate to the Magento website
    Given the user is at Magento homepage
    Then page title should contains "Home Page"
@Test
  Scenario: Create a new customer account
    Given the user is at Magento homepage
    When the user clicks on Create an Account link
    And the user enters "John" as the first name
    And the user enters "Doe" as the last name
    And the user enters "pushkar1234567@gmail.com" as the email address
    And the user enters "Password123" as the password
    And the user confirms "Password123" as the confirm password
    And the user clicks on Create an Account button
    Then the user account should be created successfully