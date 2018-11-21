package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class AdditionalTab extends BasePage {

    public AdditionalTab(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public int getCountOfAdditionalTabElements() {
        List<AndroidElement> additionalTabElements = driver.findElements(By.xpath("//*[@resource-id='com.google.android.calculator:id/pad_advanced']//*[@package='com.google.android.calculator']"));
        return additionalTabElements.size();
    }

    public AdditionalTab clickNeededLogicalOperation(String value) {
        driver.findElementByXPath("//*[@resource-id='com.google.android.calculator:id/pad_advanced']/*[@text='" + value + "']").click();
        return this;
    }


}
