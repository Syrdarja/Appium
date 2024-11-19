package ru.netology.qa.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AppiumPage {

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@resource-id='ru.netology.testing.uiautomator:id/userInput']")
    public MobileElement enterText;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    @iOSXCUITFindBy(xpath = "//android.widget.Button[@resource-id='ru.netology.testing.uiautomator:id/buttonChange']")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@resource-id='ru.netology.testing.uiautomator:id/textToBeChanged']")
    public MobileElement textToBeChanged;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    @iOSXCUITFindBy(xpath = "//android.widget.Button[@resource-id='ru.netology.testing.uiautomator:id/buttonActivity']")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@resource-id='ru.netology.testing.uiautomator:id/text']")
    public MobileElement textNewActivity;

    private AppiumDriver driver;

    public AppiumPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
