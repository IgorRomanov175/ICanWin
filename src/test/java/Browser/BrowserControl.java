package Browser;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.pagesGoogleCloud.CalculatorPage;
import pages.pagesGoogleCloud.GoogleCloudHomePage;
import pages.pagesGoogleCloud.SearchPage;
import pages.pagesPastebin.HomePagePastebin;
import pages.yopmailPages.YopmailPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BrowserControl {

    public final static String PASTEBIN_URL = "https://pastebin.com/";
    public final static String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    public final static long WAIT_TIME = 20;

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
       // driver = DriverSingleton.getDriver();
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

        // DriverSingleton.closeDriver();
    }


    public HomePagePastebin homePage(){
        return new HomePagePastebin(driver);
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

    public YopmailPage yopmailPage(){
        return new YopmailPage(driver);
    }
}
