@Regression
Feature: WebOrders login functionality
@positive @Smoke @TC-18
  Scenario: WebOrders login positive testing1
    Given the user navigate to the web orders page
    When the user provide valid username
    And the user provide valid password
    Then the user should see home page

  Scenario: WebOrders menu positive testing2
    Given the user navigate to the web orders page
    When the user provide valid username
    And the user provide valid password
    Then the user validate order menu list