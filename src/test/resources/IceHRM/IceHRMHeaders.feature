@dataTable
Feature: this is example of data table
  @first @Smoke @TC-7
  Scenario: This scenario for log in to the iceHRM

    Given the user navigate to icehrm website
    When the user provide icehrm username "admin"
    And the user provide icehrm password "admin"
    Then the user click sign in button

  @second @TC-8
  Scenario: Validation of admin headers
    When the user click the admin button
    Then teh user should see following headers
      | Dashboard               |
      | Company Structure       |
      | Job Details Setup       |
      | Qualifications Setup    |
      | Projects/Client Setup   |
      | Overtime Administration |
      | Employee Custom Fields  |
      | Company Loans           |

    #tags must be testcase id or @smoke, @regression, name of your component
  @TC-1234 @Smoke
  Scenario: Validate personal Info
    When the user click the personal information button
    Then the user should see following headers
      | Dashboard          |
      | Basic Information  |
      | Qualifications     |
      | Dependents         |
      | Emergency Contacts |