Feature: Test a web Page and Verify its accessibility

  Scenario: Verify web Page is accessible
    Given I navigate to Test webapage
    When I click on Login button
    Then Login form is Displayed