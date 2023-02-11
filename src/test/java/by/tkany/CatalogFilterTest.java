package by.tkany;

import framework.BaseTest;
import framework.CustomActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

import static by.tkany.Selectors.*;

public class CatalogFilterTest extends BaseTest {
    @Test(testName = "Catalog Filters | ID 13", description = "Catalog filters select concrete product",
            dataProvider = "CatalogFiltersData", dataProviderClass = DataProviders.class)
    public void test13(String mainCategoryName, String subCategoryName, Map<String, String> filtersItems, String productName ,String productId) {
        CustomActions actions = new CustomActions(driver);

        WebElement mainCategory = driver.findElement(By.xpath(String.format(CATALOG_MAIN_CATEGORY_BY_TEXT_XPATH, mainCategoryName)));
        actions.moveToElement(mainCategory).click().build().perform();

        if (!subCategoryName.isEmpty()) {
            WebElement subCategory = driver.findElement(By.xpath(String.format(CATALOG_SUBCATEGORY_FROM_CATEGORY_PAGE_BY_TEXT_XPATH, subCategoryName)));
            actions.moveToElementTop(subCategory).click().build().perform();
        }

        filtersItems.forEach((filter, item) -> {
            WebElement filterBlock = driver.findElement(By.xpath(String.format(CATALOG_FILTER_PARAMETER_BOX_BY_TEXT_XPATH, filter)));

            WebElement filterExpander = filterBlock.findElement(By.xpath(CATALOG_FILTER_EXPAND_BUTTON_XPATH));
            if (!filterExpander.getAttribute("class").contains("expanded"))
                actions.moveToElementTop(filterExpander).click().build().perform();

            WebElement filterItem;
            if (filter.equals("Цвет"))
                filterItem = filterBlock.findElement(By.xpath(String.format(CATALOG_FILTER_COLOR_PARAMETER_BY_TEXT_XPATH, item)));
            else
                filterItem = filterBlock.findElement(By.xpath(String.format(CATALOG_FILTER_PARAMETER_CHECKBOX_BY_TEXT_XPATH, item)));

            if (!filterItem.isDisplayed()) {
                WebElement more = filterBlock.findElement(By.xpath(CATALOG_FILTER_MORE_BUTTON_XPATH));
                actions.moveToElementTop(more).click().build().perform();
            }
            actions.moveToElementTop(filterItem).click().build().perform();
        });

        WebElement viewFilter = driver.findElement(By.xpath(String.format(CATALOG_VIEW_FILTER_BY_TEXT_XPATH, "Сортировать")));
        actions.moveToElement(viewFilter).click().build().perform();
        WebElement viewFilterItem = driver.findElement(By.xpath(String.format(CATALOG_VIEW_FILTER_OPENED_DROPDOWN_ITEM_BY_TEXT_XPATH, "алфавиту")));
        actions.moveToElement(viewFilterItem).click().build().perform();

        By productByXpath = By.xpath(String.format(CATALOG_PRODUCT_LINK_BY_TEXT_XPATH,productName));
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(productByXpath));
        WebElement product = driver.findElement(productByXpath);
        actions.moveToElementTop(product).click().build().perform();

        WebElement id = driver.findElement(By.xpath(PRODUCT_ARTICLE_XPATH));
        if (!id.getText().equals(productId)) Assert.fail("Product attribute is not correct");
    }
}
