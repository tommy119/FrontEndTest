package UITest;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;

public class ProductSortTests {
	ChromeDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	this.driver = new ChromeDriver();
    	
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/login");
    	driver.manage().window().maximize();
    	Thread.sleep(1000);
    	
    	driver.findElement(By.id("user")).sendKeys("brothersdemo@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("pass")).sendKeys("asdfasdf");
    	Thread.sleep(1000);
    	ByAngularButtonText login = ByAngular.buttonText("LOG IN");
    	driver.findElement(login).click();
    	Thread.sleep(2000);
    	
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/products");
    	Thread.sleep(2000);
	}
	@Test(priority=0)
	public void SortCodeAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Code")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Code"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	
	@Test(priority=1)
	public void SortCodeDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Code")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Code"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=2)
	public void SortDescriptionAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Description")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Description"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	@Test(priority=3)
	public void SortDescriptionDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Description")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Description"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=4)
	public void SortUPCAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-UPC")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-UPC"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	@Test(priority=5)
	public void SortUPCDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-UPC")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-UPC"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	@Test(priority=6)
	public void SortCostAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Cost")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Cost"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
}
	@Test(priority=7)
	public void SortCostDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Cost")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Cost"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	@Test(priority=8)
	public void SortRetailPriceAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-RetailPrice")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-RetailPrice"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
}
	@Test(priority=9)
	public void SortRetailPriceDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-RetailPrice")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-RetailPrice"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=10)
	public void SortTaxAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Tax")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Tax"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
}
	@Test(priority=11)
	public void SortTaxDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Tax")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Tax"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	@AfterTest
	public void end() {
    	driver.close();
	}
	
}
