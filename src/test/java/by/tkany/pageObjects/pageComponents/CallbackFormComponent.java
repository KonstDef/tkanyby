package by.tkany.pageObjects.pageComponents;

import framework.elements.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CallbackFormComponent {
    private static final String CALLBACK_WEBFORM_LINES = "//div[@class='webFormItemLabel' and contains(text(),'%s')]/ancestor::div[@class='webFormItem']//input";
    private static final TextBox CALLBACK_WEBFORM_TITLE = new TextBox(By.xpath("//div[contains(@class,'webFormModalHeading') and contains(.,'Заказать звонок')]"));
    private static final CheckBox CALLBACK_WEBFORM_AGREED = new CheckBox(By.xpath("//form[@name]//input[@type='checkbox']"));
    private static final Button CALLBACK_WEBFORM_SEND = new Button(By.xpath("//form[@name]//input[@type='submit' and contains(@value,'Отправить')]"));
    private static final TextBox CALLBACK_WEBFORM_SUCCESS_TITLE = new TextBox(By.xpath("//div[@id='webFormMessage_2']//div[contains(@class,'Heading')]"));
    private static final Button CALLBACK_WEBFORM_SUCCESS_BUTTON = new Button(By.xpath("//div[@id='webFormMessage_2']//a[contains(@class,'Exit')]"));

    @Step("Check callback form is opened")
    public void isOpened(){
        Assert.assertTrue(CALLBACK_WEBFORM_TITLE.isDisplayed(),
                "Callback webform was not opened, but expected.");
    }

    @Step("Enter {data} into {lineName}")
    public CallbackFormComponent enterLine(String lineName, String data){
        TextBox input = new TextBox(By.xpath(String.format(CALLBACK_WEBFORM_LINES,lineName)));
        input.sendKeys(data);
        return this;
    }

    @Step("Check personal data consent")
    public CallbackFormComponent pressAgreed(){
        CALLBACK_WEBFORM_AGREED.moveAndClickByAction();
        return this;
    }

    @Step("Send callback data")
    public CallbackFormComponent sendForm(){
        CALLBACK_WEBFORM_SEND.moveAndClickByAction();
        return this;
    }

    @Step("Check message display is success")
    public CallbackFormComponent checkSuccess(){
        CALLBACK_WEBFORM_SUCCESS_TITLE.waitForElementAttachment();
        String textActual = CALLBACK_WEBFORM_SUCCESS_TITLE.getText();
        Assert.assertEquals(textActual,"Сообщение отправлено",
                "Success message for callback does not equals expected:\nActual: '"+textActual+"'\nExpected: 'Сообщение отправлено'");
        CALLBACK_WEBFORM_SUCCESS_BUTTON.click();
        return this;
    }
}
