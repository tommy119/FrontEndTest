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
	
	@Test
	public void loginTest() throws InterruptedException {
		String pagLabel = driver.findElement(By.className("mat-paginator-range-label")).getText();
    	Assert.assertFalse(pagLabel.equals("0 of 0"));
	}

}
