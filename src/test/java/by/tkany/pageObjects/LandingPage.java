package by.tkany.pageObjects;

import org.openqa.selenium.By;

public class LandingPage extends BaseByTkanyPage {
    private static final By IDENTIFIER = By.id("promoBlock");

    public LandingPage() {
        super(IDENTIFIER, "Landing");
    }
}
