package algo.tpo_3lab.wordpress;

import org.junit.jupiter.api.Test;
import algo.tpo_3lab.wordpress.pages.HomePage;
import algo.tpo_3lab.wordpress.pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchWorks() {
        String keyword = "12.shop";
        HomePage home = new HomePage(driver);
        home.open();
        home.searchFor(keyword);
        String resKey = "Он доступен!";
        SearchPage search = new SearchPage(driver);
        assertTrue(search.isResultPresentFor(resKey),
                "Результат поиска не содержит '" + keyword + "'");
    }

    @Test
    public void testSearchDoesntWork() {
        String keyword = "12.drop";
        HomePage home = new HomePage(driver);
        home.open();
        home.searchFor(keyword);
        String resKey = "Он доступен!";
        SearchPage search = new SearchPage(driver);
        assertFalse(search.isResultPresentFor(resKey),
                "Результат поиска содержит '" + keyword + "'");
    }
}