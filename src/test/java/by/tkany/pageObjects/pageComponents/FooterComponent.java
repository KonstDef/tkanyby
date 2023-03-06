package by.tkany.pageObjects.pageComponents;

import framework.elements.TextBox;
import org.openqa.selenium.By;

public class FooterComponent {
    public static final TextBox FOOTER_BAR_ID = new TextBox(By.id("footerBottom"));
    public FooterComponent scrollTo(){
        FOOTER_BAR_ID.scrollTo();
        return this;
    }
}
