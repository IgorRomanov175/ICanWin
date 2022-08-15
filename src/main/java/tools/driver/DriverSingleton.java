package tools.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Objects;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser){
        if(null == driver){
            if(Objects.equals(System.getProperty("browser"), "edge") || browser.equals("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if(Objects.equals(System.getProperty("browser"), "firefox") || browser.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (Objects.equals(System.getProperty("browser"), "chrome") || browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
