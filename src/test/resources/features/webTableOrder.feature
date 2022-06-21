Feature: Web table user order feature


  Scenario: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "american express"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table

    #Iconvert my table below into scenario outline and WeCaNot do Scenario outline without provide an example table
   #xample below are given to create a Parameterization Type We ConvertInto Parameterization intoScenario Outline
   # This Step->When user selects product type "<productType>". So The mention Step does not change
  Scenario Template: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipcode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table

    #control each table when We are on Runner Class using scenario outline
    #Tata table allows us to pass collection type into a step in feature file
    #Scenario outline is completely different, It's similar approach to Parameterization. But instead of passing the
    #test data inside of the step, we provide a test data as a table under our Scenario outline
    #When You change the name on the custom name test failure due to not match at expectedName
    @femaleScientists
    Examples: Famous female scientists
      |productType|quantity|customerName |street    |city  |state  |zipcode|cardType|cardNumber      |expDate|expectedName |
      |MoneyCog   |2       |Marie Curie  |London st |London|England|50505  |Visa    |1111222233334444|12/24  |Marie Curie  |
      |Familybea  |3       |Rachel Carson|London st |London|England|50505  |Visa    |1111222233334444|12/24  |Rachel Carson|
      |Screenable |4       |Marie Tharp  |London st |London|England|50505  |Visa    |1111222233334444|12/24  |Marie Tharp  |
      |MoneyCog   |5       |Rachel Carson|London st |London|England|50505  |Visa    |1111222233334444|12/24  |Rachel Carson|
      |MoneyCog   |6       |Mary Anning  |London st |London|England|50505  |Visa    |1111222233334444|12/24  |Mary Anning  |

    #scenario outline
    @maleScientist
    Examples: Famous male scientists
      |productType|quantity|customerName|street   |city  |state  |zipcode|cardType|cardNumber      |expDate|expectedName|
      |MoneyCog   |2       |Carl Hart   |London st|London|England|50505  |Visa    |1111222233334444|12/24  |Carl Hart   |
      |Familybea  |3       |Bill Nye    |London st|London|England|50505  |Visa    |1111222233334444|12/24  |Bill Nye    |
      |Screenable |4       |CV Raman    |London st|London|England|50505  |Visa    |1111222233334444|12/24  |CV Raman    |
      |MoneyCog   |5       |Galileo     |London st|London|England|50505  |Visa    |1111222233334444|12/24  |Galileo     |
      |MoneyCog   |6       |Isaac Newton|London st|London|England|50505  |Visa    |1111222233334444|12/24  |Isaac Newton|
      |MoneyCog   |6       |John Muir   |London st|London|England|50505  |Visa    |1111222233334444|12/24  |John Muir   |


    # The plugIn we add is to keep track of the failure scenario