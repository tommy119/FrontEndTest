package UITest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup() {
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/login");
	}
	
	@Test
	public void loginTest() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(By.id("user")).sendKeys("brothersdemo@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("pass")).sendKeys("asdfasdf");
    	Thread.sleep(3000);
    	driver.findElement(By.id("login")).click();
	}
	
}
