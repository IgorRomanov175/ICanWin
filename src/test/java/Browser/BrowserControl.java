package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pagesGoogleCloud.CalculatorPage;
import pagesGoogleCloud.GoogleCloudHomePage;
import pagesGoogleCloud.SearchPage;
import pagesPastebin.HomePagePastebin;
import pagesPastebin.ResultPage;
import yopmailPages.YopmailHomePage;
import yopmailPages.YopmailMailPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BrowserControl {

    public final static String PASTEBIN_URL = "https://pastebin.com/";
    public final static String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    public final static long WAIT_TIME = 20;

    private RemoteWebDriver driver;

    @BeforeTest
    public void setUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public WebDriver driver(){
        return driver;
    }

    public HomePagePastebin homePage(){
        return new HomePagePastebin(driver);
    }

    public ResultPage resultPage(){
        return new ResultPage(driver);
    }

    public GoogleCloudHomePage googleCloudHomePage(){
        return new GoogleCloudHomePage(driver);
    }

    public SearchPage searchPage(){
        return new SearchPage(driver);
    }

    public CalculatorPage calculatorPage(){
        return new CalculatorPage(driver);
    }

    public YopmailHomePage yopmailHomePage(){
        return new YopmailHomePage(driver);
    }

    public YopmailMailPage yopmailMailPage(){
        return new YopmailMailPage(driver);
    }
}
