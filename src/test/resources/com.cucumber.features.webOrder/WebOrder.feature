@Regression
Feature:  Web Orders


  Background:

    Given the user navigate to the web orders page
    When the user provide valid username
    And the user provide valid password

  @TC-15
  Scenario Template:
    * The user click order button
    * The user select product "<product>"
    * The user give quantity "<quantity>"
    * the user change customerName "<customerName>"
    * the user change street "<street>"
    * the user change city "<city>"
    * the user change zip "<zip>"
    * the user change state  "<state>"
    * user choose the card "<card>"
    * the user provide cardNumber "<cardnumber>"
    * *user enter expiration date "<expire>"
    * user press process button
    * user click view all orders button
    * the user validate update order info "<product>""<quantity>""<customerName>""<street>""<city>""<zip>""<state>""<card>""<cardnumber>""<expire>"
    * The user click order button
    Examples:
      | product     | quantity | customerName | street        | city        | zip   | state | card             | cardnumber          | expire |
      | MyMoney     | 10       | Ariet        | 2400 Your st  | Chicago     | 60657 | IL    | Visa             | 1234567789123456789 | 04/19  |
      | FamilyAlbum | 20       | Baha         | 234 Dundee Rd | Los Angeles | 3256  | CA    | American Express | 321654987321654978  | 03/20  |
      | ScreenSaver | 30       | Dimitry      | 5588 Dody ave | Palo Alto   | 79822 | CA    | MasterCard       | 3215874987321654978 | 08/24  |
