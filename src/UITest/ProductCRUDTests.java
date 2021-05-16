package UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;

public class ProductCRUDTests {
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
    	
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/products");
    	Thread.sleep(2000);
	}
	@Test(priority=0)
	public void ProductAddNewProduct() throws InterruptedException {
		driver.findElement(By.id("mat-button-toggle-2-button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("mat-input-0")).sendKeys("000001");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-1")).sendKeys("Colgate toothpaste");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-2")).sendKeys("1.25");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-3")).sendKeys("0.12");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-8")).sendKeys("1");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
		
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		String tableName = driver.findElements(By.className("cdk-column-Description")).get(1).getText();
		String tableAddress = driver.findElements(By.className("cdk-column-Cost")).get(1).getText();
		String tableCity = driver.findElements(By.className("cdk-column-Tax")).get(1).getText();
		String tableStatus = driver.findElements(By.className("cdk-column-Active-Status")).get(1).getText();

		Assert.assertTrue(tableCode.equals("000001"));
		Assert.assertTrue(tableName.equals("Colgate toothpaste"));
		Assert.assertTrue(tableAddress.equals("1.25"));
		Assert.assertTrue(tableCity.equals("0.12"));
		Assert.assertTrue(tableStatus.equals("1"));
	}	
	@Test(priority=1)
	public void ProductSingelEditFormView() throws InterruptedException {
		driver.findElement(By.id("mat-checkbox-31")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		
		String editFormCode = driver.findElement(By.id("mat-input-0")).getAttribute("value");
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		Thread.sleep(1000);

		Assert.assertTrue(editFormCode.equals(tableCode));
	}	
	@Test(priority=2)
	public void ProductSingleEdit() throws InterruptedException {
		driver.findElement(By.id("mat-input-6")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-6")).sendKeys("edited");
		Thread.sleep(2000);
		
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableUPC = driver.findElements(By.className("cdk-column-UPC")).get(1).getText();
		Thread.sleep(2000);

		Assert.assertTrue(tableUPC.equals("edited"));
	}
	@Test(priority=3)
	public void ProductSingleDelete() throws InterruptedException {
		driver.findElement(By.id("mat-checkbox-51")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);

    	driver.findElement(ByAngular.buttonText("Delete Product(s)")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		Thread.sleep(2000);

		Assert.assertFalse(tableCode.equals("000001"));
	}
	@Test(priority=4)
	public void CustomerMultiEdit() throws InterruptedException {
		
		driver.findElement(By.id("mat-button-toggle-2-button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("mat-input-18")).sendKeys("000001");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-19")).sendKeys("Colgate toothpaste");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-20")).sendKeys("1.25");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-21")).sendKeys("0.12");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-26")).sendKeys("1");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Product")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
    	
		driver.findElement(By.id("mat-input-18")).sendKeys("000002");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-19")).sendKeys("Nike shorts");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-20")).sendKeys("18.44");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-21")).sendKeys("1.8");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-26")).sendKeys("1");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Product")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		driver.findElement(By.id("mat-checkbox-111")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-112")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
    	

		driver.findElement(By.id("mat-input-30")).sendKeys("multiedited");
		Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableUPC1 = driver.findElements(By.className("cdk-column-UPC")).get(1).getText();
		String tableUPC2= driver.findElements(By.className("cdk-column-UPC")).get(2).getText();
		Thread.sleep(2000);
		
		Assert.assertTrue(tableUPC1.equals("multiedited"));
		Assert.assertTrue(tableUPC2.equals("multiedited"));
	}
	@Test(priority=5)
	public void CustomerMultiDelete() throws InterruptedException {
		driver.findElement(By.id("mat-checkbox-131")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-132")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);

    	driver.findElement(ByAngular.buttonText("Delete Product(s)")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("OK")).click();
    	Thread.sleep(2000);
    	
		String tableNote1 = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		String tableNote2 = driver.findElements(By.className("cdk-column-Code")).get(2).getText();
		Thread.sleep(2000);

		Assert.assertFalse(tableNote1.equals("000001"));
		Assert.assertFalse(tableNote2.equals("000002"));
	}
	
	@AfterTest
	public void end() {
    	driver.close();
	}
}
