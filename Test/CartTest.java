import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {


    private CartPage cartPage = new CartPage();
    private IndexPage indexPage = new IndexPage();
    private LoginPage loginPage = new LoginPage();


    @Test
    public void checkCartWithoutLogin() {

        indexPage.openIndexPage();

        assertTrue(indexPage.getCartTab().isEnabled());
    }

//    @Test
//    public void addItemWithoutLogin() {
//        indexPage.openIndexPage();
//
//        indexPage.addItemToCart("Amazon Fire");
//        assertTrue(indexPage.selectSpecificItem("Amazon Fire").isDisplayed());
//
//
//    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/addItemTestData.csv", numLinesToSkip = 1)
    public void addItemWithValidUser(String categoryName, String itemName) {
        loginPage.loginWitValidData();
        indexPage.addSelectedItemToCart(categoryName, itemName, 1);
        indexPage.openCart();
        assertTrue(cartPage.itemNameField(itemName).isDisplayed());

        cartPage.deleteItem(itemName);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/increaseItemTestData.csv", numLinesToSkip = 1)
    public void increaseAmountOfItemInCart(String categoryName, String itemName, int countToAdd, int countPress, String expected) {
        loginPage.loginWitValidData();

        indexPage.addSelectedItemToCart(categoryName, itemName, countToAdd);
        indexPage.openCart();
        cartPage.plusItem(itemName, countPress);
        assertEquals(expected, cartPage.getItemCount(itemName).getText());

        cartPage.deleteItem(itemName);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/decreaseItemTestData.csv", numLinesToSkip = 1)
    public void decreaseAmountOfItemInCart(String categoryName, String itemName, int countToAdd, int countPress, String expected) {
        loginPage.loginWitValidData();

        indexPage.addSelectedItemToCart(categoryName, itemName, countToAdd);
        indexPage.openCart();
        cartPage.minusItem(itemName, countPress);
        assertEquals(expected, cartPage.getItemCount(itemName).getText());

        cartPage.deleteItem("Amazon Fire HD 8");

    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/deleteItemTestData.csv", numLinesToSkip = 1)
    public void deleteItemInCart(String categoryName, String itemName, int countToAdd) {
        loginPage.loginWitValidData();

        indexPage.addSelectedItemToCart(categoryName, itemName, countToAdd);
        indexPage.openCart();
        cartPage.deleteItem(itemName);
        assertFalse(cartPage.isItemOnPage(itemName));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/deleteItemsWithButtonTestData.csv", numLinesToSkip = 1)
    public void deleteItemWithMinusButtonInCart(String categoryName, String itemName, int countToAdd, int countPress) {
        loginPage.loginWitValidData();

        indexPage.addSelectedItemToCart(categoryName, itemName, countToAdd);
        indexPage.openCart();
        cartPage.minusItem(itemName, countPress);
        assertFalse(cartPage.isItemOnPage(itemName));
    }


}