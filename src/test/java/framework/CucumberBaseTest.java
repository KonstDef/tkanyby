package framework;

import io.cucumber.testng.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;

@Log4j2
@Listeners(TestListener.class)
public abstract class CucumberBaseTest {
    private TestNGCucumberRunner testNGCucumberRunner;
    public static PropertyReader properties = new PropertyReader("config.properties");

    public Browser driver = new Browser();

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver.getInstance();
        driver.windowMaximize();
        driver.getPage(properties.getProperty("base.URL"));
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown(){
        driver.exit();
    }

    @BeforeClass(alwaysRun = true)
    public void setupClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }

    @Test(dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        try {
            return this.testNGCucumberRunner.provideScenarios();
        } catch (NullPointerException nullPointerException){
            log.fatal(this.getClass().toString()+": Feature file is missing or has an other name;");
            return new Object[0][0];
        }
    }
}
