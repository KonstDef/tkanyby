package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.elements.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static by.tkany.testData.Selectors.*;

public class CatalogContainersTest extends BaseTest {
    @Test(testName = "CatalogContainers | ID12", description = "Catalog contains required containers on widescreen",
            dataProvider = "CatalogContainersData", dataProviderClass = DataProviders.class)
    public void testID12(String mainCategoryName, String subCategoryName, List<String> expectedResults) {
        SoftAssert softAssert = new SoftAssert();

        Label mainCategory = new Label(By.xpath(String.format(CATALOG_MAIN_CATEGORY_BY_TEXT_XPATH, mainCategoryName)));
        mainCategory.moveAndClickByAction();

        if (!subCategoryName.isEmpty()) {
            Label subCategory = new Label(By.xpath(String.format(CATALOG_SUBCATEGORY_FROM_CATEGORY_PAGE_BY_TEXT_XPATH, subCategoryName)));
            subCategory.moveToTop();
            subCategory.clickByAction();
        }

        Label catalogMenuHead = new Label(By.xpath(CATALOG_MENU_TOGGLE_XPATH));
        softAssert.assertTrue(catalogMenuHead.isDisplayed(),
                "Catalog menu expand button is not present on page.\n");

        Label catalogFilters = new Label(By.xpath(String.format(CATALOG_FILTER_EXPAND_BUTTON_XPATH,"")));
        int filtersCount = catalogFilters.countElements();
        int expectedFiltersNum = Integer.parseInt(expectedResults.get(0));
        softAssert.assertEquals(filtersCount,expectedFiltersNum,
                String.join("\n","Products filter count does not equal expected value:",
                        "Actual result: "+filtersCount,
                        "Expected result: "+expectedFiltersNum));

        Label catalogBreadcrumbs = new Label(By.xpath(String.format(CATALOG_BREADCRUMBS_LINK_BY_TEXT_XPATH, "")));
        boolean isBreadcrumbsActual = catalogBreadcrumbs.isDisplayed();
        softAssert.assertTrue(isBreadcrumbsActual, "Breadcrumbs are not displayed but were expected");

        Label catalogProducts = new Label(By.xpath(String.format(CATALOG_PRODUCT_LINK_BY_TEXT_XPATH,"")));
        int productsCount = catalogProducts.countElements();
        softAssert.assertTrue(productsCount>0,
                String.join("\n","There are no products on page:",
                        "Actual result: "+productsCount,
                        "Expected result: Number of products is greater then 0"));

        Label catalogPagination = new Label(By.xpath(String.format(CATALOG_PAGINATION_LINK_BY_TEXT_XPATH,"")));
        boolean isPaginationPresent = catalogPagination.countElements()>0;
        boolean isPaginationExpected = Boolean.parseBoolean(expectedResults.get(1));
        softAssert.assertEquals(isPaginationPresent,isPaginationExpected,
                String.join(" ","Pagination elements",(isPaginationPresent?"are":"are not"),"present",
                        "but",(isPaginationExpected?"were":"were not"),"expected"));

        softAssert.assertAll();
    }
}
