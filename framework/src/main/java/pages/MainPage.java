package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

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
    @AndroidFindBy(id = "pad_advanced")
    private AndroidElement additionalTabButton;

    private List<AndroidElement> logicFields = driver.findElements(By.xpath("//*[@resource-id='com.google.android.calculator:id/pad_operator']/android.widget.Button"));

    public MainPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public MainPage clickNeededLogicalOperation(String value) {
        driver.findElementByXPath("//*[@resource-id='com.google.android.calculator:id/pad_operator']/*[@text='" + value + "']").click();
        return this;
    }

    public long getCountOfArithmeticSymbols() {
        return logicFields.size();
    }

    public boolean isFormulaWindowEmpty() {
        return formulaWindow.getText().isEmpty();
    }

    public boolean isFormulaWindowPresent() {
        return formulaWindow.isDisplayed();
    }

    public boolean isAdditionalTabPresent() {
        return additionalTabButton.isDisplayed();
    }

    public boolean isMoreOptionsButtonPresent() {
        return moreOptionsButton.isDisplayed();
    }

    public boolean isMoreOptionsWindowDisplayed() {
        return moreOptionsWindow.isDisplayed();
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

    public MainPage openAdditionalTab() {
        additionalTabButton.click();
        return this;
    }
}