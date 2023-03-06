package by.tkany.pageObjects.pageComponents;

import by.tkany.pageObjects.ProductPage;
import framework.Browser;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardComponent {
    private final String PRODUCT_NAME_XPATH = "//a[@class='name']";
    private final String PRODUCT_NAME;
    private final String CARD_PATH;
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

    public ProductPage openProductPage(){
        Label ProductName = new Label(By.xpath(CARD_PATH+PRODUCT_NAME_XPATH));
        ProductName.waitToStale();
        ProductName.scrollIntoView();
        ProductName.clickAndWait();
        return new ProductPage(PRODUCT_NAME);
    }
}
