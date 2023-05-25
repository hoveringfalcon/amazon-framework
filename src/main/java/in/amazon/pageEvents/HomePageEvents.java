package in.amazon.pageEvents;

import org.openqa.selenium.By;

import in.amazon.base.BaseTest;
import in.amazon.pageObjects.HomePageElements;

public class HomePageEvents extends BaseTest {
	
	public static void searchitems(String item) throws InterruptedException {

        driver.findElement(By.xpath(HomePageElements.searchbox)).sendKeys(item);
        driver.findElement(By.xpath(HomePageElements.searchButton)).click();

    }

}
