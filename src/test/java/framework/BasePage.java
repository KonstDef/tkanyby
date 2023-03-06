package framework;

import framework.elements.Label;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Date;

@Log4j2
public abstract class BasePage {
    private String pageName;
    private Label pageIdentifier;

    public void init(final By locator, final String title){
        this.pageName = title;
        this.pageIdentifier = new Label(locator);
    }
    public void assertIsPageOpened(){
        long startTime = new Date().getTime();
        Browser.waitForPageToLoad();
        try{
            pageIdentifier.isElementPresent();
            long openTime = new Date().getTime() - startTime;
            log.info(String.format("Form '%s' appears in %s msec",pageName,openTime));
        } catch (Throwable e){
            Assert.fail(String.format("ERROR: Page '%s' was not loaded\n",this.pageName));
        }
    }

    public BasePage(final By locator, final String title){
        init(locator,title);
        assertIsPageOpened();
    }
}