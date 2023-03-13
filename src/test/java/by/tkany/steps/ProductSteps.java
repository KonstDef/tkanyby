package by.tkany.steps;

import by.tkany.pageObjects.pageComponents.ConfirmProductComponent;
import io.cucumber.java.en.*;
import static by.tkany.steps.BaseSteps.*;

public class ProductSteps {
    @Then ("Product page contains catalog navigation")
    public void productAssertCataloguePNavigation(){
        product.getCatalogueNavigation().assertIsPresent();
    }
    @Then ("Product page contains breadcrumbs")
    public void productAssertPBreadcrumbs(){
        product.getBreadCrumbs().assertIsDisplayed();
    }
    @Then ("Product page contains product navigation tabs")
    public void productAssertPNavigationTabs(){
        product.assertNavigationTabsPresent();
    }
    @Then ("Product page contains short description")
    public void productAssertPShortDescription(){
        product.assertShortDescriptionPresent();
    }
    @Then ("Product page contains article equals {string}")
    public void productAssertPArticleEquals(String articleExpected){
        product.assertArticleEquals(articleExpected);
    }
    @Then ("Product page contains title equals {string}")
    public void productAssertPTitleEquals(String titleExpected){
        product.assertTitleEquals(titleExpected);
    }
    @Then ("Product page contains 'add to cart' button")
    public void productAssertPAddToCartPresent(){
        product.assertAddToCartPresent();
    }
    @Then ("Product page contains 'fast order' button")
    public void productAssertPFastOrderPresent(){
        product.assertFastOrderPresent();
    }
    @Then ("Product page contains product image")
    public void productAssertPImagePresent(){
        product.assertImagePresent();
    }
    @Then ("Product page contains product properties")
    public void productAssertPPropertiesPresent(){
        product.assertPropertiesPresent();
    }
    @When ("User clicks on \"Купить в 1 клик\" button")
    public void productOpenPFastOrder(){
        product.openFastOrder();
    }
    @Then ("Fast order component is opened")
    public void productCheckFastOrder(){
        product.getFastOrder().assertIsPresent();
    }
    @Then ("Fast order component contains {string} title")
    public void productCheckFastOrderTitle(String title){
        product.getFastOrder().assertTitlePresent(title);
    }
    @Then ("Fast order component contains image")
    public void productCheckFastOrderImage(){
        product.getFastOrder().assertImagePresent();
    }
    @Then ("Fast order component contains price")
    public void productCheckFastOrderPrice(){
        product.getFastOrder().assertPricePresent();
    }
    @Then ("Fast order component {string} can be filled with {string}")
    public void productCheckFastOrderInput(String inputName, String inputData){
        product.getFastOrder().assertInputIsEnterable(inputName, inputData);
    }
    @Then ("Fast order component personal data agreement checkbox is clickable")
    public void productCheckFastOrderCheckbox(){
        product.getFastOrder().assertPersonaDataClickable();
    }
    @Then ("Fast order \"Купить в один клик\" button is clickable")
    public void productCheckFastOrderButton(){
        product.getFastOrder().assertFastBuyButtonClickable();
    }
    @When("User sets {double} for product")
    public void productSetProductAmount(double amount){
        product.setProductAmount(amount);
    }
    @When("User clicks \"В корзину\" button")
    public void productClickToCart(){
        product.clickAddToCart();
        product.setConfirmProduct(new ConfirmProductComponent());
    }
    @Then("\"Product confirm\" component is displayed")
    public void productCheckProductConfirmComponent(){
        product.getConfirmProduct().assertOpened();
    }
    @When("User changes amount of product at \"Cart add\" component from {double} to {double} with buttons")
    public void productChangeProductConfirmAmountByButtons(double initialAmount, double targetAmount){
        product.getConfirmProduct().setAmountWithButtons(initialAmount, targetAmount);
    }
    @When("User clicks \"Перейти в корзину\" button")
    public void productChangeProductConfirmAmountByButtons(){
        cart = product.getConfirmProduct().clickGoToCartButon();
        product.setConfirmProduct(null);
    }
}
