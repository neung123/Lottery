Feature: Set the lottery machine
    As a manager
    I want to set the number of the lottery machine, so that I can manage the results.

Background:
    Given a ticket with numbers 1 and 2 and 3

Scenario: Set a lottery machine to won
    When set lotterry machine min = 2 and max = 3
    And I submit ticket
    And I operate the machine
    Then My victory is true

Scenario: Set a lottery machine to lose
    When set lotterry machine min = 4 and max = 5
    And I submit ticket
    And I operate the machine
    Then My victory is false
