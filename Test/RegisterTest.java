import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {

    private RegisterPage registerPage = new RegisterPage();
    private IndexPage indexPage = new IndexPage();
    private Util util = new Util();
    private String takenUsername = "admin";
    String username = util.generateString();
    String password = util.generateString();

    @Test
    public void registerSuccessfully() {

        registerPage.directToRegisterPage();
        registerPage.fillUsernameField(username);
        registerPage.fillPasswordField(password);
        registerPage.clickRegisterButton();

        assertTrue(util.isElementDisplayed(indexPage.getLoginTab()));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/RegisterData.csv", numLinesToSkip = 1)
    public void registerWithLongUsername(String username, String password) {
        registerPage.directToRegisterPage();
        registerPage.fillUsernameField(username);
        registerPage.fillPasswordField(password);
        registerPage.clickRegisterButton();

        assertFalse(util.isElementDisplayed(registerPage.getRegisterButton()), "Register unsuccessful.");

    }

    @Test
    public void registerTakenUsername() {

        registerPage.directToRegisterPage();
        registerPage.fillUsernameField(takenUsername);
        registerPage.fillPasswordField(password);
        registerPage.clickRegisterButton();

        assertTrue(util.isElementDisplayed(registerPage.getErrorMessage()));

    }

}