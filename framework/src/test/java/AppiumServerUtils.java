import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumServerUtils {
    
    private static AppiumDriverLocalService service;
    private static AppiumServiceBuilder builder;
    private static DesiredCapabilities cap;

    public static void start() {

        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

    }

    public static AndroidDriver<AndroidElement> setUp() throws MalformedURLException {
        File f = new File("src");
        File fs = new File(f, "Сalculator.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5x");

        desiredCapabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }

    public static void stopServer() {
        service.stop();
    }
}
