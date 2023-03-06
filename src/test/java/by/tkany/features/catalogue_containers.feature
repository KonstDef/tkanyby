Feature: tkany.by

  @Catalogue @Smoke
  Scenario Outline: Catalogue menu links open correct pages on widescreen
    Given User is on "Landing" page
    When User clicks "<category>" category on catalogue navigation list
    And User clicks on "<subCategory>" subcategory under catalogue navigation list
    Then Catalog menu expand button is present on page
    And There are 8 product filters on page
    And There are product cards on page
    And Pagination "<is/not>" expected

    Examples:
      | category                       | subCategory | is/not |
      | Ткани для одежды               | Пальтовые   | is     |
      | Ткани для дома                 |             | is not |
      | Аксессуары и прикладные товары | Пряжа       | is     |
