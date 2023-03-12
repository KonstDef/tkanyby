package by.tkany.pageObjects.pageComponents;

import framework.elements.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FastOrderComponent {
    private static final TextBox IDENTIFIER = new TextBox(By.xpath("//div[@id='appFastBuyContainer']//div[@class='heading']"));
    private static final Image IMAGE = new Image(By.xpath("//div[@id='fastBuyPicture']//img"));
    private static final Label TITLE = new Label(By.xpath("//div[@id='fastBuyName']//span"));
    private static final TextBox PRICE = new TextBox(By.id("fastBuyPrice"));
    private static final String INPUT = "//div[contains(@class,'formLine')]//input[contains(@placeholder,'%s')]";
    private static final CheckBox CHECKBOX = new CheckBox(By.xpath("//div[@id='appFastBuyContainer']//input[@type='checkbox']"));
    private static final Button BUY_BUTTON = new Button(By.xpath("//div[@id='appFastBuyContainer']//a[@id='fastBuyFormSubmit']"));

    @Step("Assert fast view page is opened")
    public void assertIsPresent(){
        Assert.assertTrue(IDENTIFIER.isDisplayed(),"Fast buy window was not displayed, but expected");}
    @Step("Assert fast view page image is displayed")
    public void assertImagePresent(){
        Assert.assertTrue(IMAGE.isDisplayed(),"Fast buy window was not displayed, but expected");
    }
    @Step("Assert fast view page title equals expected")
    public void assertTitlePresent(String titleExpected) {
        String titleActual = TITLE.getText();
        Assert.assertEquals(titleActual, titleExpected, "Fast buy window title does not equals expected value:\nActual: " + titleActual + "\nExpected: " + titleExpected);
    }
    @Step("Assert fast view page input field can be filled with data")
    public void assertInputIsEnterable(String inputFieldName,String testData){
        TextBox inputField = new TextBox(By.xpath(String.format(INPUT,inputFieldName)));
        inputField.sendKeys(testData);
        String actualData = inputField.getJSValue();
        Assert.assertEquals(actualData,testData,
                "Fast buy window input '"+inputFieldName+"' was not filled with provided data:"+
                "\nActual: "+actualData+"\nProvided: "+testData);
    }
    @Step("Assert fast view page personal data agreement checkbox field is present and clickable")
    public void assertPersonaDataClickable(){
        Assert.assertTrue(CHECKBOX.isClickable(),"Fast buy window does not contains data agreement checkbox, but expected to have");
    }
    @Step("Assert fast price is present")
    public void assertPricePresent(){
        Assert.assertTrue(PRICE.isDisplayed(),"Fast buy window price is displayed, but expected to be");
    }
    @Step("Assert fast view page 'Купить в один клик' button is clickable")
    public void assertFastBuyButtonClickable(){
        Assert.assertTrue(BUY_BUTTON.isClickable(),"Fast buy window 'Купить в один клик' button is not clickable, but expected to be");
    }
}