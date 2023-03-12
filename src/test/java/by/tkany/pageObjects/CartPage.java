package by.tkany.pageObjects;

import by.tkany.pageObjects.pageComponents.BreadCrumbsComponent;
import by.tkany.pageObjects.pageComponents.FastOrderComponent;
import by.tkany.pageObjects.pageComponents.ProductCardComponent;
import framework.elements.Button;
import framework.elements.Image;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class CartPage extends BaseByTkanyPage {
    private static final By IDENTIFIER = By.xpath("//h1[contains(.,'Корзина')]");
    private static final String PRODUCT_CARD_XPATH = "//div[contains(@class,'parent') and //span[contains(.,'%s')]]";
    private ProductCardComponent productCard;

    public CartPage() {
        super(IDENTIFIER, "Корзина");
    }

    public ProductCardComponent getProductCard(String productName){
        return (productCard = new ProductCardComponent(PRODUCT_CARD_XPATH,productName));
    }
}
