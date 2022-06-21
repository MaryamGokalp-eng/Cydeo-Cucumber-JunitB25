
Feature: Examples of Cucumber data table implementations

  #@wip
  #CreateSteps 4 Parameterization passArgument in-->WikipediaStepDefinitions class & pass theArgument Inside
  # the steps -->Steve Jobs
  #For the data table We create pipe under the scenario and pass over some fruit U like scenario below
  Scenario: List of fruits I like
    Then user should see fruits I like
      | kiwi        |
      | banana      |
      | cucumber    |
      | orange      |
      | mango       |
      | grape       |
      | pomegranate |


    #command + option + L for the arrangement
    #to beautify the pipes above
    #mac: command + option + L
    #windows: control + alt + L


    #Scenario below to practice is to put in DataTableSpeDe_ List of String SoI CanUse Java&Collection Logic
    # to Implement & Do my Verification

  Scenario: User should be able to see all 12 months in months dropdown
    Given User is on the page
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |


    # Implement this today 16.06.02 with java part only to understand java & cucumber. Next week implement with selenium
     #Run from the runner class to get the Sniper

 # My table snipers can covert the dataTable.features into same argument we can store the feature table into
  # A list of string