package test;

import infra.AppiumDriverProvider;
import infra.TestContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.MainPage;
import logic.NewEventPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


public class TaskAppTest {
    private static  TestContext context;
    private static AppiumDriverProvider appiumDriverProvider;
    private  AndroidDriver<MobileElement> driver;


    @BeforeAll
    public static void beforeAll() {
        context = new TestContext();
        appiumDriverProvider=new AppiumDriverProvider();
        context.put("driver",appiumDriverProvider.getDriver());

    }
    @BeforeEach
    public void setup(){
        driver=context.get("driver");

    }
    @Test
    public void addNewEvent(){
        MainPage mainPage=new MainPage(driver);
        mainPage.clickOnAddEventButton();
        mainPage.chooseTomorrow();
        NewEventPage newEventPage=new NewEventPage(driver);
        newEventPage.setEventName("new event");
        newEventPage.saveEvent();

        assertNotEquals("NO PENDING EVENT", mainPage.pendingEvents());
    }
}
