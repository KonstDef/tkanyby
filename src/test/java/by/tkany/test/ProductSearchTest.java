package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.Browser;
import framework.elements.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static by.tkany.testData.Selectors.*;

public class ProductSearchTest extends BaseTest {
    @Test(testName = "ProductSearch | ID4", description = "Selecting product at search field redirects to product page",
            dataProvider = "ProductSearchData", dataProviderClass = DataProviders.class)
    public void testID04(String productName, String expectedCode) {
        TextBox searchField = new TextBox(By.xpath(SEARCH_FIELD_XPATH));
        searchField.sendKeys(productName);

        Label productFound = new Label(By.xpath(String.format(SEARCH_PRODUCT_FOUND_BY_TEXT_XPATH, "Пальтовая клетка")));
        Browser.waitForjQueryLoad();
        productFound.moveAndClickByAction();

        TextBox productCode = new TextBox(By.xpath(PRODUCT_ARTICLE_XPATH));
        String actualCode = productCode.getText();

        Assert.assertEquals(actualCode,expectedCode,
                String.join("\n", "Actual product code not equals expected:",
                        "Actual result: " + actualCode,
                        "Expected result: " + expectedCode));
    }
}
