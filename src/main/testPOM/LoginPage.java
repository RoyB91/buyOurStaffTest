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

    public LoginPage() {

        this.driver = getDriver();
        this.wait = getWait();

    }



}