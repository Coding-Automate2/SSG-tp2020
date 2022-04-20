Feature: to enter into game

  Scenario: Check entering the game is working fine or not.
    Given user navigates to another tab
    And closes alert popup
    When selects the tp2020 game
    And navigates to game table
    Then shows the bet limit
