package by.tkany.pageObjects;

import framework.BasePage;
import org.openqa.selenium.By;

public class SocialPage extends BasePage{
    private static final String IDENTIFIER_H1 = "//h1[contains(.,'%s')]";
    private static final String IDENTIFIER_H2 = "//h2[contains(.,'%s')]";

    public SocialPage(String title) {
        super(By.xpath(String.format(title.equals("tkany_by")?IDENTIFIER_H1:IDENTIFIER_H2,title)), title);
    }

    @Override
    public void assertIsPageOpened() {
        try{
            super.assertIsPageOpened();
        } catch (Throwable t){
            BaseByTkanyPage.softAssert.fail(t.toString());
        }
    }
}
