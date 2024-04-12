Feature: Form filing with invalid email id
	@regression
  Scenario: Verifying Take a demo button is disabled when invalid email is entered
    Given User clicked on For corporates page and selects wellness plans
    When user gives all the valid details except emailId
    Then Schedule demo button has to be disabled
