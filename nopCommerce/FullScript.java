package nopCommerce;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FullScript {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void configureReport() {
	//create object of extent reports class
	report = new ExtentReports(System.getProperty("user.dir")+"\\nopCommerce.html");
			
	//start test using variable extent report class
	test = report.startTest("NopCommerceTest");
	
	}
	@BeforeMethod(alwaysRun = true)
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.PASS, "Chrome Browser has opened successfully.");
		driver.get("https://demo.nopcommerce.com/");
		test.log(LogStatus.PASS, "URL is Valid");
		driver.manage().window().maximize(); 
	}
	@Test(priority = 1)
	public void Register() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//locate Register and click on it
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		test.log(LogStatus.PASS, "Clicked on Register Successfully.");
		
		driver.findElement(By.id("gender-female")).click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='FirstName']")); //locate FirstName element
		WebElement LastName = driver.findElement(By.xpath("//input[@id='LastName']")); //locate LastName element
		WebElement Email = driver.findElement(By.xpath("//input[@name='Email']")); //locate Email element
		WebElement Password = driver.findElement(By.xpath("//input[@name='Password']")); //locate Password element
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']")); //locate ConfirmPassword element
		
		//sending the values
		FirstName.sendKeys("Sakshi");
		test.log(LogStatus.PASS, "First name entered successfully.");
		LastName.sendKeys("Yeramwar");
		test.log(LogStatus.PASS, "Last name entered successfully.");
		Email.sendKeys("saky@gmail.com");
		test.log(LogStatus.PASS, "Email entered successfully.");
		Password.sendKeys("sakshi");
		test.log(LogStatus.PASS, "Password entered successfully.");
		ConfirmPassword.sendKeys("sakshi");
		test.log(LogStatus.PASS, "Confirm Password entered successfully.");
		
		//click on the final register button
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(2000);
		
		//taking screenshot of the registration successful message
		TakesScreenshot ts = (TakesScreenshot)driver; 
		File file1 = ts.getScreenshotAs(OutputType.FILE); //using the method get ss and converting it into file
		File file2 = new File("C:\\Users\\HP\\OneDrive\\Pictures\\Screenshot\\img1.png"); //mention file path where we want to store the ss
		FileUtils.copyFile(file1, file2); 
		test.log(LogStatus.PASS, "Screenshot was taken successfully.");
	}
	@Test(priority = 2)
	public void shoes() throws InterruptedException {
		//mouse hover to apparel 
		Actions act = new Actions(driver);
		WebElement Apparel = driver.findElement(By.linkText("Apparel"));
		act.moveToElement(Apparel).build().perform();
		test.log(LogStatus.PASS, "Mouse hovered to Apparel successfully.");
				
		//click on shoes
		driver.findElement(By.linkText("Shoes")).click();
		test.log(LogStatus.PASS, "Clicked on Shoes successfully.");
				
		//scroll to first product
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
				
		//click on first product
		driver.findElement(By.linkText("adidas Consortium Campus 80s Running Shoes")).click();
		test.log(LogStatus.PASS, "Clicked on Adidas Consortium Campus 80s Running Shoes successfully.");
				
		//handling size dropdown 
		WebElement SizeDropdown = driver.findElement(By.xpath("//select[@id='product_attribute_9']"));
		Select sel = new Select(SizeDropdown);
		sel.selectByIndex(2); //selected size 9
				
		//click on add to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-25']")).click();
		test.log(LogStatus.PASS, "Adidas Consortium Campus 80s Running Shoes added to cart successfully.");
		Thread.sleep(2000);
		
	}
	@Test(priority = 3)
	public void clothing() throws InterruptedException {
		//mouse hover to apparel 
		Actions act = new Actions(driver);
		WebElement Apparel = driver.findElement(By.linkText("Apparel"));
		act.moveToElement(Apparel).build().perform();
		test.log(LogStatus.PASS, "Mouse hovered to Apparel successfully.");
				
		//click on clothing
		driver.findElement(By.linkText("Clothing")).click();
		test.log(LogStatus.PASS, "Clicked on Clothing successfully.");
				
		//scroll to first product
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
				
		//click on first product
		driver.findElement(By.linkText("Custom T-Shirt")).click();
		test.log(LogStatus.PASS, "Clicked on Custom T-Shirt successfully.");
				
		//entering text in text box
		WebElement TextBox = driver.findElement(By.id("product_attribute_12"));
		TextBox.sendKeys("Eat. Sleep. Code. Repeat.");
		test.log(LogStatus.PASS, "Text entered in text box successfully.");
		
		//click on add to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-29']")).click();
		test.log(LogStatus.PASS, "Custom T-Shirt added to cart successfully.");
		Thread.sleep(2000);
		
	}
	@Test(priority = 4)
	public void accessories() throws InterruptedException {
		//mouse hover to apparel 
		Actions act = new Actions(driver);
		WebElement Apparel = driver.findElement(By.linkText("Apparel"));
		act.moveToElement(Apparel).build().perform();
		test.log(LogStatus.PASS, "Mouse hovered to Apparel successfully.");
						
		//click on accessories
		driver.findElement(By.linkText("Accessories")).click();
		test.log(LogStatus.PASS, "Clicked on Accessories successfully.");
						
		//scroll to first product
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
				
		//click on first product
		driver.findElement(By.linkText("Obey Propaganda Hat")).click();
		test.log(LogStatus.PASS, "Clicked on Obey Propaganda Hat successfully.");
				
		//handling size dropdown 
		WebElement SizeDropdown = driver.findElement(By.xpath("//select[@id='product_attribute_13']"));
		Select sel = new Select(SizeDropdown);
		sel.selectByIndex(2); //selected medium size
				
		//click on add to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-31']")).click();
		test.log(LogStatus.PASS, "Obey Propaganda Hat added to cart successfully.");
		Thread.sleep(2000);
	}
	
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.close();
	}
	
	@AfterClass
	public void last() {
		report.endTest(test);
		report.flush();
	}
	
}

