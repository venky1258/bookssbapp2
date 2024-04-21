import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;



public class T3 {

WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
	
	//System.setProperty("webdriver.edge.driver",
	           // "C:\\Users\\Venky1\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	        // Instantiate a ChromeDriver class.
	        // driver = new EdgeDriver();
		driver =new ChromeDriver();
	driver.get("http://localhost:8080/FSP2/adduserform.jsp");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	Thread.sleep(5000);
	}
	
	@Test
	public void verifyPage()
	{
	WebElement textField = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
	textField.sendKeys("iiiii");
	
	WebElement pw = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
	pw.sendKeys("iiiii");
	
	WebElement em = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input"));
	em.sendKeys("iiiii@g.com");
	
	WebElement radioButton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input[1]"));
	// To click on the radio button
	radioButton.click();

	// To check if the radio button is selected
	//boolean isSelected = radioButton.isSelected();

	WebElement selectElement = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/select"));
	Select dropdown = new Select(selectElement);
	// Select by visible text
	//dropdown.selectByVisibleText("Option 1");

	// Select by value
	//dropdown.selectByValue("value1");

	// Select by index
	dropdown.selectByIndex(0);

	
	WebElement submitButton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/input"));
	submitButton.click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p")));

    // Extract the response message
    String responseMessage = responseElement.getText();

    // Assert the response message
    String expectedMessage = "Record successfully saved!";
    if (responseMessage.equals(expectedMessage)) {
        System.out.println("Submit button works properly. Response message: " + responseMessage);
    } else {
        System.out.println("Submit button does not work properly. Response message: " + responseMessage);
    }
    
    Assert.assertEquals(responseMessage,expectedMessage);
	}
	
    @AfterMethod
	public void tearDown()
	{
	driver.quit();
	}

	
}
