package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private By notificationItem = By.xpath("//a[contains(@href,'/notifications') or contains(text(),'Управление уведомлениями')]");

    private By questionsItem = By.xpath("//button[contains(@class, 'masterbar__item masterbar__item-help')]");

    private By notificationInside = By.xpath("//div[@role='radiogroup' and @aria-label='Фильтровать уведомления']");

    private By helpMenuInside = By.xpath("//button[contains(@class, 'help-center-contact-pa')]");

    private By themesMenuItem = By.xpath("//span[contains(text(), 'Темы')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickThemes() {
        wait.until(ExpectedConditions.elementToBeClickable(themesMenuItem)).click();
    }

    public void clickHelpMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(questionsItem)).click();
    }

    public void clickNotifications() {
        wait.until(ExpectedConditions.elementToBeClickable(notificationItem)).click();
    }

    public boolean checkIsOpenHelpMenu() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(helpMenuInside));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkIsOPenNotification() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(notificationInside));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isPageLoaded() {
        String url = driver.getCurrentUrl();
        return url.contains("/sites");
    }
}