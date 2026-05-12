package algo.tpo_3lab.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By getStartedButton = By.xpath("//a[contains(text(),'Get Started') or contains(text(),'Создать сайт')]");
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
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getTitle().contains("WordPress.com");
    }
}
