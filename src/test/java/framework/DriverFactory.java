package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.*;

public class DriverFactory {
    public static WebDriver getDriver() {
        PropertyReader properties = new PropertyReader("config.properties");
        String browser = properties.getProperty("browser");

        boolean isHeadless = properties.getBooleanProperty("headless");
        String headless = isHeadless ? "--headless" : "";
        String windowSize = "--window-size=" + properties.getProperty("window_size");

        String[] args = new String[]{headless, windowSize};

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(args);
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(args);
                return new FirefoxDriver(firefoxOptions);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(args);
                return new EdgeDriver(edgeOptions);
            case "ie":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            default:
                System.out.println("Invalid browser name");
                return null;
        }
    }
}
