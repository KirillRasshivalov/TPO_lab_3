package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ThemesPage extends BasePage {

    private By themeSelector = By.xpath("//*[@id=\"primary\"]/main/div/div[2]/div[3]/div/div/div/div[3]/div/div[1]/a/img");
    private By activateButton = By.xpath("//*[@id=\"primary\"]/main/div/div[1]/div[1]/div[1]/div[2]/a");
    private By successNotice = By.xpath("//*[@id=\"step-header\"]/div/h1");

    public ThemesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://wordpress.com/themes");
    }

    public void activateFirstTheme() {
        wait.until(ExpectedConditions.elementToBeClickable(themeSelector)).click();
        wait.until(ExpectedConditions.elementToBeClickable(activateButton)).click();
    }

    public boolean isThemeActivated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).isDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/themes");
    }
}