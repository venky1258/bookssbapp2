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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;


public class T6 {
WebDriver driver;
private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@BeforeTest
	public void setUp() throws SecurityException, IOException
	{
	
		LOGGER.setLevel(Level.INFO);
        //Handler consoleHandler = new ConsoleHandler();
        FileHandler fh = new FileHandler("logfile.log");
            LOGGER.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
       // LOGGER.addHandler(consoleHandler);
	driver=new ChromeDriver();
		
	driver.get("https://demo.nopcommerce.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority=1)
	public void logoPresence()
	{
	boolean disstatus=driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
	Assert.assertEquals(disstatus, true);
	}
	@Test(priority=2)
	public void loginTest()
	{
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.id("Email")).sendKeys("avb@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("avb@123"); 
	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
	Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
	}
	@Test(priority=3)
	public void registrationTest()
	{
	
	throw new SkipException("Skipping this Test");
	}
	
	@Test(priority=4)
	public void myaccountTest()
	{
		boolean disstatus=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).isDisplayed();
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
		Assert.assertEquals(disstatus, true);
	
	}
	@AfterTest
	public void tearDown()
	{ 
	//driver.quit();
	}
	
}
