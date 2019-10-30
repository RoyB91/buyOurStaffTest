import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private IndexPage indexPage = new IndexPage();
    private Util util = new Util();
    private String loginURL = getBaseURL() + "login";

    public LoginPage() {

        this.driver = getDriver();
        this.wait = getWait();

    }

    @FindBy(name = "username") private WebElement usernameField;
    @FindBy(name = "password") private WebElement passwordField;
    @FindBy(className = "btn-success") private WebElement loginButton;

    public void directToLoginPage() {

        driver.navigate().to(loginURL);

    }

    public void fillUsernameField(String username) {

        util.waitForClickableAndClick(usernameField);
        usernameField.sendKeys(username);

    }

    public void fillPasswordField(String password) {

        util.waitForClickableAndClick(passwordField);
        passwordField.sendKeys(password);

    }

    public void clickRegisterButton() {

        util.waitForClickableAndClick(loginButton);

    }

}