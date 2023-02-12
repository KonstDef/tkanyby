package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> pageLoaded(WebDriver driver) {
        return new ExpectedCondition<>() {
            @Override
            public Boolean apply(WebDriver input) {
                String pageLoadingState = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
                return pageLoadingState.equals("complete");
            }

            public String toString() {
                return "loaded state of current page.";
            }
        };
    }
}
