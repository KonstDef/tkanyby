Feature: tkany.by

  @OrderPage @Smoke
  Scenario Outline: User adds product to card and fills final information
    Given User is on "Landing" page
    When User clicks "<category>" category on catalogue navigation list
    And User clicks on "<subCategory>" subcategory under catalogue navigation list
    And User opens product page for "<product>"
    And User sets <amount> for product
    And User clicks "В корзину" button
    And User clicks "Перейти в корзину" button
    And User clicks on "Оформить заказ" button
    Then Order page is opened

    When User clicks "Далее" button
    Then "Регион доставки" order section is opened
    And "Товары в заказе" section is "approved"
    And "Товары в заказе" section contains "<product>" with <amount>

    When User selects "<city>" city name
    And User sets "<index>" as postal code
    And User clicks "Далее" button
    Then "Доставка" order section is opened
    And "Регион доставки" section is "approved"
    And "Регион доставки" section contains "<city>"

    When User selects "<delivery>" delivery method
    And User clicks "Далее" button
    Then "Оплата" order section is opened
    And "Доставка" section is "approved"
    And "Доставка" section contains "<delivery>"

    When User selects "<payment>" payment method
    And User clicks "Далее" button
    Then "Покупатель" order section is opened
    And "Оплата" section is "approved"
    And "Оплата" section contains "<payment>"

    When User fills "Ф.И.О" input field with "<name>"
    And User fills "Телефон" input field with "<phone>"
    And User fills "Адрес доставки" input field with "<address>"
    And User clicks "Назад" button
    Then "Оплата" order section is opened
    And "Покупатель" section is "approved"
    And "Покупатель" section contains "<address>"


    Examples:
      | category         | subCategory | product                       | amount | city  | index  | delivery                   | payment                    | name       | phone             | address                    |
      | Ткани для одежды | Парча       | Парча-жаккард серебряная роза | 1.5    | Минск | 102 00 | До пункта выдачи ЕВРОПОЧТА | Оплата в пункте самовывоза | Autotester | +375 29 111 22 33 | Tester street 11, TestCity |