package by.tkany.steps;

import by.tkany.pageObjects.*;
import framework.Browser;
import framework.PropertyReader;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class BaseSteps {
    public static PropertyReader testDataProperty = new PropertyReader("testData.properties");
    static LandingPage landing = new LandingPage();
    static CataloguePage catalogue;
    static InfoPage info;
    static AuthPage authorization;
    static ProductPage product;
    static SocialPage social;
    static UserPage user;
    static CartPage cart;
    static OrderPage order;

    @Given("User is logged in")
    public void loginViaCookies(){
        Browser.getDriver().manage().deleteCookie(Browser.getDriver().manage().getCookieNamed("PHPSESSID"));
        Browser.getDriver().manage().addCookie(new Cookie("PHPSESSID",testDataProperty.getProperty("login.cookies")));
        Browser.getDriver().navigate().refresh();
    }
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
    public void takeScreenShotAfterStep(Scenario scenario){
        if (scenario.isFailed()) {
            final byte[] screenShot = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/jpg", scenario.getName());
        }
    }
}
