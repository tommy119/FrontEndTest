package UITest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;


public class CustomerSortTests {
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
	public void SortNameAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Name")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Name"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	@Test(priority=3)
	public void SortNameDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Name")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Name"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=4)
	public void SortAddressAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Address")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Address"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	@Test(priority=5)
	public void SortAddressDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Address")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Address"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=6)
	public void SortCityAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-City")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-City"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	@Test(priority=7)
	public void SortCityDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-City")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-City"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=8)
	public void SortStateAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-State")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-State"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	@Test(priority=9)
	public void SortStateDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-State")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-State"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=10)
	public void SortZipAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Postal-Code")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Postal-Code"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	@Test(priority=11)
	public void SortZipDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Postal-Code")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Postal-Code"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=12)
	public void SortNoteAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Note")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Note"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	@Test(priority=13)
	public void SortNoteDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Note")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Note"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@Test(priority=14)
	public void SortPhoneAscend() throws InterruptedException {

		driver.findElements(By.className("cdk-column-Phone")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Phone"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) <= 0);
		}
	}
	
	@Test(priority=15)
	public void SortPhoneDescend() throws InterruptedException {
		driver.findElements(By.className("cdk-column-Phone")).get(0).click();
		Thread.sleep(2000);
		
		List<WebElement> itemList = driver.findElements(By.className("cdk-column-Phone"));
		for (int i = 1; i < itemList.size()-1; i++) {
			Assert.assertTrue(itemList.get(i).getText().compareTo(itemList.get(i+1).getText()) >= 0);
		}
	}
	
	@AfterTest
	public void end() {
    	driver.close();
	}
}
