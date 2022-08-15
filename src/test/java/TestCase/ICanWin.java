package TestCase;

import Browser.BrowserControl;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tools.retry.Retry;


public class ICanWin extends BrowserControl {

    String code = "Hello from WebDriver";
    String title = "helloweb";

    @Test(
            retryAnalyzer = Retry.class
    )
    public void iCanWin(){
        homePage()
                .openURL(PASTEBIN_URL)
                .closeAdd()
                .codeFieldInsert(code)
                .pasteExpiration10Minutes(WAIT_TIME)
                .setPasteName(title)
                .createNewPasteClick();
    }

}
