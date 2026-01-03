Feature: Appointment

  Scenario: Successful Appointment
    Given I open the login page
    And I enter username "John Doe" and password "ThisIsNotAPassword"
    And I click login
    And I should see the dashboard
    When I fill the appointment form
    Then I should see booking confirmation text