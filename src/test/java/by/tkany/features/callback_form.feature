Feature: tkany.by

  @CallBack @Smoke
  Scenario Outline: Link 'Заказать звонок' toggles callback form to open on widescreen
    Given User is on "Landing" page
    When User clicks "Заказать звонок" button
    Then Callback form is displayed
    When User fills "<fields>" with "<data>"
    And User clicks personal data consent checkbox
    And User clicks on "Отправить" button
    Then Success message is displayed

    Examples:
      | fields                | data                            |
      | Ваш телефон, Ваше имя | +375 (29) 000-00-00, AutoTester |