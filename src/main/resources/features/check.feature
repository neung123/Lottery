Feature: Check lottery ticket
    As a customer
    I want to check the number of ticket refer to the machines, so that I will know if I won or not.

Background:
    Given a ticket with numbers 89 and 15 and 78

Scenario: Check for won, same position
    When I submit ticket
    And the machine numbers are 89 and 15 and 78
    Then My victory is true

Scenario: Check for won, different position
    When I submit ticket
    And the machine numbers are 15 and 0 and 7
    Then My victory is true

Scenario: Check for lose
    When I submit ticket
    And the machine numbers are 9 and 0 and 7
    Then My victory is false

