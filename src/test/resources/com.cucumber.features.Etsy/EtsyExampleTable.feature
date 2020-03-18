
Feature: Example Table Practice

  Background: this step will navigate Etsy before every scenario
    Given the user navigate to the Etsy


  Scenario Outline: validate Etsy title after search
    When the user search with "<SearchValue>"
    Then the user validate the "<ExpectedTitle>"
    Examples:
      | SearchValue       | ExpectedTitle             |
      | wooden spoon      | Wooden spoon \| Etsy      |
      | make up organizer | Make up organizer \| Etsy |
      | sweater           | Sweater \| Etsy           |
      | rose              | Rose \| Etsy              |
      | birthday cake     | Birthday cake \| Etsy     |
      | microphone        | Microphone \| Etsy        |
      | cable             | Cable \| Etsy             |
      | water bottle      | Water bottle \| Etsy      |
      | mouse             | Mouse \| Etsy             |
      #For Mac user option+command+l
      #for Windows user Ctrl+Alt+L