package by.tkany.pageObjects;

import by.tkany.pageObjects.pageComponents.BreadCrumbsComponent;
import by.tkany.pageObjects.pageComponents.FastOrderComponent;
import framework.elements.*;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class ProductPage extends BaseByTkanyPage {
    private static final String TITLE = "//h1[contains(.,'%s')]";
    public static final TextBox ARTICLE = new TextBox(By.xpath("//span[@class='changeArticle']"));
    private static final String SHORT_DESCRIPTION = "//div[@class='changeShortDescription']";
    private static final Image IMAGES = new Image(By.xpath("//div[@id='pictureContainer']//img"));
    private static final String ATTRIBUTE_ROW_BY_FIRST_COLUMN = "//div[@class='detailPropertiesTable']//tr[td/span[contains(text(),'%s')]]";
    private static final String NAVIGATION_TAB = "//div[@id='elementNavigation']//div[@class='tab' or @class='tab active']/a[contains(text(),'%1$s')] | //div[@id='elementSmallNavigation']//div[@class='tab' or @class='tab active']/a[contains(text(),'%1$s')]";
    public static final Button ADD_TO_CART_BUTTON = new Button(By.xpath("//div[@id='elementTools']//a[contains(@class,'addCart')]"));
    public static final Button ADD_TO_CART_INPUT = new Button(By.xpath("//div[@id='elementTools']//input[@class='qty']"));
    public static final Button FAST_ORDER_BUTTON = new Button(By.xpath("//div[@id='elementTools']//a[contains(@class,'fastBack')]"));
    private final BreadCrumbsComponent breadCrumbs = new BreadCrumbsComponent();

    public ProductPage(String title) {
        super(By.xpath(String.format(TITLE, title)), title);
    }

    @Step("Check product navigation tabs are present")
    public void assertNavigationTabsPresent() {
        Label productNavigation = new Label(By.xpath(String.format(NAVIGATION_TAB, "")));
        softAssert.assertTrue(productNavigation.isDisplayed(), "Product navigation tabs on product page are not displayed:");
    }

    @Step("Check product short description is present")
    public void assertShortDescriptionPresent() {
        TextBox productShortDescription = new TextBox(By.xpath(SHORT_DESCRIPTION));
        softAssert.assertTrue(productShortDescription.isDisplayed(), "Product short description on product page is not displayed:");

    }

    @Step("Check product article equals expected")
    public void assertArticleEquals(String idExpected) {
        String idActual = ARTICLE.getText();
        softAssert.assertEquals(idActual, idExpected,
                String.join("\n", "Product id on product page does not equal expected value:",
                        "Actual result: " + idActual,
                        "Expected result: " + idExpected));
    }

    @Step("Check product article equals expected")
    public void assertTitleEquals(String titleExpected) {
        TextBox productTitle = new TextBox(By.xpath(String.format(TITLE, "")));
        String titleActual = productTitle.getText();
        softAssert.assertEquals(titleActual, titleExpected,
                String.join("\n", "Product title on product page does not equal expected value:",
                        "Actual result: " + titleActual,
                        "Expected result: " + titleExpected));
    }

    @Step("Check add to cart button is displayed")
    public void assertAddToCartPresent() {
        softAssert.assertTrue(ADD_TO_CART_BUTTON.isDisplayed(), "Add to cart button on product page is not displayed, but expected");
    }

    @Step("Check fast order button is displayed")
    public void assertFastOrderPresent() {
        softAssert.assertTrue(FAST_ORDER_BUTTON.isDisplayed(), "Fast order button on product page is not displayed, but expected");
    }

    @Step("Check images are displayed")
    public void assertImagePresent() {
        softAssert.assertTrue(IMAGES.isDisplayed(), "Product image on product page is not displayed, but expected:");
    }
    @Step("Check images are displayed")
    public void assertPropertiesPresent() {
        TextBox productProperties = new TextBox(By.xpath(String.format(ATTRIBUTE_ROW_BY_FIRST_COLUMN, "")));
        softAssert.assertTrue(productProperties.isDisplayed(), "Properties table on product page is not displayed:");
    }
    @Step("Open fast order")
    public void openFastOrder() {
        FAST_ORDER_BUTTON.moveAndClickByAction();
        setFastOrder(new FastOrderComponent());
    }
    @Step("Set product buy amount")
    public void setProductAmount(double amount) {
        ADD_TO_CART_BUTTON.moveTo();
        ADD_TO_CART_INPUT.clearInput();
        ADD_TO_CART_INPUT.sendKeys(Double.toString(amount));
    }
    @Step("Set product buy amount")
    public void clickAddToCart() {
        ADD_TO_CART_BUTTON.click();
    }
}
