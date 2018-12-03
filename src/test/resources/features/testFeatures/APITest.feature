Feature: World countries API
  As a user
  I want to be able see various country details


  Scenario: Get country details from capital city reference
    Given i retrieve country details of city code AMS
    Then Country name is displayed as Netherlands
    And Calling code is displayed as 31
    And Translation of country name in spanish is Países Bajos