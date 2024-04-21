
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameTxt = By.id("t1");
    private By passwordTxt = By.id("t2");
    private By loginBtn = By.xpath("/html/body/form/input[3]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Set username in textbox
    public void setUsername(String username) {
        driver.findElement(usernameTxt).sendKeys(username);
    }

    // Set password in password textbox
    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    // Click on login button
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // Get the title of login page
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Perform login action
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
    }
}

