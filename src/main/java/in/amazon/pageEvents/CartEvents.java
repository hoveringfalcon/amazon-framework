package in.amazon.pageEvents;

import org.openqa.selenium.By;

import in.amazon.base.BaseTest;
import in.amazon.pageObjects.CartElements;

public class CartEvents extends BaseTest {
	
	public static void deleteitem() {

        driver.findElement(By.xpath(CartElements.deleteitem)).click();

    }

}
