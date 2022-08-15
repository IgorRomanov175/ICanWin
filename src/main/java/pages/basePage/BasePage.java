package pages.basePage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private final WebDriver driver;
    public final static long WAIT_TIME = 10;

    public BasePage(WebDriver driver) {
        this.driver =  driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToPreviousTab(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.TAB);
    }

    public void waitForPageLoadComplete(long waitTime) {
        new WebDriverWait(driver, Duration.ofSeconds(waitTime)).until
                (webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void waitForVisibilityOfElement(long waitTime, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickableElement(long waitTime, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(final WebElement element) {
        JavascriptExecutor je = ((JavascriptExecutor) driver);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
