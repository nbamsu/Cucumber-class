@Regression
Feature: Validate of product info

  Background:
    Given the user navigate to the web orders page
    When the user provide valid username
    And the user provide valid password

  @Smoke @TC-23
  Scenario Outline: Validation of Edit Order
    * the user click edit button
    * the user change customerName "<customerName>"
    * the user change street "<street>"
    * the user change city "<city>"
    * the user change zip "<zip>"
    * the user change state  "<state>"
    When the user click update button
    Then the user validate update order info "<customerName>""<street>""<city>""<zip>""<state>"
    Examples:
      | customerName | street           | city        | zip   | state |
      | Ariet Stamov | 2200 E Devon ave | Chicago     | 60018 | IL    |
      | Muammer      | 2200 E Devon ave | Des Plaines | 60018 | IL    |
      | Aria         | 2100 w Davon ave | Des Plaines | 60018 | NY    |
      | Aibek        | 2200 E Devon ave | Des Plaines | 60018 | IL    |
      | Baha         | 2200 E Devon ave | Des Plaines | 60018 | IL    |
