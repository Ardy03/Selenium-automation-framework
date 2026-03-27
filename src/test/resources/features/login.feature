Feature: Login Feature

  Scenario Outline: Login dengan berbagai user
    Given user membuka halaman login
    When user login dengan username "<username>" dan password "<password>"
    Then user melihat hasil "<expected>"

    Examples:
      | username  | password              | expected |
      | tomsmith  | SuperSecretPassword! | success  |
      | wronguser | wrongpass            | error    |