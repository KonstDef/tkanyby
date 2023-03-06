//package by.tkany.tests.inP;
//
//import framework.BaseTest;
//import framework.Browser;
//import framework.elements.*;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import static by.tkany.pageObjects.Selectors.*;
//
//public class ProductPageContainersTest extends BaseTest {
//    @Test(testName = "ProductPageContainers | ID15", description = "Product page contains required parts on widescreen",
//            dataProvider = "ProductPageContainersData", dataProviderClass = DataProviders.class)
//    public void test15(String mainCategoryName, String subCategoryName, String productName, String idExpected) {
//        SoftAssert softAssert = new SoftAssert();
//
//        Label mainCategory = new Label(By.xpath(String.format(CATALOG_MAIN_CATEGORY_BY_TEXT_XPATH, mainCategoryName)));
//        mainCategory.moveTo();
//
//        if (!subCategoryName.isEmpty()) {
//            Label subCategory = new Label(By.xpath(String.format(CATALOG_NAV_SUBCATEGORIES_BY_ACTIVE_SUBCATEGORY_TEXT_XPATH, subCategoryName)));
//            subCategory.scrollIntoView();
//            subCategory.clickByAction();
//        } else mainCategory.click();
//
//        Label productLink = new Label(By.xpath(String.format(CATALOG_PRODUCT_LINK_BY_TEXT_XPATH, productName)));
//        productLink.scrollIntoView();
//        productLink.clickAndWait();
//
//        Browser.waitForjQueryLoad();
//
//        Label categoryHead = new Label(By.xpath(CATALOG_MENU_TOGGLE_XPATH));
//        softAssert.assertTrue(categoryHead.isDisplayed(), "Catalog navigation menu on product page is not displayed:");
//
//        Label breadcrumbs = new Label(By.xpath(String.format(CATALOG_BREADCRUMBS_LINK_BY_TEXT_XPATH,"")));
//        softAssert.assertTrue(breadcrumbs.isDisplayed(),"Breadcrumbs bar on product page is not displayed:");
//
//        Label productNavigation = new Label(By.xpath(String.format(PRODUCT_NAVIGATION_TAB_BY_TEXT_XPATH,"")));
//        softAssert.assertTrue(productNavigation.isDisplayed(),"Product navigation tabs on product page are not displayed:");
//
//        TextBox productShortDescription = new TextBox(By.xpath(PRODUCT_SHORT_DESCRIPTION_XPATH));
//        softAssert.assertTrue(productShortDescription.isDisplayed(),"Product short description on product page is not displayed:");
//
//        TextBox productId = new TextBox(By.xpath(PRODUCT_ARTICLE_XPATH));
//        String idActual = productId.getText();
//        softAssert.assertEquals(idActual, idExpected,
//                String.join("\n", "Product id on product page does not equal expected value:",
//                        "Actual result: " + idActual,
//                        "Expected result: " + idExpected));
//
//        TextBox productTitle = new TextBox(By.xpath(PRODUCT_HEADER_XPATH));
//        String titleActual = productTitle.getText();
//        softAssert.assertEquals(titleActual, productName,
//                String.join("\n", "Product title on product page does not equal expected value:",
//                        "Actual result: " + titleActual,
//                        "Expected result: " + productName));
//
//        Label toCart = new Label(By.xpath(DESKTOP_PRODUCT_ADD_TO_CART_BUTTON_XPATH));
//        softAssert.assertTrue(toCart.isDisplayed(), "Add to cart button on product page is not displayed:");
//
//        Label fastOrder = new Label(By.xpath(DESKTOP_PRODUCT_FAST_ORDER_BUTTON_XPATH));
//        softAssert.assertTrue(toCart.isDisplayed(), "Fast order button on product page is not displayed:");
//
//        Label image = new Label(By.xpath(PRODUCT_IMAGES_XPATH));
//        softAssert.assertTrue(image.isDisplayed(), "Product image on product page is not displayed:");
//
//        TextBox productProperties = new TextBox(By.xpath(String.format(PRODUCT_ATTRIBUTE_ROW_BY_FIRST_COLUMN_XPATH,"")));
//        softAssert.assertTrue(productProperties.isDisplayed(), "Properties table on product page is not displayed:");
//
//        softAssert.assertAll();
//    }
//}
