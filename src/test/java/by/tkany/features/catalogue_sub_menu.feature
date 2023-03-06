Feature: tkany.by

  @Catalogue @Smoke
  Scenario Outline: Catalogue menu links show submenu on float on widescreen
    Given User is on "Landing" page
    When User moves mouse on "<category>" category at catalogue navigation list
    And User clicks "<subCategory>" subCategory at catalogue navigation list
    Then Catalogue page "<subCategory>" is opened

    Examples:
      | category                       | subCategory |
      | Ткани для одежды               | Армани      |
      | Ткани для одежды               | Трикотаж    |
      | Аксессуары и прикладные товары | Пряжа       |

