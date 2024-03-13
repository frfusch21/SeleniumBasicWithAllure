package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();

    @BeforeMethod
    public void openBrowser(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments();
//        driver.set(new ChromeDriver(options));
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize();
        driver.get().manage().window().maximize();
        driver.get().get("https://demoblaze.com/");
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(120)));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }
}
