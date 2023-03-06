package by.tkany.pageObjects.pageComponents;

import framework.Browser;
import framework.elements.*;
import org.openqa.selenium.By;

import static by.tkany.pageObjects.BaseByTkanyPage.softAssert;

public class FiltersComponent {
    private static final String CATALOGUE_FILTER_COLOR_PARAMETER_BY_TEXT_XPATH = "//ul[contains(@class,'checkboxList')]//span[contains(@title,'%s')]";
    private static final String CATALOGUE_FILTER_PARAMETER_CHECKBOX_BY_TEXT_XPATH ="//div[@class='paramsBox' and div/span[contains(text(),'%1$s')]]//ul[@class='checkbox']//label[contains(text(),'%2$s')]";
    private static final String CATALOGUE_FILTER_EXPAND_BUTTON_XPATH = "//div[@class='paramsBox' and div/span[contains(text(),'%1$s')]]//ins[contains(@class,'propExpander')]";
    private static final String CATALOGUE_FILTER_MORE_BUTTON_XPATH = "//div[@class='paramsBox' and div/span[contains(text(),'%1$s')]]//a[@class='showALL']";

    private Button EXPAND_BUTTON;
    private Button MORE_BUTTON;
    private final String filterName;

    public FiltersComponent(String filterName){
        this.filterName = filterName;
        EXPAND_BUTTON = new Button(By.xpath(String.format(CATALOGUE_FILTER_EXPAND_BUTTON_XPATH,filterName)));
        MORE_BUTTON = new Button(By.xpath(String.format(CATALOGUE_FILTER_MORE_BUTTON_XPATH,filterName)));
    }

    public FiltersComponent(){
        this("");
    }

    public void checkNumber(int expectedFiltersNum){
        int actualNum = EXPAND_BUTTON.countElements();
        softAssert.assertEquals(actualNum,expectedFiltersNum,
                String.join("\n","Products filter count does not equal expected value:",
                        "Actual result: "+actualNum,
                        "Expected result: "+expectedFiltersNum));
    }

    public void setValue(String value){
            if (!EXPAND_BUTTON.getAttribute("class").contains("expanded")) {
                EXPAND_BUTTON.scrollIntoView();
                EXPAND_BUTTON.clickByAction();
            }

            Label filterItem;
            if (filterName.equals("Цвет"))
                filterItem = new Label(By.xpath(String.format(CATALOGUE_FILTER_COLOR_PARAMETER_BY_TEXT_XPATH, value)));
            else
                filterItem = new Label(By.xpath(String.format(CATALOGUE_FILTER_PARAMETER_CHECKBOX_BY_TEXT_XPATH,filterName, value)));

            if (!filterItem.isDisplayed()) {
                MORE_BUTTON.scrollIntoView();
                MORE_BUTTON.clickByAction();
            }
            filterItem.scrollIntoView();
            filterItem.clickAndWait();
            Browser.waitForjQueryLoad();
    }
}