package algo.tpo_3lab.wordpress;

import org.junit.jupiter.api.Test;
import algo.tpo_3lab.wordpress.pages.HomePage;
import algo.tpo_3lab.wordpress.pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void testUserCanLogin() {
        HomePage home = new HomePage(driver);
        home.open();
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login("test@gmail.com", "test");
        assertTrue(login.isLoggedIn());
    }
}
