import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.Random;

public class Util extends BasePage {

    private WebDriverWait wait;

    public Util() {

        this.wait = getWait();

    }

    public boolean isElementDisplayed(WebElement element) {

        waitForVisible(element);
        return element.isDisplayed();

    }

    public void waitForVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForClickableAndClick(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public String generateString() {

        byte[] array = new byte[10];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));

    }

}
