package in.amazon.pages;

import core.framework.base.BasePage;
import core.framework.controls.elements.Element;

public class HomePage extends BasePage {
    public Element eleDepartment() {
        return new Element(getElement("xpath","//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]"),"TV department","home page");
    }

    public Element eleSubSection() {
        return new Element(getElement("xpath","//*[text()='Televisions']"),"television","home page");
    }

    public Element eleBrand() {
        return new Element(getElement("xpath","//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]"),"brand","home page");
    }

    public Element eleHamburgerMenu() {
        return new Element(getElement("xpath","//*[@id='nav-hamburger-menu']"),"hamburger menu","home page");
    }

    public void navigateToTelevision(){
        eleHamburgerMenu().click();
        eleDepartment().click();
        eleSubSection().click();
    }

    public void filterBySamsung(){
        eleBrand().click();
    }
}
