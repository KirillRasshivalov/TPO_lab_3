package algo.tpo_3lab.wordpress;

import org.junit.jupiter.api.Test;
import algo.tpo_3lab.wordpress.pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest {
    @Test
    public void testUserCanRegister() {
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.open();
        regPage.register("testuser1232@gmail.com");
        assertTrue(regPage.isRegistrationSuccessful());
    }
}