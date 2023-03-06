Feature: tkany.by

  @NavigationMenu @Smoke
  Scenario Outline: Header links redirects to correct pages on widescreen
    Given User is on "Landing" page
    Then "<Navigation links>" redirect to info pages
    And "<Authorization links>" redirect to authorization pages
    And "<Phone links>" check callto: number
    And "<Icon labels>" redirect to social pages
    And "<Callback labels>" open callback page

    Examples:
      | Navigation links                                                                                     | Authorization links | Phone links                              | Icon labels                  | Callback labels            |
      | Новости, Контакты, Оплата, Доставка, Вопрос ответ, Отзывы, Акции!, Коллекции, Оферта, Обратная связь | Вход, Регистрация   | +375 (33) 900-10-96, +375 (29) 563-94-24 | socVK, socFB, socODN, socINS | callBackIcon, scheduleIcon |
