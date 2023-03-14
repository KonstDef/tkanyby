Feature: tkany.by

  @UserPageLogin @Smoke
  Scenario Outline: User logins with correct credentials
    Given User is on "Landing" page
    When User clicks on "Вход" navigation label
    And User enters "<login>" to "Логин" field
    And User enters "<password>" to "Пароль" field
    And User click on "Войти" button
    Then User sees success authorization page

    Examples:
      | login       | password |
      | successAuto | pwd12345 |