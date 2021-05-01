package UITest;
import org.openqa.selenium.By;
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
    	driver.findElement(By.id("mat-input-0")).sendKeys("brothersdemo@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("mat-input-1")).sendKeys("asdfasdf");
    	Thread.sleep(1000);
    	ByAngularButtonText login = ByAngular.buttonText("LOG IN");
    	driver.findElement(login).click();
    	Thread.sleep(3000);
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/customers");
    	Thread.sleep(3000);
	}
	
	@Test(priority=0)
	public void VerifySingelEditFormTest() throws InterruptedException {
		driver.findElement(By.id("mat-checkbox-12")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(3000);
		
		String editFormCode = driver.findElement(By.id("mat-input-0")).getAttribute("value");
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		Thread.sleep(3000);

		Assert.assertTrue(editFormCode.equals(tableCode));
	}
	
	@Test(priority=1)
	public void ViewTest() throws InterruptedException {
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
    	Assert.assertFalse(pagLabel.equals("0 of 0"));
    	Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void PaginationNextPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-next").click();
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		Thread.sleep(3000);
		
		Assert.assertTrue(pagLabel.indexOf("21 – 40") != -1);
	}
	
	@Test(priority=3)
	public void PaginationPreviousPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-previous").click();
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		Thread.sleep(3000);
		
		Assert.assertTrue(pagLabel.indexOf("1 – 20") != -1);
	}
	
	
	@Test(priority=4)
	public void PaginationLastPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-last").click();
		
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		int dashIndex = pagLabel.indexOf("–") + 2;
		pagLabel = pagLabel.substring(dashIndex);
		String array[] = pagLabel.split("\\s+");
		Thread.sleep(3000);
		
		Assert.assertTrue(array[0].equals(array[2]));
	}
	
	
	@Test(priority=5)
	public void PaginationFirstPageTest() throws InterruptedException {
		driver.findElementByCssSelector("button.mat-paginator-navigation-first").click();
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
		Thread.sleep(3000);
		
		Assert.assertTrue(pagLabel.indexOf("1 – 20") != -1);
	}	
	
	@AfterTest
	public void end() {
    	//driver.close();
	}

}
