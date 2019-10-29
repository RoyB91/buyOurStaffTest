import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private String baseURL = "http://0.0.0.0:8888/";
    private WebDriver driver = WebDriverManager.getInstance().getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private String username = System.getenv("UserName");
    private String password = System.getenv("PASSWORD");


    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
