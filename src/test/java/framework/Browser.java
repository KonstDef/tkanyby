package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Browser {
    private static final String DEFAULT_PAGE_LOAD_TIMEOUT = "page.timeout";
    private static final String DEFAULT_CONDITION_TIMEOUT = "condition.timeout";

    static final String PROPERTIES_FILE = "config.properties";

    private static Browser instance;
    private static WebDriver driver;

    private static int timeoutForCondition;
    private static int timeoutForPageLoad;

    private static PropertyReader props;

    public Function<? super WebDriver, Boolean> viewIsOnTop =
            (Function<WebDriver, Boolean>) webDriver -> getPageOffset().get(1) == 0;

    public Browser getInstance() {
        if (instance == null) {
            try {
                driver = DriverFactory.getDriver();
                driver.manage().timeouts().implicitlyWait(timeoutForCondition, TimeUnit.SECONDS);
            }catch (Exception e) {
                Assert.fail("Driver was not initialized");
            }
            initProperties();
            instance = new Browser();
        }
        return instance;
    }

    private static void initProperties() {
        props = new PropertyReader(PROPERTIES_FILE);
        timeoutForCondition = props.getIntProperty(DEFAULT_CONDITION_TIMEOUT);
        timeoutForPageLoad = props.getIntProperty(DEFAULT_PAGE_LOAD_TIMEOUT);
    }

    public void windowMaximize() {
        try {
            driver.manage().window().maximize();
        } catch (Exception e) {
            Assert.fail("Maximize fail: Driver was not initialized");
        }
    }

    public void getPage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<Long> getPageOffset() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long x = (Long) js.executeScript("return window.pageXOffset;");
        long y = (Long) js.executeScript("return window.pageYOffset;");
        return List.of(x, y);
    }

    public static int getTimeoutForCondition() {
        return timeoutForCondition;
    }

    public static int getTimeoutForPageLoad() {
        return timeoutForPageLoad;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getTimeoutForPageLoad()));
        try {
            wait.until((ExpectedCondition<Boolean>) d -> {
                if (!(d instanceof JavascriptExecutor)) {
                    return true;
                }
                Object result = ((JavascriptExecutor) d)
                        .executeScript("return document['readyState'] ? 'complete' === document.readyState : true");
                return result instanceof Boolean && (Boolean) result;
            });
            System.out.printf("Page %s(%s) loaded successfully\n", driver.getTitle(), driver.getCurrentUrl());
        } catch (Exception e) {
            Assert.fail("Page does not load: " + e);
        }
    }

    public static void waitForjQueryLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(getTimeoutForCondition()));
        wait.until(driver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0"));
    }

    public static <T, R> void explicitlyWaitUntil(Function<? super WebDriver, R> isTrue) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(getTimeoutForCondition()));
        wait.until(isTrue);
    }

    public static void goBack() {
        driver.navigate().back();
        waitForPageToLoad();
    }

    public void exit() {
        if (instance != null) {
            driver.quit();
            instance = null;
        }
    }
}