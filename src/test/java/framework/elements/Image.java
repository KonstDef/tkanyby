package framework.elements;

import org.openqa.selenium.By;

public class Image extends BaseElement {
    public Image(By by) {
        super(by);
    }

    public Image(By by, String name) {
        super(by, name);
    }

    @Override
    protected String getElementType() {
        return "Image";
    }
}
