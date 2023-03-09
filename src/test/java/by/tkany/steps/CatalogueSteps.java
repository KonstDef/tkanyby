package by.tkany.steps;

import io.cucumber.java.en.*;

import static by.tkany.steps.BaseSteps.*;
import static framework.TextTransformers.commaSeparate;
import static framework.TextTransformers.connectTestData;

public class CatalogueSteps {
    @Then ("Catalogue page {string} is opened")
    public void checkPageOpened(String catalogueTitle){
        catalogue.isPageCorrect(catalogueTitle);
    }
    @And("User clicks on {string} subcategory under catalogue navigation list")
    public void goToDirectCategory(String subCategory){
        catalogue.navigateToDirectSub(subCategory);
    }
    @Then("Catalog menu expand button is present on page")
    public void menuPresent(){
        catalogue.getCatalogueNavigation().assertIsPresent();
    }
    @And ("There are {int} product filters on page")
    public void checkFiltersNum(int numExpected){
        catalogue.getFilter().checkNumber(numExpected);
    }
    @And ("There are product cards on page")
    public void thereAreProducts(){
        catalogue.assertAreProducts();
    }
    @And ("Pagination {string} expected")
    public void checkPagination(String bool){
        boolean isPaginationExpected = bool.equals("is");
        catalogue.assertPagination(isPaginationExpected);
    }
    @And ("User sets {string} for {string} filter")
    public void setFilter(String filterValue, String filterName){
        connectTestData(commaSeparate(filterName),commaSeparate(filterValue))
                .forEach((k,v)-> catalogue.getFilter(k).setValue(v));
    }
    @And ("User opens product page for {string}")
    public void openProduct(String productName){
        product = catalogue.getProductCard(productName).openProductPage();
    }
    @When ("User sorts products by {string}")
    public void sortProductList(String sortName){
        catalogue.sortProductList(sortName);
    }
    @When ("User hovers mouse over {string} card image")
    public void moveMouseOnProduct(String sortName){
        catalogue.getProductCard(sortName).mouseOver();
    }
    @When("User opens fast view for {string}")
    public void openFastView(String sortName){
      catalogue.setFastView(
              catalogue.getProductCard(sortName).openFastView()
      );
    }
    @Then ("Fast view window is opened")
    public void fastViewOpened(){
        catalogue.getFastView().assertOpened();
    }
    @Then ("Fast view window contains {string} name")
    public void fastViewHasName(String productName){
        catalogue.getFastView().assertNameEquals(productName);
    }
    @Then("Fast view window contains product article equals to {string}")
    public void fastViewArticle(String article){
        catalogue.getFastView().assertArticleEquals(article);
    }
    @Then("Fast view window contains product images")
    public void fastViewHasImages(){
        catalogue.getFastView().assertImage();
    }
    @Then("Fast view window contains product characteristics")
    public void fastViewHasCharacteristics(){
        catalogue.getFastView().assertProperties();
    }
    @Then("Fast view window contains add to cart button")
    public void fastViewHasAddToCart(){
        catalogue.getFastView().assertAddToCart();
    }
    @Then("Fast view window contains read more button")
    public void fastViewReadMore(){
        catalogue.getFastView().assertReadMore();
    }
}
