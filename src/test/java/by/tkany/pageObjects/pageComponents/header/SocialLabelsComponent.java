package by.tkany.pageObjects.pageComponents.header;

import by.tkany.pageObjects.SocialPage;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SocialLabelsComponent {
    public static final String ICON_LABELS_BY_CLASS_XPATH = "//div[contains(@id,'headerLine') or contains(@id,'subHeader')]//a[contains(@class,'%s')]";

    @Step("Redirect to social page")
    public SocialPage redirectSocial(String socialClass){
        Label socialPageIcon = new Label(By.xpath(String.format(ICON_LABELS_BY_CLASS_XPATH, socialClass)));
        socialPageIcon.clickAndWait();

        switch (socialClass){
            case("socVK"):{
                return new SocialPage("Интернет-магазин TKANY.BY");
            }
            case("socINS"):{
                return new SocialPage("tkany_by");
            }
            default:{
                return new SocialPage("Интернет-магазин Tkany.by");
            }
        }
    }
}
