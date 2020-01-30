Feature: Home Page tabs content titles validation

  Scenario: Home Page URL validation
    When User on Home Page
    Then The Home Page URL should be correct

  Scenario: Home Page title validation
    When User on Home Page
    Then The Home Page title should be - "Risk Management Solutions - RMS"

  Scenario: Tab 'How we Serve' by clicking is opening in new Window
    When Click on the on "How We Serve" tab
    Then The "How We Serve" page should be open

  Scenario: Inner tabs of the 'Product & Services' tab are available by moving cursor on it
    When User move cursor on the "Products & Services" tab
    Then User should see "DATA" as the inner_tab
    And User should see "MODELS" as the inner_tab
    And User should see "SERVICES" as the inner_tab
    And User should see "Software" as the inner_tab
    Then User should see "NEWSROOM" inner_tab

  Scenario: Inner tabs of the 'Resources & Insights' tab are available by moving cursor on it
    When User move cursor on the "Resources & Insights" tab
    Then User should see "PUBLICATIONS" as the inner_tab
    And User should see "BLOG" as the inner_tab
    And User should see "EVENTS" as the inner_tab
    And User should see "NEWSROOM" as the inner_tab
    Then User should see "Newsletters" inner_tab

  Scenario: Inner tabs of the 'Company' tab are available by moving cursor on it
    When User move cursor on the "Company" tab
   Then User should see "ABOUT US" as the inner_tab
    And User should see "CAREERS" as the inner_tab
    And User should see "CONTACT US" as the inner_tab
    Then User should see "LEGAL INFORMATION" inner_tab
