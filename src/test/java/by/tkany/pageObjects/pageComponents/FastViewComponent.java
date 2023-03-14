package by.tkany.pageObjects.pageComponents;

import by.tkany.pageObjects.BaseByTkanyPage;
import framework.elements.*;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FastViewComponent{
    private static final TextBox IDENTIFIER = new TextBox(By.className("appFastViewHeading"));
    public static final TextBox FAST_VIEW_TITLE =  new TextBox(By.xpath("//span[contains(@class,'Heading')]"));
    public static final TextBox FAST_VIEW_ARTICLE =  new TextBox(By.xpath("//div[@id='appFastView']//span[@class='changeArticle']"));
    public static final Button FAST_VIEW_ADD_TO_CART = new Button(By.xpath("//div[contains(@class,'ViewInformation')]/a[contains(@class,'addCart')]"));
    public static final Image FAST_VIEW_IMAGE = new Image(By.xpath("//img[contains(@class,'FastViewPicture')]"));
    private static final TextBox FAST_VIEW_PROPERTIES = new TextBox(By.className("propertyList"));

    public void assertOpened(){
        Assert.assertTrue(IDENTIFIER.isDisplayed(),"Fast view window was not displayed, but expected ");
    }

    public void assertNameEquals(String expectedName){
        String actualName = FAST_VIEW_TITLE.getText();

        BaseByTkanyPage.softAssert.assertEquals(actualName,expectedName,
                "Fast view did not contained expected product name:"+"\nExpected: "+expectedName+"\nActual: "+actualName);
    }

    public void assertArticleEquals(String expectedArticle){
        String actualArticle = FAST_VIEW_ARTICLE.getText();

        BaseByTkanyPage.softAssert.assertEquals(actualArticle,expectedArticle,
                "Fast view did not contained expected article:"+"\nExpected: "+expectedArticle+"\nActual: "+actualArticle);
    }

    public void assertImage(){
        BaseByTkanyPage.softAssert.assertTrue(FAST_VIEW_IMAGE.isElementPresent(),
                "Fast view did not contained image, but expected");
    }

    public void assertProperties(){
        BaseByTkanyPage.softAssert.assertTrue(FAST_VIEW_PROPERTIES.isElementPresent(),
                "Fast view did not contained product properties, but expected");
    }

    public void assertAddToCart(){
        BaseByTkanyPage.softAssert.assertTrue(FAST_VIEW_ADD_TO_CART.isElementPresent(),
                "Fast view did not contained 'add to cart' button, but expected");
    }

    public void assertReadMore(){
        BaseByTkanyPage.softAssert.assertTrue(FAST_VIEW_ADD_TO_CART.isElementPresent(),
                "Fast view did not contained 'read more' button, but expected");
    }
}