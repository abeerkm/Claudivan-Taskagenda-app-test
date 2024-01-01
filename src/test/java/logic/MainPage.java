package logic;

import infra.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {
    private MobileElement prevButton;
    private MobileElement nextButton;
    private MobileElement addEventButton;
    private MobileElement pendingEvents;
    private final String PENDING_EVENTS="com.claudivan.taskagenda:id/btEventosSemana";

    private final String ADD_EVENT_BUTTON="com.claudivan.taskagenda:id/btNovoEvento";
    private final String PREV_BUTTON="com.claudivan.taskagenda:id/ibtRetroceder";
    private final String NEXT_BUTTON="com.claudivan.taskagenda:id/ibtAvancar";

    public MainPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.setUp();

    }
    public void setUp(){
        this.prevButton=driver.findElementById(PREV_BUTTON);
        this.nextButton=driver.findElementById(NEXT_BUTTON);
        this.addEventButton=driver.findElementById(ADD_EVENT_BUTTON);
    }
    public void clickOnAddEventButton(){
        this.addEventButton.click();
    }
    public void chooseTomorrow(){
        MobileElement tomorrow=this.driver.findElementByXPath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Tomorrow']");
        tomorrow.click();
    }
    public String pendingEvents(){
        this.pendingEvents=driver.findElementById(PENDING_EVENTS);
        return this.pendingEvents.getText();
    }
    public void clickOnPendingEvents(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id(pendingEvents())));
        this.pendingEvents=driver.findElementById(PENDING_EVENTS);
        this.pendingEvents.click();
    }
}
