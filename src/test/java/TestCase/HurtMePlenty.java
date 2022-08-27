package TestCase;

import BrowserConfig.BrowserControl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HurtMePlenty extends BrowserControl {

    private final static String SEARCH = "HurtMePlenty.test.data.search";

    String vmClass = "HurtMePlenty.test.data.vmClass";
    String instanceType = "HurtMePlenty.test.data.instanceType";
    String region = "HurtMePlenty.test.data.region";
    String localSSD = "HurtMePlenty.test.data.localSSD";
    String commitmentTerm = "HurtMePlenty.test.data.commitmentTerm";
    String totalCost = "HurtMePlenty.test.data.totalCost";

    @Test
    public void hurtMePlenty() throws InterruptedException {
        googleCloudHomePage().getDriver().get(GOOGLE_CLOUD_URL);
        googleCloudHomePage().searchFieldInput(getTestData(SEARCH));


        searchPage().waitForClickableElement(WAIT_TIME, searchPage().getPricingLink());
        searchPage().pricingLinkClick();


        calculatorPage()
                .switchToFrame(calculatorPage().getFrame1())
                .switchToFrame(calculatorPage().getFrame2())
                .computeEngineClick()
                .setNumberOfInstances("4")
                .setOperatingSystem()
                .setSeries()
                .setMachineType()
                .addGPUclick()
                .setGpuType()
                .setNumOfGPU()
                .setLocalSSD()
                .setDatacenterLocation()
                .setCommitmentLocation()
                .clickEstimateButton();


        Assert.assertEquals(getTestData(vmClass), calculatorPage().getAssertVMClass().getText());
        Assert.assertEquals(getTestData(instanceType), calculatorPage().getAssertInstanceType().getText());
        Assert.assertEquals(getTestData(region), calculatorPage().getAssertRegion().getText());
        Assert.assertEquals(getTestData(localSSD), calculatorPage().getAssertLocalSSD().getText());
        Assert.assertEquals(getTestData(commitmentTerm), calculatorPage().getAssertCommitmentTerm().getText());
        Assert.assertEquals(getTestData(totalCost), calculatorPage().getAssertTotalCost().getText());
    }
}
