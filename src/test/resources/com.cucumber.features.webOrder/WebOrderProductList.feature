Feature: This is for web order all products
  Background:
    Given the user navigate to the web orders page

  Scenario: Validation of all product data

    When the user provide valid username
    And the user provide valid password
    Then user click view all product button
    And the user validate product table
  @positives
    Scenario:  Web Order login negative testing
      When the user provider userName "Test"
      And the user provided password "admin"
      Then the user validate text "Invalid Login or Password."
  @negative
  Scenario:  Web Order login negative testing with numbers
    When the user provider userName 1234
    And the user provided password 4567
    Then the user validate text "Invalid Login or Password."
  @negative
  Scenario:  Web Order login negative testing2
    When the user provide userName "Test" and password "tt"
    Then the user validate text "Invalid Login or Password."

