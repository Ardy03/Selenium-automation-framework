Feature: Login Feature

  Scenario: Login valid
    Given user membuka halaman login
    When user login dengan username "tomsmith" dan password "SuperSecretPassword!"
    Then user berhasil login

  Scenario: Login invalid password
    Given user membuka halaman login
    When user login dengan username "tomsmith" dan password "wrongpass"
    Then muncul pesan "Your password is invalid!"