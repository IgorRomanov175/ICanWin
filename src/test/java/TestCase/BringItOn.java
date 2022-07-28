package TestCase;

import Browser.BrowserControl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BringItOn extends BrowserControl {

    private final static String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    private final static String TITLE = "how to gain dominance among developers";

    @Test
    public void bringItOn() {

        homePage()
                .openURL(PASTEBIN_URL)
                .codeFieldInsert(CODE)
                .setSyntaxHighlightingBash(WAIT_TIME)
                .pasteExpiration10Minutes(WAIT_TIME)
                .setPasteName(TITLE)
                .createNewPasteClick()
                .waitForVisibilityOfElement(WAIT_TIME, homePage().getBashTag());


        Assert.assertTrue(homePage().getDriver().getTitle().contains(TITLE));
        Assert.assertTrue(homePage().getBashTegText().contains("Bash"));
        Assert.assertEquals(homePage().getTextareaWithCode().getText(), CODE);
    }

}
