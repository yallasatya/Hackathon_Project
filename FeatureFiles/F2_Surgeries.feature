Feature: surgerieslist
	@smoke
  Scenario: extracting and printing the list of surgeries
    Given user clicks on the surgeries
    Then user extracts and stores the list of surgeries names and prints them in a list
