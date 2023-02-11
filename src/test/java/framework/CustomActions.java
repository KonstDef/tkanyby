package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomActions extends Actions{
    private final WebDriver webDriver;
    public CustomActions(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
    }

    public Actions moveToElementTop(WebElement source){
        JavascriptExecutor js=(JavascriptExecutor)webDriver;
        js.executeScript("arguments[0].scrollIntoView();",source);

        return super.moveToElement(source);
    }
}
