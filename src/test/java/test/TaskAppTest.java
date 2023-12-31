package test;

import infra.AppiumDriverProvider;
import infra.TestContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    public void settingTest(){


    }
}
