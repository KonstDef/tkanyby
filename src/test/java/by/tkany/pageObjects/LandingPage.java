package by.tkany.pageObjects;

import org.openqa.selenium.By;

public class LandingPage extends BaseByTkanyPage {
    private static final By PAGE_LOCATOR = By.id("promoBlock");

    public LandingPage() {
        super(PAGE_LOCATOR, "Landing");
    }
}
