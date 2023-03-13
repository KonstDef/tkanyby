package by.tkany.steps;

import framework.Browser;
import io.cucumber.java.en.*;
import org.openqa.selenium.Cookie;

import static by.tkany.steps.BaseSteps.*;

public class UserSteps {
    @When("User enters {string} to login name field")
    public void authEnterLoginName(String login){
        authorization.enterLoginName(login);
    }
    @When("User enters {string} to login password field")
    public void authEnterLoginPassword(String password){
        authorization.enterLoginPassword(password);
    }
    @When("User click on \"Войти\" button")
    public void authClickEnterButton(){
        authorization = authorization.clickEnter();
    }
    @Then("User sees success authorization page")
    public void authAssertSuccessPageOpened(){
        authorization.assertIsPageOpened();

        Cookie loginCookie= Browser.getDriver().manage().getCookieNamed("PHPSESSID");
        String loginCookieValue = loginCookie.getValue();
        testDataProperty.setProperty("login.cookies",loginCookieValue);
    }
    @Then("User clicks on {string} user tab link")
    public void authAssertUserTab(String label){
        user = user.navigateTo(label);
    }
    @Then("User page {string} is opened")
    public void authAssertUserPageIsOpened(String userPage){
        user.assertIsPageOpened();
    }
}
