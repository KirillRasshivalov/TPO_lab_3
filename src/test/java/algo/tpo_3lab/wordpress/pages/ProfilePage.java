package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    private By authorLink = By.xpath("//span[contains(@class, 'masterbar__item-howdy-howdy')]");
    private By profileLink = By.xpath("//a[contains(@class, 'sidebar__menu-link')]//span[text()='Мой профиль']");
    private By profileSettings = By.xpath("//a[contains(@class, 'sidebar__menu-link')]//span[text()='Настройки учетной записи']");
    private By profileBlogs = By.xpath("//a[contains(@class, 'sidebar__menu-link')]//span[text()='Управление блогами']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickAuthorName() {
        driver.findElement(authorLink).click();
    }

    public boolean isMyProfileVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileLink)).isDisplayed();
    }

    public boolean isMyProfileSettingsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileSettings)).isDisplayed();
    }

    public boolean isMyProfileBlogsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileBlogs)).isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/author/");
    }
}
