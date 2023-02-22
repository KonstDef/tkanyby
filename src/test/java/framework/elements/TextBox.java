package framework.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TextBox extends BaseElement{
    public TextBox(By by) {
        super(by);
    }

    public TextBox(By by, String name) {
        super(by, name);
    }

    @Override
    protected String getElementType() {
        return "TextBox";
    }

    @Step("Scroll to textbox.")
    public void scrollTo() {
        super.scrollTo();
    }
}
