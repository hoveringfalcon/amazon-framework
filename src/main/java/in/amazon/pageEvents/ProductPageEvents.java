package in.amazon.pageEvents;

import org.openqa.selenium.By;

import in.amazon.base.BaseTest;
import in.amazon.pageObjects.ProductPageElements;

public class ProductPageEvents extends BaseTest {
	
	public static void addtocart() {

        driver.findElement(By.cssSelector(ProductPageElements.addtocart)).click();
        driver.findElement(By.linkText(ProductPageElements.gotocart)).click();
        
    }

}
