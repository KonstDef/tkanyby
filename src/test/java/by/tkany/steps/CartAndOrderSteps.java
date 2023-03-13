package by.tkany.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static by.tkany.steps.BaseSteps.*;

public class CartAndOrderSteps {
    @Then ("Product {string} is present with {double} amount")
    public void checkCartProductAmountEquals(String productName, double amount){
        cart.getProductCard(productName).assertAmountEquals(amount);
    }
    @When("User clicks on \"Оформить заказ\" button")
    public void goToOrder(){
        order = cart.openOrder();
    }
    @Then("Order page is opened")
    public void orderIsOpened(){
        order.assertIsPageOpened();
    }
    @When("User clicks \"Далее\" button")
    public void orderClickNext(){
        order.clickNext();
    }
    @Then("{string} order section is opened")
    public void orderAssertSectionIsOpened(String section){
        order.assertIsSectionOpened(section);
    }
    @Then("{string} section is \"approved\"")
    public void orderAssertSectionIsApproved(String section){
        order.assertIsSectionApproved(section);
    }
    @Then("\"Товары в заказе\" section contains {string} with {double}")
    public void orderAssertProductHas(String productName, double quantity){
        order.assertProductHas(productName,quantity);
    }
    @When("User selects {string} city name")
    public void orderSelectCity(String cityName){
        order.selectCity(cityName);
    }
    @When("User sets {string} as postal code")
    public void orderSetPostal(String postal){
        order.setPostal(postal);
    }
    @Then("\"Регион доставки\" section contains {string}")
    public void orderAssertCity(String cityName){
        order.assertCity(cityName);
    }
    @When("User selects {string} delivery method")
    public void orderSelectDelivery(String deliveryName){
        order.selectDelivery(deliveryName);
    }
    @Then("\"Доставка\" section contains {string}")
    public void orderAssertDelivery(String delivery){
        order.assertDelivery(delivery);
    }
    @When("User selects {string} payment method")
    public void orderSelectPayment(String payment){
        order.selectPayment(payment);
    }
    @Then ("\"Оплата\" section contains {string}")
    public void orderAssertPayment(String payment){
        order.assertPayment(payment);
    }
    @When("User fills {string} input field with {string}")
    public void orderSetPayerField(String fieldName, String input){
        order.setPayerField(fieldName,input);
    }
    @When("User clicks \"Назад\" button")
    public void orderClickBack(){
        order.clickBack();
    }
    @Then("\"Покупатель\" section contains {string}")
    public void orderAssertPayerAddress(String address){
        order.assertPayerAddress(address);
    }
}
