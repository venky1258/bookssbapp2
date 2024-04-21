import java.io.IOException;
import java.time.Duration;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;


public class T5 {
WebDriver driver;
private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@BeforeMethod
	public void setUp() throws SecurityException, IOException
	{
	
		LOGGER.setLevel(Level.INFO);
        //Handler consoleHandler = new ConsoleHandler();
        FileHandler fh = new FileHandler("logfile.log");
            LOGGER.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
       // LOGGER.addHandler(consoleHandler);
	driver=new ChromeDriver();
		
	driver.get("http://localhost:8080/FSP3/login.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(dataProvider= "dataSupplier")
	public void testLogin(String un, String pwd) {
	
	//driver.findElement (By.xpath("//span [text ()='My Account']")).click();
	//driver.findElement(By.linkText ("Login")).click();
	driver.findElement (By.id("t1")).sendKeys (un); 
	driver.findElement (By.id("t2")).sendKeys (pwd);
	driver.findElement(By.xpath("/html/body/form/input[3]")).click(); 
	for(int i=1;i<5;i++)
	{
		String s1="/html/body/form/input[";
		String s2="]";
		driver.findElement(By.xpath(s1+i+s2)).click(); 
		
		
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/h1 ")));

    // Extract the response message
    String responseMessage = responseElement.getText();
	
	String expectedMessage="Login App using HttpSession";
	
	if (responseMessage.equals(expectedMessage)) {
		LOGGER.info("Success");
        
    } else {
    	 
		//LOGGER.log(Level.SEVERE, "An error occurred:");
    }
	try {
	Assert.assertEquals(responseMessage,expectedMessage);
	 } catch (Throwable e) {
         LOGGER.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
     }
	}
	@DataProvider
	public Object[][] dataSupplier() {
	Object[][] data = {{"as", "as"},{"qw", "qw"},{"rt", "rt"},{"er", "er"},{"rt","rt"}};
	return data;
	} 
	
	
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}

	
}
