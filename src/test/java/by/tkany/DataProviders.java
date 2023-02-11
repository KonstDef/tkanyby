package by.tkany;

import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class DataProviders {
    @DataProvider(name = "NavMenuCollapseData")
    public static Object[][] test1Data() {
        return new Object[][]{
                {1024, 566,
                        List.of("Новости", "Контакты", "Оплата", "Доставка", "Вопрос ответ"),
                        List.of("Отзывы", "Акции!", "Коллекции", "Оферта", "Обратная связь")},
                {375, 812,
                        List.of(),
                        List.of("Новости", "Контакты", "Оплата", "Доставка", "Вопрос ответ",
                                "Отзывы", "Акции!", "Коллекции", "Оферта", "Обратная связь")},
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
                        "Трикотаж вискоза принт геометрия","1851"},
                {"Аксессуары", "",
                        Map.of("Цвет", "красный",
                                "Отделка", "меланж",
                                "Состав", "100% полиамид"),
                        "Пряжа ТЮЛЬ ФИРФИР Дантел 258","11176"},
        };
    }
}
