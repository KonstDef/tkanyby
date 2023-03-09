Feature: tkany.by

  @BackToTop @Smoke
  Scenario: Link 'Заказать звонок' toggles callback form to open on widescreen
    Given User is on "Landing" page
    Then "Back to top" button "is not" visible
    When User scrolls down to footer
    Then "Back to top" button "is" visible
    And User clicks on "Back to top" button
    Then Screen is returned to top
    And "Back to top" button "is not" visible