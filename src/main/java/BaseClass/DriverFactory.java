package BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class DriverFactory {
    public static WebDriver driver;
    public static void initDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
}