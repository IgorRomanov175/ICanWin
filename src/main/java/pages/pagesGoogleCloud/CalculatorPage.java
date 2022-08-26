package pages.pagesGoogleCloud;

import org.openqa.selenium.WindowType;
import pages.basePage.BasePage;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class CalculatorPage extends BasePage {

    @FindBy(xpath = "//iframe[@src='https://cloud.google.com/products/calculator/index_d6a98ba38837346d20babc06ff2153b68c2990fa24322fe52c5f83ec3a78c6a0.frame?hl=sv']")
    private WebElement frame1;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frame2;

    @FindBy(xpath = "//div[text()='Compute Engine']")
    private WebElement computeEngine;



    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstances;



    @FindBy(xpath = "//label[contains(text() , 'Operating System / Software')]/following-sibling::md-select")
    private WebElement operatingSystemSpan;

    @FindBy(xpath = "//div[contains(text() , 'Free: Debian')]/parent::md-option/parent::md-content/md-option")
    private List<WebElement> operatingSystemAnswer;



    @FindBy(xpath = "//label[contains(text(), 'Series')]/following-sibling::md-select")
    private WebElement seriesSpan;

    @FindBy(xpath = "//div[contains(text(), 'N1')]/parent::md-option/parent::md-content/md-option")
    private List<WebElement> seriesAnswer;



    @FindBy(xpath = "//label[contains(text(), 'Machine type')]/following-sibling::md-select")
    private WebElement machineTypeSpan;

    @FindBy(xpath = "//label[contains(text(), 'standard')]/following-sibling::md-option")
    private List<WebElement> machineTypeAnswer;



    @FindBy(xpath = "(//div[@ng-transclude])[3]")
    private WebElement addGPU;



    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeSpan;

    @FindBy(xpath = "//div[contains(text(), 'NVIDIA Tesla K80')]/parent::md-option/parent::md-content/md-option")
    private List<WebElement> gpuTypeAnswer;



    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numOfGPUSpan;

    @FindBy(xpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU']")
    private List<WebElement> numOfGPUAnswer;



    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDSpan;

    @FindBy(xpath = "//div[contains(text(), '2x375')]/parent::md-option/parent::md-content/md-option")
    private List<WebElement> localSSDAnswer;



    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationSpan;

    @FindBy(xpath = "//md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']")
    private List<WebElement> datacenterLocationAnswer;



    @FindBy(xpath = "//md-select[@ng-disabled='listingCtrl.isCudDisabled']")
    private WebElement commitedLocationSpan;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='None']")
    private WebElement commitedLocationWaiter;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option")
    private List<WebElement> commitedLocationAnswer;


    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement estimateButton;


    @FindBy(xpath = "//md-content[@id='compute']//span[text()='Compute Engine']")
    private WebElement assertVMClass;

    @FindBy(xpath = "//sub[@ng-if='item.items.isInstanceCommitted']/parent::div/parent::div")
    private WebElement assertInstanceType;

    @FindBy(xpath = "(//md-list-item//div[@class='md-list-item-text ng-binding'])[1]")
    private WebElement assertRegion;

    @FindBy(xpath = "(//md-list-item//div[@class='md-list-item-text ng-binding'])[3]")
    private WebElement assertCommitmentTerm;

    @FindBy(xpath = "//sub[@ng-if='item.items.isSsdCommitted']/parent::div/parent::div")
    private WebElement assertLocalSSD;

    @FindBy(xpath = "//h2[@class='md-title']/b")
    private WebElement assertTotalCost;

    @FindBy(xpath = "//button[@ng-click='cloudCartCtrl.showEmailForm();']")
    private WebElement mailButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement mailAddress;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmail;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage switchToFrame(WebElement frame){
        waitForPageLoadComplete(WAIT_TIME);
        getDriver().switchTo().frame(frame);
        return this;
    }

    public CalculatorPage computeEngineClick(){
        computeEngine.click();
        return this;
    }

    public CalculatorPage setNumberOfInstances(String text, long time){
        waitForVisibilityOfElement(time, numberOfInstances);
        numberOfInstances.click();
        numberOfInstances.sendKeys(text);
        return this;

    }

    public CalculatorPage setOperatingSystem(long time){
        operatingSystemSpan.click();
        waitForVisibilityOfElement(time, operatingSystemAnswer.get(0));
        operatingSystemAnswer.get(0).click();
        scrollToElement(numberOfInstances);
        return this;
    }

    public CalculatorPage setSeries(long time) {
        scrollToElement(numberOfInstances);
        seriesSpan.click();
        waitForVisibilityOfElement(time, seriesAnswer.get(0));
        seriesAnswer.get(0).click();
        return this;
    }

    public CalculatorPage setMachineType(long time) {
        machineTypeSpan.click();
        waitForVisibilityOfElement(time, machineTypeAnswer.get(3));
        machineTypeAnswer.get(3).click();
        return this;
    }

    public CalculatorPage addGPUclick(long time){
        addGPU.click();
        waitForVisibilityOfElement(time, gpuTypeSpan);
        scrollToElement(seriesSpan);
        return this;
    }

    public CalculatorPage setGpuType(long time){
        gpuTypeSpan.click();
        waitForVisibilityOfElement(time, gpuTypeAnswer.get(1));
        gpuTypeAnswer.get(1).click();
        return this;
    }

    public CalculatorPage setNumOfGPU(long time){
        numOfGPUSpan.click();
        waitForVisibilityOfElement(time, numOfGPUAnswer.get(1));
        numOfGPUAnswer.get(1).click();
        scrollToElement(addGPU);
        return this;
    }

    public CalculatorPage setLocalSSD(long time){
        scrollToElement(addGPU);
        localSSDSpan.click();
        waitForVisibilityOfElement(time, localSSDAnswer.get(2));
        localSSDAnswer.get(2).click();
        return this;
    }

    public CalculatorPage setDatacenterLocation(long time){
        datacenterLocationSpan.click();
        waitForVisibilityOfElement(time, datacenterLocationAnswer.get(11));
        datacenterLocationAnswer.get(11).click();
        return this;
    }

    public CalculatorPage setCommitmentLocation(long time){
        waitForVisibilityOfElement(time, commitedLocationSpan);
        commitedLocationSpan.click();
        waitForVisibilityOfElement(time, commitedLocationWaiter);
        commitedLocationAnswer.get(1).click();
        return this;
    }

    public CalculatorPage clickEstimateButton(){
        estimateButton.click();
        return this;
    }

    public CalculatorPage mailButtonClick(long time){
        waitForVisibilityOfElement(time, mailButton);
        mailButton.click();
        return this;
    }

    public CalculatorPage setMailAddress(String mail, long time){
        mailAddress.click();
        mailAddress.sendKeys(mail + "@yopmail.com", Keys.ENTER);
        scrollToElement(mailAddress);
        sendEmail.click();
        return this;
    }

    public CalculatorPage switchToNewWindow(String url){
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get(url);
        return this;
    }

}
