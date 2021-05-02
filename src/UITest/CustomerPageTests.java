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
    	Thread.sleep(2000);
    	driver.get("http://dsd-office-web.s3-website-us-west-2.amazonaws.com/customers");
    	Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void VerifyAddTest() throws InterruptedException {
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
		driver.findElement(By.id("mat-input-8")).sendKeys("1");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Confirm")).click();
    	Thread.sleep(2000);
		
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		String tableName = driver.findElements(By.className("cdk-column-Name")).get(1).getText();
		String tableAddress = driver.findElements(By.className("cdk-column-Address")).get(1).getText();
		String tableCity = driver.findElements(By.className("cdk-column-City")).get(1).getText();
		String tableStatus = driver.findElements(By.className("cdk-column-Active-Status")).get(1).getText();

		Assert.assertTrue(tableCode.equals("000001"));
		Assert.assertTrue(tableName.equals("AmenRa"));
		Assert.assertTrue(tableAddress.equals("Egypt"));
		Assert.assertTrue(tableCity.equals("Giza"));
		Assert.assertTrue(tableStatus.equals("1"));
	}	
	
	@Test(priority=1)
	public void VerifySingelEditFormTest() throws InterruptedException {
		driver.findElement(By.id("mat-checkbox-32")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
		
		String editFormCode = driver.findElement(By.id("mat-input-0")).getAttribute("value");
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		Thread.sleep(1000);

		Assert.assertTrue(editFormCode.equals(tableCode));
	}	
	
	@Test(priority=2)
	public void VerifySingelEditTest() throws InterruptedException {
		driver.findElement(By.id("mat-input-6")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-6")).sendKeys("edited");
		Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Confirm")).click();
    	Thread.sleep(2000);
		String tableNote = driver.findElements(By.className("cdk-column-Note")).get(1).getText();
		Thread.sleep(2000);

		Assert.assertTrue(tableNote.equals("edited"));
	}
	
	@Test(priority=3)
	public void VerifySingelDeleteTest() throws InterruptedException {

    	driver.findElement(ByAngular.buttonText("Delete Customer(s)")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Confirm")).click();
    	Thread.sleep(2000);
		String tableCode = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		Thread.sleep(2000);

		Assert.assertFalse(tableCode.equals("000001"));
	}
	
	@Test(priority=4)
	public void VerifyMultiEditTest() throws InterruptedException {
		
		driver.findElement(By.id("mat-button-toggle-2-button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("mat-input-9")).sendKeys("000001");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-10")).sendKeys("AmenRa");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-11")).sendKeys("Egypt");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-12")).sendKeys("Giza");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-17")).sendKeys("1");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Confirm")).click();
    	Thread.sleep(2000);
    	
		driver.findElement(By.id("mat-input-9")).sendKeys("000002");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-10")).sendKeys("Anubis");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-11")).sendKeys("Duat");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-12")).sendKeys("Fourth Kingdom");
		Thread.sleep(1000);
		driver.findElement(By.id("mat-input-17")).sendKeys("1");
		Thread.sleep(1000);
		
    	driver.findElement(ByAngular.buttonText("Add Customer")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Confirm")).click();
    	Thread.sleep(2000);
    	
		driver.findElement(By.id("mat-checkbox-92")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-checkbox-93")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mat-button-toggle-1-button")).click();
		Thread.sleep(1000);
    	

		driver.findElement(By.id("mat-input-21")).sendKeys("multiedited");
		Thread.sleep(1000);
    	driver.findElement(ByAngular.buttonText("Save Changes")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Confirm")).click();
    	Thread.sleep(2000);
		String tableNote1 = driver.findElements(By.className("cdk-column-Note")).get(1).getText();
		String tableNote2 = driver.findElements(By.className("cdk-column-Note")).get(2).getText();
		Thread.sleep(2000);
		
		Assert.assertTrue(tableNote1.equals("multiedited"));
		Assert.assertTrue(tableNote2.equals("multiedited"));
	}
	
	@Test(priority=5)
	public void VerifyMultiDeleteTest() throws InterruptedException {

    	driver.findElement(ByAngular.buttonText("Delete Customer(s)")).click();
    	Thread.sleep(2000);
    	driver.findElement(ByAngular.buttonText("Confirm")).click();
    	Thread.sleep(2000);
		String tableCode1 = driver.findElements(By.className("cdk-column-Code")).get(1).getText();
		String tableCode2 = driver.findElements(By.className("cdk-column-Code")).get(2).getText();
		Thread.sleep(2000);

		Assert.assertFalse(tableCode1.equals("000001"));
		Assert.assertFalse(tableCode2.equals("000002"));
	}
	
	/*
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
	}	*/
	
	@AfterTest
	public void end() {
    	//driver.close();
	}

}
