package by.tkany.steps;

import by.tkany.pageObjects.*;
import framework.Browser;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class BaseSteps {
    static LandingPage landing = new LandingPage();
    static CataloguePage catalogue;
    static InfoPage info;
    static AuthPage authorization;
    static ProductPage product;
    static SocialPage social;

    @Given("User is on {string} page")
    public void startFrom(String page){
        switch (page){
            case "Landing":{
                landing.assertIsPageOpened();
                break;
            }
            case "Catalogue":{
                break;
            }
        }
    }

    @After
    public void takeScreenShotAfterStep(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/jpg", scenario.getName());
        }
    }
}
