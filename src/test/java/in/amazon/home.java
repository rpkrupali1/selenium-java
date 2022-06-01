package in.amazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class home {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='hmenu-content']//a[*[text()='TV, Appliances, Electronics']]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Televisions']")).click();
        Thread.sleep(1000);
        // WebElement elBrands = driver.findElement(By.xpath("xpathExpression"));
        driver.findElement(By.xpath(
                "//div[*[text()='Brands']]/following::ul//*[*[text()='Samsung']]/div[contains(@class,'checkbox')]"))
                .click();
        Thread.sleep(1000);
        // WebElement elSort = driver.findElement(By.xpath("//*[text()='Sort
        // by:']/following::select"));
        // Select selectSort = new Select(elSort);
        // selectSort.selectByValue("Price: High to Low");
        driver.findElement(By.xpath("//span[*[text()='Sort by:']]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='a-popover-inner']/ul/li/a[text()='Price: High to Low']")).click();
        Thread.sleep(1000);
        // get original windows
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@data-component-type='s-search-result'][2]")).click();
        Thread.sleep(1000);

        // Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='About this item']")).isDisplayed());
        System.out
                .println(driver.findElement(By.xpath("//h1[normalize-space()='About this item']/following-sibling::ul"))
                        .getText());

        driver.quit();
    }
}
