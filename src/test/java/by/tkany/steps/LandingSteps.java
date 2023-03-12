package by.tkany.steps;

import by.tkany.pageObjects.*;
import framework.Browser;
import io.cucumber.java.en.*;

import static by.tkany.steps.BaseSteps.*;
import static framework.TextTransformers.*;

public class LandingSteps {
    @Then("Visible links list is similar to {string}")
    public void checkVisible(String visibleList) {
        landing.getNavigation().checkVisibleLabels(commaSeparate(visibleList));
    }
    @When("User clicks on Hamburger button")
    public void clickHamburger() {
        landing.getNavigation().clickHamburgerButton();
    }
    @Then("Hidden links list is similar to {string}")
    public void checkHidden(String hiddenList) {
        landing.getNavigation().checkHiddenLabels(commaSeparate(hiddenList));
        LandingPage.softAssert.assertAll();
    }
    @Then("{string} redirect to info pages")
    public void toInfo(String navList) {
        commaSeparate(navList).forEach(s -> {
            landing.getNavigation().redirectInfo(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
    }
    @And("{string} redirect to authorization pages")
    public void toAuth(String authList) {
        commaSeparate(authList).forEach(s -> {
            landing.getAuthorizationMenu().redirectAuth(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
    }
    @And("{string} check callto: number")
    public void toCallTo(String calltoList) {
        commaSeparate(calltoList).forEach(s -> landing.getCallTo().checkCallTo(s));
    }
    @And("{string} redirect to social pages")
    public void toSocial(String socialList) {
        commaSeparate(socialList).forEach(s -> {
            landing.getSocialLabels().redirectSocial(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
    }
    @And("{string} open callback page")
    public void toCallback(String callbackList) {
        commaSeparate(callbackList).forEach(s -> {
            landing.getCallTo().redirectCallback(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
        LandingPage.softAssert.assertAll();
    }
    @Then("User sees floating menu")
    public void checkFloater() {
        landing.getFloater().isVisible();
    }
    @When("User scrolls down to footer")
    public void scrollToFooter() {
        landing.getFooter().scrollTo();
    }
    @When("User scrolls up to navigation menu")
    public void scrollToHeader() {
        landing.getNavigation().scrollTo();
    }
    @When("User enters {string} into search field")
    public void searchFieldEnter(String product) {
        landing.getSearch().enterSearchText(product);
    }
    @Then("User sees {string} card under search field")
    public void checkCardIsPresent(String product) {
        landing.getSearch().checkProduct(product);
    }
    @When("User clicks on {string} card under search field")
    public void clickCard(String productName) {
        product = landing.getSearch().clickOnProduct(productName);
    }
    @Then("Product page {string} is opened")
    public void cardIsOpened(String productName) {
        product.assertIsPageOpened();
    }
    @When("User clicks \"Заказать звонок\" button")
    public void openCallOrder() {
        landing.getCallTo().openForm();
    }
    @Then("Callback form is displayed")
    public void checkOpened() {
        landing.getCallback().isOpened();
    }
    @When("User fills {string} with {string}")
    public void checkOpened(String fields, String data) {
        connectTestData(commaSeparate(fields),commaSeparate(data))
                .forEach((k,v)-> landing.getCallback().enterLine(k,v));
    }
    @And("User clicks personal data consent checkbox")
    public void checkCallbackConsent() {
        landing.getCallback().pressAgreed();
    }
    @And("User clicks on \"Отправить\" button")
    public void sendCallbackForm() {
        landing.getCallback().sendForm();
    }
    @Then("Success message is displayed")
    public void checkFormSuccess(){
        landing.getCallback().checkSuccess();
    }
    @When ("User clicks {string} category on catalogue navigation list")
    public void catalogMainNavigation(String title){
        catalogue = landing.getCatalogueNavigation().navigateMain(title);
    }
    @When ("User moves mouse on {string} category at catalogue navigation list")
    public void catalogMainMove(String title){
        landing.getCatalogueNavigation().openSubMenuList(title);
    }
    @And ("User clicks {string} subCategory at catalogue navigation list")
    public void catalogSubNavigation(String title){
        catalogue = landing.getCatalogueNavigation().openSubMenu(title);
    }
    @When ("User clicks on \"Back to top\" button")
    public void backToTop(){
        landing.getFloater().backToTop();
    }
    @Then ("Screen is returned to top")
    public void isOnTop(){
        landing.getFloater().assertIsOnTop();
    }
    @Then ("\"Back to top\" button {string} visible")
    public void backToTopVisible(String title){
        boolean expected = title.equals("is");
        landing.getFloater().assertBackToTopVisible(expected);
    }
    @When ("User clicks on {string} navigation label")
    public void loginPageClick(String label){
        switch(label){
            case "Вход":{
                authorization = landing.getAuthorizationMenu().redirectAuth("Вход");
                break;
            }
            case "Личный кабинет":{
                user = landing.getAuthorizationMenu().redirectUser("Личный кабинет");
                break;
            }
            case "Выход":{
                landing.getAuthorizationMenu().redirectAuth("Выход");
                break;
            }
        }
    }
    @When ("There is no {string} navigation label")
    public void assertLichny(String navLabel){
        landing.getAuthorizationMenu().assertPresent(navLabel);
    }

}
