//package by.tkany.tests.inP;
//
//import framework.BaseTest;
//import framework.Browser;
//import framework.elements.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static by.tkany.pageObjects.Selectors.*;
//
//public class BackToHeaderTest extends BaseTest {
//    @Test(testName = "ArrowButton | ID20", description = "Arrow button return scroll to header on click")
//    public void test20() {
//        TextBox footerBar = new TextBox(By.id(FOOTER_BAR_ID));
//        footerBar.scrollTo();
//
//        Label arrowButton = new Label(By.xpath(BACK_TO_TOP_BUTTON_XPATH));
//        arrowButton.moveAndClickByAction();
//        try {
//            Browser.explicitlyWaitUntil(driver.viewIsOnTop);
//        } catch (TimeoutException e) {
//            Assert.fail("View failed to return to start position after clicking \"back to page top\" button ");
//        }
//
//        Assert.assertFalse(arrowButton.isDisplayed(),
//                "Arrow button is visible after screen returned back to top");
//    }
//}