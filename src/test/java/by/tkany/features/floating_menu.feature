Feature: tkany.by

  @FloatingMenu @Smoke
  Scenario: Bottom menu floats with page scrolling
    Given User is on "Landing" page
    Then User sees floating menu
    When User scrolls down to footer
    Then User sees floating menu
    When User scrolls up to navigation menu
    Then User sees floating menu
