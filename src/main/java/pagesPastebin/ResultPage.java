package pagesPastebin;

import basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ResultPage extends BasePage {

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement bashTag;

    @FindBy(xpath = "//textarea")
    private WebElement textareaWithCode;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public String getBashTegText(){
        return getBashTag().getText();
    }

}
