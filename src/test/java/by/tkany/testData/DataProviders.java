package by.tkany.testData;

import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class DataProviders {
    @DataProvider(name = "NavMenuCollapseData")
    public static Object[][] test01Data() {
        return new Object[][]{
                {List.of("Новости", "Контакты", "Оплата", "Доставка", "Вопрос ответ", "Отзывы", "Акции!"),
                        List.of("Коллекции", "Оферта", "Обратная связь")}
        };
    }

    @DataProvider(name = "NavMenuLabelsData")
    public static Object[][] test02Data() {
        return new Object[][]{
                {Map.of("Новости", "https://tkany.by/news/",
                        "Контакты", "https://tkany.by/about/contacts/",
                        "Оплата", "https://tkany.by/about/howto/",
                        "Доставка", "https://tkany.by/delivery/",
                        "Вопрос ответ", "https://tkany.by/faq/",
                        "Отзывы", "https://tkany.by/reviews/",
                        "Акции!", "https://tkany.by/stock/",
                        "Коллекции", "https://tkany.by/collection/",
                        "Оферта", "https://tkany.by/about/",
                        "Обратная связь","https://tkany.by/callback/"),
                        Map.of("Вход","https://tkany.by/auth/?backurl=/",
                                "Регистрация","https://tkany.by/auth/?register=yes&backurl=/"),
                        Map.of("+375 (33) 900-10-96","tel:+375339001096",
                                "+375 (29) 563-94-24","tel:+375295639424"),
                        Map.of("socVK","https://vk.com/shop_tkanyby/",
                                "socFB","https://www.facebook.com/tkanyby/",
                                "socODN","https://ok.ru/group/54861296566478",
                                "socINS","https://www.instagram.com/tkany_by/",
                                "callBackIcon","https://tkany.by/callback/",
                                "scheduleIcon","https://tkany.by/callback/")}
        };
    }

    @DataProvider(name = "ProductSearchData")
    public static Object[][] test04Data() {
        return new Object[][]{
                {"Пальтовая клетка с шерстью зеленая", "11822"}
        };
    }

    @DataProvider(name = "CallbackFormData")
    public static Object[][] test05Data() {
        return new Object[][]{
                {List.of("Ваш телефон*", "Ваше имя")}
        };
    }

    @DataProvider(name = "CatalogMenuLinksData")
    public static Object[][] test10Data() {
        return new Object[][]{
                {"Каталог товаров", "Каталог товаров"},
                {"Ткани для одежды", "Ткани для одежды"},
                {"Ткани для дома", "Ткани для дома"},
                {"Аксессуары и прикладные товары", "Аксессуары и прикладные товары"},
                {"Новинки", "Новинки"},
                {"Популярные товары", "Популярные товары"},
                {"Распродажи и скидки", "Распродажа"},
                {"Товары с кэшбэком", "Товары с кэшбэком"},
                {"Уцененные товары", "Уцененные товары"},
                {"Скоро в продаже", "Скоро в продаже"}
        };
    }

    @DataProvider(name = "CatalogSubMenuData")
    public static Object[][] test11Data() {
        return new Object[][]{
                {"Ткани для одежды", "Армани", "Армани"},
                {"Ткани для одежды", "Трикотаж", "Трикотаж"},
                {"Аксессуары и прикладные товары", "Пряжа", "Пряжа"},
        };
    }
    @DataProvider(name = "CatalogContainersData")
    public static Object[][] test12Data() {
        return new Object[][]{
                {"Ткани для одежды", "Пальтовые",
                        List.of(String.valueOf(8),String.valueOf(true))},
                {"Ткани для дома", "",
                        List.of(String.valueOf(8),String.valueOf(false))},
                {"Аксессуары и прикладные товары", "Пряжа",
                        List.of(String.valueOf(8),String.valueOf(true))},
        };
    }

    @DataProvider(name = "CatalogFiltersData")
    public static Object[][] test13Data() {
        return new Object[][]{
                {"Ткани для одежды", "Трикотаж",
                        Map.of("Цвет", "мультиколор",
                                "Состав", "75% вискоза, 24% п/э, 1% эластан",
                                "Узор", "геометрия",
                                "Назначение", "платья повседневные"),
                        "Трикотаж вискоза принт геометрия", "1851"},
                {"Аксессуары", "",
                        Map.of("Цвет", "красный",
                                "Отделка", "меланж",
                                "Состав", "100% полиамид"),
                        "Пряжа ТЮЛЬ ФИРФИР Дантел 258", "11176"}
        };
    }

    @DataProvider(name = "FastViewData")
    public static Object[][] test14Data() {
        return new Object[][]{
                {"Ткани для одежды", "Вельвет", "Ткань Вельвет темно-бирюзовый", "9590"}
        };
    }

    @DataProvider(name = "ProductPageContainersData")
    public static Object[][] test15Data() {
        return new Object[][]{
                {"Ткани для одежды", "Кружевное полотно", "Кружевное полотно узкое пыльно-серое", "2306"}
        };
    }
}
