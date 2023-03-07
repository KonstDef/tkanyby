package by.tkany.pageObjects.pageComponents.header;

import by.tkany.pageObjects.BaseByTkanyPage;
import by.tkany.pageObjects.ProductPage;
import by.tkany.pageObjects.pageComponents.ProductCardComponent;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchComponent {
    private final TextBox SEARCH_FIELD = new TextBox(By.xpath("//input[@id='searchQuery']"));
    private final String PRODUCT_FOUND_BY_TEXT_XPATH = "//div[@id='searchResult']//a[@class='name' and span[contains(text(),'%s')]]/ancestor::div[@class='item product sku']";

    private ProductCardComponent productCard;

    @Step("Enter text into search field")
    public void enterSearchText(String productName) {
        SEARCH_FIELD.moveAndClickByAction();
        SEARCH_FIELD.sendKeys(productName);
    }

    @Step("Check product card appeared")
    public void checkProduct(String productName){
        productCard = new ProductCardComponent(PRODUCT_FOUND_BY_TEXT_XPATH,productName);
        BaseByTkanyPage.softAssert.assertTrue(productCard.isPresent(),productName+" product card did not appeared under search field. But expected.");
    }

    @Step("Click on product appeared")
    public ProductPage clickOnProduct(String productName) {
        productCard.openProductPage();
        return new ProductPage(productName);
    }
}
