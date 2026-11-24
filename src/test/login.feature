Feature: Login Functionality

  Scenario: Login with valid credentials

    Given user is on the login page

    When user enters valid username

    And user enters valid password

    And user clicks on login button

    Then user should successfully login