Feature: Login

    Scenario: Successful login
        Given I open the login page
        When I enter username "John Doe" and password "ThisIsNotAPassword"
        And I click login
        Then I should see the dashboard

    Scenario: Unsuccessful login
        Given I open the login page
        When I enter username "Johnny" and password "BlackFlag"
        And I click login
        Then I should see login failed message