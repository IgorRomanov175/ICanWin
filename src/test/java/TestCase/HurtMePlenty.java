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
        googleCloudHomePage().getDriver().get(GOOGLE_CLOUD_URL);
        googleCloudHomePage().searchFieldInput(SEARCH);


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
                .clickEstimateButton();


        Assert.assertEquals(vmClass, calculatorPage().getAssertVMClass().getText());
        Assert.assertEquals(instanceType, calculatorPage().getAssertInstanceType().getText());
        Assert.assertEquals(region, calculatorPage().getAssertRegion().getText());
        Assert.assertEquals(localSSD, calculatorPage().getAssertLocalSSD().getText());
        Assert.assertEquals(commitmentTerm, calculatorPage().getAssertCommitmentTerm().getText());
        Assert.assertEquals(totalCost, calculatorPage().getAssertTotalCost().getText());
    }
}
