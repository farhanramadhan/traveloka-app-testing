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
import java.util.List;

public class automation {

    public static final int TIME_LIMIT = 2;

    public static void main(String args[]) throws MalformedURLException {

        String fromDestination = "Jakarta (JKTA)";
        String toDestination = "Surabaya (SUB)";

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

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/image_view_product_icon")));
        MobileElement FlightsButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.ImageView[@bounds='[42,489][174,621]']"));
        FlightsButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
        MobileElement FromButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,516][996,636]']"));
        FromButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_geo_name")));
        MobileElement JakartaChoiceButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[48,398][446,463]']"));
        JakartaChoiceButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));

        // Assert From City
        Assert.assertEquals(FromButton.getText(), fromDestination);

        MobileElement ToButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,756][996,876]']"));
        ToButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_geo_name")));
        MobileElement SurabayaChoiceButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[48,557][482,622]']"));
        SurabayaChoiceButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));

        // Assert To Destination City
        Assert.assertEquals(ToButton.getText(), toDestination);

        MobileElement DepartureDateButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,996][996,1116]']"));
        DepartureDateButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/info_top_text_view")));
        List<AndroidElement> elements = driver.findElements(By.xpath ("//android.widget.TextView[@bounds='[503,796][577,840]']/../*"));
        int indexDate = Integer.parseInt(elements.get(1).getAttribute("text"));
        indexDate += 1;
        String choosenIndexDate = Integer.toString(indexDate);
        indexDate += 1;
        String choosenDate = Integer.toString(indexDate);

//        while (!(elementExist(driver, 3, "com.traveloka.android:id/widgetView")));
        MobileElement theDayAfterTommorowDate = (MobileElement) driver.findElement(By.xpath ("//android.widget.RelativeLayout[@index='" + choosenIndexDate + "']"));
        theDayAfterTommorowDate.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));

        // Assert Chosen Date
        Assert.assertTrue(DepartureDateButton.getText().contains(choosenDate));
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
        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_continue")));
        MobileElement el2 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_continue");
        el2.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_skip")));
        MobileElement el3 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_skip");
        el3.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_skip")));
        MobileElement el4 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_skip");
        el4.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_tooltip_ok")));
        MobileElement el6 = (MobileElement) driver.findElementById("com.traveloka.android:id/text_view_tooltip_ok");
        el6.click();
    }
}