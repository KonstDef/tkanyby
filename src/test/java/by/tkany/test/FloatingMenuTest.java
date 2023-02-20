package by.tkany.test;

import framework.BaseTest;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static by.tkany.testData.Selectors.*;

public class FloatingMenuTest extends BaseTest {
    //TODO: finish test logic
    @Test(testName = "FloatingMenu | ID3", description = "Bottom menu floats with page scrolling on widescreen")
    public void testID03() {
        SoftAssert softAssert = new SoftAssert();

        TextBox floatingMenu = new TextBox(By.xpath(String.format(FLOATING_FOOTER_LINK_BY_TEXT_XPATH, "")));
        softAssert.assertTrue(floatingMenu.isElementPresent(),
                "Bottom floating menu did not appeared on start:");

        TextBox footerMenu = new TextBox(By.id(FOOTER_BAR_ID));
        footerMenu.scrollTo();
        softAssert.assertTrue(floatingMenu.isElementPresent(),
                "Bottom floating menu did not followed view with scroll down:");

        TextBox topMenu = new TextBox(By.xpath(NAV_MENU_HIDE_BUTTON_XPATH));
        topMenu.scrollTo();
        softAssert.assertTrue(floatingMenu.isElementPresent(),
                "Bottom floating menu did not followed view with scroll up:");
    }
}
