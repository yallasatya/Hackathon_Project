Feature: Doctor Details
	@smoke
  Scenario: User finds first five doctor details
    Given user is on the practo home page
    Then user validates the practo home page title
    When user clicks on find doctors
    And user selects location feild
    And user selects specialist feild
    And user applies filters for patient stories feild
    And user applies filters for experience feild
    And user applies filters for fee feild
    And user applies filters for availability feild
    And user applies filters for sort feild
    Then user stores the top five doctors in a list and prints their detials
