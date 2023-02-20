package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static by.tkany.testData.Selectors.*;

public class CatalogMenuLinksTest extends BaseTest {
    @Test(testName = "CatalogMenuLinks | ID10", description = "Catalog menu links open correct pages on widescreen",
            dataProvider = "CatalogMenuLinksData", dataProviderClass = DataProviders.class)
    public void testID10(String labelText, String expectedTitle) {
        Label menuLabel = new Label(By.xpath(String.format(CATEGORY_NAV_LINK_BY_TEXT_XPATH, labelText)));
        menuLabel.clickAndWait();

        TextBox catalogTitle = new TextBox(By.tagName(CATALOG_TITLE_TAGNAME));
        String catalogTitleText = catalogTitle.getText();

        Assert.assertEquals(catalogTitleText,expectedTitle,
                String.join("\n","Page opened from catalog menu contains incorrect title:",
                        "Actual result: "+catalogTitleText,
                        "Expected result: "+expectedTitle));
    }
}
