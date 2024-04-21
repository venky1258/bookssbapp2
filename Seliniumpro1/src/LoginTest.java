import java.time.Duration;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    int i=0;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @BeforeTest
    public void setup() {
    	
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/FSP3/login.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        LOGGER.setLevel(Level.INFO);
        Handler consoleHandler = new ConsoleHandler();
            LOGGER.addHandler(consoleHandler);
        consoleHandler .setFormatter(new SimpleFormatter());
        }

    @Test(dataProvider= "dataSupplier")
    public void loginTest(String un,String pw) {
    	driver.get("http://localhost:8080/FSP3/login.html");
        // Perform login
    	LOGGER.info("Test"+i++);
        loginPage.login(un, pw);

        // Assert login success by checking the title of the next page
        Assert.assertEquals(loginPage.getPageTitle(), "Servlet Login Example");
    }

    
    
    
    @AfterTest
    public void teardown() {
        driver.quit();
    }
    @DataProvider
	public Object[][] dataSupplier() {
	Object[][] data = {{"qw", "qw"},{"as","as"}};
	return data;
	}
}
