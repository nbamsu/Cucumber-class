@generaltest @Regression
Feature: Validation of Salary Component

  Background: login to teh iceHRM account
    #Given the user login icehrm website
  @test @TC-12 @Smoke
  Scenario:
    Given the user navigate to icehrm website
    When the user provide icehrm username "admin"
    And the user provide icehrm password "admin"
    Then the user click sign in button

  @test @TC-13
  Scenario Template:
  *The user click the payroll button
    * The user click the salary button
    * The user click add new button
    * The user click code "<code>"
    * The user click name "<name>"
    And the user click the save button
    Then user validate "<code>" and "<name>" are saved

    Scenarios:
      | code | name   |
      | 1111 | tttt   |
      | 2222 | dafsdf |
      | 432  | turu   |