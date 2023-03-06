package by.tkany.pageObjects.pageComponents;

import by.tkany.pageObjects.*;
import framework.Browser;
import framework.elements.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CatalogueNavigationComponent {
    private static final String CATEGORY_NAV_LINK_BY_TEXT = "//div[@id='left']/a[contains(text(),'%1$s')] | //ul[@id='subLeftMenu']//a[contains(text(),'%1$s')] | //span[@class='tx']//span[@class='link-title' and contains(text(),'%1$s')]//ancestor::a";
    private static final Button CATALOGUE_MENU_TOGGLE = new Button(By.xpath("//div[@id='left']/a"));
    private static final TextBox CATALOGUE_MENU_COLLAPSIBLE = new TextBox(By.xpath("//div[@id='left']/div[contains(@class,'collapsed')]"));
    private static final String CATALOGUE_NAV_SUBCATEGORIES_BY_ACTIVE_SUBCATEGORY_TEXT = "//div[contains(@style,'table')]/ul[@class='menuItems']//li[a/span[contains(text(),'%1$s')] or a[contains(text(),'%1$s')]]";
    @Step("Check menu is not toggled")
    public boolean isMenuToggled() {
        return CATALOGUE_MENU_COLLAPSIBLE.isDisplayed();
    }

    @Step("Toggle menu")
    public void toggleMenu() {
        CATALOGUE_MENU_TOGGLE.moveAndClickByAction();
    }

    @Step("Navigate through main category")
    public CataloguePage navigateMain(String labelText) {
        if (!isMenuToggled()) toggleMenu();

        Label menuLabel = new Label(By.xpath(String.format(CATEGORY_NAV_LINK_BY_TEXT, labelText)));
        menuLabel.clickAndWait();

        return new CataloguePage(labelText);
    }

    @Step("Open submenu list for main category")
    public void openSubMenuList(String labelText) {
        if (!isMenuToggled()) toggleMenu();

        Label menuLabel = new Label(By.xpath(String.format(CATEGORY_NAV_LINK_BY_TEXT, labelText)));
        menuLabel.moveTo();
    }

    @Step("Open submenu for active category")
    public CataloguePage openSubMenu(String labelText) {
        Label menuSub = new Label(By.xpath(String.format(CATALOGUE_NAV_SUBCATEGORIES_BY_ACTIVE_SUBCATEGORY_TEXT,labelText)));
        menuSub.waitForElementAttachment();
        menuSub.scrollIntoView();
        menuSub.clickAndWait();

        return new CataloguePage(labelText);
    }

    @Step("Check catalogue menu is present")
    public void assertIsPresent() {
        BaseByTkanyPage.softAssert.assertTrue(CATALOGUE_MENU_TOGGLE.isDisplayed(),"Catalogue menu button is not present, but expected.");
    }
}