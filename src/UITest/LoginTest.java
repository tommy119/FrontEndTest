package UITest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;


public class LoginTest {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup() {
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	this.driver = new ChromeDriver();
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/login");
	}
	
	@Test
	public void loginTest() throws InterruptedException {

    	driver.findElement(By.id("mat-input-0")).sendKeys("brothersdemo@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("mat-input-1")).sendKeys("asdfasdf");
    	Thread.sleep(1000);
    	ByAngularButtonText login = ByAngular.buttonText("LOG IN");
    	driver.findElement(login).click();
    	Thread.sleep(3000);
    	String currentURL = driver.getCurrentUrl();
    	Thread.sleep(1000);
    	driver.close();
    	System.out.println(currentURL);
    	
    	Assert.assertTrue(currentURL.equals("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/home"));
	}
	
}
