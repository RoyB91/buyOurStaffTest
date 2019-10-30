import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//input[@value='Checkout' and @class='btn btn-success']")
    private WebElement checkoutButton;


    public CartPage() {
        this.driver = getDriver();
        this.wait = getWait();
        PageFactory.initElements(driver, this);
    }

    public WebElement plusButton(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-plus']"));

    }

    public WebElement minusButton(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-minus']"));
    }

    public void plusItem(String itemName, int times) {
        for (int i = 0; i < times; i++) {
            wait.until(ExpectedConditions.visibilityOf(plusButton(itemName)));
            plusButton(itemName).click();
        }
    }

    public void minusItem(String itemName, int times) {
        for (int i = 0; i < times; i++) {
            wait.until(ExpectedConditions.visibilityOf(minusButton(itemName)));
            minusButton(itemName).click();
        }
    }

    public void deleteItem(String itemName) {
        driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-trash']")).click();
    }

    public WebElement getItemCount(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']/following-sibling::td[1]"));
    }

    public WebElement itemNameField(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']"));
    }

    public boolean isItemOnPage(String itemName) {
        try {
            driver.findElement(By.xpath("//*[text()='" + itemName + "']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

}
