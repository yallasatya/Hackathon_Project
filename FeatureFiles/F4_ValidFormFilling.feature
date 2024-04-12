Feature: Form filling with valid emailID
	@regression
  Scenario: Verifying Take a demo button is enabled when valid email id is entered
    Given User clicked on ForCorporates page and selects Wellness Plans
    When user gives all the valid details
    And Schedule a demo button has to be enabled
    Then Thank Message should be displayed
