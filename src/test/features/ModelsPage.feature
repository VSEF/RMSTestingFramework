Feature: Validating Models Page

  Scenario: Models' Page URL validation
    Given User is on Home Page
    When Click on the "Products & Services" tab
    And Navigate to "Overview" link and click on it
    Then User should be on website with URL - "https://www.rms.com/products/models"

  Scenario: Models' Page Title validation
    Given User is on Home Page
    When Click on the "Products & Services" tab
    And Navigate to "Overview" link and click on it
    Then The title of Web Page should be - "Models & Data – Risk Management Solutions - RMS"

  Scenario: All types of model presenting validation
    When User is on Models Page
    Then User can see "AGRICULTURE" type of models
    And User can see "EARTHQUAKE" type of models
    And User can see "HWIND" type of models
    And User can see "MARINE" type of models
    And User can see "TERRORISM" type of models
    And User can see "TSUNAMI" type of models
    And User can see "WINDSTORM" type of models
    And User can see "CYBER" type of models
    And User can see "FLOOD" type of models
    And User can see "LIFERISKS" type of models
    And User can see "SEVERE" type of models
    And User can see "TROPICAL" type of models
    And User can see "WILDFIRE" type of models
    Then User should see "WINTER" type of models