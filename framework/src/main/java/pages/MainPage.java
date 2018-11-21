package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "formula")
    private AndroidElement formulaWindow;
    @AndroidFindBy(id = "result")
    private AndroidElement result;
    @AndroidFindBy(xpath = "//*[@content-desc='More options']")
    private AndroidElement moreOptionsButton;
    @AndroidFindBy(xpath = "//*[@class='android.widget.ListView']")
    private AndroidElement moreOptionsWindow;
    @AndroidFindBy(xpath = "//*[@text='History']")
    private AndroidElement history;
    @AndroidFindBy(xpath = "//*[@text='Send feedback']")
    private AndroidElement sendFeedback;
    @AndroidFindBy(xpath = "//*[@text='Help']")
    private AndroidElement help;
    @AndroidFindBy(id = "pad_advanced")
    private AndroidElement additionalTabButton;
    @AndroidFindBy(xpath = "//*[@text='Feedback']")
    private AndroidElement sendFeedbackPageTitle;

    private List<AndroidElement> logicFields = driver.findElements(By.xpath("//*[@resource-id='com.google.android.calculator:id/pad_operator']/android.widget.Button"));

    private List<AndroidElement> numberFields = driver.findElements(By.xpath("//*[@resource-id='com.google.android.calculator:id/pad_numeric']/android.widget.Button"));

    public MainPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public MainPage clickNeededNumber(String value) {
        driver.findElementByXPath("//*[@resource-id='com.google.android.calculator:id/pad_numeric']//*[@text='" + value + "']").click();
        return this;
    }

    public MainPage clickNeededLogicalOperation(String value) {
        driver.findElementByXPath("//*[@resource-id='com.google.android.calculator:id/pad_operator']/*[@text='" + value + "']").click();
        return this;
    }

    public long getCountOfArithmeticSymbols() {
        return logicFields.stream().count();
    }

    public int getCountOfNumbersOnMenu() {
        return numberFields.size();
    }

    public boolean isFormulaWindowEmpty() {
        if (formulaWindow.getText().isEmpty()) return true;
        else return false;
    }

    public boolean isFormulaWindowPresent() {
        if (formulaWindow.isDisplayed()) return true;
        else return false;
    }

    public boolean isAdditionalTabPresent() {
        if (additionalTabButton.isDisplayed()) return true;
        else return false;
    }

    public boolean isMoreOptionsButtonPresent() {
        if (moreOptionsButton.isDisplayed()) return true;
        else return false;
    }

    public boolean isMoreOptionsWindowDisplayed() {
        if (moreOptionsWindow.isDisplayed()) return true;
        return false;
    }

    public MainPage openMoreOptionsTab() {
        moreOptionsButton.click();
        waitUntilVisible(moreOptionsWindow);
        return this;
    }

    public String getFormulaWindowValue() {
        return formulaWindow.getText();
    }

    public String getResult() {
        return result.getText();
    }

    public int getCountOfMoreOptionsTabElements() {
        List<AndroidElement> moreOptionsElements = driver.findElements(By.xpath("//*[@class='android.widget.ListView']//*[@class='android.widget.RelativeLayout']"));
        return moreOptionsElements.size();
    }

    public MainPage openAdditionalTab() {
        additionalTabButton.click();
        return this;
    }

    public MainPage openHistoryTab() {
        history.click();
        return this;
    }

    public MainPage openSendFeedbackTab() {
        sendFeedback.click();
        return this;
    }

    public MainPage openHelpTab() {
        help.click();
        return this;
    }

    public boolean isHelpPageTitleDisplayed() {
        if (help.isDisplayed()) return true;
        return false;
    }

    public boolean isHistoryPageTitleDisplayed() {
        if (history.isDisplayed()) return true;
        return false;
    }

    public boolean isSendFeedbackPageTitleDisplayed() {
        if (sendFeedbackPageTitle.isDisplayed()) return true;
        return false;
    }
}