import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.*;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;


public class T1 {
WebDriver driver;
int i=0;
private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@BeforeMethod
	public void setUp()
	{
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venky1\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//driver=new ChromeDriver();
		LOGGER.setLevel(Level.INFO);
        Handler consoleHandler = new ConsoleHandler();
            LOGGER.addHandler(consoleHandler);
        consoleHandler .setFormatter(new SimpleFormatter());
	System.setProperty("webdriver.edge.driver",
	            "C:\\Users\\Venky1\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	        // Instantiate a ChromeDriver class.
	         driver = new EdgeDriver();		
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	LOGGER.info("BT "+i++);
	}
	
	@Test
	public void verifyTitle()
	{
	String actualTitle=driver.getTitle();
	String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	
	Assert.assertEquals(actualTitle,expectedTitle);
	LOGGER.info("Success1 ");
		}
	
	@Test
	public void verifyLogo()
	{
		boolean flag=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
		
		Assert.assertTrue(flag); 
		LOGGER.info("Success2 ");
	}
	
	@AfterMethod
	public void tearDown()
	{
		LOGGER.info("AT "+i++);
	driver.quit();
	}

	
}
