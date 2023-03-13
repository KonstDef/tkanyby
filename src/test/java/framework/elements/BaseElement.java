package framework.elements;

import framework.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Log4j2
public abstract class BaseElement {
    public static String containsText = "contains(translate(normalize-space(.),' ',' '),'%s')";
    protected WebElement element;
    protected List<WebElement> elements;
    private PropertyReader logProperties = new PropertyReader("log.properties");
    private By by;
    private String name;

    protected abstract String getElementType();

    public BaseElement(By by) {
        this.by = by;
    }

    public BaseElement(By by, String name) {
        this.by = by;
        this.name = name;
    }

    public WebElement getElement() {
        isElementPresent();
        return element;
    }

    public List<WebElement> getElements() {
        areElementsPresent();
        return elements;
    }

    public boolean isElementPresent() {
        try {
            Browser.getDriver().manage().timeouts().implicitlyWait(Browser.getTimeoutForCondition(), TimeUnit.SECONDS);
            element = Browser.getDriver().findElement(by);
            log.info(String.format("%s: %s - %s;", getElementType(), by, logProperties.getProperty("present")));
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            log.info(String.format("%s: %s - %s;\n \"NoSuchElementException\"", getElementType(), by, logProperties.getProperty("presentFailure")));
            return false;
        } catch (Exception e) {
            log.warn(String.format("%s: %s - Exception: %s", getElementType(), by, e));
        }
        return false;
    }

    public boolean areElementsPresent() {
        try {
            Browser.getDriver().manage().timeouts().implicitlyWait(Browser.getTimeoutForCondition(), TimeUnit.SECONDS);
            elements = Browser.getDriver().findElements(by);

            log.info(String.format("%s(%d): %s - %s;", getElementType(), elements.size(), by, logProperties.getProperty("presents")));
            long elementsPresentNum = elements.stream().filter(WebElement::isDisplayed).count();
            return elementsPresentNum > 0;
        } catch (NoSuchElementException e) {
            log.info(String.format("%s: %s - %s; \"NoSuchElementException\"", getElementType(), by, logProperties.getProperty("presentsFailure")));
            return false;
        } catch (Exception e) {
            log.warn(String.format(("Exception: " + e)));
        }
        return false;
    }

    public boolean isDisplayed() {
        return isElementPresent();
    }

    public boolean isClickable() {
        isElementPresent();
        try {
            new WebDriverWait(Browser.getDriver(), Duration.ZERO)
                    .until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException timeoutException) {
            log.error(String.format("%s: %s - %s;", getElementType(), by, logProperties.getProperty("clickFailure")));
        } catch (ElementNotInteractableException elementNotInteractableException){
            return false;
        }
        return false;
    }

    public String getAttribute(String attributeName) {
        isElementPresent();
        String attributeValue = element.getAttribute(attributeName);

        log.info(String.format("%s: %s - %s '%s' = %s;", getElementType(), by, logProperties.getProperty("attribute"), attributeName, attributeValue));
        return attributeValue;
    }

    public String getText() {
        isElementPresent();
        String elementText = element.getText();

        log.info(String.format("%s: %s - %s = %s;", getElementType(), by, logProperties.getProperty("text"), elementText));
        return elementText;
    }

    public List<String> getTextList() {
        areElementsPresent();
        List<String> elementTextList = new ArrayList<>();
        elements.forEach(e -> elementTextList.add(e.getText()));

        long nonEmpty = elementTextList.stream().filter(Predicate.not(String::isBlank)).count();

        log.info(String.format("%s: %s - %s(%d);", getElementType(), by, logProperties.getProperty("textList"), nonEmpty));
        return elementTextList;
    }

    public int countElements() {
        areElementsPresent();
        return elements.size();
    }

    public void forEach(Consumer<WebElement> consumer) {
        areElementsPresent();
        elements.forEach(consumer);
    }

    public void scrollTo() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        log.info(String.format("%s: %s - %s;", getElementType(), by, logProperties.getProperty("scroll")));
        actions.scrollToElement(element).build().perform();
    }

    public void click() {
        isElementPresent();
        element.click();
        log.info(String.format("%s: %s - %s;", getElementType(), by, logProperties.getProperty("sendKeys")));
    }

    public void clickByAction() {
        isElementPresent();
        Actions action = new Actions(Browser.getDriver());
        action.click(element).build().perform();
        log.info(String.format("%s: %s - %s;", getElementType(), by, logProperties.getProperty("sendKeys")));
    }

    public void waitForElementAttachment() {
        FluentWait<BaseElement> wait = new FluentWait<>(this)
                .withTimeout(Duration.ofSeconds(Browser.getTimeoutForCondition()))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(BaseElement::isElementPresent);
    }

    public void waitToStale() {
        Browser.explicitlyWaitUntil(ExpectedConditions.stalenessOf(getElement()));
    }

    public void clickAndWait() {
        click();
        Browser.waitForPageToLoad();
    }

    public void moveTo() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).build().perform();
    }

    public void scrollIntoView() {
        moveTo();
        JavascriptExecutor js = (JavascriptExecutor) Browser.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void moveAndClickByAction() {
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click(element).build().perform();
        log.info(String.format("%s: %s - %s;", getElementType(), by, logProperties.getProperty("click")));
    }

    public void sendKeys(String keys) {
        isElementPresent();
        element.sendKeys(keys);
        log.info(String.format("%s: %s - %s '%s';", getElementType(), by, logProperties.getProperty("sendKeys"), keys));
    }

    public void sendKeysToIndex(int i, String keys) {
        areElementsPresent();
        elements.get(i).sendKeys(keys);
        log.info(String.format("%s: %s[%d] - %s '%s';", getElementType(), by, i, logProperties.getProperty("sendKeys"), keys));
    }

    public void clickByJS() {
        isElementPresent();
        if (Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
        }
        ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click()", element);
        log.info(String.format("%s: %s - %s;", getElementType(), by, logProperties.getProperty("clickByJS")));
    }

    public String getJSValue() {
        isElementPresent();
        String value = (String) ((JavascriptExecutor) Browser.getDriver()).executeScript("return arguments[0].value", element);
        log.info(String.format("%s: %s - %s = %s;", getElementType(), by, logProperties.getProperty("getJSValue"),value));
        return value;
    }
    public void clearInput() {
        isElementPresent();
        element.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"A",Keys.DELETE));
    }
}