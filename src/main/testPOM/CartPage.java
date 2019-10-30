import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    private WebDriver driver;


    @FindBy(xpath = "//input[@value='Checkout' and @class='btn btn-success']")
    private WebElement checkoutButton;


    public CartPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void plusItem(String itemName) {
        driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-plus']")).click();
    }

    public void minusItem(String itemName) {
        driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-minus']")).click();
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

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

}
