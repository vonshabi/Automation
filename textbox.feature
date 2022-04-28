Feature: Text box

  Scenario: Create Account
    Given I have written my email "kalleankassyster@gmail.com"
    Given I have written my username "kalleankassyster"
    Given I have written my password "Kalleankassyster1!"
    When I click the signup button
    Then Another page is displayed

  Scenario: Creating an existing account
    Given I have written my email "kalleankassyster@gmail.com"
    Given I have written my username "kalleankassyster"
    Given I have written my password "Kalleankassyster1!"
    When I click the signup button
    Then It cannot create an account

  Scenario: Create an account with at least 100 characters
      Given I have written my email "kaltrina.shabanaj@hotmail.com"
      Given I have written my username "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaallllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"
      Given I have written my password "Moisesq-123"
      When I click the signup button
      Then It cannot create an account, too many characters

    Scenario: Create account without email
      Given I have written my username "kanelsocker"
      Given I have written my password "Moisesq-123"
      When I click the signup button
      Then It cannot create an account, mail is missing
