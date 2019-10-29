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
    public void addItemWithValidUser(){
        indexPage.openIndexPage();
        indexPage.selectCategory("Smartphone");
        indexPage.addItemToCart("iPhone 11");
        indexPage.openCart();
        assertTrue(indexPage.selectSpecificItem("iPhone 11").isDisplayed());

    }


}