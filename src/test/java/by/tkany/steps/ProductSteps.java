package by.tkany.steps;

import io.cucumber.java.en.*;

import static by.tkany.steps.BaseSteps.product;

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
}
