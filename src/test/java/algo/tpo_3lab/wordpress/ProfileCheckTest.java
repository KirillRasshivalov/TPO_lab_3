package algo.tpo_3lab.wordpress;

import org.junit.jupiter.api.Test;
import algo.tpo_3lab.wordpress.pages.HomePage;
import algo.tpo_3lab.wordpress.pages.LoginPage;
import algo.tpo_3lab.wordpress.pages.ProfilePage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileCheckTest extends BaseTest {

    @Test
    public void testUserCanViewAuthorProfile() {
        HomePage home = new HomePage(driver);
        home.open();
        home.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@gmail.com", "test");
        assertTrue(loginPage.isLoggedIn());
        ProfilePage profile = new ProfilePage(driver);
        profile.clickAuthorName();
        assertTrue(profile.isMyProfileVisible());
    }

    @Test
    public void testUserCanSeeProfileSettings() {
        HomePage home = new HomePage(driver);
        home.open();
        home.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@gmail.com", "test");
        assertTrue(loginPage.isLoggedIn());
        ProfilePage profile = new ProfilePage(driver);
        profile.clickAuthorName();
        assertTrue(profile.isMyProfileSettingsVisible());
    }

    @Test
    public void testUserCanSeeProfileBlogs() {
        HomePage home = new HomePage(driver);
        home.open();
        home.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@gmail.com", "test");
        assertTrue(loginPage.isLoggedIn());
        ProfilePage profile = new ProfilePage(driver);
        profile.clickAuthorName();
        assertTrue(profile.isMyProfileBlogsVisible());
    }
}
