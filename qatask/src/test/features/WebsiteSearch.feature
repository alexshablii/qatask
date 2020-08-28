Feature: Website search

  Scenario: Search result is relevant to search keyword
    Given the Search panel is open
    And user types search keywords "payments"
    When the user clicks the submit button
    Then the Search WEX page is open
    And the search result is relevant

  Scenario: No search result found
    Given the Search panel is open
    And user types search keywords "@#$#@$#"
    When the user clicks the submit button
    Then the "Sorry, there are no results that meet this criteria." message is displayed

  Scenario: Search by group
    Given the Search panel is open
    When user selects "Fleet" group from the dropdown menu
    And user types search keywords "payments"
    And the user clicks the submit button
    Then the Search WEX page is open
    And the selected group is highlighted on the menu
    And the search result is relevant