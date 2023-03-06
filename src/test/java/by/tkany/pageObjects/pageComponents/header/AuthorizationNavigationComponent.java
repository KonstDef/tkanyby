package by.tkany.pageObjects.pageComponents.header;

import by.tkany.pageObjects.AuthPage;
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
}
