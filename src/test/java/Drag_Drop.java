import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Drag_Drop {
    AppiumDriver driver;
    AndroidTouchAction actions;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("platformVersion","9.0");
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("app",System.getProperty("user.dir")+"/ApiDemos.apk");
        driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"),cap);
    }

    @Test
    public void DragDropTest() throws InterruptedException {
        MobileElement views = (MobileElement) driver.findElementByAccessibilityId("Views");
        actions=new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();

        AndroidElement dragDrop = (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
        actions.tap(ElementOption.element(dragDrop)).perform();

        MobileElement drag = (MobileElement) driver.findElementById("drag_dot_1");
        MobileElement drop = (MobileElement) driver.findElementById("drag_dot_2");
        actions.longPress(ElementOption.element(drag))
                .waitAction()
                .moveTo(ElementOption.element(drop))
                .release()
                .perform();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
