package sections;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.List;

public class NumbersSection extends BasePage {

    private List<AndroidElement> numberFields = driver.findElements(By.xpath("//*[@resource-id='com.google.android.calculator:id/pad_numeric']/android.widget.Button"));

    public NumbersSection(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public int getCountOfNumbersOnMenu() {
        return numberFields.size();
    }

    public NumbersSection clickNeededNumber(String value) {
        driver.findElementByXPath("//*[@resource-id='com.google.android.calculator:id/pad_numeric']//*[@text='" + value + "']").click();
        return this;
    }
}