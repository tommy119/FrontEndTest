package UITest;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import com.paulhammant.ngwebdriver.NgWebDriver;


public class HelloWorld {
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
    	JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
    	NgWebDriver ngWebDriver = new NgWebDriver(jsDriver);
    	ngWebDriver.waitForAngularRequestsToFinish();
    	
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/login");
    	Thread.sleep(1000);
    	driver.findElement(By.id("user")).sendKeys("brothersdemo@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.id("pass")).sendKeys("asdfasdf");
    	Thread.sleep(3000);
    	driver.findElement(By.id("login")).click();
    }
}
