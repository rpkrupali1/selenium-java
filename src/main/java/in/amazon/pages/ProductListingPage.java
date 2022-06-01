package in.amazon.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.Element;

public class ProductListingPage extends BasePage {
    public Element eleSortBy() {
        return new Element(getElement("xpath","//span[*[text()='Sort by:']]"),"Sort by dropdown","product listing page");
    }

    public Element elePriceHighToLow() {
        return new Element(getElement("xpath","//*[@class='a-popover-inner']/ul/li/a[text()='Price: High to Low']"),"Price high to low option","product listing page");
    }

    public Element eleSecondProduct() {
        return new Element(getElement("xpath","//*[@data-component-type='s-search-result'][2]"),"Second product from search listing","product listing page");
    }
    public void sortByPriceHighToLow(){
        eleSortBy().click();
        elePriceHighToLow().click();
    }

    public ProductDetailPage clickOnSecondProductListing(){
        eleSecondProduct().click();
        return GetInstance(ProductDetailPage.class);
    }
}
