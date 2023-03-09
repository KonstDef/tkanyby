package by.tkany.pageObjects.pageComponents;
import framework.Browser;
import framework.elements.TextBox;
import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class FloaterComponent{
    public static final TextBox FLOATING_FOOTER = new TextBox(By.id("footerLine"));
    public static final Button BACK_TO_TOP_BUTTON = new Button(By.id("upButton"));

    @Step("Check floating menu is visible")
    public void isVisible(){
        Assert.assertTrue(FLOATING_FOOTER.isDisplayed(),"Floating footer is not visible, but expected to be");
    }

    @Step("Click on 'Back to Top' button")
    public void backToTop(){
        BACK_TO_TOP_BUTTON.click();
    }

    @Step("Check if the screen is on top")
    public void assertIsOnTop(){
        try {
            Browser.explicitlyWaitUntil(Browser.viewIsOnTop);
        } catch (TimeoutException e) {
            Assert.fail("View failed to return to start position after clicking \"back to top\" button ");
        }
    }

    @Step("Check if back to top button is visible")
    public void assertBackToTopVisible(boolean isVisible){
        if(isVisible) Assert.assertTrue(BACK_TO_TOP_BUTTON.isDisplayed(),
                "Arrow button is not visible, but expected to be");
        else Assert.assertFalse(BACK_TO_TOP_BUTTON.isDisplayed(),
                "Arrow button is visible, but expected to be not");
    }
}
