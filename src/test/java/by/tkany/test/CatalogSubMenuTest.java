package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static by.tkany.testData.Selectors.*;

public class CatalogSubMenuTest extends BaseTest {
    @Test(testName = "CatalogSubMenu | ID11", description = "Catalog menu links show submenu on float on widescreen",
            dataProvider = "CatalogSubMenuData", dataProviderClass = DataProviders.class)
    public void testID11(String menuMainText, String menuSubText, String expectedTitle) {
        Label menuMain = new Label(By.xpath(String.format(CATALOG_MAIN_CATEGORY_BY_TEXT_XPATH,menuMainText)));
        menuMain.moveTo();

        Label menuSub = new Label(By.xpath(String.format(CATALOG_NAV_SUBCATEGORIES_BY_ACTIVE_SUBCATEGORY_TEXT_XPATH,menuSubText)));
        menuSub.moveToTop();
        menuSub.clickAndWait();

        TextBox title = new TextBox(By.tagName(CATALOG_TITLE_TAGNAME));
        String actualTitle = title.getText();

        Assert.assertEquals(actualTitle,expectedTitle,
                String.join("\n","Catalog title does not equal expected value:",
                        "Actual result: "+actualTitle,
                        "Expected result: "+expectedTitle));
    }
}
