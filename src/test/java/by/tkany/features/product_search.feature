Feature: tkany.by

  @ProductSearch @Smoke
  Scenario Outline: Selecting product at search field redirects to product page
    Given User is on "Landing" page
    When User enters "<product>" into search field
    Then User sees "<product>" card under search field
    When User clicks on "<product>" card under search field
    Then Product page "<product>" is opened

    Examples:
      | product                            |
      | Пальтовая клетка с шерстью зеленая |