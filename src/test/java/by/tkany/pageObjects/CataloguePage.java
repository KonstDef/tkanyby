package by.tkany.pageObjects;

import by.tkany.pageObjects.pageComponents.BreadCrumbsComponent;
import by.tkany.pageObjects.pageComponents.FiltersComponent;
import by.tkany.pageObjects.pageComponents.ProductCardComponent;
import framework.elements.*;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public class CataloguePage extends BaseByTkanyPage {
    private static final String CATALOG_SUBCATEGORY_DIRECT = "//div[@id='nextSection']//a[not(@class='cnt') and contains(text(),'%s')]";
    private static final String IDENTIFIER = "//h1";
    public static final String CATALOG_PRODUCT_LINK_BY_TEXT_XPATH = "//div[@id='catalogSection']//a[@class='name' and span[contains(text(),'%s')]]/ancestor::div[@class='item product sku']";
    public static final String PAGINATION_LINK_BY_TEXT_XPATH = "//div[contains(@class,'pagination')]//li[//span[contains(text(),'%s')]]";
    private FiltersComponent filter;
    private BreadCrumbsComponent breadcrumbs;
    private ProductCardComponent productCard;

    public FiltersComponent getFilter() {
        if (filter == null) setFilter(new FiltersComponent());
        return filter;
    }

    public FiltersComponent getFilter(String filterName) {
        setFilter(new FiltersComponent(filterName));
        return filter;
    }

    public ProductCardComponent getProductCard(String productName){
        return new ProductCardComponent(CATALOG_PRODUCT_LINK_BY_TEXT_XPATH,productName);
    }

    public CataloguePage(String title) {
        super(By.xpath(IDENTIFIER), title);
    }

    @Step("Check correct category page opened")
    public void isPageCorrect(String title) {
        String titleText = new TextBox(By.xpath(IDENTIFIER)).getText();
        BaseByTkanyPage.softAssert.assertTrue(titleText.equals(title),
                "Category page opened is not correct: \nExpected title: " + title + "\nActual title: " + titleText);
    }

    @Step("Navigate to direct subcategory")
    public void navigateToDirectSub(String subCatName) {
        if(subCatName.equals("")) return;
        Label directSub = new Label(By.xpath(String.format(CATALOG_SUBCATEGORY_DIRECT, subCatName)));
        directSub.scrollIntoView();
        directSub.clickByAction();
    }

    @Step("Check there are products on page")
    public void assertAreProducts() {
        setProductCard(new ProductCardComponent(CATALOG_PRODUCT_LINK_BY_TEXT_XPATH));
        int productsCount = productCard.getNum();
        softAssert.assertTrue(productsCount > 0,
                String.join("\n", "There are no products on page:",
                        "Actual result: " + productsCount,
                        "Expected result: Number of products is greater then 0"));
    }

    @Step("Check there is pagination on page")
    public void assertPagination(boolean isPaginationExpected) {
        Label catalogPagination = new Label(By.xpath(String.format(PAGINATION_LINK_BY_TEXT_XPATH, "")));
        boolean isPaginationPresent = catalogPagination.countElements() > 0;
        softAssert.assertEquals(isPaginationPresent, isPaginationExpected,
                String.join(" ", "Pagination elements", (isPaginationPresent ? "are" : "are not"), "present",
                        "but", (isPaginationExpected ? "were" : "were not"), "expected"));
    }

}
