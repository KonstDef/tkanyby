Feature: tkany.by

  @Catalogue @Smoke
  Scenario Outline: Catalogue menu links open correct pages on widescreen
    Given User is on "Landing" page
    When User clicks "<category>" category on catalogue navigation list
    Then Catalogue page "<title>" is opened

    Examples:
      | category                       | title                          |
      | Каталог товаров                | Каталог товаров                |
      | Ткани для одежды               | Ткани для одежды               |
      | Ткани для дома                 | Ткани для дома                 |
      | Аксессуары и прикладные товары | Аксессуары и прикладные товары |
      | Новинки                        | Новинки                        |
      | Популярные товары              | Популярные товары              |
      | Распродажи и скидки            | Распродажа                     |
      | Наборы                         | Наборы                         |
      | Уцененные товары               | Уцененные товары               |
      | Скоро в продаже                | Скоро в продаже                |

