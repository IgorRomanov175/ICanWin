package TestCase;

import BrowserConfig.BrowserControl;


public class ICanWin extends BrowserControl {

    String code = "ICanWin.test.data.code";
    String title = "ICanWin.test.data.title";

//    @Test
    public void iCanWin(){
        homePage()
                .openURL(PASTEBIN_URL)
                .closeAdd()
                .codeFieldInsert(getTestData(code))
                .pasteExpiration10Minutes(WAIT_TIME)
                .setPasteName(getTestData(title))
                .createNewPasteClick();
    }

}
