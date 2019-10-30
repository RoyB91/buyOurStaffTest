import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckOutPageTest {

    WebDriver driver;
    CheckoutPage page = new CheckoutPage();

    @ParameterizedTest
    @CsvFileSource(resources = "resources/checkoutData.csv")
    void simpleParam(String name, String email, String phone, String billing, String shopping){
        page.checkOutLogin();
        page.fillShippingInfo(name,email,phone,billing,shopping);
        Assert.assertTrue(page.getPaymentPageHeader().isDisplayed());
        page.deleteItem();
    }

    @Test
    void payWithVisaTest(){
        page.checkOutLogin();
        page.payWithVisa();
        page.getSubmitButton();
        Assert.assertTrue(page.getSubmitButton().isDisplayed());
        page.deleteItem();
    }

    @Test
    void emptyFieldTest(){
        page.checkOutLogin();
        page.emptyField();
        Assert.assertEquals(page.getValidationmessage(),"Please fill out this field.");
        page.deleteItem();
    }

    @Test
    void payWithPayPal(){
        page.checkOutLogin();
        page.payWithPayPal();
        Assert.assertTrue(page.getPayPalButton().isDisplayed());
    }
}
