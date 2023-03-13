package by.tkany.pageObjects;

import by.tkany.pageObjects.pageComponents.ProductCardComponent;
import framework.elements.Button;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class CartPage extends BaseByTkanyPage {
    private static final By IDENTIFIER = By.xpath("//h1[contains(.,'Корзина')]");
    private static final String PRODUCT_CARD_XPATH = "//div[contains(@class,'parent') and //span[contains(.,'%s')]]";
    private static final Button GO_TO_ORDER = new Button(By.xpath("//a[contains(@class,'goToOrder')]"));
    private ProductCardComponent productCard;

    public CartPage() {
        super(IDENTIFIER, "Корзина");
    }

    public ProductCardComponent getProductCard(String productName){
        return (productCard = new ProductCardComponent(PRODUCT_CARD_XPATH,productName));
    }

    @Step("Open order page")
    public OrderPage openOrder(){
        GO_TO_ORDER.scrollIntoView();
        GO_TO_ORDER.clickAndWait();
        return new OrderPage();
    }
}
