import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{

    private WebDriver driver;
    private WebDriverWait wait;
    IndexPage index = new IndexPage();


    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "e-mail")
    private WebElement emailField;

    @FindBy(id = "phone-number")
    private WebElement phoneNumberField;

    @FindBy(id = "billing-address")
    private WebElement billinhAddressField;

    @FindBy(id = "shipping-address")
    private WebElement shippingAddressField;

    @FindBy(xpath = "//input[@value='Checkout']")
    private WebElement checkoutButton;

    @FindBy(css = ".glyphicon-trash")
    private WebElement deleteIcon;

    @FindBy(xpath ="//div[@id='buttons-container']/div/div[2]/div")
    private WebElement visaButton;



    @FindBy(id = "submit-button")
    private WebElement submitButton;



    @FindBy(className = "card-header")
    private  WebElement paymentPageHeader;

    public CheckoutPage(){
        this.driver = getDriver();
        this.wait = getWait();
        PageFactory.initElements(driver, this);
    }

    public void checkOutLogin(){
        driver.navigate().to(getBaseURL());
        index.getLoginTab().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(System.getenv("UserName"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys(System.getenv("PASSWORD"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Login']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col:nth-child(1) .btn"))).click();
    }

    public void fillShippingInfo(String name, String email, String phone, String billing, String shopping){
        driver.navigate().to(getBaseURL()+"checkout");
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phone);
        billinhAddressField.sendKeys(billing);
        shippingAddressField.sendKeys(shopping);
        checkoutButton.click();
    }

    public void deleteItem(){
        driver.navigate().to(getBaseURL()+"cart");
        deleteIcon.click();
        index.getShopTab().click();
        index.getLogoutTab().click();
    }

    public void payWithVisa(){
        driver.navigate().to(getBaseURL()+"payment");
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOf(visaButton)).click();
        driver.switchTo().frame(0);
    }

    public void emptyField(){
        driver.navigate().to(getBaseURL()+"checkout");
        checkoutButton.click();
    }

    public WebElement getNameField() {
        return nameField;
    }
    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPhoneNumberField() {
        return phoneNumberField;
    }

    public WebElement getBillinhAddressField() {
        return billinhAddressField;
    }

    public WebElement getShippingAddressField() {
        return shippingAddressField;
    }

    public WebElement getPaymentPageHeader() { return paymentPageHeader; }

    public WebElement getSubmitButton() { return wait.until(ExpectedConditions.visibilityOf(submitButton)); }

    public String getValidationmessage() { return driver.findElement(By.name("name")).getAttribute("validationMessage");}
}