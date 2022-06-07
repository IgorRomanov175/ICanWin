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
        homePage().openPage(PASTEBIN_URL);
        homePage().codeFieldInsert(CODE);
        homePage().scrollToElement(homePage().getCodeField());
        homePage().setSyntaxHighlightingBash(WAIT_TIME);
        homePage().pasteExpiration10Minutes(WAIT_TIME);
        homePage().scrollToElement(homePage().getPasteName());
        homePage().setPasteName(TITLE);
        homePage().scrollToElement(homePage().getCreateNewPaste());
        homePage().createNewPasteClick();
        resultPage().waitForVisibilityOfElement(WAIT_TIME, resultPage().getBashTag());
        Assert.assertTrue(driver().getTitle().contains(TITLE));
        Assert.assertTrue(resultPage().getBashTegText().contains("Bash"));
        Assert.assertEquals(resultPage().getTextareaWithCode().getText(), CODE);
    }

}
