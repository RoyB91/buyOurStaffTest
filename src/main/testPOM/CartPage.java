import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    private WebDriver driver;


    @FindBy(xpath = "//input[@value='Checkout' and @class='btn btn-success']")
    private WebElement checkoutButton;


    public CartPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public WebElement plusItemCount(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-plus']"));
    }

    public WebElement minusItemCount(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-minus']"));
    }

    public WebElement deleteItem(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']/parent::*//*[@class='glyphicon glyphicon-trash']"));
    }

    public WebElement getItemCount(String itemName) {
        return driver.findElement(By.xpath("//*[text()='" + itemName + "']/following-sibling::td[1]"));
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }
}
