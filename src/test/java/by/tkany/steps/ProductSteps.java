package by.tkany.steps;

import io.cucumber.java.en.*;
import static by.tkany.steps.BaseSteps.*;

public class ProductSteps {
    @Then ("Product page contains catalog navigation")
    public void assertCataloguePNavigation(){
        product.getCatalogueNavigation().assertIsPresent();
    }
    @Then ("Product page contains breadcrumbs")
    public void assertPBreadcrumbs(){
        product.getBreadCrumbs().assertIsDisplayed();
    }
    @Then ("Product page contains product navigation tabs")
    public void assertPNavigationTabs(){
        product.assertNavigationTabsPresent();
    }
    @Then ("Product page contains short description")
    public void assertPShortDescription(){
        product.assertShortDescriptionPresent();
    }
    @Then ("Product page contains article equals {string}")
    public void assertPArticleEquals(String articleExpected){
        product.assertArticleEquals(articleExpected);
    }
    @Then ("Product page contains title equals {string}")
    public void assertPTitleEquals(String titleExpected){
        product.assertTitleEquals(titleExpected);
    }
    @Then ("Product page contains 'add to cart' button")
    public void assertPAddToCartPresent(){
        product.assertAddToCartPresent();
    }
    @Then ("Product page contains 'fast order' button")
    public void assertPFastOrderPresent(){
        product.assertFastOrderPresent();
    }
    @Then ("Product page contains product image")
    public void assertPImagePresent(){
        product.assertImagePresent();
    }
    @Then ("Product page contains product properties")
    public void assertPPropertiesPresent(){
        product.assertPropertiesPresent();
    }
    @When ("User clicks on \"Купить в 1 клик\" button")
    public void openPFastOrder(){
        product.openFastOrder();
    }
    @Then ("Fast order component is opened")
    public void checkFastOrder(){
        product.getFastOrder().assertIsPresent();
    }
    @Then ("Fast order component contains {string} title")
    public void checkFastOrderTitle(String title){
        product.getFastOrder().assertTitlePresent(title);
    }
    @Then ("Fast order component contains image")
    public void checkFastOrderImage(){
        product.getFastOrder().assertImagePresent();
    }
    @Then ("Fast order component contains price")
    public void checkFastOrderPrice(){
        product.getFastOrder().assertPricePresent();
    }
    @Then ("Fast order component {string} can be filled with {string}")
    public void checkFastOrderInput(String inputName, String inputData){
        product.getFastOrder().assertInputIsEnterable(inputName, inputData);
    }
    @Then ("Fast order component personal data agreement checkbox is clickable")
    public void checkFastOrderCheckbox(){
        product.getFastOrder().assertPersonaDataClickable();
    }
    @Then ("Fast order \"Купить в один клик\" button is clickable")
    public void checkFastOrderButton(){
        product.getFastOrder().assertFastBuyButtonClickable();
    }
}
