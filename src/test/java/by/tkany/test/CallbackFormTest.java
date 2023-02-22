package by.tkany.test;

import by.tkany.testData.DataProviders;
import framework.BaseTest;
import framework.elements.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

import static by.tkany.testData.Selectors.*;

public class CallbackFormTest extends BaseTest {
    //TODO: extend test logic
    @Test(testName = "CallbackForm | ID5", description = "Link 'Заказать звонок' toggles callback form to open on widescreen",
            dataProvider = "CallbackFormData", dataProviderClass = DataProviders.class)
    public void testID05(List<String> webFormItemsTextsExpected) {
        Label phoneOrderButton = new Label(By.xpath(NAV_MENU_PHONE_ORDER_XPATH));
        phoneOrderButton.moveAndClickByAction();

        TextBox webFormItems = new TextBox(By.xpath(String.format(CALLBACK_WEBFORM_TITLE_BY_TEXT_XPATH, "")));
        List<String> webFormItemsTexts = webFormItems.getTextList();
        Assert.assertEquals(webFormItemsTexts,webFormItemsTextsExpected,
                String.join("\n", "Callback form items do not equal expected:",
                "Actual result: " + webFormItemsTexts.toString(),
                "Expected result: " + webFormItemsTextsExpected));
    }
}
