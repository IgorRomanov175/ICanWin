package pages.yopmailPages;

import org.openqa.selenium.Keys;
import pages.basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class YopmailPage extends BasePage {

    @FindBy(xpath = "//span[text()='Google Cloud Sales']")
    private WebElement mailTitle;

    @FindBy(xpath = "//h2[text()='Estimated Monthly Cost: USD 4,024.56']")
    private WebElement totalCost;

    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refresh;

    @FindBy(xpath = "//iframe[@id='ifinbox']")
    private WebElement frameMailList;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    private WebElement frameMailText;

    @FindBy(xpath = "//input[@class='ycptinput']")
    private WebElement addNewMail;

    public YopmailPage(WebDriver driver) {
        super(driver);
    }

    public YopmailPage addMail(String text){
        addNewMail.sendKeys(text, Keys.ENTER);
        return this;
    }

    public YopmailPage refreshMailList(){
        refresh.click();
        return this;
    }

    public YopmailPage switchToWindow(String window){
        getDriver().switchTo().window(window);
        return this;
    }

}
