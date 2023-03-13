package by.tkany.pageObjects;

import framework.Browser;
import framework.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

public class OrderPage extends BaseByTkanyPage {
    private static final By IDENTIFIER = By.xpath("//h1[contains(., 'Оформление заказа')]");

    private static final Button BACK_BUTTON = new Button(By.xpath("//div[contains(@class,'bx-active')]//div//a[contains(@class,'pull-left')]"));
    private static final Button NEXT_BUTTON = new Button(By.xpath("//div[contains(@class,'bx-active')]//div//a[contains(@class,'pull-right')]"));
    private static final String SECTION = "//h2[contains(@class,'section-title') and contains(.,'%s')]/ancestor::div[@data-visited]";
    private static final String SECTION_CONTENT = "//h2[contains(@class,'section-title') and contains(.,'%s')]/ancestor::div[@data-visited]//div[contains(@class,'bx-soa-section-content')]";
    private static final String PRODUCT_TITLE = "//div[@data-visited]//div[contains(@class,'item-title')]/a[contains(.,'%s')]";
    private static final String PRODUCT_QUANTITY = "//div[@data-visited]//div[contains(@class,'item-title')]/a[contains(.,'%s')]/ancestor::div[contains(@class,'item-tr')]//div[contains(text(),'Количество')]/following-sibling::div/span";
    private static final String CITY = "//div[not(contains(@style,'none'))]/child::*/child::div/a[@class='quick-location-tag' and contains(text(),'%s')]";
    private static final String SECTION_CITY = "//div[@id='bx-soa-region']Адрес доставки/div[contains(@class,'section-content') and contains(.,'%s')]";
    private static final TextBox POSTAL = new TextBox(By.id("zipProperty"));
    private static final String DELIVERY = "//div[@id='bx-soa-delivery']//div[contains(@class,'smalltitle') and contains(.,'%s')]/ancestor::div[contains(@class,'bx-soa-pp-company ')]";
    private static final String SECTION_DELIVERY = "//div[@id='bx-soa-delivery']//div[contains(@class,'company-selected') and contains(.,'%s')]";
    private static final String PAYMENT = "//div[div[input[@name='PAY_SYSTEM_ID']] and div[contains(text(),'%s')]]";
    private static final String SECTION_PAYMENT = "//div[@id='bx-soa-paysystem']//div[contains(@class,'company-selected') and contains(.,'%s')]";
    private static final String PAYER_INPUT = "//div[@class='form-group bx-soa-customer-field' and label[contains(text(),'%s')]]//*[contains(@id,'property')]";
    private static final String SECTION_ADDRESS = "//div[@id='bx-soa-properties']//div[not(@class) and contains(.,'%s')]";

    public OrderPage() {
        super(IDENTIFIER, "Order");
    }

    public void clickNext() {
        Browser.waitForjQueryLoad();
        for(int i=0;i<=10;i++){
            try {
                NEXT_BUTTON.scrollIntoView();
                NEXT_BUTTON.click();
                break;
            } catch (StaleElementReferenceException stale){
                NEXT_BUTTON.waitForElementAttachment();
            }
        }
    }

    public void assertIsSectionOpened(String sectionName) {
        TextBox sectionContent = new TextBox(By.xpath(String.format(SECTION_CONTENT, sectionName)));
        Assert.assertTrue(sectionContent.isDisplayed(), String.format("Section \"%s\" was not opened (its content is not displayed), but expected to be", sectionName));
    }

    public void assertIsSectionApproved(String sectionName) {
        TextBox section = new TextBox(By.xpath(String.format(SECTION, sectionName)));
        String sectionClass = section.getAttribute("class");
        boolean hasError = sectionClass.contains("bx-step-error");
        boolean hasWarning = sectionClass.contains("bx-step-warning");
        boolean isCompleted = sectionClass.contains("bx-step-completed");

        softAssert.assertFalse(hasError, String.format("Section \"%s\" was not approved. It has error, but expected not to have.", sectionName));
        softAssert.assertFalse(hasWarning, String.format("Section \"%s\" was not approved. It has warning, but expected not to have.", sectionName));
        softAssert.assertTrue(isCompleted, String.format("Section \"%s\" was not approved. It is not marked as completed, but expected to be marked.", sectionName));
    }

    public void assertProductHas(String productName, double expectedQty) {
        Label productTitle = new Label(By.xpath(String.format(PRODUCT_TITLE, productName)));
        softAssert.assertTrue(productTitle.isDisplayed(), "Product with name \"" + productName + "\" is not displayed at overview section, but expected");

        TextBox productQty = new TextBox(By.xpath(String.format(PRODUCT_QUANTITY, productName)));
        String qty = productQty.getText();
        double actualQty = Double.parseDouble(qty.split(" ")[0]);
        softAssert.assertEquals(actualQty, expectedQty,
                "Product with name \"" + productName + "\" has quantity not equal to expected:" + "\nExpected: " + expectedQty + "\nActual: " + actualQty);
    }

    public void selectCity(String cityName) {
        Label city = new Label(By.xpath(String.format(CITY, cityName)));
        city.scrollIntoView();
        city.clickByAction();
    }

    public void setPostal(String postalCode) {
        POSTAL.clearInput();
        POSTAL.sendKeys(postalCode);
    }

    public void assertCity(String cityName) {
        TextBox city = new TextBox(By.xpath(String.format(SECTION_CITY, cityName)));
        softAssert.assertTrue(city.isDisplayed(), "\"Регион доставки\" section does not contain " + cityName + ", but expected.");
    }

    public void selectDelivery(String deliveryName) {
        Label delivery = new Label(By.xpath(String.format(DELIVERY, deliveryName)));
        delivery.click();
    }

    public void assertDelivery(String deliveryName) {
        TextBox delivery = new TextBox(By.xpath(String.format(SECTION_DELIVERY, deliveryName)));
        softAssert.assertTrue(delivery.isDisplayed(), "\"Доставка\" section does not contain " + deliveryName + ", but expected.");
    }

    public void selectPayment(String paymentName) {
        Label payment = new Label(By.xpath(String.format(PAYMENT, paymentName)));
        payment.click();
    }

    public void assertPayment(String paymentName) {
        TextBox payment = new TextBox(By.xpath(String.format(SECTION_PAYMENT, paymentName)));
        softAssert.assertTrue(payment.isDisplayed(), "\"Доставка\" section does not contain " + paymentName + ", but expected.");
    }

    public void setPayerField(String fieldName, String input) {
        TextBox field = new TextBox(By.xpath(String.format(PAYER_INPUT, fieldName)));
        field.sendKeys(input);
    }

    public void clickBack() {
        Browser.waitForjQueryLoad();
        for(int i=0;i<=10;i++){
            try {
                BACK_BUTTON.scrollIntoView();
                BACK_BUTTON.click();
                break;
            } catch (StaleElementReferenceException stale){
                BACK_BUTTON.waitForElementAttachment();
            }
        }
    }

    public void assertPayerAddress(String addressText) {
        TextBox address = new TextBox(By.xpath(String.format(SECTION_ADDRESS, addressText)));
        softAssert.assertTrue(address.isDisplayed(), "\"Доставка\" section does not contain " + addressText + ", but expected.");
    }
}
