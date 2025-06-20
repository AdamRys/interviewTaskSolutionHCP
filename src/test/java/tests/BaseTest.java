package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

//Base class - manages WebDriver. Pages are using driver from this class.
public class BaseTest {

    protected static WebDriver driver;

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public static WebDriver getDriver(){
        return driver;
    }

    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
