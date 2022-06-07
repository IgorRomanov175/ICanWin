package yopmailPages;

import basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class YopmailMailPage extends BasePage {

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

    public YopmailMailPage(WebDriver driver) {
        super(driver);
    }

    public void refreshMailList(){
        refresh.click();
    }

}
