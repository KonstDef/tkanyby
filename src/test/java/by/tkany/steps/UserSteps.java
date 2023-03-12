package by.tkany.steps;

import io.cucumber.java.en.*;

import static by.tkany.steps.BaseSteps.*;

public class UserSteps {
    @When("User enters {string} to login name field")
    public void enterLoginName(String login){
        authorization.enterLoginName(login);
    }
    @When("User enters {string} to login password field")
    public void enterLoginPassword(String password){
        authorization.enterLoginPassword(password);
    }
    @When("User click on \"Войти\" button")
    public void clickEnterButton(){
        authorization = authorization.clickEnter();
    }
    @Then("User clicks on {string} user tab link")
    public void assertUserTab(String label){
        user = user.navigateTo(label);
    }
    @Then("User page {string} is opened")
    public void assertUserPageIsOpened(String userPage){
        user.assertIsPageOpened();
    }
}
