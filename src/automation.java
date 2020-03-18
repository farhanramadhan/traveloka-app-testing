import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class automation {
    public static void main(String args[]) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        setCapability(dc);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);


        InitialChooseLanguage(driver);
//        MobileElement el1 = (MobileElement) driver.findElementById("e39493f9-4db5-49fd-a9d2-5c2ecc5d9c5f");
//        el1.click();

//        MobileElement el101 = driver.findElement(By.linkText("Indonesia (English)"));
//        el101.click();

//        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout");
//        el1.click();

        while (!(elementExist(driver, 5, "com.traveloka.android:id/image_view_product_icon")));
//        MobileElement el2 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_continue");
        MobileElement el2 = (MobileElement) driver.findElement(By.xpath ("//android.widget.ImageView[@bounds='[42,489][174,621]']"));
        el2.click();

//        MobileElement el10 = (MobileElement) driver.findElementByXPath("5ad3d6c6-330f-487e-bce0-e14269aee459");
//        el10.click();

//        Assert.assertEquals(ad.findElementById("com.android.calculator2:id/edittext_new").getText(), "3×9\n" + "=27");
    }

    public static MobileElement mobileElement;

    public static boolean elementExist(AndroidDriver driver, int timeLimitInSeconds, String targetResourceId){
        boolean isElementPresent;
        try{
            mobileElement =  (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+targetResourceId+"\")");
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        }catch(Exception e){
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        } }

    public static void setCapability(DesiredCapabilities dc) {
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "c923d41a");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.traveloka.android");
        dc.setCapability("appActivity", ".appentry.splash.SplashActivity");
    }

    public static void InitialChooseLanguage(AndroidDriver driver) {
        while (!(elementExist(driver, 5, "com.traveloka.android:id/text_continue")));
        MobileElement el2 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_continue");
        el2.click();

        while (!(elementExist(driver, 5, "com.traveloka.android:id/text_skip")));
        MobileElement el3 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_skip");
        el3.click();

        while (!(elementExist(driver, 5, "com.traveloka.android:id/text_skip")));
        MobileElement el4 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_skip");
        el4.click();

        while (!(elementExist(driver, 5, "com.traveloka.android:id/text_view_tooltip_ok")));
        MobileElement el6 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_view_tooltip_ok");
        el6.click();
    }
}