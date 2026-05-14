package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    private By continueEnterEm = By.xpath("//*[@id=\"wpcom\"]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/button[4]");
    private By emailInput = By.xpath("//*[@id=\"signup-email\"]");
    private By dashboard = By.xpath("//*[@id=\"wpcom\"]/div/div[2]/div[2]/div[1]/div/h1");
    private By continueEm = By.xpath("//*[@id=\"wpcom\"]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/form/div/button[1]");

    public void open() {
        driver.get("https://wordpress.com/setup/onboarding/ru");
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void register(String email) {
        driver.findElement(continueEnterEm).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(continueEm).click();
    }

    public boolean isRegistrationSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard)).isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("start");
    }
}