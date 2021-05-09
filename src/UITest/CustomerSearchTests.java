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

public class CustomerSearchTests {
	
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
    	
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/customers");
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
		searchBar.sendKeys("10003");
		Thread.sleep(1000);
		searchBar.sendKeys("6");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Code"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("100036"));
		}
	}
	
	@Test(priority=1)
	public void SearchByOnlyName() throws InterruptedException {
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
		searchBar.sendKeys("wood");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Name"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("wood"));
		}
	}
	
	@Test(priority=2)
	public void SearchByOnlyAddress() throws InterruptedException {
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
		searchBar.sendKeys("20000 HWY 11");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Address"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("20000 hwy 11"));
		}
	}
	
	@Test(priority=3)
	public void SearchByOnlyCity() throws InterruptedException {
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
		searchBar.sendKeys("MADISON");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-City"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("madison"));
		}
	}
	
	@Test(priority=4)
	public void SearchByOnlyState() throws InterruptedException {
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
		searchBar.sendKeys("WA");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-State"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("wa"));
		}
	}
	
	@Test(priority=5)
	public void SearchByOnlyZip() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-6")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-7")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("3575");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Postal-Code"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("3575"));
		}
	}
	
	@Test(priority=6)
	public void SearchByOnlyNote() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-7")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-8")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-touched");
		searchBar.clear();
		searchBar.sendKeys("LIMESTONE");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Note"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("limestone"));
		}
	}
	
	@Test(priority=7)
	public void SearchByOnlyPhone() throws InterruptedException {
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
		searchBar.sendKeys("256");
		Thread.sleep(2000);
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-colum-Phone"));
		for (int i = 1; i < itemList.size(); i++) {
			Assert.assertTrue(itemList.get(i).getText().toLowerCase().contains("256"));
		}
	}
	
	@Test(priority=8)
	public void SearchByMultipleNameAndAddress() throws InterruptedException {
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
		searchBar.sendKeys("72");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> NameList = driver.findElements(By.className("cdk-colum-Name"));
		List<WebElement> AddressList = driver.findElements(By.className("cdk-colum-Address"));
		for (int i = 1; i < NameList.size(); i++) {
			Assert.assertTrue(NameList.get(i).getText().toLowerCase().contains("72") || AddressList.get(i).getText().toLowerCase().contains("72") );
		}
	}
	
	@Test(priority=9)
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
		List<WebElement> nameList = driver.findElements(By.className("cdk-colum-Name"));
		List<WebElement> addressList = driver.findElements(By.className("cdk-colum-Address"));
		List<WebElement> cityList = driver.findElements(By.className("cdk-colum-City"));
		List<WebElement> stateList = driver.findElements(By.className("cdk-colum-State"));
		List<WebElement> zipList = driver.findElements(By.className("cdk-colum-Postal-Code"));
		List<WebElement> noteList = driver.findElements(By.className("cdk-colum-Note"));
		List<WebElement> phoneList = driver.findElements(By.className("cdk-colum-Phone"));
		for (int i = 1; i < codeList.size(); i++) {
			Assert.assertTrue(
					codeList.get(i).getText().toLowerCase().contains("9") ||
					nameList.get(i).getText().toLowerCase().contains("9") ||
					addressList.get(i).getText().toLowerCase().contains("9") ||
					cityList.get(i).getText().toLowerCase().contains("9") ||
					stateList.get(i).getText().toLowerCase().contains("9") ||
					zipList.get(i).getText().toLowerCase().contains("9") ||
					noteList.get(i).getText().toLowerCase().contains("9") ||
					phoneList.get(i).getText().toLowerCase().contains("9"));
		}
	}
	
	@AfterTest
	public void end() {
    	driver.close();
	}
}
