package by.tkany.pageObjects;

import framework.BasePage;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private static final String IDENTIFIER = "//h1[contains(.,'%s')]";
    public static final String PRODUCT_ARTICLE = "//span[@class='changeArticle']";
    private static final String PRODUCT_SHORT_DESCRIPTION = "//div[@class='changeShortDescription']";
    private static final String PRODUCT_IMAGES = "//div[@id='pictureContainer']//img";
    private static final String PRODUCT_ATTRIBUTE_ROW_BY_FIRST_COLUMN = "//div[@class='detailPropertiesTable']//tr[td/span[contains(text(),'%s')]]";

    public ProductPage(String title) {
        super(By.xpath(String.format(IDENTIFIER,title)), title);
    }
}
