import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdditionalTab;
import pages.MainPage;

import java.net.MalformedURLException;

public class AdditionalFunctionsTests {
    AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public void setupDriver() throws MalformedURLException {
        DesiredCapabilitiesSettings.start();
        driver = DesiredCapabilitiesSettings.setUp();
    }

    @Test
    public void verifyMoreOptionsTabElementsPresentAndClickable() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openMoreOptionsTab();

        Assert.assertTrue(mainPage.isMoreOptionsWindowDisplayed());
        Assert.assertEquals(mainPage.getCountOfMoreOptionsTabElements(), 3);

        mainPage.openHistoryTab();
        Assert.assertTrue(mainPage.isHistoryPageTitleDisplayed());

        mainPage.goBack();
        mainPage.openMoreOptionsTab();
        mainPage.openSendFeedbackTab();
        Assert.assertTrue(mainPage.isSendFeedbackPageTitleDisplayed());

        mainPage.goBack();
        mainPage.goBack();
        mainPage.openMoreOptionsTab();
        mainPage.openHelpTab();
        Assert.assertTrue(mainPage.isHelpPageTitleDisplayed());

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
        AdditionalTab additionalTab = new AdditionalTab(driver);

        mainPage.clickNeededNumber(firstNumber)
                .clickNeededNumber(secondNumber)
                .openAdditionalTab();
        additionalTab
                .clickNeededLogicalOperation(exponentiation)
                .goBack();
        mainPage.
                clickNeededNumber(degree)
                .clickNeededNumber(is);

        Assert.assertEquals(mainPage.getResult(), "625");

        mainPage.clickNeededLogicalOperation(clean);
    }

    @AfterClass
    public void stopServer() {
        DesiredCapabilitiesSettings.stopServer();
    }
}