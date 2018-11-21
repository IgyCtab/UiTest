package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected AndroidDriver<AndroidElement> driver;

    protected BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public BasePage goBack() {
        driver.navigate().back();
        return this;
    }

    protected void waitUntilVisible(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}