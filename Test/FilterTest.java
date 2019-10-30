import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


public class FilterTest {

    private IndexPage indexPage = new IndexPage();

    @AfterEach
    public void setupCategoryBase() {

        indexPage.selectCategory("Tablet");

    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/filterCategory.csv", numLinesToSkip = 1)
    public void filterByCategory(String categoryName, String itemToValidate) {
        indexPage.openIndexPage();
        indexPage.selectCategory(categoryName);
        assertTrue(indexPage.selectSpecificItem(itemToValidate).isDisplayed());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "resources/filterSupplier.csv", numLinesToSkip = 1)
    public void filterBySupplier(String supplierName,String itemToValidate) {
        indexPage.openIndexPage();
        indexPage.selectCategory(supplierName);
        assertTrue(indexPage.selectSpecificItem(itemToValidate).isDisplayed());
    }
}
