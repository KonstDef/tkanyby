package by.tkany.pageObjects.pageComponents.header;

import by.tkany.pageObjects.BaseByTkanyPage;
import by.tkany.pageObjects.InfoPage;
import framework.elements.Button;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class HamburgerNavigation {
    public static final Button HAMBURGER_BUTTON_XPATH = new Button(By.xpath("//a[@class='removedItemsLink']"));
    public static final String HAMBURGER_VISIBLE_LABELS_BY_TEXT_XPATH = "//ul[@id='subMenu']/li[not(@class)]/a[contains(text(),'%s')]";
    public static final String HAMBURGER_HIDDEN_LABELS_BY_TEXT_XPATH = "//ul[@class='removedItemsList']//a[contains(text(),'%s')]";
    public static final String HAMBURGER_LABELS_BY_TEXT_XPATH = "//ul[@id='subMenu']/li[not(@class)]/a[contains(text(),'%1$s')] | //ul[@class='removedItemsList']//a[contains(text(),'%1$s')]";

    @Step("Check visible labels are same to provided list")
    public void checkVisibleLabels(List<String> visibleLinksExpected) {
        Label navLinksVisible = new Label(By.xpath(String.format(HAMBURGER_VISIBLE_LABELS_BY_TEXT_XPATH, "")));
        List<String> visibleLinksActual = navLinksVisible.getTextList();

        BaseByTkanyPage.softAssert.assertEquals(visibleLinksActual, visibleLinksExpected,
                String.join("\n", "Visible links at nav menu are not equal to expected list:",
                        "Actual result: " + visibleLinksActual,
                        "Expected result: " + visibleLinksExpected));
    }

    @Step("Check hidden labels are same to provided list")
    public void checkHiddenLabels(List<String> hiddenLinksExpected) {
        Label navLinksHidden = new Label(By.xpath(String.format(HAMBURGER_HIDDEN_LABELS_BY_TEXT_XPATH, "")));
        List<String> hiddenLinksActual;
        hiddenLinksActual = navLinksHidden.getTextList();

        BaseByTkanyPage.softAssert.assertEquals(hiddenLinksActual,hiddenLinksExpected,
                String.join("\n","Hidden links at nav menu are not equal to expected list:",
                        "Actual result: "+hiddenLinksActual,
                        "Expected result: "+hiddenLinksExpected));
        BaseByTkanyPage.softAssert.assertAll();
    }

    @Step("Click hamburger menu button")
    public void clickHamburgerButton() {
        HAMBURGER_BUTTON_XPATH.moveAndClickByAction();
    }

    @Step("Redirect to info page")
    public InfoPage redirectInfo(String infoPageTitle){
        Label infoPageLabel = new Label(By.xpath(String.format(HAMBURGER_LABELS_BY_TEXT_XPATH, infoPageTitle)));
        if(!infoPageLabel.isClickable()) HAMBURGER_BUTTON_XPATH.click();
        infoPageLabel.clickAndWait();

        return new InfoPage(infoPageTitle);
    }

    @Step("Scroll to header component")
    public void scrollTo(){
        HAMBURGER_BUTTON_XPATH.scrollTo();
    }
}
