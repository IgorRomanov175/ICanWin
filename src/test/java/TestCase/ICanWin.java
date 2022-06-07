package TestCase;

import Browser.BrowserControl;
import dataProvide.DataProvide;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ICanWin extends BrowserControl {

    @Test
    @Parameters({"code", "title"})
    public void iCanWin(String code, String title){
        homePage().openPage(PASTEBIN_URL);
        homePage().codeFieldInsert(code);
        homePage().scrollToElement(homePage().getCodeField());
        homePage().pasteExpiration10Minutes(WAIT_TIME);
        homePage().scrollToElement(homePage().getPasteName());
        homePage().setPasteName(title);
        homePage().scrollToElement(homePage().getCreateNewPaste());
        homePage().createNewPasteClick();
    }

    @Test (dataProvider = "data-provider", dataProviderClass = DataProvide.class)
    public void myTest (String val) {
        System.out.println("Passed Parameter Is : " + val);
    }

}
