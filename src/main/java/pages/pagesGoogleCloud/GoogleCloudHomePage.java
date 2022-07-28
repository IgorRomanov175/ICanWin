package pages.pagesGoogleCloud;

import pages.basePage.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchField;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchFieldInput(String text){
        searchField.click();
        searchField.sendKeys(text, Keys.ENTER);
    }

}
