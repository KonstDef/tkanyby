package by.tkany.pageObjects;
public class Selectors{
    public static final String REGISTRATION_FORM_DIV_BY_TEXT_XPATH = "//div[@class='bx-auth-form-line' and div[contains(@class,'label') and contains(text(),'%s')]]";
    public static final String REGISTRATION_BUTTON_XPATH = "//input[@name='Register']";
    public static final String REGISTRATION_AGREE_LABEL_XPATH = "//label[@for='userPersonalInfoReg']";
    public static final String DESKTOP_INFORMATION_BUTTON_BY_PLUS_OR_MINUS_CLASS_XPATH = "//div[@class='information']//a[@class='%s']";
    public static final String DESKTOP_INFORMATION_GO_TO_BASKET_BUTTON_XPATH = "//div[@id='appBasketContainer']//td[@class='goToBasket']";
    public static final String DESKTOP_CART_PRODUCT_CARD_BY_TEXT_XPATH = "//div[@id='personalCart']//div[@class='productTable']//a/span[contains(text(),'%s')]/ancestor::div[@class='tabloid']";
    public static final String DESKTOP_CART_GO_TO_ORDER_BUTTON_XPATH = "//div[@id='personalCart']/following-sibling::a";
    public static final String DESKTOP_CART_FORM_NEXT_BUTTON_XPATH = "//div[contains(@class,'bx-active')]//div//a[contains(@class,'pull-right btn btn-default btn-md')]";
    public static final String DESKTOP_CART_FORM_CITY_BY_TEXT_XPATH = "//div[not(contains(@style,'none'))]/child::*/child::div/a[@class='quick-location-tag' and contains(text(),'%s')]";
    public static final String DESKTOP_CART_FORM_DELIVERY_BY_TEXT_XPATH = "//div[not(contains(@style,'none'))]/child::*/child::div/a[@class='quick-location-tag' and contains(text(),'%s')]";
    public static final String DESKTOP_CART_FORM_PAYMENT_BY_TEXT_XPATH = "//div[div[input[@name='PAY_SYSTEM_ID']] and div[contains(text(),'%s')]]";
    public static final String DESKTOP_CART_FORM_PAYER_INFO_BY_TEXT_XPATH = "//div[@class='form-group bx-soa-customer-field' and label[contains(text(),'%s')]]//input";
    public static final String DESKTOP_CART_FORM_END_ORDER_BUTTON_XPATH = "//div[@id='bx-soa-orderSave']/a";
}
