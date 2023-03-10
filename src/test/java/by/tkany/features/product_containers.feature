Feature: tkany.by

  @ProductContainers @Smoke
  Scenario Outline: Product page contains required parts on widescreen
    Given User is on "Landing" page
    When User clicks "<category>" category on catalogue navigation list
    And User clicks on "<subCategory>" subcategory under catalogue navigation list
    And User opens product page for "<product>"
    Then Product page "<product>" is opened
    * Product page contains catalog navigation
    * Product page contains breadcrumbs
    * Product page contains product navigation tabs
    * Product page contains short description
    * Product page contains article equals "<article>"
    * Product page contains title equals "<product>"
    * Product page contains 'add to cart' button
    * Product page contains 'fast order' button
    * Product page contains product image
    * Product page contains product properties

    Examples:
      | category                       | subCategory      | product         |
      | Аксессуары и прикладные товары | Волосы для кукол | Пряжа для волос |