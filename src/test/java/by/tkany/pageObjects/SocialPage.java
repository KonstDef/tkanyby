package by.tkany.pageObjects;

import framework.BasePage;
import org.openqa.selenium.By;

public class SocialPage extends BasePage{
    private static final String PAGE_LOCATOR = "//h1[contains(.,'%s')]";
    private static final String PAGE_LOCATOR_INST = "//h2[contains(.,'%s')]";

    public SocialPage(String title) {
        super(By.xpath(String.format(title.equals("tkany_by")?PAGE_LOCATOR:PAGE_LOCATOR_INST,title)), title);
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
