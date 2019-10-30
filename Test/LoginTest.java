import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private LoginPage loginPage = new LoginPage();
    private IndexPage indexPage = new IndexPage();
    private Util util = new Util();

    @Test
    public void loginSuccessfully() {
        loginPage.loginWitValidData();
        assertTrue(util.isElementDisplayed(indexPage.getLogoutTab()));

    }

}
