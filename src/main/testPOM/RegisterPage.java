import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private Util util = new Util();

    public RegisterPage() {
        this.driver = getDriver();
        this.wait = getWait();

    }

    @FindBy(name = "username") private WebElement usernameField;
    @FindBy(name = "password") private WebElement passwordField;
    @FindBy(className = "btn-success") private WebElement registerButton;

    public void fillUsernameField(String username) {

    util.waitForClickableAndClick(usernameField);
    usernameField.sendKeys(username);

    }

    public void fillPasswordField(String password) {

        util.waitForClickableAndClick(passwordField);
        passwordField.sendKeys(password);

    }

    public void clickRegisterButton() {

        util.waitForClickableAndClick(registerButton);

    }

}
