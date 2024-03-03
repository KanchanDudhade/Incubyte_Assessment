Feature: Compose Email in Gmail

  Scenario: Compose and send an email with predefined subject and body
    Given User am on the Gmail homepage
    When User click on the Compose button
    And User fill in recipient's email, subject, and body
    And User click on the Send button
    Then the email should be sent successfully
