package by.tkany.pageObjects;

import framework.elements.*;
import org.openqa.selenium.By;

public class AuthPage extends BaseByTkanyPage {
    private static final String PAGE_LOCATOR = "//h1[contains(.,'%s')]";
    private static final String LOGIN_FORM_INPUT = "//div[contains(@class,'auth-by-login')]//div[@class='bx-auth-input-line' and div[contains(@class,'label') and contains(text(),'%s')]]//input";
    private static final Button LOGIN_BUTTON = new Button(By.xpath("//div[contains(@class,'auth-by-login')]//input[@name='Login']"));

    public AuthPage(String title) {
        super(By.xpath(String.format(PAGE_LOCATOR,title)), title);
    }

    public void enterField(String field, String value){
        TextBox loginName = new TextBox(By.xpath(String.format(LOGIN_FORM_INPUT,field)));
        loginName.sendKeys(value);
    }
    public AuthPage clickEnter(){
        LOGIN_BUTTON.clickAndWait();
        return new AuthPage("Авторизация");
    }
}