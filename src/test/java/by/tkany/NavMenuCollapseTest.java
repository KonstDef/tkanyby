package by.tkany;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static by.tkany.Selectors.*;

public class NavMenuCollapseTest extends BaseTest {
    @Test(testName = "Navigation Menu Collapse | ID 1", description = "Header menu links are collapsed with screen width change",
            dataProvider = "NavMenuCollapseData", dataProviderClass = DataProviders.class)
    public void test1(int x, int y, List<String> visibleLinks, List<String> hiddenLinks) {
        driver.manage().window().setSize(new Dimension(x, y));
        new WebDriverWait(driver, Duration.ofSeconds(1));

        Actions actions = new Actions(driver);
        List<WebElement> navLinks;
        List<String> navLinksText = new ArrayList<>();

        navLinks = driver.findElements(By.xpath(String.format(NAV_MENU_VISIBLE_LINK_BY_TEXT_XPATH, "")));
        navLinks.forEach(wE -> navLinksText.add(wE.getText()));

        if (!navLinksText.equals(visibleLinks)) Assert.fail("Visible links are not consistent");
        navLinksText.clear();

        WebElement menuHideButton = driver.findElement(By.xpath(NAV_MENU_HIDE_BUTTON_XPATH));
        actions.moveToElement(menuHideButton).click().build().perform();

        navLinks = driver.findElements(By.xpath(String.format(NAV_MENU_HIDDEN_LINK_BY_TEXT_XPATH, "")));
        navLinks.forEach(wE -> navLinksText.add(wE.getText()));

        if (!navLinksText.equals(hiddenLinks)) Assert.fail("Hidden links are not consistent");
    }
}
