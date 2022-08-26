package BrowserConfig;


import org.testng.annotations.Listeners;
import tools.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.pagesGoogleCloud.CalculatorPage;
import pages.pagesGoogleCloud.GoogleCloudHomePage;
import pages.pagesGoogleCloud.SearchPage;
import pages.pagesPastebin.HomePagePastebin;
import pages.yopmailPages.YopmailPage;
import utils.TestListener;

@Listeners({TestListener.class})
public class BrowserControl {

    public final static String PASTEBIN_URL = "https://pastebin.com/";
    public final static String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    public final static long WAIT_TIME = 20;

    private static WebDriver driver;


    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser){
        driver = DriverSingleton.getDriver(browser);
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

    public static WebDriver returnDriver(){
        return driver;
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
