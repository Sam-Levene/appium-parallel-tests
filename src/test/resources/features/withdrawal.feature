@withdrawal
Feature: Withdraw balance

  As an existing Quidco member
  I can withdraw my balance from the app
  So that I can get my cashback into my account

  Scenario Outline: A user logs in and attempts to contact support for assistance
    Given a "Valid Balance User" is not logged in
    When a "Valid Balance User" signs in at the start
    And the user skips notifications and permissions
    And the user attempts to withdraw "<BalanceAmount>" from their balance to their "<BalanceWithdrawalType>"
    Then the balance is reduced by the amount specified
    Examples:
    | BalanceWithdrawalType | BalanceAmount |
    | Bank Account          | £10           |
    | Paypal                | £10           |
    | Amazon Gift Card      | £10           |