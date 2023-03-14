Feature: tkany.by

  @Catalogue @Smoke
  Scenario: Catalog filters select concrete product
    Given User is on "Landing" page
    When User clicks "Ткани для одежды" category on catalogue navigation list
    And User clicks on "Трикотаж" subcategory under catalogue navigation list
    And User sets "мультиколор" for "Цвет" filter
    And User sets "75% вискоза" for "Состав" filter
    And User sets "геометрия" for "Узор" filter
    And User sets "платья повседневные" for "Назначение" filter
    And User opens product page for "Трикотаж вискоза принт геометрия"
    Then Product page "Трикотаж вискоза принт геометрия" is opened

  @Catalogue @Smoke
  Scenario: Catalog filters select concrete product
    Given User is on "Landing" page
    When User clicks "Аксессуары" category on catalogue navigation list
    And User sets "красный" for "Цвет" filter
    And User sets "меланж" for "Отделка" filter
    And User sets "100% полиамид" for "Состав" filter
    And User opens product page for "Пряжа ТЮЛЬ ФИРФИР Дантел 258"
    Then Product page "Пряжа ТЮЛЬ ФИРФИР Дантел 258" is opened