package UITest;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;

public class CustomerCRUDIndependentTests {
	
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
	public void CustomerAddNewCustomer() throws InterruptedException {
        // Arrange
		driver.findElement(By.id("mat-button-toggle-2-button")).click();
		Thread.sleep(2000);
		
		// Act
		driver.findElement(By.id("mat-input-0")).sendKeys("000001");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-1")).sendKeys("AmenRa");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-2")).sendKeys("Egypt");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-3")).sendKeys("Giza");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
		
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		String tableName = driver.findElements(By.className("cdk-column-Name")).get(1).getText();
		String tableAddress = driver.findElements(By.className("cdk-column-Address")).get(1).getText();
		String tableCity = driver.findElements(By.className("cdk-column-City")).get(1).getText();
		String tableStatus = driver.findElements(By.className("cdk-column-Status")).get(1).getText();
		
		// Reset
		driver.findElement(By.id("mat-checkbox-31")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("Delete Customer(s)")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
    	driver.navigate().refresh();
    	Thread.sleep(2000);

		// Assert
		Assert.assertTrue(tableCode.equals("000001"));
		Assert.assertTrue(tableName.equals("AmenRa"));
		Assert.assertTrue(tableAddress.equals("Egypt"));
		Assert.assertTrue(tableCity.equals("Giza"));
		Assert.assertTrue(tableStatus.equals("Active"));
	}	
	
	@Test(priority=1)
	public void CustomerSingleEdit() throws InterruptedException {
		// Arrange
		driver.findElement(By.id("mat-checkbox-11")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		
		// Act
		driver.findElement(By.id("mat-input-6")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-6")).sendKeys("edited");
		Thread.sleep(2000);
		
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableNote = driver.findElements(By.className("cdk-column-Note")).get(1).getText();
		Thread.sleep(2000);
		
		// Reset
		driver.findElement(By.id("mat-checkbox-31")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("mat-input-14")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-14")).sendKeys(" ");
		Thread.sleep(2000);
		
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
    	driver.navigate().refresh();
    	Thread.sleep(2000);
		
		// Assert
		Assert.assertTrue(tableNote.equals("edited"));
	}
	
	@Test(priority=2)
	public void CustomerSingleDelete() throws InterruptedException {
        // Arrange
		driver.findElement(By.id("mat-button-toggle-2-button")).click();
		Thread.sleep(2000);
		
		// Act
		driver.findElement(By.id("mat-input-0")).sendKeys("000001");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-1")).sendKeys("AmenRa");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-2")).sendKeys("Egypt");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-3")).sendKeys("Giza");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		driver.findElement(By.id("mat-checkbox-31")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		
		// Act
    	driver.findElement(ByAngular.buttonText("Delete Customer(s)")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		Thread.sleep(2000);
		
		// Reset
    	driver.navigate().refresh();
    	Thread.sleep(2000);
		
		// Assert
		Assert.assertFalse(tableCode.equals("000001"));
	}
	
	@Test(priority=3)
	public void CustomerMultiEdit() throws InterruptedException {
		// Arrange
		driver.findElement(By.id("mat-checkbox-11")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-12")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
    	
		// Act
		driver.findElement(By.id("mat-input-3")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-3")).sendKeys("multiedited");
		Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableNote1 = driver.findElements(By.className("cdk-column-Note")).get(1).getText();
		String tableNote2 = driver.findElements(By.className("cdk-column-Note")).get(2).getText();
		Thread.sleep(2000);
		
		// Reset
		driver.findElement(By.id("mat-checkbox-31")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-32")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("mat-input-7")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-7")).sendKeys(" ");
		Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		driver.navigate().refresh();
    	Thread.sleep(2000);
		
		// Assert
		Assert.assertTrue(tableNote1.equals("multiedited"));
		Assert.assertTrue(tableNote2.equals("multiedited"));
	}
	
	@Test(priority=4)
	public void CustomerMultiDelete() throws InterruptedException {
		// Arrange
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
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		driver.findElement(By.id("mat-input-0")).sendKeys("000002");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-1")).sendKeys("Anubis");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-2")).sendKeys("Duat");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-3")).sendKeys("Fourth Kingdom");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
		
		driver.findElement(By.id("mat-checkbox-51")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-52")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		
		// Act
    	driver.findElement(ByAngular.buttonText("Delete Customer(s)")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableCode1 = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		String tableCode2 = driver.findElements(By.className("cdk-column-Code")).get(2).getText();
		Thread.sleep(2000);
		
		// Reset
    	driver.navigate().refresh();
    	Thread.sleep(2000);

		// Assert
		Assert.assertFalse(tableCode1.equals("000001"));
		Assert.assertFalse(tableCode2.equals("000002"));
	}
	
	@AfterTest
	public void end() {
    	driver.close();
	}
}
