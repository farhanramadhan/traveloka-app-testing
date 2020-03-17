import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class automation {
    public static void main(String args[]) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "c923d41a");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", ".Calculator");

        AndroidDriver<AndroidElement> ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        MobileElement el1 = (MobileElement) ad.findElementById("com.android.calculator2:id/digit3");
        // Calculator Freeze
        el1.click();
        el1.click();
        MobileElement el2 = (MobileElement) ad.findElementById("com.android.calculator2:id/mul");
        el2.click();
        MobileElement el3 = (MobileElement) ad.findElementById("com.android.calculator2:id/digit9");
        el3.click();
        MobileElement el4 = (MobileElement) ad.findElementById("com.android.calculator2:id/equal");
        el4.click();


        Assert.assertEquals(ad.findElementById("com.android.calculator2:id/edittext_new").getText(), "3×9\n" + "=27");
    }
}
