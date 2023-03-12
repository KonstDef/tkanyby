Feature: tkany.by

  @UserPageMenu @Smoke
  Scenario Outline: Tab links switch tabs at User page on widescreen
    Given User is logged in
    And User is on "Landing" page
    When User clicks on "Личный кабинет" navigation label
    And User clicks on "<userTab>" user tab link
    Then User page "<userTab>" is opened

    Examples:
      | userTab              |
      | Персональные данные  |
      | Профили покупателя   |
      | История заказов      |
      | Личный счет          |
      | Моя корзина          |
      | Подписка на рассылку |