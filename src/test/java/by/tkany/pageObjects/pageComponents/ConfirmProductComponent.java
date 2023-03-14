package by.tkany.pageObjects.pageComponents;

import by.tkany.pageObjects.CartPage;
import framework.Browser;
import framework.elements.BaseElement;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ConfirmProductComponent {
    private static final TextBox IDENTIFIER = new TextBox(By.xpath("//div[@id='appBasketContainer']//div[@class='heading']"));
    public static final Button AMOUNT_DECREASE =  new Button(By.xpath("//div[@id='appBasketContainer']//a[@class='minus']"));
    public static final Button AMOUNT_INCREASE =  new Button(By.xpath("//div[@id='appBasketContainer']//a[@class='plus']"));
    public static final Button GO_TO_CART =  new Button(By.xpath("//div[@id='appBasketContainer']//td[@class='goToBasket']"));
    public static final TextBox PRICE =  new TextBox(By.xpath("//div[@id='appBasketContainer']//span[@class='allSum']"));

    public void assertOpened(){
        Assert.assertTrue(IDENTIFIER.isDisplayed(),"Product confirm window was not displayed, but expected ");
    }

    public void setAmountWithButtons(double initialAmount, double targetAmount){
        double delta = targetAmount - initialAmount;
        int repeats = (int) (delta*10);
        Button button;

        if(repeats<0){
            repeats=-repeats;
            button = AMOUNT_DECREASE;
        } else {
            button = AMOUNT_INCREASE;
        }

        for (;repeats!=0;repeats--){
            button.clickByJS();
            Browser.waitForElementStringUpdate(PRICE, BaseElement::getText);
        }
    }

    public CartPage clickGoToCartButon(){
        GO_TO_CART.moveAndClickByAction();
        return new CartPage();
    }
}