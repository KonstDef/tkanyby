Feature: tkany.by

  @UserPageUnLogin @Smoke
  Scenario: Button 'Выход' unlogins User
    Given User is logged in
    And User is on "Landing" page
    When User clicks on "Выход" navigation label
    Then There is no "Личный кабинет" navigation label
    And There is no "Выход" navigation label