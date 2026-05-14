package algo.tpo_3lab.wordpress;

import algo.tpo_3lab.wordpress.pages.DashboardPage;
import algo.tpo_3lab.wordpress.pages.HomePage;
import algo.tpo_3lab.wordpress.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationTest extends BaseTest {

    @Test
    public void testOfNotification() {
        HomePage home = new HomePage(driver);
        home.open();
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.login("test@gmail.com", "test");
        assertTrue(login.isLoggedIn());
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickNotifications();
        assertTrue(dashboard.checkIsOPenNotification());
    }
}
