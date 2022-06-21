Feature: Wikipedia search functionality and verifications

  #WKSF-4356 !! TEST CASE NUMBERS -->> POTENTIAL JIRA TICKET NUMBER

  Background: User is on the home page
    Given User is on Wikipedia home page

  Scenario: Wikipedia Search Functionality Title Verification
   #Given User is on Wikipedia home page above line !! background we run it on all of them using like before
    When User types "Bill Gates" in the wiki search box
    And User clicks wiki search button
    Then User sees "Bill Gates" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  #Could add one more line
  #@image-header
  #Scenario: Wikipedia Search Functionality Image Header Verification
   # Given User is on Wikipedia home page
   # When User types "Steve Jobs" in the wiki search box
    #And User clicks wiki search button
    #Then User sees "Steve Jobs" is in the image header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header

 #When provide scenario outLine above u need to give example table below otherwise u get compiler error
    # Header: searchValue, expectedTitle & expectedMainHeader and then make up some name on my table below!

    @soccerPlayers
    Examples: search values we are going to be using in this scenario is as below
      | searchValue       | expectedTitle     | expectedMainHeader |
      | Bill Gates        | Bill Gates        | Bill Gates         |
      | Cristiano Ronaldo | Cristiano Ronaldo | Cristiano Ronaldo  |
      | Chuck Norris      | Chuck Norris      | Chuck Norris       |
      | Marie Curie       | Marie Curie       | Marie Curie        |
      | Lady Gaga         | Lady Gaga         | Lady Gaga          |
      | Bob Marley        | Bob Marley        | Bob Marley         |
      | Antony Hopkins    | Antony Hopkins    | Antony Hopkins     |
      | Kate Winslet      | Kate Winslet      | Kate Winslet       |

    @scientists
    Examples:
      | searchValue  | expectedTitle | expectedMainHeader |
      | Marie Curie  |    | Marie Curie        |
      | Lady Gaga    | Lady Gaga     | Lady Gaga          |
      | Kate Winslet | Kate Winslet  | Kate Winslet       |

      #to beautify the pipes above
      #mac: command + option + L
      #windows: control + alt + L
      # Summary thisLineOpen&GoToGoogle page.com..>Wikipedia
      #RunLineOpen&GoToMyTitle1stColunThenGoToTheNextOneUntilTableFinish
      #run the class by passing the tag