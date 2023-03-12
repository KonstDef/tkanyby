package by.tkany.pageObjects;

import framework.elements.Label;
import org.openqa.selenium.By;

public class UserPage extends BaseByTkanyPage {
    private static final String IDENTIFIER = "//h1[contains(.,'%s')]";
    public static final String USER_MENU_LABEL = "//ul[@id='personalMenu']//a[contains(text(),'%s')]";

    public UserPage(String title) {
        super(By.xpath(String.format(IDENTIFIER,title)), title);
    }

    public UserPage navigateTo(String label){
        Label userMenuLabel = new Label(By.xpath(String.format(USER_MENU_LABEL,label)));
        userMenuLabel.clickByAction();
        return new UserPage(label);
    }
}