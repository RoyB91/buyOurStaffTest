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

    @FindBy(xpath = "//*[@id='shopping-cart-image']")
    private WebElement cartIcon;

//    @FindBy(xpath = "//a[@class='nav-link disabled'][contains(text(),'Cart')]")
//    private WebElement disabledCartTab;


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

    public WebElement selectSpecificItem(String itemName) {
        return driver.findElement(By.xpath("//h4[@class='card-title' and text()='" + itemName + "']/parent::*/following-sibling::div//form"));

    }

    public void addItemToCart(String itemName) {
        selectSpecificItem(itemName).click();
    }

    public WebElement pickCategory(String categoryName) {
        return driver.findElement(By.xpath("//button[@class='dropdown-item' and text()='" + categoryName + "']"));
    }

    public WebElement pickSupplier(String supplierName) {
        return driver.findElement(By.xpath("//button[@class='dropdown-item' and text()='" + supplierName + "']"));
    }


    public void openIndexPage() {
        driver.navigate().to(getBaseURL());
    }


    public void selectCategory(String categoryName) {
        categoriesTab.click();
        pickCategory(categoryName).click();
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }

    public void openCart() {
        cartIcon.click();
    }
}
