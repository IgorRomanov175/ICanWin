package TestCase;

import Browser.BrowserControl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HurtMePlenty extends BrowserControl {

    private final static String SEARCH = "Google Cloud Platform Pricing Calculator";

    String vmClass = "Compute Engine";
    String instanceType = "Instance type: n1-standard-8\nCommitted Use Discount applied";
    String region = "Region: Frankfurt";
    String localSSD = "Local SSD: 2x375 GiB\nCommitted Use Discount applied";
    String commitmentTerm = "Commitment term: 1 Year";
    String totalCost = "Total Estimated Cost: USD 4,024.56 per 1 month";

    @Test
    public void hurtMePlenty() {
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
        calculatorPage().setGpuType(WAIT_TIME);
        calculatorPage().setNumOfGPU(WAIT_TIME);
        calculatorPage().scrollToElement(calculatorPage().getAddGPU());
        calculatorPage().setLocalSSD(WAIT_TIME);
        calculatorPage().setDatacenterLocation(WAIT_TIME);
        calculatorPage().setCommitmentLocation(WAIT_TIME);
        calculatorPage().clickEstimateButton();
        Assert.assertEquals(vmClass, calculatorPage().getAssertVMClass().getText());
        Assert.assertEquals(instanceType, calculatorPage().getAssertInstanceType().getText());
        Assert.assertEquals(region, calculatorPage().getAssertRegion().getText());
        Assert.assertEquals(localSSD, calculatorPage().getAssertLocalSSD().getText());
        Assert.assertEquals(commitmentTerm, calculatorPage().getAssertCommitmentTerm().getText());
        Assert.assertEquals(totalCost, calculatorPage().getAssertTotalCost().getText());
    }
}
