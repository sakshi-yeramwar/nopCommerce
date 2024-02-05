package nopCommerce;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {
	
	WebDriver driver;
	
	@org.testng.annotations.DataProvider(name = "getData")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		
		//create object of data extract class
		DataExtract get = new DataExtract();
		
		//calling data from excel
		Object[][] data = get.getDataFromExcel();
		
		return data;
	}
	
	@BeforeMethod 
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider = "getData")
	public void register(String FirstN, String LastN, String email, String password, String ConfirmPass) throws InterruptedException {
		
		//locate Register and click on it
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
				
		//locate FirstName element
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
				
		//locate LastName element
		WebElement LastName = driver.findElement(By.xpath("//input[@id='LastName']"));
				
		//locate Email element
		WebElement Email = driver.findElement(By.xpath("//input[@name='Email']"));
				
		//locate Password element
		WebElement Password = driver.findElement(By.xpath("//input[@name='Password']"));
				
		//locate ConfirmPassword element
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
				
		FirstName.sendKeys(FirstN);
		LastName.sendKeys(LastN);
		Email.sendKeys(email);
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(ConfirmPass);
		
		//click on the final register button
		driver.findElement(By.id("register-button")).click();
	}
	
	@AfterMethod
	public void last() {
		driver.close();
	}

}
