@Regression
Feature: Search summer dress

  Background: The user can navigate to the web page
    Then user navigate to automation practice page

  @Smoke
  Scenario Outline: validation of search
    * the user search with value "<searchValue>"
    * the user validate title of page "<title>"
    * te user validate search value "<searchResult>"

    Examples:
      | searchValue  | title             | searchResult     |
      | Summer Dress | Search - My Store | \"SUMMER DRESS\" |
      | Dress        | Search - My Store | \"DRESS\"        |
      | Shirts       | Search - My Store | \"SHIRTS\"       |

  @Smoke
  Scenario Outline: validation of search with data Table
    * the user search with value "<searchValue>"
    * the user validate title of page
      | Title | <title> |
    * te user validate search value "<searchResult>"

    Examples:
      | searchValue  | title             | searchResult     |
      | Summer Dress | Search - My Store | \"SUMMER DRESS\" |
      | Dress        | Search - My Store | \"DRESS\"        |
      | Shirts       | Search - My Store | \"SHIRTS\"       |

  @docString
  Scenario: This is for doc types
    * the user search with doc types
      """
      Techtorial Academy 2019 summer dress for students
      for 70 students etc.
      """