package by.tkany.pageObjects;

import org.openqa.selenium.By;

public class InfoPage extends BaseByTkanyPage{
    private static final String PAGE_LOCATOR = "//ul[@id='personalMenu']//a[@class='selected' and contains(.,'%s')]";

    public InfoPage(String title) {
        super(By.xpath(String.format(PAGE_LOCATOR,title)), title);
    }

    @Override
    public void assertIsPageOpened() {
        try{
            super.assertIsPageOpened();
        } catch (Throwable t){
            softAssert.fail(t.toString());
        }
    }
}
