package UITest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;

public class MinuteVideoScript {
	public static void main (String[] args) throws InterruptedException {
		ChromeDriver driver;
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver = new ChromeDriver();
    	
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
    	
    	// Add
		driver.findElement(By.id("mat-button-toggle-2-button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("mat-input-0")).sendKeys("000001");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-1")).sendKeys("AmenRa");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-2")).sendKeys("Egypt");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-3")).sendKeys("Giza");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(1000);
    	
    	// Edit
		driver.findElement(By.id("mat-checkbox-31")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-6")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-6")).sendKeys("edited");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(1000);
    	
    	// Sort
		driver.findElements(By.className("cdk-column-Code")).get(0).click();
		Thread.sleep(4000);
		
		driver.findElements(By.className("cdk-column-Code")).get(0).click();
		Thread.sleep(4000);
    	
    	// Search
		WebElement searchBar = driver.findElementByCssSelector("input.ng-pristine");
		searchBar.clear();
		searchBar.sendKeys("1");
		Thread.sleep(2000);
		searchBar.sendKeys("0");
		Thread.sleep(2000);
		searchBar.sendKeys("0");
		Thread.sleep(2000);
		searchBar.sendKeys("0");
		Thread.sleep(2000);
		searchBar.sendKeys("3");
		Thread.sleep(2000);
		searchBar.sendKeys("6");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		driver.close();
	}
}
