Feature: Validate of product info

  Background:
    Given the user navigate to the web orders page
    When the user provide valid username "Tester"
    And the user provide valid password "test"

  Scenario Outline: Validation of Edit Order
    * the user click edit button
    * the user change customerName "<customerName>"
    * the user change street "<street>"
    * the user change city "<city>"
    * the user change state  "<state>"
    * the user change zip "<zip>"
    When the user click update button
    Then the user validate update order info
    Examples:
      | customerName | street           | city    | zip   | state |
      | Ariet Stamov | 2200 E Devon ave | chicago | 60018 | IL    |
