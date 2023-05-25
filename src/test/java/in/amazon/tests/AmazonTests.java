package in.amazon.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import in.amazon.base.BaseTest;
import in.amazon.pageEvents.HomePageEvents;
import in.amazon.pageEvents.ProductPageEvents;
import in.amazon.utils.ExcelUtils;

public class AmazonTests extends BaseTest {
	
	@DataProvider(name = "cartTestData")
    public Object[] getcartTestData() throws IOException, InterruptedException {
        String filePath = "C:\\Users\\vyom\\eclipse-workspace\\framework\\testdata\\cartTest - searchQuery.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtils.getTestData(filePath, sheetName);
    }

    @Test(dataProvider = "cartTestData")
    public void cartTest(String searchQuery) throws InterruptedException {

        HomePageEvents.searchitems(searchQuery);
        driver.findElement(By.xpath("//*[contains(text(),'Dove Go Fresh Moisture')]")).click();
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        ProductPageEvents.addtocart();
        
        test = extent.createTest("Amazon Cart Test");

        if (driver.findElement(By.xpath("//*[contains(text(),'Dove Go Fresh Moisture')]")).isDisplayed())
            test.log(Status.PASS, "Amazon Cart test successful");
        else
            test.log(Status.FAIL, "Amazon Cart test failed");


    }
	
	@DataProvider(name = "testProductSearchAndDetailsData")
    public Object[] gettestProductSearchAndDetailsData() throws IOException, InterruptedException {
        String filePath = "C:\\Users\\vyom\\eclipse-workspace\\framework\\testdata\\testProductSearchAndDetails - searchQuery.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtils.getTestData(filePath, sheetName);
    }

    @Test(dataProvider = "testProductSearchAndDetailsData")
    public void testProductSearchAndDetails(String searchQuery) throws InterruptedException {
    	
        HomePageEvents.searchitems(searchQuery);
        driver.findElement(By.xpath("//*[contains(text(),'Midnight')]")).click();

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        
        test = extent.createTest("Amazon Search & Details Test");

        if (driver.findElement(By.xpath("//span[@id='productTitle']")).getText().contains("Apple iPhone 14 (128 GB) - Midnight"))
        	test.log(Status.PASS, "Amazon Search & Details test successful");
        else
            test.log(Status.FAIL, "Amazon Search & Details test failed");

    }

}
