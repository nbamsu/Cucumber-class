@qualification @Regression
Feature: Testing person qualification

  Background: This will logIn to Ichrm website
    Given the user navigate to icehrm website
    When the user provide icehrm username "admin"
    Then the user provide icehrm password "admin"
    * the user click sign in button
@Smoke @TC-10
  Scenario: Validation of personal info
    Given the user click qualification step button
    Then the user click education tab
    And the user validate personal info displaed
      | Bachelors Degree | Science          |
      | Diploma          | USA              |
      | Masters Degree   | Computer Science |
      | Doctorate        | Management       |

  @language @Smoke @TC-11
  Scenario: Validation language
    Given the user click qualification step button
    Then the user click language button
    Then the user validate language info
      | en         | English   |
      | fr         | French    |
      | de         | German    |
      | zh         | Chinese   |
      | aa         | Afar      |
      | tt         | Abkhaz    |
      | ae         | Avestan   |
      | af         | Afrikaans |
      | ak         | Akan      |
      | am         | Amharic   |
      | an         | Aragonese |
      | ar         | Arabic    |
      | techtorial | Assamese  |
      | av         | Avaric    |
      | ay         | Aymara    |

   @language1
  Scenario: Validation language1
    Then the user validate language info with header
      | Name       | Description |
      | en         | English     |
      | fr         | French      |
      | de         | German      |
      | zh         | Chinese     |
      | aa         | Afar        |
      | tt         | Abkhaz      |
      | ae         | Avestan     |
      | af         | Afrikaans   |
      | ak         | Akan        |
      | am         | Amharic     |
      | an         | Aragonese   |
      | ar         | Arabic      |
      | techtorial | Assamese    |
      | av         | Avaric      |
      | ay         | Aymara      |

