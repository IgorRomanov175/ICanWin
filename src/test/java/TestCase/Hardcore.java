package TestCase;

import Browser.BrowserControl;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;


public class Hardcore extends BrowserControl {

    String mailText = "AddMailForGoogleCloud6";

    @Test
    public void hardcore() throws InterruptedException {
        googleCloudHomePage().openPage(GOOGLE_CLOUD_URL);
        googleCloudHomePage().searchFieldInput("Google Cloud Platform Pricing Calculator");
        searchPage().waitForClickableElement(WAIT_TIME, searchPage().getPricingLink());
        searchPage().pricingLinkClick();
        calculatorPage().waitForPageLoadComplete(WAIT_TIME);
        driver().switchTo().frame(calculatorPage().getFrame1());
        driver().switchTo().frame(calculatorPage().getFrame2());
        calculatorPage().computeEngineClick();
        calculatorPage().getComputeEngine().getText();
        calculatorPage().waitForVisibilityOfElement(WAIT_TIME, calculatorPage().getNumberOfInstances());
        calculatorPage().setNumberOfInstances("4");
        calculatorPage().setOperatingSystem(WAIT_TIME);
        calculatorPage().scrollToElement(calculatorPage().getNumberOfInstances());
        calculatorPage().setSeries(WAIT_TIME);
        calculatorPage().setMachineType(WAIT_TIME);
        calculatorPage().addGPUclick(WAIT_TIME);
        calculatorPage().scrollToElement(calculatorPage().getSeriesSpan());
        calculatorPage().waitForVisibilityOfElement(WAIT_TIME, calculatorPage().getGpuTypeSpan());
        calculatorPage().setGpuType(WAIT_TIME);
        calculatorPage().setNumOfGPU(WAIT_TIME);
        calculatorPage().scrollToElement(calculatorPage().getAddGPU());
        calculatorPage().setLocalSSD(WAIT_TIME);
        calculatorPage().setDatacenterLocation(WAIT_TIME);
        calculatorPage().setCommitmentLocation(WAIT_TIME);
        calculatorPage().clickEstimateButton();
        driver().switchTo().newWindow(WindowType.TAB);
        driver().get("https://yopmail.com/uk/");
        yopmailHomePage().addMail(mailText);
        yopmailHomePage().switchToPreviousTab();
        ArrayList<String> tabs = new ArrayList<>(driver().getWindowHandles());
        driver().switchTo().window(tabs.get(0));
        driver().switchTo().frame(calculatorPage().getFrame1());
        driver().switchTo().frame(calculatorPage().getFrame2());
        calculatorPage().mailButtonClick(WAIT_TIME);
        calculatorPage().setMailAddress(mailText);
        driver().switchTo().window(tabs.get(1));
        Thread.sleep(10000);
        yopmailMailPage().refreshMailList();
        driver().switchTo().frame(yopmailMailPage().getFrameMailList());
        Assert.assertEquals("Google Cloud Sales", yopmailMailPage().getMailTitle().getText());
        driver().switchTo().defaultContent();
        driver().switchTo().frame(yopmailMailPage().getFrameMailText());
        yopmailMailPage().waitForVisibilityOfElement(WAIT_TIME, yopmailMailPage().getTotalCost());
        Assert.assertEquals("Estimated Monthly Cost: USD 4,024.56", yopmailMailPage().getTotalCost().getText());

    }
}
