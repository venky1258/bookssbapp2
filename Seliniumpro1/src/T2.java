import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T2 {

WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
	
	System.setProperty("webdriver.edge.driver",
	            "C:\\Users\\Venky1\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	        // Instantiate a ChromeDriver class.
	         driver = new EdgeDriver();
		
	driver.get("http://localhost:8080/FSP/F1.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void verifyPage()
	{
	WebElement textField = driver.findElement(By.xpath("//*[@id=\"t1\"]"));
	textField.sendKeys("iiiii");
	WebElement submitButton = driver.findElement(By.xpath("/html/body/form/input[2]"));
	submitButton.click();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
	//driver.quit();
	}

	
}
