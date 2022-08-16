package TestCase;

import BrowserConfig.BrowserControl;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataReader;

public class HurtMePlenty extends BrowserControl {

    private final static String SEARCH = "HurtMePlenty.test.data.search";

    String vmClass = "HurtMePlenty.test.data.vmClass";
    String instanceType = "HurtMePlenty.test.data.instanceType";
    String region = "HurtMePlenty.test.data.region";
    String localSSD = "HurtMePlenty.test.data.localSSD";
    String commitmentTerm = "HurtMePlenty.test.data.commitmentTerm";
    String totalCost = "HurtMePlenty.test.data.totalCost";

    @Test
    public void hurtMePlenty() {
        googleCloudHomePage().getDriver().get(GOOGLE_CLOUD_URL);
        googleCloudHomePage().searchFieldInput(TestDataReader.getTestData(SEARCH));


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


        Assert.assertEquals(TestDataReader.getTestData(vmClass), calculatorPage().getAssertVMClass().getText());
        Assert.assertEquals(TestDataReader.getTestData(instanceType), calculatorPage().getAssertInstanceType().getText());
        Assert.assertEquals(TestDataReader.getTestData(region), calculatorPage().getAssertRegion().getText());
        Assert.assertEquals(TestDataReader.getTestData(localSSD), calculatorPage().getAssertLocalSSD().getText());
        Assert.assertEquals(TestDataReader.getTestData(commitmentTerm), calculatorPage().getAssertCommitmentTerm().getText());
        Assert.assertEquals(TestDataReader.getTestData(totalCost), calculatorPage().getAssertTotalCost().getText());
    }
}
