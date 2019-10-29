import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Shop']")
    private WebElement shopButton;
    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Cart']")
    private WebElement cartButton;
    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[contains(text(),'Categories')]")
    private WebElement categoriesButton;

    @FindBy(xpath = "//*[contains(text(),'Suppliers')]")
    private WebElement suppliersButton;


    @FindBy(xpath = "//div[@class='logged-in-name']")
    private WebElement loggedUserName;

    @FindBy(xpath = "//div[@id='shopping-cart-amount']")
    private WebElement shoppingCartAmount;


    public IndexPage() {
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
    }


    public String getLoggedUsernameText() {
        return loggedUserName.getText();
    }

    public WebElement getShopButton() {
        return shopButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getCategoriesButton() {
        return categoriesButton;
    }

    public WebElement getSuppliersButton() {
        return suppliersButton;
    }

    public WebElement addToSpecificItem(String itemName) {
        return driver.findElement(By.xpath("//h4[@class='card-title' and text()='" + itemName + "']/parent::*/following-sibling::div//form"));
    }
}
