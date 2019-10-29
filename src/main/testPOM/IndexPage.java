import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Shop']")
    private WebElement shopTab;
    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Cart']")
    private WebElement cartTab;
    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Login']")
    private WebElement loginTab;
    @FindBy(xpath = "//li[@class='nav-item']//*[text() = 'Logout']")
    private WebElement logoutTab;

    @FindBy(xpath = "//*[contains(text(),'Categories')]")
    private WebElement categoriesTab;

    @FindBy(xpath = "//*[contains(text(),'Suppliers')]")
    private WebElement suppliersTab;


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

    public WebElement getShopTab() {
        return shopTab;
    }

    public WebElement getCartTab() {
        return cartTab;
    }

    public WebElement getLoginTab() {
        return loginTab;
    }

    public WebElement getLogoutTab() {
        return logoutTab;
    }

    public WebElement getCategoriesTab() {
        return categoriesTab;
    }

    public WebElement getSuppliersTab() {
        return suppliersTab;
    }

    public WebElement addToSpecificItem(String itemName) {
        return driver.findElement(By.xpath("//h4[@class='card-title' and text()='" + itemName + "']/parent::*/following-sibling::div//form"));
    }

    public WebElement pickCategory(String categoryName) {
        return driver.findElement(By.xpath("//button[@class='dropdown-item' and text()='" + categoryName + "']"));
    }

    public WebElement pickSupplier(String supplierName) {
        return driver.findElement(By.xpath("//button[@class='dropdown-item' and text()='" + supplierName + "']"));
    }


}
