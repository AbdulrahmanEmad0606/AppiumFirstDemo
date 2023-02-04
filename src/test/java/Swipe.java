import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Swipe {
    AppiumDriver driver;
    AndroidTouchAction actions;

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
    public void swipeTest() throws InterruptedException {
        actions = new AndroidTouchAction(driver);
        AndroidElement views =
                (AndroidElement) driver.findElementByAccessibilityId("Views");
        actions.tap(ElementOption.element(views)).perform();
        AndroidElement gallery =
                (AndroidElement) driver.findElementByAccessibilityId("Gallery");
        actions.tap(ElementOption.element(gallery)).perform();
        AndroidElement photos =
                (AndroidElement) driver.findElementByAccessibilityId("1. Photos");
        actions.tap(ElementOption.element(photos)).perform();
        AndroidElement photo1 =
                (AndroidElement) driver.findElement(By.className("android.widget.ImageView"));
        actions.press(ElementOption.element(photo1))
                .waitAction()
                .moveTo(PointOption.point(-500, 210))
                .release().perform();


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
