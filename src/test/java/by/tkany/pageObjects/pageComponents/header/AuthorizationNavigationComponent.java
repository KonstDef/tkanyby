package by.tkany.pageObjects.pageComponents.header;

import by.tkany.pageObjects.AuthPage;
import by.tkany.pageObjects.BaseByTkanyPage;
import by.tkany.pageObjects.UserPage;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AuthorizationNavigationComponent {
    public static final String AUTH_LABELS_BY_TEXT_XPATH = "//div[@id='topAuth']//a[contains(text(),'%s')]";

    @Step("Redirect to authorization page")
    public AuthPage redirectAuth(String authPageTitle){
        Label authPageLabel = new Label(By.xpath(String.format(AUTH_LABELS_BY_TEXT_XPATH, authPageTitle)));
        authPageLabel.clickAndWait();

        if(authPageTitle.equals("Вход")) return new AuthPage("Авторизация");
        return new AuthPage(authPageTitle);
    }

    @Step("Redirect to user page")
    public UserPage redirectUser(String userPageTitle){
        redirectAuth(userPageTitle);
        return new UserPage(userPageTitle);
    }

    @Step("Asserts if navigation label is not present")
    public void assertPresent(String authPageTitle){
        Label authPageLabel = new Label(By.xpath(String.format(AUTH_LABELS_BY_TEXT_XPATH, authPageTitle)));
        BaseByTkanyPage.softAssert.assertTrue(authPageLabel.isDisplayed(),authPageTitle+" label was not displayed, but expected.");
    }
}
