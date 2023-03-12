Feature: tkany.by

  @UserPageUnLogin @Smoke
  Scenario Outline: Fast order component for product page is consistent
    Given User is on "Landing" page
    When User clicks "<category>" category on catalogue navigation list
    And User clicks on "<subCategory>" subcategory under catalogue navigation list
    And User opens product page for "<product>"
    And User clicks on "Купить в 1 клик" button
    Then Fast order component is opened
    * Fast order component contains "<product>" title
    * Fast order component contains image
    * Fast order component contains price
    * Fast order component "Имя" can be filled with "TestName"
    * Fast order component "Телефон" can be filled with "+375 29 1234567"
    * Fast order component personal data agreement checkbox is clickable
    * Fast order "Купить в один клик" button is clickable

    Examples:
      | category         | subCategory | product                                    |
      | Ткани для одежды | Вельвет     | Ткань Вельвет темно-коричневый с тиснением |