package pages.pagesPastebin;

import pages.basePage.BasePage;
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

    @FindBy(xpath = "//a[text()='Bash']")
    private WebElement bashTag;

    @FindBy(xpath = "//textarea")
    private WebElement textareaWithCode;

    public HomePagePastebin(WebDriver driver) {
        super(driver);
    }

    public HomePagePastebin openURL(String url){
        getDriver().get(url);
        return this;
    }

    public HomePagePastebin codeFieldInsert(String code){
        codeField.sendKeys(code);
        return this;
    }

    public HomePagePastebin pasteExpiration10Minutes(long time){
        pasteExpirationSpan.click();
        waitForClickableElement(time, pasteExpirationAnswer);
        pasteExpirationAnswer.click();
        scrollToElement(codeField);
        return this;
    }

    public HomePagePastebin setSyntaxHighlightingBash(long time){
        syntaxHighlightingSpan.click();
        waitForClickableElement(time, syntaxHighlightingAnswer);
        syntaxHighlightingAnswer.click();
        return this;
    }

    public HomePagePastebin setPasteName(String name){
        pasteName.sendKeys(name);
        return this;
    }

    public HomePagePastebin createNewPasteClick(){
        createNewPaste.click();
        return this;
    }

    public void scrollToElement(WebElement element) {
        super.scrollToElement(element);
    }

    public String getBashTegText(){
        return getBashTag().getText();
    }
}
