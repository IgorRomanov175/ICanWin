package TestCase;

import Browser.BrowserControl;
import org.testng.annotations.Test;


public class ICanWin extends BrowserControl {

    String code = "Hello from WebDriver";
    String title = "helloweb";

    @Test
    public void iCanWin(){
        homePage()
                .openURL(PASTEBIN_URL)
                .codeFieldInsert(code)
                .pasteExpiration10Minutes(WAIT_TIME)
                .setPasteName(title)
                .createNewPasteClick();
    }

}
