package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    private By continueEnterEm = By.xpath("//button[contains(@class, 'components-button " +
            "a8c-components-wp-button social-buttons__button is-next-40px-default-size is-secondary')]//span[text()='Чтобы продолжить, введите адрес эл. почты']");
    private By emailInput = By.xpath("//input[@type='email']");
    private By dashboard = By.xpath("//button[contains(@class, 'components-button domain-search-controls__submit is-primary')]");
    private By continueEm = By.xpath("//button[contains(@class, 'components-button signup-form__submit is-next-40px-default-size is-primary')]");

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