package nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Accessories {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void configureReport() {
	//create object of extent reports class
	report = new ExtentReports(System.getProperty("user.dir")+"\\nopCommerceAccessories.html");
			
	//start test using variable extent report class
	test = report.startTest("NopCommerceTestAccessories");
	
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
	
	@Test(alwaysRun = true)
	public void product1() {
		//mouse hover to apparel by creating an instance actions class
		Actions act = new Actions(driver);
		WebElement Apparel = driver.findElement(By.linkText("Apparel"));
		act.moveToElement(Apparel).build().perform();
		test.log(LogStatus.PASS, "Mouse hovered to Apparel successfully.");
		
		//click on accessories
		driver.findElement(By.linkText("Accessories")).click();
		test.log(LogStatus.PASS, "Clicked on Accessories successfully.");
		
		//scroll to first product, typecasting js executor with driver instance
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		//click on first product
		driver.findElement(By.linkText("Obey Propaganda Hat")).click();
		test.log(LogStatus.PASS, "Clicked on Obey Propaganda Hat successfully.");
		
		//js.executeScript("window.scrollBy(0,400)");
		
		//handling size dropdown with select class
		WebElement SizeDropdown = driver.findElement(By.xpath("//select[@id='product_attribute_13']"));
		Select sel = new Select(SizeDropdown);
		sel.selectByIndex(2); //selected medium size
		
		//click on add to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-31']")).click();
		test.log(LogStatus.PASS, "Obey Propaganda Hat added to cart successfully.");
		
	}
	
	@Test(alwaysRun = true)
	public void product2() {
		//mouse hover to apparel by creating an instance actions class
		Actions act = new Actions(driver);
		WebElement Apparel = driver.findElement(By.linkText("Apparel"));
		act.moveToElement(Apparel).build().perform();
		test.log(LogStatus.PASS, "Mouse hovered to Apparel successfully.");
				
		//click on accessories
		driver.findElement(By.linkText("Accessories")).click();
		test.log(LogStatus.PASS, "Clicked on Accessories successfully.");
				
		//scroll to first product, typecasting js executor with driver instance
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		//click on second product
		driver.findElement(By.linkText("Ray Ban Aviator Sunglasses")).click();
		test.log(LogStatus.PASS, "Clicked on Ray Ban Aviator Sunglasses successfully.");
		
		//add to wishlist
		driver.findElement(By.id("add-to-wishlist-button-33")).click();
		test.log(LogStatus.PASS, "Ray Ban Aviator Sunglasses added to wishlist successfully.");
		
	}
	
	@Test(alwaysRun = true)
	public void product3() {
		//mouse hover to apparel by creating an instance actions class
		Actions act = new Actions(driver);
		WebElement Apparel = driver.findElement(By.linkText("Apparel"));
		act.moveToElement(Apparel).build().perform();
		test.log(LogStatus.PASS, "Mouse hovered to Apparel successfully.");
						
		//click on accessories
		driver.findElement(By.linkText("Accessories")).click();
		test.log(LogStatus.PASS, "Clicked on Accessories successfully.");
						
		//scroll to first product, typecasting js executor with driver instance
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
				
		//click on third product
		driver.findElement(By.linkText("Reversible Horseferry Check Belt")).click();
		test.log(LogStatus.PASS, "Clicked on Reversible Horseferry Check Belt successfully.");
		
		js.executeScript("window.scrollBy(0,400)");
		
		//add to comparelist
		driver.findElement(By.xpath("//button[@class='button-2 add-to-compare-list-button']")).click();
		test.log(LogStatus.PASS, "Reversible Horseferry Check Belt added to comparelist successfully.");
		
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
