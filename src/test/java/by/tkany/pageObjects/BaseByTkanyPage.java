package by.tkany.pageObjects;

import by.tkany.pageObjects.pageComponents.*;
import by.tkany.pageObjects.pageComponents.header.*;
import framework.BasePage;
import framework.Browser;
import lombok.*;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

@Getter
@Setter
public class BaseByTkanyPage extends BasePage {
    private AuthorizationNavigationComponent authorizationMenu = new AuthorizationNavigationComponent();
    private CallToComponent callTo = new CallToComponent();
    private HamburgerNavigation navigation = new HamburgerNavigation();
    private SocialLabelsComponent socialLabels = new SocialLabelsComponent();
    private FloaterComponent floater = new FloaterComponent();
    private FooterComponent footer = new FooterComponent();
    private SearchComponent search = new SearchComponent();
    private CallbackFormComponent callback = new CallbackFormComponent();
    private CatalogueNavigationComponent catalogueNavigation = new CatalogueNavigationComponent();
    private FastViewComponent fastView;
    private FastOrderComponent fastOrder;
    private ConfirmProductComponent confirmProduct;

    public static SoftAssert softAssert = new SoftAssert();

    @AfterMethod
    private void waitForJQuery() {
        Browser.waitForjQueryLoad();
    }

    public BaseByTkanyPage(By locator, String title) {
        super(locator, title);
    }
}
