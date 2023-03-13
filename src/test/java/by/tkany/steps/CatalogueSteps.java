package by.tkany.steps;

import io.cucumber.java.en.*;

import static by.tkany.steps.BaseSteps.*;
import static framework.TextTransformers.commaSeparate;
import static framework.TextTransformers.connectTestData;

public class CatalogueSteps {
    @Then ("Catalogue page {string} is opened")
    public void catalogueCheckPageOpened(String catalogueTitle){
        catalogue.isPageCorrect(catalogueTitle);
    }
    @And("User clicks on {string} subcategory under catalogue navigation list")
    public void catalogueGoToDirectCategory(String subCategory){
        catalogue.navigateToDirectSub(subCategory);
    }
    @Then("Catalog menu expand button is present on page")
    public void catalogueMenuPresent(){
        catalogue.getCatalogueNavigation().assertIsPresent();
    }
    @And ("There are {int} product filters on page")
    public void catalogueCheckFiltersNum(int numExpected){
        catalogue.getFilter().checkNumber(numExpected);
    }
    @And ("There are product cards on page")
    public void catalogueThereAreProducts(){
        catalogue.assertAreProducts();
    }
    @And ("Pagination {string} expected")
    public void catalogueCheckPagination(String bool){
        boolean isPaginationExpected = bool.equals("is");
        catalogue.assertPagination(isPaginationExpected);
    }
    @And ("User sets {string} for {string} filter")
    public void catalogueSetFilter(String filterValue, String filterName){
        connectTestData(commaSeparate(filterName),commaSeparate(filterValue))
                .forEach((k,v)-> catalogue.getFilter(k).setValue(v));
    }
    @And ("User opens product page for {string}")
    public void catalogueOpenProduct(String productName){
        product = catalogue.getProductCard(productName).openProductPage();
    }
    @When ("User sorts products by {string}")
    public void catalogueSortProductList(String sortName){
        catalogue.sortProductList(sortName);
    }
    @When ("User hovers mouse over {string} card image")
    public void catalogueMoveMouseOnProduct(String sortName){
        catalogue.getProductCard(sortName).mouseOver();
    }
    @When("User opens fast view for {string}")
    public void catalogueOpenFastView(String sortName){
      catalogue.setFastView(
              catalogue.getProductCard(sortName).openFastView()
      );
    }
    @Then ("Fast view window is opened")
    public void catalogueFastViewOpened(){
        catalogue.getFastView().assertOpened();
    }
    @Then ("Fast view window contains {string} name")
    public void catalogueFastViewHasName(String productName){
        catalogue.getFastView().assertNameEquals(productName);
    }
    @Then("Fast view window contains product article equals to {string}")
    public void catalogueFastViewArticle(String article){
        catalogue.getFastView().assertArticleEquals(article);
    }
    @Then("Fast view window contains product images")
    public void catalogueFastViewHasImages(){
        catalogue.getFastView().assertImage();
    }
    @Then("Fast view window contains product characteristics")
    public void catalogueFastViewHasCharacteristics(){
        catalogue.getFastView().assertProperties();
    }
    @Then("Fast view window contains add to cart button")
    public void catalogueFastViewHasAddToCart(){
        catalogue.getFastView().assertAddToCart();
    }
    @Then("Fast view window contains read more button")
    public void catalogueFastViewReadMore(){
        catalogue.getFastView().assertReadMore();
    }
}
