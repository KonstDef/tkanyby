package by.tkany.steps;

import by.tkany.pageObjects.*;
import framework.Browser;
import io.cucumber.java.en.*;

import static by.tkany.steps.BaseSteps.*;
import static framework.TextTransformers.*;

public class LandingSteps {
    @Then("Visible links list is similar to {string}")
    public void landingCheckVisible(String visibleList) {
        landing.getNavigation().checkVisibleLabels(commaSeparate(visibleList));
    }
    @When("User clicks on Hamburger button")
    public void landingClickHamburger() {
        landing.getNavigation().clickHamburgerButton();
    }
    @Then("Hidden links list is similar to {string}")
    public void landingCheckHidden(String hiddenList) {
        landing.getNavigation().checkHiddenLabels(commaSeparate(hiddenList));
        LandingPage.softAssert.assertAll();
    }
    @Then("{string} redirect to info pages")
    public void landingRedirectInfo(String navList) {
        commaSeparate(navList).forEach(s -> {
            landing.getNavigation().redirectInfo(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
    }
    @And("{string} redirect to authorization pages")
    public void landingRedirectAuth(String authList) {
        commaSeparate(authList).forEach(s -> {
            landing.getAuthorizationMenu().redirectAuth(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
    }
    @And("{string} check callto: number")
    public void landingRedirectCallTo(String calltoList) {
        commaSeparate(calltoList).forEach(s -> landing.getCallTo().checkCallTo(s));
    }
    @And("{string} redirect to social pages")
    public void landingRedirectSocial(String socialList) {
        commaSeparate(socialList).forEach(s -> {
            landing.getSocialLabels().redirectSocial(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
    }
    @And("{string} open callback page")
    public void landingRedirectCallback(String callbackList) {
        commaSeparate(callbackList).forEach(s -> {
            landing.getCallTo().redirectCallback(s)
                    .assertIsPageOpened();
            Browser.goBack();
        });
        LandingPage.softAssert.assertAll();
    }
    @Then("User sees floating menu")
    public void landingFloaterVisible() {
        landing.getFloater().isVisible();
    }
    @When("User scrolls down to footer")
    public void landingScrollToFooter() {
        landing.getFooter().scrollTo();
    }
    @When("User scrolls up to navigation menu")
    public void landingScrollToHeader() {
        landing.getNavigation().scrollTo();
    }
    @When("User enters {string} into search field")
    public void landingSearchFieldEnter(String product) {
        landing.getSearch().enterSearchText(product);
    }
    @Then("User sees {string} card under search field")
    public void landingCheckCardIsPresent(String product) {
        landing.getSearch().checkProduct(product);
    }
    @When("User clicks on {string} card under search field")
    public void landingClickCard(String productName) {
        product = landing.getSearch().clickOnProduct(productName);
    }
    @Then("Product page {string} is opened")
    public void landingCardIsOpened(String productName) {
        product.assertIsPageOpened();
    }
    @When("User clicks \"Заказать звонок\" button")
    public void landingOpenCallOrder() {
        landing.getCallTo().openForm();
    }
    @Then("Callback form is displayed")
    public void landingCheckOpened() {
        landing.getCallback().isOpened();
    }
    @When("User fills {string} with {string}")
    public void landingCallbackEnterLine(String fields, String data) {
        connectTestData(commaSeparate(fields),commaSeparate(data))
                .forEach((k,v)-> landing.getCallback().enterLine(k,v));
    }
    @And("User clicks personal data consent checkbox")
    public void landingCheckCallbackConsent() {
        landing.getCallback().pressAgreed();
    }
    @And("User clicks on \"Отправить\" button")
    public void landingSendCallbackForm() {
        landing.getCallback().sendForm();
    }
    @Then("Success message is displayed")
    public void landingCheckFormSuccess(){
        landing.getCallback().checkSuccess();
    }
    @When ("User clicks {string} category on catalogue navigation list")
    public void landingCatalogueMainNavigation(String title){
        catalogue = landing.getCatalogueNavigation().navigateMain(title);
    }
    @When ("User moves mouse on {string} category at catalogue navigation list")
    public void landingCatalogueMainMove(String title){
        landing.getCatalogueNavigation().openSubMenuList(title);
    }
    @And ("User clicks {string} subCategory at catalogue navigation list")
    public void landingCatalogueSubNavigation(String title){
        catalogue = landing.getCatalogueNavigation().openSubMenu(title);
    }
    @When ("User clicks on \"Back to top\" button")
    public void landingBackToTop(){
        landing.getFloater().backToTop();
    }
    @Then ("Screen is returned to top")
    public void landingIsOnTop(){
        landing.getFloater().assertIsOnTop();
    }
    @Then ("\"Back to top\" button {string} visible")
    public void landingBackToTopVisible(String title){
        boolean expected = title.equals("is");
        landing.getFloater().assertBackToTopVisible(expected);
    }
    @When ("User clicks on {string} navigation label")
    public void landingLoginPageClick(String label){
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
    public void landingAssertLichny(String navLabel){
        landing.getAuthorizationMenu().assertPresent(navLabel);
    }
}
