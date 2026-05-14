package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private By themesMenuItem = By.xpath("//*[@id=\"secondary\"]/div/div/ul/li[3]/a/span");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickThemes() {
        wait.until(ExpectedConditions.elementToBeClickable(themesMenuItem)).click();
    }

    @Override
    public boolean isPageLoaded() {
        String url = driver.getCurrentUrl();
        return url.contains("/sites");
    }
}