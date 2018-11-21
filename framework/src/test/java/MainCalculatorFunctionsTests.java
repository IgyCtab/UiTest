
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

import java.net.MalformedURLException;

public class MainCalculatorFunctionsTests {
    AndroidDriver<AndroidElement> driver;

    @BeforeClass
    public void setupDriver() throws MalformedURLException {
        DesiredCapabilitiesSettings.start();
        driver = DesiredCapabilitiesSettings.setUp();
    }

    @Test
    public void openAppAndVerifyAllNeededElementsPresent() {
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.isFormulaWindowPresent());
        Assert.assertTrue(mainPage.isFormulaWindowEmpty());
        Assert.assertTrue(mainPage.isAdditionalTabPresent());
        Assert.assertTrue(mainPage.isMoreOptionsButtonPresent());
        Assert.assertEquals(mainPage.getCountOfArithmeticSymbols(), 5);
        Assert.assertEquals(mainPage.getCountOfNumbersOnMenu(), 12);

    }

    @Test
    public void verifyPlusCalculatorFunctionWithInteger() {
        String firstNumberForTest = "1";
        String secondNumberForTest = "2";
        String plus = "+";
        String is = "=";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest);

        mainPage.clickNeededLogicalOperation(plus);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + plus);

        mainPage.clickNeededNumber(secondNumberForTest);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + plus + secondNumberForTest);

        mainPage.clickNeededNumber(is);
        Assert.assertEquals(mainPage.getResult(), "3");

        mainPage.clickNeededLogicalOperation("CLR");

    }

    @Test
    public void verifyMinusCalculatorFunctionWithInteger() {
        String firstNumberForTest = "2";
        String secondNumberForTest = "1";
        String minus = "−";
        String is = "=";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest);

        mainPage.clickNeededLogicalOperation(minus);

        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + minus);
        mainPage.clickNeededNumber(secondNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + minus + secondNumberForTest);
        mainPage.clickNeededNumber(is);

        Assert.assertEquals(mainPage.getResult(), "1");
        mainPage.clickNeededLogicalOperation("CLR");

    }

    @Test
    public void verifyMultiplyCalculatorFunctionWithInteger() {
        String firstNumberForTest = "2";
        String secondNumberForTest = "1";
        String minus = "×";
        String is = "=";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest);

        mainPage.clickNeededLogicalOperation(minus);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + minus);

        mainPage.clickNeededNumber(secondNumberForTest);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + minus + secondNumberForTest);

        mainPage.clickNeededNumber(is);
        Assert.assertEquals(mainPage.getResult(), "2");

        mainPage.clickNeededLogicalOperation("CLR");

    }

    @Test
    public void verifyDivideCalculatorFunctionWithInteger() {
        String firstNumberForTest = "2";
        String secondNumberForTest = "1";
        String minus = "÷";
        String is = "=";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest);

        mainPage.clickNeededLogicalOperation(minus);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + minus);

        mainPage.clickNeededNumber(secondNumberForTest);
        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + minus + secondNumberForTest);

        mainPage.clickNeededNumber(is);
        Assert.assertEquals(mainPage.getResult(), "2");

        mainPage.clickNeededLogicalOperation("CLR");

    }

    @Test
    public void verifyPlusCalculatorFunctionWithDouble() {
        String firstNumberForTest = "1";
        String secondNumberForTest = "2";
        String plus = "+";
        String is = "=";
        String point = ".";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(firstNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + point + firstNumberForTest);

        mainPage.clickNeededLogicalOperation(plus);

        Assert.assertEquals(mainPage.getFormulaWindowValue(),
                firstNumberForTest + point + firstNumberForTest + plus);

        mainPage.clickNeededNumber(secondNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(secondNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(),
                firstNumberForTest + point + firstNumberForTest + plus +
                        secondNumberForTest + point + secondNumberForTest);

        mainPage.clickNeededNumber(is);

        Assert.assertEquals(mainPage.getResult(), "3.3");

        mainPage.clickNeededLogicalOperation("CLR");

    }

    @Test
    public void verifyMinusCalculatorFunctionWithDouble() {
        String firstNumberForTest = "2";
        String secondNumberForTest = "1";
        String minus = "−";
        String is = "=";
        String point = ".";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(firstNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + point + firstNumberForTest);

        mainPage.clickNeededLogicalOperation(minus);

        Assert.assertEquals(mainPage.getFormulaWindowValue(),
                firstNumberForTest + point + firstNumberForTest + minus);

        mainPage.clickNeededNumber(secondNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(secondNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(),
                firstNumberForTest + point + firstNumberForTest
                        + minus + secondNumberForTest + point + secondNumberForTest);

        mainPage.clickNeededNumber(is);

        Assert.assertEquals(mainPage.getResult(), "1.1");

        mainPage.clickNeededLogicalOperation("CLR");

    }

    @Test
    public void verifyMultiplyCalculatorFunctionWithDouble() {
        String firstNumberForTest = "2";
        String secondNumberForTest = "1";
        String minus = "×";
        String is = "=";
        String point = ".";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(firstNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + point + firstNumberForTest);

        mainPage.clickNeededLogicalOperation(minus);

        Assert.assertEquals(mainPage.getFormulaWindowValue(),
                firstNumberForTest + point + firstNumberForTest + minus);

        mainPage.clickNeededNumber(secondNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(secondNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(),
                firstNumberForTest + point + firstNumberForTest + minus
                        + secondNumberForTest + point + secondNumberForTest);

        mainPage.clickNeededNumber(is);

        Assert.assertEquals(mainPage.getResult(), "2.42");

        mainPage.clickNeededLogicalOperation("CLR");

    }

    @Test
    public void verifyDivideCalculatorFunctionWithDouble() {
        String firstNumberForTest = "2";
        String secondNumberForTest = "1";
        String minus = "÷";
        String is = "=";
        String point = ".";
        MainPage mainPage = new MainPage(driver);

        mainPage.clickNeededNumber(firstNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(firstNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + point + firstNumberForTest);

        mainPage.clickNeededLogicalOperation(minus);

        Assert.assertEquals(mainPage.getFormulaWindowValue(), firstNumberForTest + point + firstNumberForTest + minus);

        mainPage.clickNeededNumber(secondNumberForTest)
                .clickNeededNumber(point)
                .clickNeededNumber(secondNumberForTest);

        Assert.assertEquals(mainPage.getFormulaWindowValue(),
                firstNumberForTest + point + firstNumberForTest + minus +
                        secondNumberForTest + point + secondNumberForTest);

        mainPage.clickNeededNumber(is);

        Assert.assertEquals(mainPage.getResult(), "2");

        mainPage.clickNeededLogicalOperation("CLR");

    }

    @AfterClass
    public void stopServer() {
        DesiredCapabilitiesSettings.stopServer();
    }

}
