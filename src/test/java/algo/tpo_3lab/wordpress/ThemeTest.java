package algo.tpo_3lab.wordpress;

import algo.tpo_3lab.wordpress.pages.DashboardPage;
import algo.tpo_3lab.wordpress.pages.HomePage;
import org.junit.jupiter.api.Test;
import algo.tpo_3lab.wordpress.pages.LoginPage;
import algo.tpo_3lab.wordpress.pages.ThemesPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThemeTest extends BaseTest {
    @Test
    public void testUserCanChangeTheme() {
        HomePage home = new HomePage(driver);
        home.open();
        home.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@gmail.com", "test");
        assertTrue(loginPage.isLoggedIn());
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickThemes();
        ThemesPage themes = new ThemesPage(driver);
        themes.activateFirstTheme();
        assertTrue(themes.isThemeActivated());
    }
}