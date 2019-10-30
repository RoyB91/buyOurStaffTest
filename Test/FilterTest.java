import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FilterTest {

    private IndexPage indexPage = new IndexPage();

    @AfterEach
    public void setupCategoryBase() {

        indexPage.selectCategory("Tablet");

    }

    @Test
    public void filterByCategory() {
        indexPage.openIndexPage();
        indexPage.selectCategory("Smartphone");
        assertTrue(indexPage.selectSpecificItem("iPhone 11").isDisplayed());
    }

    @Test
    public void filterBySupplier() {
        indexPage.openIndexPage();
        indexPage.selectCategory("Apple");
        assertTrue(indexPage.selectSpecificItem("iPhone 11").isDisplayed());
    }
}
