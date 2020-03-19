import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.reflect.TypeUtilsTest;
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
        final String EmailContactDetails = "JidapaOrc3241321@gmail.com";

        final String AdultName = "Jimmy Hendrix";

        final String ChildName = "adelyn rihana";
        final String ChildDate = "2";
        final String ChildMonth = "Mar";
        final String ChildYear = "2010";

        final String InfantName = "ray marco";
        final String InfantDate = "10";
        final String InfantMonth = "Apr";
        final String InfantYear = "2019";

        // Setup Appium
        DesiredCapabilities dc = new DesiredCapabilities();
        setCapability(dc);

        // Setup Android
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        // Testing The App
        InitialChooseLanguage(driver);
        AssertOriginCity(driver, fromDestination);
        AssertDestinationCity(driver, toDestination);
        AssertDate(driver);
        AssertPassenger(driver);
        AssertFlightClass(driver);
        AssertChooseFlightSchedule(driver);
        AssertContactDetails(driver, NameContactDetails, MobileNumberContactDetails, EmailContactDetails);
        AssertAdult(driver, AdultName);
        AssertChild(driver, ChildName, ChildDate, ChildMonth, ChildYear);
        AssertInfant(driver, InfantName, InfantDate, InfantMonth, InfantYear);
        AssertFlightDetail(driver);
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

    public static void AssertOriginCity(AndroidDriver driver, String fromDestination) {
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
    }

    public static void AssertDestinationCity(AndroidDriver driver, String toDestination) {
        MobileElement ToButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,756][996,876]']"));
        ToButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_geo_name")));
        MobileElement SurabayaChoiceButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.TextView[@bounds='[48,557][482,622]']"));
        SurabayaChoiceButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));

        // Assert To Destination City
        Assert.assertEquals(ToButton.getText(), toDestination);
    }

    public static void AssertDate(AndroidDriver driver) {
        MobileElement DepartureDateButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,996][996,1116]']"));
        DepartureDateButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/info_top_text_view")));
        List<AndroidElement> elements = driver.findElements(By.xpath ("//android.widget.TextView[@text='today']/../*"));
        int indexDate = Integer.parseInt(elements.get(1).getAttribute("text"));

        indexDate += 1;
        String choosenIndexDate = Integer.toString(indexDate);
        indexDate += 1;
        String choosenDate = Integer.toString(indexDate);

        MobileElement theDayAfterTommorowDate = (MobileElement) driver.findElement(By.xpath ("//android.widget.RelativeLayout[@index='" + choosenIndexDate + "']"));
        theDayAfterTommorowDate.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
        // Assert Chosen Date
        Assert.assertTrue(DepartureDateButton.getText().contains(choosenDate));
    }

    public static void AssertPassenger(AndroidDriver driver) {
        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
        MobileElement Passengers = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[84,1237][516,1357]']"));
        Passengers.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/wheel_passenger_adult")));

        swipe(driver, 542, 542, 1458, 1285);
        swipe(driver, 790, 790, 1458, 1285);

        MobileElement SelectButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='Select']"));
        SelectButton.click();
    }

    public static void AssertFlightClass(AndroidDriver driver) {
        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/widgetView")));
        MobileElement SeatClass = (MobileElement) driver.findElement(By.xpath ("//android.widget.EditText[@text='Economy']"));
        SeatClass.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/radio_button")));
        MobileElement EconomyClass = (MobileElement) driver.findElement(By.xpath ("//android.widget.RadioButton[@bounds='[48,747][132,831]']"));
        EconomyClass.click();

        MobileElement DoneButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='DONE']"));
        DoneButton.click();
    }

    public static void AssertChooseFlightSchedule(AndroidDriver driver) {
        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/btn_search")));
        MobileElement SearchButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='Search']"));
        SearchButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/recycler_view_content")));
        List<AndroidElement> elementFlight = driver.findElements(By.xpath ("//androidx.recyclerview.widget.RecyclerView[@bounds='[0,316][1080,1800]']/*"));
        MobileElement secondFlight = elementFlight.get(3);
        secondFlight.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_select"))){
            swipe(driver, 542, 542, 1458, 1285);
        };
        MobileElement selectButton = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@text='Select']"));
        selectButton.click();
    }

    public static void AssertContactDetails(AndroidDriver driver, String NameContactDetails, String MobileNumberContactDetails, String EmailContactDetails) {
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
    }

    public static void AssertAdult(AndroidDriver driver, String AdultName) {
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
    }

    public static void AssertChild(AndroidDriver driver, String ChildName, String ChildDate, String ChildMonth, String ChildYear) {
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
        DateBirthChild.click();

        while (!(elementExist(driver, TIME_LIMIT, "android:id/pickers")));
        String monthChild = driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[192,891][384,1035]']")).getText();
        String dayChild = driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[432,891][624,1035]']")).getText();
        String yearChild = driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[672,891][864,1035]']")).getText();
        int diffMonth = getMonthInNumber(monthChild) - getMonthInNumber(ChildMonth);
        int diffDay = Integer.parseInt(dayChild) - Integer.parseInt(ChildDate);
        int diffYear = Integer.parseInt(yearChild) - Integer.parseInt(ChildYear);

        boolean directionMonth = getDirection(diffMonth);
        boolean directionDay = getDirection(diffDay);
        boolean directionYear = getDirection(diffYear);

        diffMonth = Math.abs(diffMonth);
        diffDay = Math.abs(diffDay);
        diffYear = Math.abs(diffYear);

        if (directionYear) {
            MobileElement minusYear = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[672,693][864,891]']"));
            for ( int i = 1; i <= diffYear; i++) {
                minusYear.click();
            }
        } else {
            MobileElement addYear = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[672,1035][864,1233]']"));
            for ( int i = 1; i <= diffYear; i++) {
                addYear.click();
            }
        }

        if (directionMonth) {
            MobileElement minusMonth = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[192,693][384,891]']"));
            for ( int i = 1; i <= diffMonth; i++) {
                minusMonth.click();
            }
        } else {
            MobileElement addMonth = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[192,1035][384,1233]']"));
            for ( int i = 1; i <= diffMonth; i++) {
                addMonth.click();
            }
        }

        if (directionDay) {
            MobileElement minusDay = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[432,693][624,891]']"));
            for ( int i = 1; i <= diffDay; i++) {
                minusDay.click();
            }
        } else {
            MobileElement addDay = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[432,1035][624,1233]']"));
            for ( int i = 1; i <= diffDay; i++) {
                addDay.click();
            }
        }


        MobileElement ChildOkButton = (MobileElement) driver.findElementById("android:id/button1");
        ChildOkButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement SaveChild = (MobileElement) driver.findElementById("com.traveloka.android:id/button_save");
        SaveChild.click();
    }

    public static void AssertInfant(AndroidDriver driver, String InfantName, String InfantDate, String InfantMonth, String InfantYear) {
        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/layout_empty")));
        MobileElement infantDetails = (MobileElement) driver.findElementById("com.traveloka.android:id/layout_empty");
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
        DateBirthInfant.click();

        while (!(elementExist(driver, TIME_LIMIT, "android:id/pickers")));
        String monthInfant = driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[192,891][384,1035]']")).getText();
        String dayInfant = driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[432,891][624,1035]']")).getText();
        String yearInfant = driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[672,891][864,1035]']")).getText();
        int diffMonths = getMonthInNumber(monthInfant) - getMonthInNumber(InfantMonth);
        int diffDays = Integer.parseInt(dayInfant) - Integer.parseInt(InfantDate);
        int diffYears = Integer.parseInt(yearInfant) - Integer.parseInt(InfantYear);

        boolean directionMonths = getDirection(diffMonths);
        boolean directionDays = getDirection(diffDays);
        boolean directionYears = getDirection(diffYears);

        diffMonths = Math.abs(diffMonths);
        diffDays = Math.abs(diffDays);
        diffYears = Math.abs(diffYears);

        if (directionYears) {
            MobileElement minusYear = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[672,693][864,891]']"));
            for ( int i = 1; i <= diffYears; i++) {
                minusYear.click();
            }
        } else {
            MobileElement addYear = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[672,1035][864,1233]']"));
            for ( int i = 1; i <= diffYears; i++) {
                addYear.click();
            }
        }

        if (directionMonths) {
            MobileElement minusMonth = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[192,693][384,891]']"));
            for ( int i = 1; i <= diffMonths; i++) {
                minusMonth.click();
            }
        } else {
            MobileElement addMonth = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[192,1035][384,1233]']"));
            for ( int i = 1; i <= diffMonths; i++) {
                addMonth.click();
            }
        }

        if (directionDays) {
            MobileElement minusDay = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[432,693][624,891]']"));
            for ( int i = 1; i <= diffDays; i++) {
                minusDay.click();
            }
        } else {
            MobileElement addDay = (MobileElement) driver.findElement(By.xpath ("//android.widget.Button[@bounds='[432,1035][624,1233]']"));
            for ( int i = 1; i <= diffDays; i++) {
                addDay.click();
            }
        }

        MobileElement InfantOkButton = (MobileElement) driver.findElementById("android:id/button1");
        InfantOkButton.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_save")));
        MobileElement SaveInfant = (MobileElement) driver.findElementById("com.traveloka.android:id/button_save");
        SaveInfant.click();

        swipe(driver, 542, 542, 1458, 400);
    }

    public static void AssertFlightDetail(AndroidDriver driver) {
        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/text_view_see_below_view")));
        MobileElement CONTINUE = (MobileElement) driver.findElementById("com.traveloka.android:id/text_view_see_below_view");
        CONTINUE.click();

        while (!(elementExist(driver, TIME_LIMIT, "com.traveloka.android:id/button_continue"))){
            swipe(driver, 542, 542, 1458, 400);
        };
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

    public static int getMonthInNumber(String month) {
        switch (month) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                return 0;
        }
    }

    public static boolean getDirection(int number) {
        if (number >= 0) {
            return true;
        }
        return false;
    }
}