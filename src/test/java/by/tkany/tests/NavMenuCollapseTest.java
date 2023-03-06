package by.tkany.tests;

import framework.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/by/tkany/features/nav_menu_collapse.feature",
        glue = {"by/tkany/steps"},
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class NavMenuCollapseTest extends CucumberBaseTest {
}
