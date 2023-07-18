Feature: LoginFeature
  This login feature deals with the login functionality

  @regression
  Scenario: Login with username and password
    Given User navigates to login page
    When User enters in username as "john" and password as "demo"
    And User clicks login button
    Then User should go to the Account page

  Scenario: Login with username and password (Data Table scenario)
    Given User navigates to login page
    And User enters in the following for username and password in login page
      | username | password |
      | john     | demo     |
    And User clicks login button
    Then User should go to the Account page


  Scenario: Login with username and password (Transform scenario--under construction)
    Given User navigates to login page
    And User enters in the following for username and password in login page
      | username | password         |
      | admin    | adminpasswordxxx |
    And User clicks login button
    Then User should go to the Account page

  @smoke
  Scenario Outline: Login with username and password (Examples Table scenario)
    Given User navigates to login page
    And User enters in <username> and <password> to field
    And User clicks login button
    Then User should go to the Account page

    Examples:
      | username | password |
      | john     | demo     |
      | cat      | dog      |
      | cow      | now      |

