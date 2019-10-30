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

    @Test
    public void loginWithInvalidPassword() {

        loginPage.directToLoginPage();
        loginPage.fillUsernameField(loginPage.getUsername());
        loginPage.fillPasswordField(loginPage.getIncorrectPassword());
        loginPage.clickLoginButton();

    }

    @Test
    public void loginWithUppercaseUsername() {

        loginPage.directToLoginPage();
        loginPage.fillUsernameField(loginPage.getUsername().toUpperCase());
        loginPage.fillPasswordField(loginPage.getPassword());
        loginPage.clickLoginButton();

    }

    @Test
    public void logOut() {

        loginPage.loginWitValidData();
        loginPage.clickLogOutTab();

        assertTrue(util.isElementDisplayed(indexPage.getLoginTab()));

    }

}
