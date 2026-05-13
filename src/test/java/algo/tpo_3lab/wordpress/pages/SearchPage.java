package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResultPresentFor(String keyword) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Поиск на странице: " + currentUrl);
        String xPath = "//*[@id=\"primary\"]/div/div/div/div/div/div[3]/div/div/div[2]/div[1]" +
                "/div/div[1]/div/div/div[1]/span[contains(text(), '" + keyword + "')]";
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isPageLoaded() {
        String url = driver.getCurrentUrl();
        return url.contains("s=") || url.contains("/search") || url.contains("/domains");
    }
}