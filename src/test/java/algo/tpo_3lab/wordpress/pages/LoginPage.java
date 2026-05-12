package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return false;
    }

    public void login(String email, String password) {
        System.out.println("URL после клика: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        By emailFieldLocator = By.xpath("//input[@name='usernameOrEmail']");
        enterText(emailFieldLocator, email);

        By continueBtnLocator = By.xpath("//button[contains(@class, 'is-primary') " +
                "and (contains(text(),'Continue') or contains(text(),'Продолжить') or" +
                " normalize-space()='Continue' or normalize-space()='Продолжить')]");
        clickSafely(continueBtnLocator);

        By passwordFieldLocator = By.xpath("//input[@type='password']");
        enterText(passwordFieldLocator, password);

        By loginBtnLocator = By.xpath("//button[contains(text(),'Log In') or contains(text(),'Войти')]");
        clickSafely(loginBtnLocator);
    }

    private void enterText(By locator, String text) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                element.clear();
                element.sendKeys(text);
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException, повторная попытка " + (attempts + 1));
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
            attempts++;
        }
        throw new RuntimeException("Не удалось ввести текст в элемент " + locator + " после 3 попыток");
    }

    private void clickSafely(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException при клике, повторная попытка " + (attempts + 1));
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
            attempts++;
        }
        throw new RuntimeException("Не удалось кликнуть по элементу " + locator + " после 3 попыток");
    }

    public boolean isLoggedIn() {
        By avatar = By.xpath("//img[contains(@class,'gravatar')]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(avatar));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        By avatarLocator = By.xpath("//img[contains(@class,'gravatar')]");
        clickSafely(avatarLocator);

        By logoutBtnLocator = By.xpath("//div[contains(@class,'popover')]//button[contains(text(),'Log Out')]");
        clickSafely(logoutBtnLocator);
    }
}