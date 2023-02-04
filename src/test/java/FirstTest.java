import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformVersion", "9.0");
        cap.setCapability("deviceName", "Android Emulator");
        cap.setCapability("app", System.getProperty("user.dir") + "/ApiDemos.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
    }

    @Test
    public void clickAppButton() {
        MobileElement el = (MobileElement) driver.findElementByAccessibilityId("App");
        el.click();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
