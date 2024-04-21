
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.logging.*;

public class T4 {
	static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        // Set up logging
        LOGGER.setLevel(Level.INFO);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(consoleHandler);

        // Set up WebDriver
        System.setProperty("webdriver.edge.driver",
	            "C:\\Users\\Venky1\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	        // Instantiate a ChromeDriver class.
	         driver = new EdgeDriver();
	     LOGGER.info("Navigating to the website...");
	driver.get("http://localhost:8080/FSP2/adduserform.jsp");
        // Open website
        
        

        // Perform actions
        LOGGER.info("Performing some actions...");

        // Close browser
        LOGGER.info("Closing the browser...");
        driver.quit();
    }
}
