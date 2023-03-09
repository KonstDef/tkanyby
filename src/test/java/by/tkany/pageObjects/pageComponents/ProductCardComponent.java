package by.tkany.pageObjects.pageComponents;

import by.tkany.pageObjects.ProductPage;
import framework.elements.*;
import org.openqa.selenium.By;

public class ProductCardComponent {
    private final String PRODUCT_NAME_XPATH = "//a[@class='name']";
    private final String PRODUCT_NAME;
    private final String CARD_PATH;
    private final String PRODUCT_IMAGE = "//img[@class='lazy']";
    private final String FAST_VIEW = "//span[@class='getFastView']";
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

    public void mouseOver(){
        Image productImage = new Image(By.xpath(CARD_PATH+PRODUCT_IMAGE));
        productImage.waitForElementAttachment();
        productImage.scrollIntoView();
        productImage.moveTo();
    }

    public FastViewComponent openFastView(){
        Label fastView = new Label(By.xpath(CARD_PATH+FAST_VIEW));
        if(!fastView.isDisplayed()) mouseOver();
        fastView.clickByAction();
        return new FastViewComponent();
    }

    public ProductPage openProductPage(){
        Label ProductName = new Label(By.xpath(CARD_PATH+PRODUCT_NAME_XPATH));
        ProductName.waitForElementAttachment();
        ProductName.scrollIntoView();
        ProductName.clickAndWait();
        return new ProductPage(PRODUCT_NAME);
    }
}
