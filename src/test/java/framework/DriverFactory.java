package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class DriverFactory {
    public static WebDriver getDriver() {
        PropertyReader properties = new PropertyReader("config.properties");
        String browser = properties.getProperty("browser");
        List<String> args =  new ArrayList<>();

        boolean isHeadless = properties.getBooleanProperty("headless");
        String headless = "--headless";
        if(isHeadless) args.add(headless);

        String windowSize = "--window-size=" + properties.getProperty("window_size");
        args.add(windowSize);

        boolean isAllowOrigin = properties.getBooleanProperty("remote");
        String allowOrigin = "--remote-allow-origins=*";
        if(isAllowOrigin) args.add(allowOrigin);

        boolean isActivePort = properties.getBooleanProperty("activeport");
        String activePort =  "--no-sandbox --disable-dev-shm-usage";
        if(isActivePort) args.add(activePort);

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
                log.error("Invalid browser name");
                return null;
        }
    }
}