import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sections.AdditionalTab;
import pages.MainPage;
import sections.MoreOptionsTab;
import sections.NumbersSection;

import java.net.MalformedURLException;

public class AdditionalFunctionsTests {
    AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public void setupDriver() throws MalformedURLException {
        AppiumServerUtils.start();
        driver = AppiumServerUtils.setUp();
    }

    @Test
    public void verifyMoreOptionsTabElementsPresentAndClickable() {

        MainPage mainPage = new MainPage(driver);
        MoreOptionsTab moreOptionsTab = new MoreOptionsTab(driver);
        mainPage.openMoreOptionsTab();

        Assert.assertTrue(mainPage.isMoreOptionsWindowDisplayed());
        Assert.assertEquals(moreOptionsTab.getCountOfMoreOptionsTabElements(), 3);

        moreOptionsTab.openHistoryTab();
        Assert.assertTrue(moreOptionsTab.isHistoryPageTitleDisplayed());

        mainPage.goBack();
        mainPage.openMoreOptionsTab();
        moreOptionsTab.openSendFeedbackTab();
        Assert.assertTrue(moreOptionsTab.isSendFeedbackPageTitleDisplayed());

        mainPage.goBack();
        mainPage.goBack();
        mainPage.openMoreOptionsTab();
        moreOptionsTab.openHelpTab();
        Assert.assertTrue(moreOptionsTab.isHelpPageTitleDisplayed());

        mainPage.goBack();
    }

    @Test
    public void verifyExponentiationFunction() {

        String firstNumber = "2";
        String secondNumber = "5";
        String degree = "2";
        String exponentiation = "^";
        String is = "=";
        String clean = "CLR";

        MainPage mainPage = new MainPage(driver);
        NumbersSection numbersSection = new NumbersSection(driver);
        AdditionalTab additionalTab = new AdditionalTab(driver);

        numbersSection.clickNeededNumber(firstNumber)
                .clickNeededNumber(secondNumber);
        mainPage.openAdditionalTab();
        additionalTab
                .clickNeededAdditionalLogicalOperation(exponentiation)
                .goBack();
        numbersSection.
                clickNeededNumber(degree)
                .clickNeededNumber(is);

        Assert.assertEquals(mainPage.getResult(), "625");

        mainPage.clickNeededLogicalOperation(clean);
    }

    @AfterClass
    public void stopServer() {
        AppiumServerUtils.stopServer();
    }
}