package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private By getStartedButton = By.xpath("//a[contains(text(),'Get Started') or contains(text(),'Начало работы')]");
    private By loginLink = By.xpath("//a[contains(@href,'log-in') or contains(text(),'Log In')]");
    private By searchField = By.xpath("//input[@type='search']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://wordpress.com/");
    }

    public void clickGetStarted() {
        driver.findElement(getStartedButton).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void searchFor(String query) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='search']")
        ));
        searchField.clear();
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.RETURN);
        String originalWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(ExpectedConditions.urlContains("start/domain"));
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getTitle().contains("WordPress.com");
    }
}
