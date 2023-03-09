package by.tkany.pageObjects;

import org.openqa.selenium.By;

public class AuthPage extends BaseByTkanyPage {
    private static final String IDENTIFIER = "//h1[contains(.,'%s')]";

    public AuthPage(String title) {
        super(By.xpath(String.format(IDENTIFIER,title)), title);
    }
}