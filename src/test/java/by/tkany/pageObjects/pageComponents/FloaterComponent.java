package by.tkany.pageObjects.pageComponents;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FloaterComponent{
    public static final TextBox FLOATING_FOOTER = new TextBox(By.id("footerLine"));
    public static final String FLOATING_FOOTER_LINK_BY_TEXT_XPATH = "//div[@id='footerLine']//a[contains(text(),'%s')]";

    @Step("Check floating menu is visible")
    public FloaterComponent isVisible(){
        Assert.assertTrue(FLOATING_FOOTER.isDisplayed(),"Floating footer is not visible, but expected to be");
        return this;
    }
}
