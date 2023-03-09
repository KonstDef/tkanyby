Feature: tkany.by

  @FastView @Smoke
  Scenario Outline: Fast view window contains required parts for catalogue page
    Given User is on "Landing" page
    When User clicks "<mainCategory>" category on catalogue navigation list
    And User clicks on "<subCategory>" subcategory under catalogue navigation list
    And User sorts products by "алфавиту"
    And User hovers mouse over "<product>" card image
    And User opens fast view for "<product>"
    Then Fast view window is opened
    * Fast view window contains "<product>" name
    * Fast view window contains product article equals to "<productArticle>"
    * Fast view window contains product images
    * Fast view window contains product characteristics
    * Fast view window contains add to cart button
    * Fast view window contains read more button

    Examples:
      | mainCategory     | subCategory | product                       | productArticle |
      | Ткани для одежды | Вельвет     | Ткань Вельвет темно-бирюзовый | 9590           |