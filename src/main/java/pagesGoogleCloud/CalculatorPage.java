package pagesGoogleCloud;

import basePage.BasePage;
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



    @FindBy(xpath = "//input[@id='input_85']")
    private WebElement numberOfInstances;



    @FindBy(xpath = "//md-select-value[@id='select_value_label_77']")
    private WebElement operatingSystemSpan;

    @FindBy(xpath = "//div[@id='select_container_99']//md-option/div")
    private List<WebElement> operatingSystemAnswer;



    @FindBy(xpath = "//md-select-value[@id='select_value_label_80']")
    private WebElement seriesSpan;

    @FindBy(xpath = "//div[@id='select_container_111']//md-option/div")
    private List<WebElement> seriesAnswer;



    @FindBy(xpath = "//md-select-value[@id='select_value_label_81']")
    private WebElement machineTypeSpan;

    @FindBy(xpath = "//div[@id='select_container_113']//md-option/div")
    private List<WebElement> machineTypeAnswer;



    @FindBy(xpath = "(//div[@ng-transclude])[2]")
    private WebElement addGPU;



    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeSpan;

    @FindBy(xpath = "//div[@id='select_container_454']//md-option/div")
    private List<WebElement> gpuTypeAnswer;



    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numOfGPUSpan;

    @FindBy(xpath = "//div[@id='select_container_456']//md-option/div")
    private List<WebElement> numOfGPUAnswer;



    @FindBy(xpath = "//md-select-value[@id='select_value_label_409']")
    private WebElement localSSDSpan;

    @FindBy(xpath = "//div[@id='select_container_411']//md-option/div")
    private List<WebElement> localSSDAnswer;



    @FindBy(xpath = "//md-select-value[@id='select_value_label_83']")
    private WebElement datacenterLocationSpan;

    @FindBy(xpath = "//div[@id='select_container_119']//md-option/div")
    private List<WebElement> datacenterLocationAnswer;



    @FindBy(xpath = "//md-select-value[@id='select_value_label_84']")
    private WebElement commitedLocationSpan;

    @FindBy(xpath = "//div[@id='select_container_126']//md-option/div")
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

    @FindBy(xpath = "//input[@id='input_530']")
    private WebElement mailAddress;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmail;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void computeEngineClick(){
        computeEngine.click();
    }

    public void setNumberOfInstances(String text){
        numberOfInstances.click();
        numberOfInstances.sendKeys(text);
    }

    public void setOperatingSystem(long time){
        operatingSystemSpan.click();
        waitForVisibilityOfElement(time, operatingSystemAnswer.get(0));
        operatingSystemAnswer.get(0).click();
    }

    public void setSeries(long time) {
        seriesSpan.click();
        waitForVisibilityOfElement(time, seriesAnswer.get(0));
        seriesAnswer.get(0).click();
    }

    public void setMachineType(long time) {
        machineTypeSpan.click();
        waitForVisibilityOfElement(time, machineTypeAnswer.get(6));
        machineTypeAnswer.get(6).click();
    }

    public void addGPUclick(long time){
        addGPU.click();
        waitForVisibilityOfElement(time, gpuTypeSpan);
    }

    public void setGpuType(long time){
        gpuTypeSpan.click();
        waitForVisibilityOfElement(time, gpuTypeAnswer.get(1));
        gpuTypeAnswer.get(1).click();
    }

    public void setNumOfGPU(long time){
        numOfGPUSpan.click();
        waitForVisibilityOfElement(time, numOfGPUAnswer.get(1));
        numOfGPUAnswer.get(1).click();
    }

    public void setLocalSSD(long time){
        localSSDSpan.click();
        waitForVisibilityOfElement(time, localSSDAnswer.get(2));
        localSSDAnswer.get(2).click();
    }

    public void setDatacenterLocation(long time){
        datacenterLocationSpan.click();
        waitForVisibilityOfElement(time, datacenterLocationAnswer.get(10));
        datacenterLocationAnswer.get(10).click();
    }

    public void setCommitmentLocation(long time){
        commitedLocationSpan.click();
        waitForVisibilityOfElement(time, commitedLocationAnswer.get(1));
        commitedLocationAnswer.get(1).click();
    }

    public void clickEstimateButton(){
        estimateButton.click();
    }

    public void mailButtonClick(long time){
        waitForVisibilityOfElement(time, mailButton);
        mailButton.click();
    }

    public void setMailAddress(String mail){
        mailAddress.sendKeys(mail + "@yopmail.com", Keys.ENTER);
        sendEmail.click();
    }

}
