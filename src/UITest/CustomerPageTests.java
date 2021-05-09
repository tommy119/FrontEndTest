package UITest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;

public class CustomerPageTests {
	
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
	
	
	

	
	@Test(priority=8)
	public void ViewTest() throws InterruptedException {
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		Thread.sleep(2000);
		
    	Assert.assertFalse(pagLabel.equals("0 of 0"));
	}
	
	@Test(priority=9)
	public void PaginationNextPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-next").click();
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		Thread.sleep(2000);
		
		Assert.assertTrue(pagLabel.indexOf("21 – 40") != -1);
	}
	
	@Test(priority=10)
	public void PaginationPreviousPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-previous").click();
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		Thread.sleep(2000);
		
		Assert.assertTrue(pagLabel.indexOf("1 – 20") != -1);
	}
	
	
	@Test(priority=11)
	public void PaginationLastPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-last").click();
		
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		int dashIndex = pagLabel.indexOf("–") + 2;
		pagLabel = pagLabel.substring(dashIndex);
		String array[] = pagLabel.split("\\s+");
		Thread.sleep(2000);
		
		Assert.assertTrue(array[0].equals(array[2]));
	}
	
	
	@Test(priority=12)
	public void PaginationFirstPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-first").click();
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		Thread.sleep(2000);
		
		Assert.assertTrue(pagLabel.indexOf("1 – 20") != -1);
	}
	
	@Test(priority=13)
	public void SearchTest() throws InterruptedException {
		driver.findElement(ByAngular.buttonText("Search Settings")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-3")).click();
		Thread.sleep(1000);
		driver.findElementByCssSelector("body.mat-typography").click();
		Thread.sleep(1000);
		
		WebElement searchBar = driver.findElementByCssSelector("input.ng-pristine");
		searchBar.sendKeys("wood");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> names = driver.findElements(By.className("cdk-colum-Name"));
		for (int i = 1; i < names.size(); i++) {
			Assert.assertTrue(names.get(i).getText().toLowerCase().contains("wood"));
		}
	}
	
	@AfterTest
	public void end() {
    	driver.close();
	}

}
