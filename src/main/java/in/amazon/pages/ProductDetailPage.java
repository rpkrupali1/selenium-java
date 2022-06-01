package in.amazon.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.Element;

public class ProductDetailPage extends BasePage {
    public Element eleAboutThisHeader() {
        return new Element(getElement("xpath","//h1[normalize-space()='About this item']"),"About this header","product detail page");
    }

    public Element eleProductDescription() {
        return new Element(getElement("xpath","//h1[normalize-space()='About this item']/following-sibling::ul"),"Product description","product detail page");
    }

    public boolean isAboutThisHeaderDisplayed(){
        return eleAboutThisHeader().isDisplayed();
    }

    public String getProductDetails(){
        return eleProductDescription().getText();
    }
}
