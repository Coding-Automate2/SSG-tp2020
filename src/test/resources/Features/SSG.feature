
Feature: to test login functionality
  Scenario: Check login is successful with valid credential
    Given user is on login page
    When user enters username and selects currency
    And clicks submit button
    Then user clicks game lobby link
    Given user navigates to another tab
    And closes alert popup
    Then selects the tp2020 game
    And navigates to game table
    Then shows the bet limit
    And checks the balance
    And wait for timer
    Then selects the chip
    And place the bet
    Then checking total bet
    And checks the total balance
    And checking the win amount
    Then gets the Total balance
