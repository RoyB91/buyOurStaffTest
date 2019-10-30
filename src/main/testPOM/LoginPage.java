import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Util util = new Util();
    private IndexPage indexPage = new IndexPage();
    private String loginURL = getBaseURL() + "login";
    private String incorrectPassword = "admin2";

    public LoginPage() {

        this.driver = getDriver();
        this.wait = getWait();
        PageFactory.initElements(driver,this);

    }

    @FindBy(name = "username") private WebElement usernameField;
    @FindBy(name = "password") private WebElement passwordField;
    @FindBy(className = "btn-success") private WebElement loginButton;

    public void loginWitValidData() {

        directToLoginPage();
        fillUsernameField(getUsername());
        fillPasswordField(getPassword());
        clickLoginButton();

    }

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

    public void clickLoginButton() {

        util.waitForClickableAndClick(loginButton);

    }

    public void clickLogOutTab() {

        util.waitForClickableAndClick(indexPage.getLogoutTab());

    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }

}