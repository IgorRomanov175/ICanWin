package TestCase;

import BrowserConfig.BrowserControl;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataReader;

public class BringItOn extends BrowserControl {

    private final static String CODE = "BringItOn.test.data.code";

    private final static String TITLE = "BringItOn.test.data.title";

//    @Test
    public void bringItOn() {

        homePage()
                .openURL(PASTEBIN_URL)
                .closeAdd()
                .codeFieldInsert(TestDataReader.getTestData(CODE))
                .setSyntaxHighlightingBash(WAIT_TIME)
                .pasteExpiration10Minutes(WAIT_TIME)
                .setPasteName(TestDataReader.getTestData(TITLE))
                .createNewPasteClick()
                .waitForVisibilityOfElement(WAIT_TIME, homePage().getBashTag());


        Assert.assertTrue(homePage().getDriver().getTitle().contains(TestDataReader.getTestData(TITLE)));
        Assert.assertTrue(homePage().getBashTegText().contains("Bash"));
        Assert.assertEquals(homePage().getTextareaWithCode().getText(), TestDataReader.getTestData(CODE));
    }

}
