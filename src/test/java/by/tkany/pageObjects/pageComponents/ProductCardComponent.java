package by.tkany.pageObjects.pageComponents;

import by.tkany.pageObjects.ProductPage;
import framework.elements.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.w3c.dom.Text;

public class ProductCardComponent {
    private final String PRODUCT_NAME_XPATH = "//a[@class='name']/span";
    private final String PRODUCT_NAME;
    private final String CARD_PATH;
    private final String PRODUCT_IMAGE = "//img[@class='lazy']";
    private final String FAST_VIEW = "//span[@class='getFastView']";
    private final String QUANTITY_INPUT = "//input[@class='qty']";
    private final Label CARD;

    public ProductCardComponent(String cardXpath, String productName){
        CARD_PATH = String.format(cardXpath,productName);
        PRODUCT_NAME = productName;
        CARD = new Label(By.xpath(CARD_PATH));
    }

    public ProductCardComponent(String cardXpath){
        this(cardXpath,"");
    }

    public int getNum(){
        return CARD.countElements();
    }

    public boolean isPresent(){
        return CARD.isDisplayed();
    }

    @Step("Hover mouse over product image")
    public void mouseOver(){
        Image productImage = new Image(By.xpath(CARD_PATH+PRODUCT_IMAGE));
        productImage.waitForElementAttachment();
        productImage.scrollIntoView();
        productImage.moveTo();
    }

    @Step("Open fast view for product")
    public FastViewComponent openFastView(){
        Label fastView = new Label(By.xpath(CARD_PATH+FAST_VIEW));
        if(!fastView.isDisplayed()) mouseOver();
        fastView.clickByAction();
        return new FastViewComponent();
    }

    @Step("Open product page for card")
    public ProductPage openProductPage(){
        Label ProductName = new Label(By.xpath(CARD_PATH+PRODUCT_NAME_XPATH));
        ProductName.waitForElementAttachment();
        ProductName.scrollIntoView();
        ProductName.clickAndWait();
        return new ProductPage(PRODUCT_NAME);
    }

    @Step("Check product cart quantity expected")
    public void assertAmountEquals(double amountExpected) {
        TextBox inputField = new TextBox(By.xpath(CARD_PATH + QUANTITY_INPUT));
        inputField.scrollIntoView();
        double amountActual = Double.parseDouble(inputField.getJSValue());

        Assert.assertEquals(amountActual,amountExpected, "For product "+PRODUCT_NAME+" added to cart quantity does not equal expected:"
        +"\nActual: "+amountActual+"\nExpected: "+amountExpected);
    }
}
