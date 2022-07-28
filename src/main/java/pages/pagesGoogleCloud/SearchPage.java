package pages.pagesGoogleCloud;

import pages.basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchPage extends BasePage {

    @FindBy(xpath = "//a/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement pricingLink;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void pricingLinkClick(){
        pricingLink.click();
    }

}
