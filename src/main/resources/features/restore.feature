Feature: Restore the lottery
    As a customer
    I want to restore my ticket and check, so that I will reuse my ticket with the lottery machine.

Background:
    Given a ticket with numbers 89 and 15 and 78

Scenario: Save then buy new ticket and restore
    When I save my ticket
    And I buy ticket with numbers 0 and 7 and 4
    And I restore an old ticket
    Then My ticket should be with numbers 89 and 15 and 78

Scenario: Doesn't save then buy new ticket and restore
   When I buy ticket with numbers 0 and 7 and 4
   And I restore an old ticket
   Then My ticket should be with numbers 0 and 7 and 4
