import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class automation {

    public static final int TIME_LIMIT = 1;

    public static void main(String args[]) throws MalformedURLException {

        // Expected Value
        final String fromDestination = "Jakarta (JKTA)";
        final String toDestination = "Surabaya (SUB)";

        final String NameContactDetails = "Jidapa Ornec";
        final String MobileNumberContactDetails = "81234314123";
        final String EmailContactDetails = "JidapaOrc1241321@gmail.com";

        final String AdultName = "Jimmy Hendrix";

        final String ChildName = "adelyn rihana";
        final String ChildBirth = "2 March 2010";

        final String InfantName = "ray marco";
        final String InfantBirth = "10 April 2019";

        DesiredCapabilities dc = new DesiredCapabilities();
        setCapability(dc);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);


        InitialChooseLanguage(driver);

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/image_view_product_icon")));
        MobileElement FlightsButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.ImageView[@bounds='[42,489][174,621]']"));
        FlightsButton.click();

//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
//        MobileElement FromButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,516][996,636]']"));
//        FromButton.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_geo_name")));
//        MobileElement JakartaChoiceButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[48,398][446,463]']"));
//        JakartaChoiceButton.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
//
//        // Assert From City
//        Assert.assertEquals(FromButton.getText(), fromDestination);
//
//        MobileElement ToButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,756][996,876]']"));
//        ToButton.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_geo_name")));
//        MobileElement SurabayaChoiceButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[48,557][482,622]']"));
//        SurabayaChoiceButton.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
//
//        // Assert To Destination City
//        Assert.assertEquals(ToButton.getText(), toDestination);
//
//        MobileElement DepartureDateButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,996][996,1116]']"));
//        DepartureDateButton.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/info_top_text_view")));
//        List<AndroidElement> elements = driver.findElements(By.xpath ("//android.widget.TextView[@bounds='[503,796][577,840]']/../*"));
//        int indexDate = Integer.parseInt(elements.get(1).getAttribute("text"));
//
//        indexDate += 1;
//        String choosenIndexDate = Integer.toString(indexDate);
//        indexDate += 1;
//        String choosenDate = Integer.toString(indexDate);
//
//        MobileElement theDayAfterTommorowDate = (MobileElement) driver.findElement(By.xpath ("//android.widget.RelativeLayout[@index='" + choosenIndexDate + "']"));
//        theDayAfterTommorowDate.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
//        // Assert Chosen Date
//        Assert.assertTrue(DepartureDateButton.getText().contains(choosenDate));

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
        MobileElement Passengers = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,1237][516,1357]']"));
        Passengers.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/wheel_passenger_adult")));

        swipe(driver, 542, 542, 1458, 1285);
        swipe(driver, 790, 790, 1458, 1285);

        MobileElement SelectButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='Select']"));
        SelectButton.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
//        MobileElement SeatClass = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@text='Economy']"));
//        SeatClass.click();
//
//        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/radio_button")));
//        MobileElement EconomyClass = (MobileElement) driver.findElement(By.xpath ("//android.widget.RadioButton[@bounds='[48,747][132,831]']"));
//        EconomyClass.click();
//
//        MobileElement DoneButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='DONE']"));
//        DoneButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/btn_search")));
        MobileElement SearchButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='Search']"));
        SearchButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/recycler_view_content")));
        List<AndroidElement> elements = driver.findElements(By.xpath ("//androidx.recyclerview.widget.RecyclerView[@bounds='[0,316][1080,1800]']/*"));
        MobileElement secondFlight = elements.get(3);
        secondFlight.click();

//        new TouchAction(driver).press(PointOption.point(576, 941)).release().perform();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_select"))){
            swipe(driver, 542, 542, 1458, 1285);
        };
        MobileElement selectButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='Select']"));
        selectButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/layout_empty")));
        MobileElement FillInContactDetails = (MobileElement) driver.findElement(By.xpath ("//android.widget.RelativeLayout[@content-desc='trip_booking_view_contactemptycontainer']"));
        FillInContactDetails.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_toolbar_title")));
        MobileElement FullName = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[48,291][1032,522]']"));
        FullName.sendKeys(NameContactDetails);

        MobileElement MobileNumber = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[360,570][1032,714]']"));
        MobileNumber.sendKeys(MobileNumberContactDetails);

        MobileElement Email = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[48,762][1032,945]']"));
        Email.sendKeys(EmailContactDetails);

        driver.hideKeyboard();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement Save = (MobileElement) driver.findElementById("com.traveloka.android:id/button_save");
        Save.click();

        swipe(driver, 542, 542, 1458, 400);

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/layout_empty")));
        MobileElement adultDetails = (MobileElement) driver.findElement(By.xpath ("//android.widget.RelativeLayout[@bounds='[24,1035][1056,1203]']"));
        adultDetails.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement TitleAdult = (MobileElement) driver.findElement(By.xpath ("//android.widget.Spinner[@bounds='[48,414][1032,573]']"));
        TitleAdult.click();

        while (!(elementExist(driver, TIME_LIMIT, "android:id/text1")));
        MobileElement MrChoice = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[60,504][1020,639]']"));
        MrChoice.click();

        MobileElement FullNameAdult = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[48,621][1032,804]']"));
        FullNameAdult.sendKeys(AdultName);

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement SaveAdult = (MobileElement) driver.findElementById("com.traveloka.android:id/button_save");
        SaveAdult.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/layout_empty")));
        MobileElement childDetails = (MobileElement) driver.findElement(By.xpath ("//android.widget.RelativeLayout[@bounds='[24,1227][1056,1395]']"));
        childDetails.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement TitleChild = (MobileElement) driver.findElement(By.xpath ("//android.widget.Spinner[@bounds='[48,414][1032,573]']"));
        TitleChild.click();

        while (!(elementExist(driver, TIME_LIMIT, "android:id/text1")));
        MobileElement MsChoice = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[60,639][1020,774]']"));
        MsChoice.click();

        MobileElement FullNameChild = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[48,621][1032,804]']"));
        FullNameChild.sendKeys(ChildName);

        MobileElement DateBirthChild = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[48,852][1032,1050]']"));
        DateBirthChild.sendKeys(ChildBirth);

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement SaveChild = (MobileElement) driver.findElementById("com.traveloka.android:id/button_save");
        SaveChild.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/layout_empty")));
        MobileElement infantDetails = (MobileElement) driver.findElement(By.xpath ("//android.widget.RelativeLayout[@bounds='[24,1419][1056,1587]']"));
        infantDetails.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement TitleInfant = (MobileElement) driver.findElement(By.xpath ("//android.widget.Spinner[@bounds='[48,414][1032,573]']"));
        TitleInfant.click();

        while (!(elementExist(driver, TIME_LIMIT, "android:id/text1")));
        MobileElement MrChoiceI = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[60,504][1020,639]']"));
        MrChoiceI.click();

        MobileElement FullNameInfant = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[48,621][1032,804]']"));
        FullNameInfant.sendKeys(InfantName);

        MobileElement DateBirthInfant = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[48,852][1032,1050]']"));
        DateBirthInfant.sendKeys(InfantBirth);

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement SaveInfant = (MobileElement) driver.findElementById("com.traveloka.android:id/button_save");
        SaveInfant.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_see_below_view")));
        MobileElement CONTINUE = (MobileElement) driver.findElementById("com.traveloka.android:id/text_view_see_below_view");
        CONTINUE.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_continue")));
        MobileElement Continue = (MobileElement) driver.findElementById("com.traveloka.android:id/button_continue");
        Continue.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widget_button_blue")));
        MobileElement YesContinue = (MobileElement) driver.findElementById("com.traveloka.android:id/widget_button_blue");
        YesContinue.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_toolbar_title")));
        MobileElement SelectPaymentMethod = (MobileElement) driver.findElementById("com.traveloka.android:id/text_view_toolbar_title");
        SelectPaymentMethod.getText();
        System.out.println("THE END" + " " + SelectPaymentMethod.getText());
    }

    public static void swipe(AndroidDriver driver ,int startX, int endX, int startY, int endY) {
        try {
            new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX, endY)).release().perform();
        } catch (Exception e) {
            System.out.println("unable to swipe");
        }
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