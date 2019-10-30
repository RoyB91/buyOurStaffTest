import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {


    private CartPage cartPage = new CartPage();
    private IndexPage indexPage = new IndexPage();


    @Test
    public void checkCartWithoutLogin() {
        indexPage.openIndexPage();
        assertTrue(indexPage.getCartTab().isEnabled());
    }

    @Test
    public void addItemWithoutLogin() {
        indexPage.openIndexPage();
        indexPage.addItemToCart("Amazon Fire");
        assertTrue(indexPage.selectSpecificItem("Amazon Fire").isEnabled());



    }

    @Test
    public void addItemWithValidUser() {
        indexPage.addSelectedItemToCart("Tablet", "Amazon Fire HD 8");
        indexPage.openCart();
        assertTrue(cartPage.itemNameField("Amazon Fire HD 8").isDisplayed());

        cartPage.deleteItem("Amazon Fire HD 8");

    }

    @Test
    public void increaseAmountOfItemInCart() {
        indexPage.addSelectedItemToCart("Tablet", "Amazon Fire HD 8");
        indexPage.openCart();
        cartPage.plusItem("Amazon Fire HD 8");
        assertEquals(2, cartPage.getItemCount("Amazon Fire HD 8"));

        cartPage.deleteItem("Amazon Fire HD 8");
    }

    @Test
    public void decreaseAmountOfItemInCart() {
        indexPage.addSelectedItemToCart("Tablet", "Amazon Fire HD 8");
        indexPage.addSelectedItemToCart("Tablet", "Amazon Fire HD 8");
        indexPage.openCart();
        cartPage.minusItem("Amazon Fire HD 8");
        assertEquals(1, cartPage.getItemCount("Amazon Fire HD 8"));

        cartPage.deleteItem("Amazon Fire HD 8");

    }

    @Test
    public void deleteItemInCart() {
        indexPage.addSelectedItemToCart("Tablet", "Amazon Fire HD 8");
        indexPage.openCart();
        cartPage.deleteItem("Amazon Fire HD 8");
        assertFalse(cartPage.itemNameField("Amazon Fire HD 8").isDisplayed());
    }

    @Test
    public void deleteItemWithMinusButtonInCart() {
        indexPage.addSelectedItemToCart("Tablet", "Amazon Fire HD 8");
        indexPage.addSelectedItemToCart("Tablet", "Amazon Fire HD 8");
        indexPage.openCart();
        cartPage.minusItem("Amazon Fire HD 8");
        cartPage.minusItem("Amazon Fire HD 8");
        assertFalse(cartPage.itemNameField("Amazon Fire HD 8").isDisplayed());
    }




}