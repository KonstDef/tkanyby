package by.tkany.tests;

import framework.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/by/tkany/features/callback_form.feature",
        glue = {"by/tkany/steps"},
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class CallbackFormTest extends CucumberBaseTest {

}
