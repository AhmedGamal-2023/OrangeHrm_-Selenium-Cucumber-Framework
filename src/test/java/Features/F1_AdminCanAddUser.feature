Feature: Verify the Add function

  @SmokeTesting
  Scenario: validate the Admin can add user then and delete User
    Given in login page, Enter Username and Enter Password then click on login button
    When in Home page, Click on Admin tab on the left side menu
    And Get the number of records found
    And Click on add button
    And Fill the required data
    And Click on save button
    Then Verify that the number of records increased by 1
    And Search with the username for the new user
    And Delete the new user
    Then Verify that the number of records decreased by 1