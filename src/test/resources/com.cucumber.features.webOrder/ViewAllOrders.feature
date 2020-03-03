Feature: Creating new file
  @Order @smoke
  Scenario: Product page  testing1
    Given the user navigate to the web orders page
    When the user provide valid username "Tester"
    And the user provide valid password "test"
    * the user have to validate "List of all orders" header is displayed
