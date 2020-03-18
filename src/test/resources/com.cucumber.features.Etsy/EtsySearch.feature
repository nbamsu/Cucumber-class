
Feature: Validation of search in ETSY

  Background:
    Given the user navigate to the Etsy


  Scenario: Validation of Wooden Spoon
    When the user search "Wooden Spoon"
    Then the user validate "Wooden spoon | Etsy"


  Scenario: Validation of MakeUp organizer
    When the user search "Make up Organizer"
    Then the user validate "Make up organizer | Etsy"
