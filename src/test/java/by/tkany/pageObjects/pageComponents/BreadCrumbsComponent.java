package by.tkany.pageObjects.pageComponents;

import framework.elements.Label;
import org.openqa.selenium.By;

import static by.tkany.pageObjects.BaseByTkanyPage.softAssert;

public class BreadCrumbsComponent {
    public static final String BREADCRUMBS_LINK_BY_TEXT_XPATH = "//div[@id='breadcrumbs']//span[not(@class='arrow') and contains(text(),'%s')]";

    public void assertIsDisplayed() {
        Label catalogBreadcrumbs = new Label(By.xpath(String.format(BREADCRUMBS_LINK_BY_TEXT_XPATH, "")));
        softAssert.assertTrue(catalogBreadcrumbs.isDisplayed(), "Breadcrumbs are not displayed but were expected");
    }
}
