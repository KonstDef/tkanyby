Feature: tkany.by

  @Catalogue @Smoke
  Scenario Outline: Catalog filters select concrete product
    Given User is on "Landing" page
    When User clicks "<category>" category on catalogue navigation list
    And User clicks on "<subCategory>" subcategory under catalogue navigation list
    And User sets "<filterValues>" for "<filterNames>" filter
    And User opens product page for "<product>"
    Then Product page "<product>" is opened

    Examples:
      | category         | subCategory | filterNames                    | filterValues                                             | product                          |
      | Ткани для одежды | Трикотаж    | Цвет, Состав, Узор, Назначение | мультиколор, 75% вискоза, геометрия, платья повседневные | Трикотаж вискоза принт геометрия |
      | Аксессуары       |             | Цвет, Отделка, Состав          | красный, меланж, 100% полиамид                           | Пряжа ТЮЛЬ ФИРФИР Дантел 258     |