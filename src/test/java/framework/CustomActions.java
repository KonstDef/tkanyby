package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Consumer;

public class CustomActions extends Actions {
    private final WebDriver webDriver;

    public CustomActions(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }

    public CustomActions moveToElementTop(WebElement source) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", source);

        return (CustomActions) super.moveToElement(source);
    }

    public CustomActions inProcess(WebElement webElement, Consumer<WebElement> action) {
        this.perform();
        new WebDriverWait(webDriver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(webElement));
        action.accept(webElement);
        return this;
    }
    @Override
    public CustomActions moveToElement(WebElement target) {
        return (CustomActions) super.moveToElement(target);
    }
}