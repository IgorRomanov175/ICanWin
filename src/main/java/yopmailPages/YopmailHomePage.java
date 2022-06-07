package yopmailPages;

import basePage.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailHomePage extends BasePage {

    @FindBy(xpath = "//input[@class='ycptinput']")
    private WebElement addNewMail;

    public YopmailHomePage(WebDriver driver) {
        super(driver);
    }

    public void addMail(String text){
        addNewMail.sendKeys(text, Keys.ENTER);
    }

}
