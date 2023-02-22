package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.Browser;
import framework.elements.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static by.tkany.testData.Selectors.*;

public class FastViewTest extends BaseTest {
    @Test(testName = "FastView | ID14", description = "Fast view window contains required parts on widescreen",
            dataProvider = "FastViewData", dataProviderClass = DataProviders.class)
    public void test14(String mainCategoryName, String subCategoryName, String productName, String idExpected) {
        SoftAssert softAssert = new SoftAssert();

        Label mainCategory = new Label(By.xpath(String.format(CATALOG_MAIN_CATEGORY_BY_TEXT_XPATH, mainCategoryName)));
        mainCategory.moveAndClickByAction();

        if (!subCategoryName.isEmpty()) {
            Label subCategory = new Label(By.xpath(String.format(CATALOG_SUBCATEGORY_FROM_CATEGORY_PAGE_BY_TEXT_XPATH, subCategoryName)));
            subCategory.moveToTop();
            subCategory.clickByAction();
        }

        Label fastViewLink = new Label(By.xpath(String.format(CATALOG_PRODUCT_FAST_VIEW_BUTTON_BY_TEXT_LINK_XPATH, productName)));
        fastViewLink.moveTo();
        fastViewLink.clickByJS();

        Browser.waitForjQueryLoad();

        TextBox fastViewHeading = new TextBox(By.className(CATALOG_FAST_VIEW_CLASSNAME));
        Assert.assertTrue(fastViewHeading.isDisplayed(), "Fast view windows was not opened");

        TextBox productId = new TextBox(By.xpath(PRODUCT_ARTICLE_XPATH));
        String idActual = productId.getText();
        softAssert.assertEquals(idActual, idExpected,
                String.join("\n", "Product id does not equal expected value:",
                        "Actual result: " + idActual,
                        "Expected result: " + idExpected));

        TextBox fastViewTitle = new TextBox(By.xpath(CATALOG_FAST_VIEW_TITLE_BY_XPATH));
        String titleActual = fastViewTitle.getText();
        softAssert.assertEquals(titleActual, productName,
                String.join("\n", "Product title does not equal expected value:",
                        "Actual result: " + titleActual,
                        "Expected result: " + productName));

        Label toCart = new Label(By.xpath(CATALOG_FAST_VIEW_ADD_TO_CART_BY_XPATH));
        softAssert.assertTrue(toCart.isDisplayed(), "Fast view add to cart is not displayed:");

        Label image = new Label(By.xpath(CATALOG_FAST_VIEW_IMAGE_BY_XPATH));
        softAssert.assertTrue(image.isDisplayed(), "Fast view image is not displayed:");

        TextBox properties = new TextBox(By.className(CATALOG_FAST_VIEW_PROPERTIES_BY_CLASSNAME));
        softAssert.assertTrue(properties.isDisplayed(), "Properties table is not displayed:");

        Label moreLink = new Label(By.xpath(CATALOG_FAST_VIEW_MORE_LINK_BY_XPATH));
        softAssert.assertTrue(moreLink.isDisplayed(), "Fast view more info link is not displayed:");

        softAssert.assertAll();
    }
}
