
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


public class RegisterTest {

    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private IndexPage indexPage = new IndexPage();
    private Util util = new Util();


    @ParameterizedTest
    @CsvFileSource(resources = "resources/RegisterData.csv", numLinesToSkip = 1)
    public void registerWithLongUsername(String username, String password) {

        registerPage.loginWithGivenData(username, password);

        assertTrue(util.isElementDisplayed(indexPage.getLoginTab()));

    }

    @Test
    public void registerSuccessfully() {

        String username = util.generateString();
        String password = util.generateString();

        registerPage.loginWithGivenData(username, password);

        assertTrue(util.isElementDisplayed(indexPage.getLoginTab()));

    }

}
