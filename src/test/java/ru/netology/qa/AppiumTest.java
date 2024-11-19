package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.AppiumPage;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    enum Platform {Android, IOS}

    Platform platform = Platform.Android;
    private AppiumDriver driver;
    private AppiumPage appiumPage;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach

    public void setUp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        if (platform == Platform.Android) {
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("appium:deviceName", "some name");
            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            driver = new AndroidDriver(getUrl(), desiredCapabilities);
        } else if (platform == Platform.IOS) {
            desiredCapabilities.setCapability("platformName", "iOS");
            desiredCapabilities.setCapability("appium:deviceName", "iPhone 11");
            desiredCapabilities.setCapability("appium: bundleId", "com.shubham-iosdev.Calculator-UI");
            desiredCapabilities.setCapability("appium:automationName", "XCUITest");
            driver = new IOSDriver(getUrl(), desiredCapabilities);
        }
        appiumPage = new AppiumPage(driver);

    }

    String emptyText = "   ";
    String trialText = "Hello";

    @Test
    public void inputEmptyText() {
        String expect = appiumPage.textToBeChanged.getText();

        appiumPage.enterText.isDisplayed();
        appiumPage.enterText.click();
        appiumPage.enterText.sendKeys(emptyText);

        appiumPage.buttonChange.isDisplayed();
        appiumPage.buttonChange.click();

        appiumPage.textToBeChanged.isDisplayed();
        Assertions.assertEquals(expect, appiumPage.textToBeChanged.getText());
    }

    @Test
    public void inputTextNewActivity() {
        appiumPage.enterText.isDisplayed();
        appiumPage.enterText.click();
        appiumPage.enterText.sendKeys(trialText);
        String expect = appiumPage.enterText.getText();

        appiumPage.buttonActivity.isDisplayed();
        appiumPage.buttonActivity.click();

        appiumPage.textNewActivity.isDisplayed();
        Assertions.assertEquals(expect, appiumPage.textNewActivity.getText());
    }

    @AfterEach

    public void tearDown() {
        driver.quit();
    }
}
