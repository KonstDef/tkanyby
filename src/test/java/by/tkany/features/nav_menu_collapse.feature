Feature: tkany.by

  @NavigationMenu @Smoke
  Scenario Outline: Header menu links are collapsed with screen width
    Given User is on "Landing" page
    Then Visible links list is similar to "<visible expected>"
    When User clicks on Hamburger button
    Then Hidden links list is similar to "<hidden expected>"

    Examples:
      | visible expected                                  | hidden expected                                  |
      | Новости, Контакты, Оплата, Доставка, Вопрос ответ | Отзывы, Акции!, Коллекции, Оферта, Обратная связь |