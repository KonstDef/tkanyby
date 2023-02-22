package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.elements.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static by.tkany.testData.Selectors.*;

public class NavMenuCollapseTest extends BaseTest {
    @Test(testName = "Navigation Menu Collapse | ID1", description = "Header menu links are collapsed with screen width change",
            dataProvider = "NavMenuCollapseData", dataProviderClass = DataProviders.class)
    public void test1(List<String> visibleLinks, List<String> hiddenLinks) {
        SoftAssert softAssert = new SoftAssert();
        List<String> navLinksText;

        Label navLinksVisible = new Label(By.xpath(String.format(NAV_MENU_VISIBLE_LINK_BY_TEXT_XPATH, "")));
        navLinksText = navLinksVisible.getTextList();

        softAssert.assertEquals(navLinksText, visibleLinks,
                String.join("\n", "Visible links at nav menu are not equal to expected list:",
                        "Actual result: " + navLinksText,
                        "Expected result: " + visibleLinks));
        navLinksText.clear();

        Label menuHideButton = new Label(By.xpath(NAV_MENU_HIDE_BUTTON_XPATH));
        menuHideButton.moveAndClickByAction();

        Label navLinksHidden = new Label(By.xpath(String.format(NAV_MENU_HIDDEN_LINK_BY_TEXT_XPATH, "")));
        navLinksText = navLinksHidden.getTextList();

        softAssert.assertEquals(navLinksText, visibleLinks,
                String.join("\n", "Hidden links at nav menu are not equal to expected list:",
                        "Actual result: " + navLinksText,
                        "Expected result: " + hiddenLinks));
        navLinksText.clear();
        softAssert.assertAll();
    }
}
