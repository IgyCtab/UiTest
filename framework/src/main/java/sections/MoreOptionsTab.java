package sections;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;

public class MoreOptionsTab extends BasePage {

    @AndroidFindBy(xpath = "//*[@text='History']")
    private AndroidElement history;
    @AndroidFindBy(xpath = "//*[@text='Help']")
    private AndroidElement help;
    @AndroidFindBy(xpath = "//*[@text='Send feedback']")
    private AndroidElement sendFeedback;
    @AndroidFindBy(xpath = "//*[@text='Feedback']")
    private AndroidElement sendFeedbackPageTitle;

    public MoreOptionsTab(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public int getCountOfMoreOptionsTabElements() {
        List<AndroidElement> moreOptionsElements = driver.findElements(By.xpath("//*[@class='android.widget.ListView']//*[@class='android.widget.RelativeLayout']"));
        return moreOptionsElements.size();
    }

    public MoreOptionsTab openHistoryTab() {
        history.click();
        return this;
    }

    public MoreOptionsTab openSendFeedbackTab() {
        sendFeedback.click();
        return this;
    }

    public MoreOptionsTab openHelpTab() {
        help.click();
        return this;
    }

    public boolean isHelpPageTitleDisplayed() {
        return help.isDisplayed();
    }

    public boolean isHistoryPageTitleDisplayed() {
        return history.isDisplayed();
    }

    public boolean isSendFeedbackPageTitleDisplayed() {
        return sendFeedbackPageTitle.isDisplayed();
    }
}