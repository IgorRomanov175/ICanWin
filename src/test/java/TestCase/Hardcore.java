package TestCase;

import Browser.BrowserControl;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.retry.Retry;


import java.util.ArrayList;


public class Hardcore extends BrowserControl {

    private final static String YOPMAIL_URL = "https://yopmail.com/uk/";
    String mailText = "AddMailForGoogleCloud6";

    ArrayList<String> tabs;

    @Test(
            retryAnalyzer = Retry.class
    )
    public void hardcore() throws InterruptedException {
        googleCloudHomePage().getDriver().get(GOOGLE_CLOUD_URL);
        googleCloudHomePage().searchFieldInput("Google Cloud Platform Pricing Calculator");
        searchPage().waitForClickableElement(WAIT_TIME, searchPage().getPricingLink());
        searchPage().pricingLinkClick();
        calculatorPage()
                .switchToFrame(calculatorPage().getFrame1())
                .switchToFrame(calculatorPage().getFrame2())
                .computeEngineClick()
                .setNumberOfInstances("4", WAIT_TIME)
                .setOperatingSystem(WAIT_TIME)
                .setSeries(WAIT_TIME)
                .setMachineType(WAIT_TIME)
                .addGPUclick(WAIT_TIME)
                .setGpuType(WAIT_TIME)
                .setNumOfGPU(WAIT_TIME)
                .setLocalSSD(WAIT_TIME)
                .setDatacenterLocation(WAIT_TIME)
                .setCommitmentLocation(WAIT_TIME)
                .clickEstimateButton()
                .switchToNewWindow(YOPMAIL_URL);

        yopmailPage()
                .addMail(mailText)
                .switchToPreviousTab();


        tabs = new ArrayList<>(yopmailPage().getDriver().getWindowHandles());
        yopmailPage().switchToWindow(tabs.get(0));

        calculatorPage()
                .switchToFrame(calculatorPage().getFrame1())
                .switchToFrame(calculatorPage().getFrame2())
                .mailButtonClick(WAIT_TIME)
                .setMailAddress(mailText, WAIT_TIME);

        yopmailPage().switchToWindow(tabs.get(1));
        Thread.sleep(10000);
        yopmailPage().refreshMailList();
        yopmailPage().getDriver().switchTo().frame(yopmailPage().getFrameMailList());
        Assert.assertEquals("Google Cloud Sales", yopmailPage().getMailTitle().getText());
        yopmailPage().getDriver().switchTo().defaultContent();
        yopmailPage().getDriver().switchTo().frame(yopmailPage().getFrameMailText());
        yopmailPage().waitForVisibilityOfElement(WAIT_TIME, yopmailPage().getTotalCost());
        Assert.assertTrue(yopmailPage().getTotalCost().getText().contains("Estimated Monthly Cost:"));

    }
}
