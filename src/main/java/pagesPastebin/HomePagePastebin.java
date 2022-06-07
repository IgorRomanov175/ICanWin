package pagesPastebin;

import basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePagePastebin extends BasePage {

    @FindBy(xpath = "//textarea")
    private WebElement codeField;

    @FindBy(xpath = "//label[text()='Syntax Highlighting:']/following-sibling::div//span[@class='select2-selection__rendered']")
    private WebElement syntaxHighlightingSpan;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingAnswer;

    @FindBy(xpath = "//label[text()='Paste Expiration:']/following-sibling::div//span[@class='select2-selection__rendered']")
    private WebElement pasteExpirationSpan;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationAnswer;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPaste;

    public HomePagePastebin(WebDriver driver) {
        super(driver);
    }

    public void codeFieldInsert(String code){
        codeField.sendKeys(code);
    }

    public void pasteExpiration10Minutes(long time){
        pasteExpirationSpan.click();
        waitForClickableElement(time, pasteExpirationAnswer);
        pasteExpirationAnswer.click();
    }

    public void setSyntaxHighlightingBash(long time){
        syntaxHighlightingSpan.click();
        waitForClickableElement(time, syntaxHighlightingAnswer);
        syntaxHighlightingAnswer.click();
    }

    public void setPasteName(String name){
        pasteName.sendKeys(name);
    }

    public void createNewPasteClick(){
        createNewPaste.click();
    }

}
