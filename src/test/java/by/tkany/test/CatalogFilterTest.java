package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.Browser;
import framework.elements.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static by.tkany.testData.Selectors.*;

public class CatalogFilterTest extends BaseTest {
    @Test(testName = "Catalog Filters | ID13", description = "Catalog filters select concrete product",
            dataProvider = "CatalogFiltersData", dataProviderClass = DataProviders.class)
    public void test13(String mainCategoryName, String subCategoryName, Map<String, String> filtersItems, String productName, String expectedProductId) {
        Label mainCategory = new Label(By.xpath(String.format(CATALOG_MAIN_CATEGORY_BY_TEXT_XPATH, mainCategoryName)));
        mainCategory.moveAndClickByAction();

        if (!subCategoryName.isEmpty()) {
            Label subCategory = new Label(By.xpath(String.format(CATALOG_SUBCATEGORY_FROM_CATEGORY_PAGE_BY_TEXT_XPATH, subCategoryName)));
            subCategory.moveToTop();
            subCategory.clickByAction();
        }

        filtersItems.forEach((filter, item) -> {
            Label filterExpander = new Label(By.xpath(String.format(CATALOG_FILTER_EXPAND_BUTTON_XPATH,filter)));
            if (!filterExpander.getAttribute("class").contains("expanded")) {
                filterExpander.moveToTop();
                filterExpander.clickByAction();
            }

            Label filterItem;
            if (filter.equals("Цвет"))
                filterItem = new Label(By.xpath(String.format(CATALOG_FILTER_COLOR_PARAMETER_BY_TEXT_XPATH, item)));
            else
                filterItem = new Label(By.xpath(String.format(CATALOG_FILTER_PARAMETER_CHECKBOX_BY_TEXT_XPATH,filter, item)));

            if (!filterItem.isDisplayed()) {
                Label more = new Label(By.xpath(String.format(CATALOG_FILTER_MORE_BUTTON_XPATH,filter)));
                more.moveToTop();
                more.clickByAction();
            }
            filterItem.moveToTop();
            filterItem.clickByAction();
        });

        DropDown viewFilter = new DropDown(By.xpath(String.format(CATALOG_VIEW_FILTER_BY_TEXT_XPATH, "Сортировать")));
        viewFilter.moveAndClickByAction();
        TextBox viewFilterItem = new TextBox(By.xpath(String.format(CATALOG_VIEW_FILTER_OPENED_DROPDOWN_ITEM_BY_TEXT_XPATH, "алфавиту")));
        viewFilterItem.moveAndClickByAction();

        Label productLink = new Label(By.xpath(String.format(CATALOG_PRODUCT_LINK_BY_TEXT_XPATH, productName)));
        Browser.waitForjQueryLoad();
        productLink.moveToTop();
        productLink.click();

        TextBox productId = new TextBox(By.xpath(PRODUCT_ARTICLE_XPATH));
        String id = productId.getText();
        Assert.assertEquals(id,expectedProductId,
                String.join("\n","Product id does not equal expected value:",
                        "Actual result: "+id,
                        "Expected result: "+expectedProductId));
    }
}
