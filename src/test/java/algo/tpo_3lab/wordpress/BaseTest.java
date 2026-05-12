package algo.tpo_3lab.wordpress;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String browser = System.getProperty("browser", "chrome");
    protected boolean useRemote = Boolean.parseBoolean(System.getProperty("useRemote", "false"));

    @BeforeEach
    public void setUp() throws MalformedURLException {
        if (useRemote) {
            URL seleniumServerURL = new URL("http://localhost:4444/wd/hub");
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new RemoteWebDriver(seleniumServerURL, new ChromeOptions());
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new RemoteWebDriver(seleniumServerURL, new FirefoxOptions());
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } else {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
