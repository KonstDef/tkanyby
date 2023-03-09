package by.tkany.pageObjects;

import framework.BasePage;
import org.openqa.selenium.By;

public class AuthPage extends BaseTest {
    private static final String IDENTIFIER = "//h1[contains(.,'%s')]";

    public AuthPage(String title) {
        super(By.xpath(String.format(IDENTIFIER,title)), title);
    }
}
