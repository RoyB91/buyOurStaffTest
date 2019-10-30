import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;


public class Register {

    private RegisterPage registerPage = new RegisterPage();
    private IndexPage indexPage = new IndexPage();
    private Util util = new Util();

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
    public void registerSuccessfully() {

        String username = util.generateString();
        String password = util.generateString();

        registerPage.directToRegisterPage();
        registerPage.fillUsernameField(username);
        registerPage.fillPasswordField(password);
        registerPage.clickRegisterButton();

        assertTrue(util.isElementDisplayed(indexPage.getLoginTab()));

    }

}
