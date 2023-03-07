package by.tkany.pageObjects.pageComponents.header;

import by.tkany.pageObjects.*;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.regex.Pattern;

public class CallToComponent{
    public static final String PHONE_NUMBER_BY_TEXT_XPATH = "//div[@class='phonesTc']/span/a[contains(text(),'%s')]";
    public static final String ICON_LABELS_BY_CLASS_XPATH = "//div[contains(@id,'headerLine') or contains(@id,'subHeader')]//a[contains(@class,'%s')]";
    public static final Label PHONE_ORDER_LABEL_XPATH = new Label(By.xpath("//a[contains(@class,'openWebFormModal')]"));


    @Step("Check callto: link")
    public void checkCallTo(String phoneNumber){
        Label callTo = new Label(By.xpath(String.format(PHONE_NUMBER_BY_TEXT_XPATH, phoneNumber)));
        BaseByTkanyPage.softAssert.assertTrue(callTo.isClickable(),
                String.format("Phone button is not clickable for number: %s\nExpected: is clickable",phoneNumber));

        String callToNumberActual = callTo.getAttribute("href");

        Pattern pattern = Pattern.compile("[^0-9]");
        callToNumberActual = callToNumberActual.replaceAll(pattern.pattern(),"");

        String callToNumberExpected = phoneNumber.replaceAll(pattern.pattern(),"");

        BaseByTkanyPage.softAssert.assertEquals(callToNumberActual,callToNumberExpected,
                String.format("Phone number at link does not equal expected \nExpected: %s\nActual: %s",callToNumberExpected,callToNumberActual));
    }

    @Step("Redirect to callback page")
    public InfoPage redirectCallback(String callBackClass){
        Label callBackIcon = new Label(By.xpath(String.format(ICON_LABELS_BY_CLASS_XPATH, callBackClass)));
        callBackIcon.clickByJS();

        return new InfoPage("Обратная связь");
    }

    @Step("Open callback form")
    public void openForm(){
        PHONE_ORDER_LABEL_XPATH.moveAndClickByAction();
    }
}
