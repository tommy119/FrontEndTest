package UITest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
public class ProductSearchTests {
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
	public void SearchByOnlyCode() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-2")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-pristine");
		searchBar.clear();
		searchBar.sendKeys("0008");
		Thread.sleep(1000);
		searchBar.sendKeys("5");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Code"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("00085"));
		}
	}
	
	@Test(priority=1)
	public void SearchByOnlyDescription() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-2")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-3")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("BAITNET 4.99");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Description"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("BAITNET 4.99"));
		}
	}
	
	@Test(priority=2)
	public void SearchByOnlyUPC() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-3")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-4")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("793571024536");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-UPC"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("793571024536"));
		}
	}
	@Test(priority=3)
	public void SearchByOnlyCost() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-4")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-5")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("4.53");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Tax"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("4.53"));
		}
	}
	@Test(priority=4)
	public void SearchByOnlyRetailPrice() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-5")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-6")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("8.99");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-RetailPrice"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("8.99"));
		}
	}
	@Test(priority=5)
	public void SearchByOnlyTax() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-8")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-9")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("0");
		Thread.sleep(2000);
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-UPC"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("0"));
		}
	}
	@Test(priority=6)
	public void SearchByMultipleDescriptionAndUPC() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-9")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-3")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-4")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("793571024536");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> UPCList = driver.findElements(By.className("cdk-colum-UPC"));
		List<WebElement> TaxList = driver.findElements(By.className("cdk-colum-Tax"));
		for (int i = 1; i < UPCList.size(); i++) {
			Assert.assertTrue(UPCList.get(i).getText().toLowerCase().contains("793571024536") || TaxList.get(i).getText().toLowerCase().contains("0") );
		}
	}
	
	@Test(priority=7)
	public void SearchByAllFields() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-1")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("9");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		

		List<WebElement> codeList = driver.findElements(By.className("cdk-colum-Code"));
		List<WebElement> nameList = driver.findElements(By.className("cdk-colum-description"));
		List<WebElement> UPCList  = driver.findElements(By.className("cdk-colum-UPC"));
		List<WebElement> CostList = driver.findElements(By.className("cdk-colum-Cost"));
		List<WebElement> RetailPrice = driver.findElements(By.className("cdk-colum-RetailPrice"));
		List<WebElement> TaxList  = driver.findElements(By.className("cdk-colum-Tax"));
		for (int i = 1; i < codeList.size(); i++) {
			Assert.assertTrue(
					codeList.get(i).getText().toLowerCase().contains("9") ||
					nameList.get(i).getText().toLowerCase().contains("9") ||
					UPCList.get(i).getText().toLowerCase().contains("9") ||
					CostList.get(i).getText().toLowerCase().contains("9") ||
					RetailPrice.get(i).getText().toLowerCase().contains("9") ||
				    TaxList.get(i).getText().toLowerCase().contains("9"));
		}
		}
	
	@AfterTest
	public void end() {
    	driver.close();
	}
}
