Feature: tkany.by

  @Cart @Smoke
  Scenario Outline: User adds product to cart
    Given User is on "Landing" page
    When User clicks "<category>" category on catalogue navigation list
    And User clicks on "<subCategory>" subcategory under catalogue navigation list
    And User opens product page for "<product>"
    And User sets <initial amount> for product
    And User clicks "В корзину" button
    Then "Product confirm" component is displayed
    When User changes amount of product at "Cart add" component from <initial amount> to <changed amount> with buttons
    And User clicks "Перейти в корзину" button
    Then Product "<product>" is present with <changed amount> amount

    Examples:
      | category         | subCategory | product                       | initial amount | changed amount |
      | Ткани для одежды | Парча       | Парча-жаккард серебряная роза | 1.5            | 0.3            |