Feature: Test Automation Case Study-1

  Background:
    Given homepage is open
    Then I close the pop up


  Scenario: task one
    Given title should verify
    When I search for "drone"
    Then search result "drone" should be seen

  Scenario: task two
    Given I open "Account" dropdown menu
    And sign in page click
    When I write email address "demokloia@gmail.com" and password "123456789Ks."
    And click login button
    Then verify successful login

  Scenario: task three
    Given I open "Account" dropdown menu
    And sign in page click
    And I open sign in with google
    And I switch to google page
    And I write email address "demokloia" then click forward button
    And I write password "123456789Ks." then click forward button
    Then verify loading page
    When Open new tab and go to bestbuy
    Then verify successful login

  Scenario: task four
    Given I open menu
    And I open "Audio" item
    And I open "Headphones" item
    And I open "Wireless Headphones" item page
    And I filter by "Brand A-Z" in item page
    And filter brands show more
    And I select "Philips" from Brand filtered results
    And show filters results
    And Click "2"nd product on the search result page
    And Click save button
    When I open "Saved Items" dropdown menu
    Then Verify that the title of saved product is on the list

